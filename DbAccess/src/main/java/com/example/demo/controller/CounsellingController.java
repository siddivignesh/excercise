package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Counselling;
import com.example.demo.service.CounsellingService;

@RestController
public class CounsellingController {
	@Autowired 
	private CounsellingService counsellingservice;
	@RequestMapping(value = "/getalldepartments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody List<Counselling> getalldepartments(){
		return counsellingservice.getalldepartments();
		
	}

}
