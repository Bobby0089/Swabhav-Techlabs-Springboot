package com.company.curd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.company.curd.Repository.RoleRepository;
import com.company.curd.Repository.UserRepository;
import com.company.curd.dto.user.UserLoginDto;
import com.company.curd.dto.user.UserRegisterDto;
import com.company.curd.entity.Role;
import com.company.curd.entity.User;
import com.company.curd.exception.UserApiException;
import com.company.curd.security.JwtTokenProvider;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User register(UserRegisterDto registration) {
		if(userRepository.existsByUserName(registration.getUsername()))
			throw new UserApiException(HttpStatus.BAD_REQUEST, "User already exists");

		User user = new User();
		user.setUserName(registration.getUsername());
		user.setPassword(passwordEncoder.encode(registration.getPassword()));
		
		List<Role> roles = new ArrayList<Role>();
		
		Role userRole = roleRepository.findByRolename(registration.getRole()).get();
		roles.add(userRole);
		user.setRoles(roles);
		
		return userRepository.save(user);
	}

	@Override
	public String login(UserLoginDto loginDto) {
		try
		{
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			String token = jwtTokenProvider.generateToken(authentication);
					return token;
		}catch(BadCredentialsException e)
		{
			throw new UserApiException(HttpStatus.NOT_FOUND,"User or password is incorret");
		}
	}

}
