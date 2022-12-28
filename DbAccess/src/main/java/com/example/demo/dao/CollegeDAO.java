package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.exceptions.MyRunTimeException;
import com.example.demo.models.College;

@Component
public class CollegeDAO {
	@Autowired
	private JdbcTemplate jdbctemplate;

	public College getcollege(int id) {
		List<College> colleges = jdbctemplate.query("SELECT * FROM COLLEGES WHERE ID = ?", new CollegeMapper(), id);
		if (colleges.isEmpty()) {
			MyRunTimeException exception = new MyRunTimeException();
			exception.setReason("invalid id ");
			throw exception;
		}

		return colleges.get(0);

	}
	
	public List<College> getallcolleges() {
		// TODO Auto-generated method stub
		List<College> colleges = jdbctemplate.query("SELECT * FROM COLLEGES", new CollegeMapper());
		return colleges;
	}
} 
