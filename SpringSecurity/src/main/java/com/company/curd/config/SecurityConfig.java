package com.company.curd.config;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.company.curd.security.JwtAuthenticationFilter;
import com.company.curd.security.JwtAuthenticationentryPoint;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@EnableMethodSecurity
@Configuration
@RequiredArgsConstructor
@AllArgsConstructor
public class SecurityConfig {

	
//	private UserDetailsService userDetailsService;
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	@Autowired
	private JwtAuthenticationentryPoint authenticationEntryPoint;

	@Bean
	static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration Configuration)
			throws Exception {
		return Configuration.getAuthenticationManager();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		//configuration
		http.csrf(csrf -> csrf.disable()).cors(withDefaults());
		http.sessionManagement(session -> session.sessionCreationPolicy(STATELESS));

		http.authorizeHttpRequests(request -> request.requestMatchers("/api/register").permitAll());
		http.authorizeHttpRequests(request -> request.requestMatchers("/api/login").permitAll());
		http.authorizeHttpRequests(request -> request.requestMatchers("/api/add").permitAll());
		http.authorizeHttpRequests(request -> request.requestMatchers("/api/get").permitAll());

		http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.GET, "/studentapp/**"));
		http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.POST, "/studentapp/**"));
		http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.PUT, "/studentapp/**"));
		http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.DELETE, "/studentapp/**"));
		http.exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint));
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		http.authorizeHttpRequests(request -> request.anyRequest().authenticated());

		return http.build();
	}

}
