package com.company.crud.service;


import java.util.List;

import com.company.crud.dto.DepartmentRequestDto;
import com.company.crud.dto.DepartmentResponseDto;
import com.company.crud.dto.EmployeeResponseDto;
import com.company.crud.dto.PageResponseDto;

public interface DepartmentService {
    DepartmentResponseDto addDepartment(DepartmentRequestDto departmentRequestDto);

    PageResponseDto<DepartmentResponseDto> getAllDepartment(int pagenumber, int pagesize);

	DepartmentResponseDto assignEmployees(int departmentid, int[] employeeids);

	List<EmployeeResponseDto> getAllEmployees(int departmentid);
}