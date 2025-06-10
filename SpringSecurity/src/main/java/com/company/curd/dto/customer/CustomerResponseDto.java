package com.company.curd.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class CustomerResponseDto {

	private int customerid;
	private String firstName;
	private String lastName;
	private long mobileNumber;
}
