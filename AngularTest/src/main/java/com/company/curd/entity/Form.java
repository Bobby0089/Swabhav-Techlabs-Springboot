package com.company.curd.entity;

import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="forms")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Form {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String username;
	
	@Column
	private String email;
	
	@Column
	private long mobilenumber;
	
	@Column
	private String password;
	

}
