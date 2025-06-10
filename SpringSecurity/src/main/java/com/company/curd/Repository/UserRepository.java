package com.company.curd.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.curd.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUserName(String name);
	
	boolean existsByUserName(String name);
}
