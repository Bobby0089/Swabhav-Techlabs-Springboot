package com.company.curd.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.curd.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Optional<Role> findByRolename(String name);
}
