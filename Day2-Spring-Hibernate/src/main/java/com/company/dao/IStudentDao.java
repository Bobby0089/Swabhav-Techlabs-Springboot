package com.company.dao;

import java.util.List;

import com.company.entity.Student;

public interface IStudentDao {	

	public void save(Student thestudent);

	public Student findById(Integer ID);

	List<Student> findAll();
	
	public void deletByID(int id);
	
	public int deleteAll();
	
	
}
