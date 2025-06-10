package com.company.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.crud.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
}
