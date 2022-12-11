package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "/getallstudents", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Student> GetAllStudents() {
		//List<Student> students = studentService.GetAllStudents();
		//return students;
		
		return studentService.GetAllStudents();
	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object getStudent(@PathVariable int id) {
		try {
			return studentService.getStudent(id);
		} catch (MyRunTimeException e) {
			ErrorResponse e1 = new ErrorResponse();
			e1.setMessage(e.getReason());
			System.out.println(" message : " + e1.getMessage());
			return e1;
		}

	}

	@RequestMapping(value = "/addstudent", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object addstudent(@RequestBody Student student) {
		try {
			return studentService.addStudent(student);
		} catch (Exception e) {

			System.out.println("Exception controller");

			return null;
		}

	}

	@RequestMapping(value = "/addstudenttransactional", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object addstudentTransactional(@RequestBody Student student) {
		try {
			return studentService.addStudentTransactional(student);
		} catch (Exception e) {

			System.out.println("Exception controller");

			return null;
		}

	}

}
