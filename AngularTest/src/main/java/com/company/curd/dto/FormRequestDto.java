package com.company.curd.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class FormRequestDto {
	

	private String username;

	private String email;
	
	private long mobilenumber;

	private String password;

}
