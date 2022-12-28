package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CounsellingDAO;
import com.example.demo.models.Counselling;

@Service

public class CounsellingService {
	@Autowired
	private CounsellingDAO counsellingDAO;
	
	public List<Counselling> getalldepartments(){
		return counsellingDAO.getalldepartements();
	}
}
