package com.company.crud.entity;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departments")
public class Department {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptid;
	
	@Column
	private String deptname;
	
	@Column
	private int managerno;
	
	@OneToMany(mappedBy = "department", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH })
	private List<Employee> employees;
}
