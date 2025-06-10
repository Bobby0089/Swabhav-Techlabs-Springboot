package com.company.crud.service;

import com.company.crud.dto.DepartmentResponseDto;
import com.company.crud.dto.EmployeeResponseDto;
import com.company.crud.dto.PageResponseDto;
import com.company.crud.entity.Employee;


public interface EmployeeService {

	PageResponseDto<Employee> getAllEmployees(int pageNumber, int pageSize, String firstname);

	Employee getAEmployee(int EmployeeId);

	Employee addAEmployee(Employee employee);

	void deleteAEmployee(int id);

	EmployeeResponseDto assignDepartment(int employeeid, int departmentid);

	DepartmentResponseDto getDepartment(int employeeid);
}
