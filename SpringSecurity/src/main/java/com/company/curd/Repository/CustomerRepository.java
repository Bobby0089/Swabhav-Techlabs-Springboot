package com.company.curd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.curd.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
