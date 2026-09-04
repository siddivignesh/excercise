package com.example.demo.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDAO;
import com.example.demo.models.Student;

@Service
public class StudentService {
	@Autowired
	private StudentDAO studentDAO;
	@PostConstruct
	public void init() {
		System.out.println("spring boot is initializing this class during bootup because the class has '@component' ");
	}
	public List<Student> GetAllStudents() {
		List<Student> students = studentDAO.GetAllStudents();
		return students;
	}

	public void addStudent(Student student) {
		//try {
		
		studentDAO.addStudent(student);
		//}catch(Exception e){
			//e.printStackTrace();  
			//System.out.println("Exception raised. Message: " + e.getMessage());
			//throw e;
		//}
		//finally{
			//System.out.println("students");
			
		//}
	}
}
