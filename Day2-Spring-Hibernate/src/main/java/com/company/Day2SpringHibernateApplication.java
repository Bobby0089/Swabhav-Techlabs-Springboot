package com.company;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.company.dao.IStudentDao;
import com.company.entity.Student;

@SpringBootApplication
public class Day2SpringHibernateApplication {

	private final CommandLineRunner commandLineRunner;

	Day2SpringHibernateApplication(CommandLineRunner commandLineRunner) {
		this.commandLineRunner = commandLineRunner;
	}

	public static void main(String[] args) {
		SpringApplication.run(Day2SpringHibernateApplication.class, args);
	}

	@Bean
	public static CommandLineRunner commandLineRunner(IStudentDao studentDao) {

		return runner -> {
			try (Scanner sc = new Scanner(System.in)) {
			createStudent(studentDao);
			createMultipleStudent(studentDao);
//			readStudent(studentDao,sc);

//			readAllStudent(studentDao);
				
//			deletebyid(studentDao);
			
//			deleteAllStudents(studentDao);
			}
		};
	}
	
	private static void deleteAllStudents(IStudentDao studentDao) {
		System.out.println("Deleting all students...");
		int deletedCount = studentDao.deleteAll();
		System.out.println("Total records deleted: " + deletedCount);
	}

	
	private static void deletebyid(IStudentDao dao) {
		dao.deletByID(2);
	}


	private static void readAllStudent(IStudentDao studentDao) {
		List<Student> temp = studentDao.findAll();
		
		for(Student s : temp)
		{
			System.out.println(s);
		}
		
	}

	private static void readStudent(IStudentDao studentDao, Scanner sc) {

		System.out.println("Enter Student id : ");
		int id = sc.nextInt();

		Student student = studentDao.findById(id);
		if (student != null) {
			System.out.println("Student Found: " + student);
		} else {
			System.out.println("No student found with ID: " + id);
		}

	}

	private static void createStudent(IStudentDao studentDao) {
		System.out.println("Creating student object");
		Student student1 = new Student("Krushna", "Yadav", "krushna@gmail.com");

		System.out.println("Saving the student");
		studentDao.save(student1);
		System.out.println("Student created successfilly ");
	}

	private static void createMultipleStudent(IStudentDao studentDao) {
		System.out.println("Creating student object");
		Student student1 = new Student("Bobby", "Gupta", "Bobby@gmail.com");
		Student student2 = new Student("Bala", "Konar", "Bala@gmail.com");
		Student student3 = new Student("Parth", "Bhudale", "Parth@gmail.com");

		System.out.println("Saving the student");
		studentDao.save(student1);
		studentDao.save(student2);
		studentDao.save(student3);
		System.out.println("Student created successfilly ");
	}

}
