package com.company.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.company.crud.dto.DepartmentRequestDto;
import com.company.crud.dto.DepartmentResponseDto;
import com.company.crud.dto.EmployeeResponseDto;
import com.company.crud.dto.PageResponseDto;
import com.company.crud.entity.Department;
import com.company.crud.entity.Employee;
import com.company.crud.exception.EmployeeApiException;
import com.company.crud.repository.DepartmentRepository;
import com.company.crud.repository.EmployeeRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public DepartmentResponseDto addDepartment(DepartmentRequestDto departmentRequestDto) {
		
        Department department = mapper.map(departmentRequestDto, Department.class);
		
        departmentRepository.save(department);
		
		return mapper.map(department, DepartmentResponseDto.class);
	}

	@Override
	public PageResponseDto<DepartmentResponseDto> getAllDepartment(int pagenumber, int pagesize) {
		Pageable pageable = PageRequest.of(pagenumber, pagesize);
		
		Page<Department> page =departmentRepository.findAll(pageable);
		 
		PageResponseDto<DepartmentResponseDto> pageResponseDto = new PageResponseDto<>();
		
		pageResponseDto.setPageNumber(page.getNumber());
		pageResponseDto.setPageNumber(page.getSize());
		pageResponseDto.setTotalPages(page.getTotalPages());
		pageResponseDto.setTotalElement(page.getTotalElements());
		List<Department> dbdepartment = page.getContent();
		List<DepartmentResponseDto> dtodepartment = new ArrayList<>();	
		for(Department course : dbdepartment)
		{
			DepartmentResponseDto dto = mapper.map(course, DepartmentResponseDto.class);
			dtodepartment.add(dto);
		}
		pageResponseDto.setContent(dtodepartment);
		pageResponseDto.setLast(page.isLast());
		return pageResponseDto;
	}

	@Override
	public DepartmentResponseDto assignEmployees(int departmentid, int[] employeeids) {
		
		Department dbDepartment = departmentRepository.findById(departmentid).
				orElseThrow(() -> new EmployeeApiException("Department with id "+departmentid+" not found"));
		
		List<Employee> dbEmployee = dbDepartment.getEmployees();
		
		for(int employeeid : employeeids)
		{
			Employee employee = employeeRepo.findById(employeeid).
					orElseThrow(() -> new EmployeeApiException("Employee with id "+employeeid+" not found"));
			employee.setDepartment(dbDepartment);
			
			dbEmployee.add(employeeRepo.save(employee));
			
		}
		
		dbDepartment.setEmployees(dbEmployee);
		departmentRepository.save(dbDepartment);
		
		return mapper.map(departmentRepository.save(dbDepartment),DepartmentResponseDto.class);
	}

	@Override
	public List<EmployeeResponseDto> getAllEmployees(int departmentid) {
		
		Department dbDepartment = departmentRepository.findById(departmentid).
				orElseThrow(() -> new EmployeeApiException("Department with id "+departmentid+" not found"));
		
		List<Employee> employees = dbDepartment.getEmployees();
		
		List<EmployeeResponseDto> employeeResponses = new ArrayList<>();
		
		for(Employee employee : employees)
		{
			employeeResponses.add(mapper.map(employee, EmployeeResponseDto.class));
		}
		
		return employeeResponses;
	}

}
