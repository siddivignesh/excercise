package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.example.demo.exceptions.MyRunTimeException;
import com.example.demo.models.Student;

@Component
public class StudentDAO {
	List<Student> students = new ArrayList<Student>();
	
	  int array[] = new int[5];
	  String array1[] = new String[4];
	  Student studentarray[] = new Student[2];
	  //array2[0] = "amar";
	  //array2[1] = "sunny";
	  
	 // for(int i =0; i <array2.length(); i++) {
	//	  System.out.println(i);
	 // }

	@PostConstruct
	public void init() {
		System.out.println(students.size());
		System.out.println("spring boot is initializing this class during bootup because the class has '@component' ");
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
		studentarray[0] = new Student();
		studentarray[0].setName("amar");
		  studentarray[1] = new Student();
			studentarray[1].setName("bunny");
		  
		 for(int i =0; i <studentarray.length; i++) {
			 System.out.println("i in loop : " + i);
			Student student3 = studentarray[i];
			System.out.println("array before : "  + student3);
			student3.getName();
			System.out.println("array after : "  + student3);
			  
		} 

		for (int i = 0; i < students.size(); i++) {

			Student student2 = students.get(i);
  
			if (student2.getName().equals(student.getName())) {
				System.out.println(student.getName() + " is already exists");
				throw new MyRunTimeException("name already exists");

			}
		} 

		students.add(student);
	}

	public List<Student> GetAllStudents() {

		return students;

	}
} 