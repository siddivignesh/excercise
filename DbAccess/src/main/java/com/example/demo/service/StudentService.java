package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDAO;
import com.example.demo.exceptions.MyRunTimeException;
import com.example.demo.models.Book;
import com.example.demo.models.Counselling;
import com.example.demo.models.Student;

@Service

public class StudentService {
	@Autowired
	private StudentDAO studentDAO;

	public List<Student> GetAllStudents() {
		List<Student> students = studentDAO.GetAllStudents();
		return students;
	}

	public List<Book> getAllBooks() {
		return studentDAO.getAllBooks();

	}

	public Book addbook(Book book) {
		return studentDAO.addbook(book);
	}

	public List<Book> getbook(int id) {
		return studentDAO.getbook(id);
	}

	public List<Counselling> getclgdepartment() {

		return studentDAO.getclgdepartment();

	}

	/*
	 * public Student getStudent(int id) { try { return studentDAO.getStudent(id); }
	 * catch (Exception e) { throw e;
	 * 
	 * } }
	 */
	public void updatestudent(int id, String name) {
		try {
			studentDAO.updatestudent(id, name);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void deletestudent(int id) {
		try {
			studentDAO.deletestudent(id);
		} catch (Exception e) {
			throw e;
		}
	}

	public Student addStudent(Student student) {
		try {

			int s2 = studentDAO.getAvailableseats(student.getClgdeptid());

			Student s1 = studentDAO.addStudent(student);

			studentDAO.updateavailableseats(student.getClgdeptid());

			return s1;

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
