package com.example.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//			readStudent(studentDAO);X
//			queryforstudents(studentDAO);
//			queryforStudentByLastName(studentDAO);
//			updateStudent(studentDAO);
			deleteStudent(studentDAO);
		};
	}
	private void deleteStudent(StudentDAO studentDAO) {
		int id = 1;
		studentDAO.delete(id);
		queryforstudents(studentDAO);
	}
	private void updateStudent(StudentDAO studentDAO) {
		int id = 1 ;
		Student student = studentDAO.findById(id);
		student.setLastName("MorningStar");
		studentDAO.update(student);
		queryforstudents(studentDAO);
	}
	
	private void queryforStudentByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Awasthi");
		for (Student s : students) System.out.println(s);
	}
	
	private void queryforstudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findall();
		for(Student s : students) System.out.println(s.toString());
	}
	private void readStudent(StudentDAO studentDAO) {
//		Student newstudent = new Student("Divy","Awasthi","divy@gmail.com");
//		studentDAO.save(newstudent);
//		int theId = newstudent.getId();
		Student mystud = studentDAO.findById(2);
		System.out.println(mystud);
	}
	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("Paul","Atkins","paul@gmail.com");
		studentDAO.save(student);
		System.out.println(student.getId());
	}
}
