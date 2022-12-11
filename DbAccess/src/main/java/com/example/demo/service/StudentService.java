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

	public Student getStudent(int id) {
		try {
			return studentDAO.getStudent(id);
		} catch (Exception e) {
			throw e;

		}
	}

	public Student addStudent(Student student) {
		try {

			return studentDAO.addStudent(student);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception raised. Message: " + e.getMessage());
			throw e;
		} finally {
			System.out.println("students");

		}
	}

	public Student addStudentTransactional(Student student) {
		try {

			return studentDAO.addStudentTransac(student);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception raised. Message: " + e.getMessage());
			throw e;
		} finally {
			System.out.println("students");

		}
	}

}
