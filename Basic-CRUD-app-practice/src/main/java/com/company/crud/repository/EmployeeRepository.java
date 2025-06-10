package com.company.crud.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.company.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    
    Page<Employee> findByFirstName(Pageable pageable, String firstName);
}
