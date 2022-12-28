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
import com.example.demo.dao.StudentDAO;
import com.example.demo.exceptions.MyRunTimeException;
import com.example.demo.models.Book;
import com.example.demo.models.Counselling;
import com.example.demo.models.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/getallstudents", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Student> GetAllStudents() {
		// List<Student> students = studentService.GetAllStudents();
		// return students;

		return studentService.GetAllStudents();
	}
	@RequestMapping(value = "/getallbooks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Book> getAllBooks(){
		// List<Student> students = studentService.GetAllStudents();
		// return students;

		return studentService.getAllBooks();
	}
	@RequestMapping(value = "/getbook/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Book> getbook(@PathVariable int id){
		return studentService.getbook(id);
		// List<Student> students = studentService.GetAllStudents();
		// return students;

		//return studentService.getAllBooks();
	}
	/*@RequestMapping(value = "/bookallocation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Book> bookallocation(int id){
		// List<Student> students = studentService.GetAllStudents();
		// return students;

		return studentService.bookallocation();
	}*/
	@RequestMapping(value= "/addbook",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object addbook(@RequestBody Book book) {
		return studentService.addbook(book);
		
	}
	@RequestMapping(value = "/getclgdepartment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Counselling> getclgdepartment() {

		return studentService.getclgdepartment();

	}

	/*
	 * @RequestMapping(value = "/students/{id}", method = RequestMethod.GET,
	 * produces = MediaType.APPLICATION_JSON_VALUE) public @ResponseBody Object
	 * getStudent(@PathVariable int id) { try { return
	 * studentService.getStudent(id); } catch (MyRunTimeException e) { ErrorResponse
	 * e1 = new ErrorResponse(); e1.setMessage(e.getReason());
	 * System.out.println(" message : " + e1.getMessage()); return e1; }
	 * 
	 * }
	 */
	@RequestMapping(value = "/addstudent", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object addstudent(@RequestBody Student student) {
		try {
			Student s1 = studentService.addStudent(student);

			return s1;
		} catch (MyRunTimeException e) {

			System.out.println("Exception raised. Message: " + "invalid id");
			ErrorResponse e1 = new ErrorResponse();
			e1.setMessage(e.getReason());
	
			//e1.setMessage(e.getReason());
			return e1;
		} catch (Exception e) {
			ErrorResponse e2 = new ErrorResponse();
			e2.setMessage(e.getMessage());
			System.out.println("message : " + "invalid id");
			System.out.println("Exception controller1");
			return e2;

		}

	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object updatestudent(@PathVariable int id, @RequestBody Student student) {

		try {
			studentService.updatestudent(id, student.getName());
		} catch (MyRunTimeException e) {
			ErrorResponse e2 = new ErrorResponse();
			e2.setMessage(e.getReason());
			System.out.println("message : " + e2.getMessage());
			System.out.println("Exception controller");
		} catch (Exception e) {
			ErrorResponse e3 = new ErrorResponse();

		}

		return student;
	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Object deletestudent(@PathVariable int id) {
		try {
			studentService.deletestudent(id);
		} catch (MyRunTimeException e) {
			ErrorResponse e3 = new ErrorResponse();
			e3.setMessage(e.getReason());
			System.out.println("message : " + e3.getMessage());
		}
		return id;
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
