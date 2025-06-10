package com.company.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.company.curd.dto.customer.CustomerRequestDto;
import com.company.curd.dto.customer.CustomerResponseDto;
import com.company.curd.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<CustomerResponseDto> addACustomer(@RequestBody CustomerRequestDto customerDto)
	{
		return ResponseEntity.ok(customerService.addACustomer(customerDto));
	}
	@GetMapping("/get")
	@PreAuthorize("hasRole('CUSTOMER')")
	public ResponseEntity<List<CustomerResponseDto>> getAllCustomer()
	{
		return ResponseEntity.ok(customerService.getAllCustomers());
	}

}
