package com.company.curd.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.curd.Repository.CustomerRepository;
import com.company.curd.dto.customer.CustomerRequestDto;
import com.company.curd.dto.customer.CustomerResponseDto;
import com.company.curd.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {


	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ModelMapper mapper;


	@Override
	public CustomerResponseDto addACustomer(CustomerRequestDto customerDto) {
		Customer customer = mapper.map(customerDto, Customer.class);
		customerRepository.save(customer);
		
		return mapper.map(customer, CustomerResponseDto.class);
	}


	@Override
	public List<CustomerResponseDto> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		
		List<CustomerResponseDto> customerDtos = new ArrayList<>();
		
		for(Customer customer : customers)
		{
			customerDtos.add(mapper.map(customer, CustomerResponseDto.class));
		}
		return customerDtos;
	}
	
	
}
