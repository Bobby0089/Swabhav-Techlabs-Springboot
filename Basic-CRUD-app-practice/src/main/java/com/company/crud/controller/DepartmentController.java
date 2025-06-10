package com.company.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.crud.dto.DepartmentRequestDto;
import com.company.crud.dto.DepartmentResponseDto;
import com.company.crud.dto.EmployeeResponseDto;
import com.company.crud.dto.PageResponseDto;
import com.company.crud.service.DepartmentService;
import com.company.crud.service.EmployeeService;

@RestController
@RequestMapping({"employeeapp"})
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    
    @Autowired
    private EmployeeService employeeService;

    public DepartmentController() {
    }

    @PostMapping({"/department"})
    public ResponseEntity<DepartmentResponseDto> addDepartment(@RequestBody DepartmentRequestDto department) {
        return ResponseEntity.ok(this.departmentService.addDepartment(department));
    }

    @GetMapping({"/getdepartments"})
    public ResponseEntity<PageResponseDto<DepartmentResponseDto>> findAllDepartments(@RequestParam int pagesize, @RequestParam int pagenumber) {
        return ResponseEntity.ok(this.departmentService.getAllDepartment(pagenumber, pagesize));
    }
    
    @PutMapping("/departments/{departmentid}/assignemployees")
    public ResponseEntity<DepartmentResponseDto> asssignEmployees(@PathVariable int departmentid, @RequestBody int employeeids[])
    {
    	return ResponseEntity.ok(departmentService.assignEmployees(departmentid,employeeids));
    }
    
    @GetMapping("/department/{departmentid}/getemployees")
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployess(@PathVariable int departmentid)
    {
    	return ResponseEntity.ok(departmentService.getAllEmployees(departmentid));
    }
}


