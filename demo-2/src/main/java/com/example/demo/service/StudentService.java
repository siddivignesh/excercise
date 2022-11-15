package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDAO;
import com.example.demo.models.Student;

@Service
public class StudentService {
	@Autowired
	private StudentDAO studentDAO;

	public List<Student> GetAllStudents() {
		List<Student> students = studentDAO.GetAllStudents();
		return students;
	}

	public void addStudent(Student student) {
		studentDAO.addStudent(student);
	}
}
