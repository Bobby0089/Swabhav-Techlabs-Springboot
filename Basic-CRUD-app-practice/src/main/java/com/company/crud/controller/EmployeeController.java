package com.company.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.crud.dto.DepartmentResponseDto;
import com.company.crud.dto.EmployeeResponseDto;
import com.company.crud.dto.PageResponseDto;
import com.company.crud.entity.Employee;
import com.company.crud.service.EmployeeService;

@RestController
@RequestMapping("/employeeapp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<PageResponseDto<Employee>> getAllEmployees(
            @RequestParam int pageNumber, 
            @RequestParam int pageSize, 
            @RequestParam(required = false) String firstname) {

        return ResponseEntity.ok(employeeService.getAllEmployees(pageNumber, pageSize, firstname));
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> getAEmployee(@PathVariable int employeeId) {
        return ResponseEntity.ok(employeeService.getAEmployee(employeeId));
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addAEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.addAEmployee(employee));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        employeeService.deleteAEmployee(id);
        return ResponseEntity.ok("Employee deactivated successfully");
    }
    
    @PutMapping("/employee/assigndepartment")
    public ResponseEntity<EmployeeResponseDto> assignDepartment(@RequestParam int employeeid, @RequestParam int departmentid)
    {
    	return ResponseEntity.ok(employeeService.assignDepartment(employeeid,departmentid));
    }
    
    @GetMapping("/employee/{employeeid}/getdepartment")
    public ResponseEntity<DepartmentResponseDto> getdepartment(@PathVariable int employeeid)
    {
    	return ResponseEntity.ok(employeeService.getDepartment(employeeid));
    }
}
