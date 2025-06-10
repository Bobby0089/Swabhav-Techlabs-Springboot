package com.company.curd.service;

import java.util.List;

import com.company.curd.dto.customer.CustomerRequestDto;
import com.company.curd.dto.customer.CustomerResponseDto;

public interface CustomerService {

	List<CustomerResponseDto> getAllCustomers();

	CustomerResponseDto addACustomer(CustomerRequestDto customerDto);

}
