package com.company.crud.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class EmployeeResponseDto {

	private int employeeid;
	private String firstName;
	private Date joiningDate;
	private String lastName;
	private double salary;
}
