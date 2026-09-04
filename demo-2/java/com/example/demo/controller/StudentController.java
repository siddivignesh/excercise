package com.example.demo.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ErrorResponse;
import com.example.demo.exceptions.MyRunTimeException;
import com.example.demo.models.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostConstruct
	public void init() {
		System.out.println("spring boot is initializing this class during bootup because the class has '@component' ");
	}

	@RequestMapping(value = "/getallstudents", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Student> GetAllStudents() {
		List<Student> students = studentService.GetAllStudents();
		return students;
	}

	@RequestMapping(value = "/addstudent", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object addstudent(@RequestBody Student student) {
		try {
			studentService.addStudent(student);
		} catch (MyRunTimeException e) {
			ErrorResponse E1 = new ErrorResponse();
			E1.setMessage(e.getReason());
			System.out.println("message : " + E1.getMessage());
			return E1;
		} catch (Exception e) {
 
			System.out.println("Exception controller"); 
			 
			return new ErrorResponse();
		} finally {
			System.out.println("Controller finally");
		}
		return student;
	}
} 
