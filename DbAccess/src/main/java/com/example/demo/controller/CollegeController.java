package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ErrorResponse;
import com.example.demo.exceptions.MyRunTimeException;
import com.example.demo.models.College;
import com.example.demo.models.Student;
import com.example.demo.service.CollegeService;

@RestController
public class CollegeController {
	@Autowired
	private CollegeService collegeService;

	@RequestMapping(value = "/college/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object getcollege(@PathVariable int id) {
		try {
			return collegeService.getcollege(id);
		} catch (MyRunTimeException e) {
			ErrorResponse e1 = new ErrorResponse();
			e1.setMessage(e.getReason());
			System.out.println("Message : " + e.getReason());
			return e1;

		}
	}
	@RequestMapping(value = "/getallcolleges", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<College> getallcolleges() {
		
		return collegeService.getallcolleges();
		
	}
		

}
