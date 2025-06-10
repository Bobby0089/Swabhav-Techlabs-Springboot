package com.company.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class DepartmentResponseDto {

	private int deptid;
	private String deptname;
	private int managerno;
}
