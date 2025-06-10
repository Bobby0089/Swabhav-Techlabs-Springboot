package com.company.crud.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name="Employee")
public class Employee {
	
	@Column(name="employeeId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	
	@Column
	@NotBlank(message ="name cannot be blank")
	private String firstName;
	
	@Column
	@NotBlank(message ="name cannot be blank")
	private String lastName;
	
	@Column(name="email")
	@Email
	@NotBlank(message ="email cannot be blank")
	private String email;
	
	@Column(name="joiningDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joiningDate;
	
	@Column(name="salary")
	@Min(value = 0)
	private double salary;
	
	@Column(name="isActive")
	private boolean isActive;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressid")
	private Address address;
	
	 @ManyToOne
	    @JoinColumn(name = "deptid")
	    private Department department;
	

}
