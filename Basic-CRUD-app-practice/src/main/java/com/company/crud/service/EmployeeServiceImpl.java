package com.company.crud.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.company.crud.dto.DepartmentResponseDto;
import com.company.crud.dto.EmployeeResponseDto;
import com.company.crud.dto.PageResponseDto;
import com.company.crud.entity.Department;
import com.company.crud.entity.Employee;
import com.company.crud.exception.EmployeeApiException;
import com.company.crud.repository.DepartmentRepository;
import com.company.crud.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepo;
    
    @Autowired
    private DepartmentRepository departmnentRepo;
    
    @Autowired
    private ModelMapper mapper;

    @Override
    public PageResponseDto<Employee> getAllEmployees(int pageNumber, int pageSize, String firstname) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        
        Page<Employee> employeePage;

        if (firstname == null || firstname.trim().isEmpty()) {
            employeePage = employeeRepo.findAll(pageable);
        } else {
            employeePage = employeeRepo.findByFirstName(pageable, firstname);
        }

        PageResponseDto<Employee> employeePageResponse = new PageResponseDto<>();
        employeePageResponse.setPageNumber(employeePage.getNumber());
        employeePageResponse.setPageSize(employeePage.getSize());
        employeePageResponse.setTotalPages(employeePage.getTotalPages());
        employeePageResponse.setTotalElement(employeePage.getTotalElements());
        employeePageResponse.setContent(employeePage.getContent());
        employeePageResponse.setLast(employeePage.isLast());
        
        return employeePageResponse;
    }

    @Override
    public Employee getAEmployee(int employeeId) {
        return employeeRepo.findById(employeeId)
                .orElseThrow(() -> new EmployeeApiException("Employee with id " + employeeId + " is not present"));
    }

    @Override
    public Employee addAEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public void deleteAEmployee(int id) {
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new EmployeeApiException("Employee with id " + id + " does not exist"));

        if (!employee.isActive()) {
            throw new EmployeeApiException("Employee with id " + id + " is already inactive");
        }

        employee.setActive(false);
        employeeRepo.save(employee);
    }

	@Override
	public EmployeeResponseDto assignDepartment(int employeeid, int departmentid) {
		
		Employee dbEmployee = employeeRepo.findById(employeeid).
				orElseThrow(() -> new EmployeeApiException("Employee with id "+employeeid+" not present"));
		
		Department dbDpartment = departmnentRepo.findById(departmentid).
				orElseThrow(() -> new EmployeeApiException("Department with id "+departmentid+" not present"));
		
		dbEmployee.setDepartment(dbDpartment);
		employeeRepo.save(dbEmployee);
		departmnentRepo.save(dbDpartment);
		return mapper.map(dbEmployee, EmployeeResponseDto.class);
	}

	@Override
	public DepartmentResponseDto getDepartment(int employeeid) {
		
		Employee dbEmployee = employeeRepo.findById(employeeid).
				orElseThrow(() -> new EmployeeApiException("Employee with id "+employeeid+" not present"));
		
		Department dbDepartment = dbEmployee.getDepartment();
		
		return mapper.map(dbDepartment,DepartmentResponseDto.class );
	}
}
