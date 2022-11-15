package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import com.example.demo.models.Student;

@Component
public class StudentDAO {
	List<Student> students = new ArrayList<Student>();

	@PostConstruct
	public void init() {
		// init code goes here
		Student s1 = new Student();
		s1.setName("Amar");
		s1.setId(1);
		s1.setBranch("ece");
		students.add(s1);

		Student s2 = new Student();
		s2.setName("Bunny");
		s2.setId(2);
		s2.setBranch("cse");
		students.add(s2);
	}
	public void addStudent(Student student) {
		students.add(student);
	}


	public List<Student> GetAllStudents() {

		return students;

	}

}
