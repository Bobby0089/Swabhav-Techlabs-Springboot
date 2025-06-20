package com.company.curd.security;

import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.company.curd.Repository.UserRepository;
import com.company.curd.entity.User;
import com.company.curd.exception.UserApiException;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException("User id not found"));
		
		Set<GrantedAuthority> authorities = user
				.getRoles()
				.stream()
				.map((role) -> new SimpleGrantedAuthority(role.getRolename())).collect(Collectors.toSet());
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(),
				user.getPassword(),
				authorities);
		
	}

}
