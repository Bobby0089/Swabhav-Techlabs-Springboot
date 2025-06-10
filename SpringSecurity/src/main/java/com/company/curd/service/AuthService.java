package com.company.curd.service;

import com.company.curd.dto.user.UserLoginDto;
import com.company.curd.dto.user.UserRegisterDto;
import com.company.curd.entity.User;

public interface AuthService {

	User register(UserRegisterDto registration);
	String login(UserLoginDto loginDto);
}
