package com.company.curd.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.curd.entity.Form;

public interface FormRepository extends JpaRepository<Form, Integer>{
	
	Optional<Form> findByUsername(String username);
	
	Optional<Form> findByPassword(String password);
	
	
	boolean existsByUsername(String username);
	
	boolean existsByPassword(String password);

}
