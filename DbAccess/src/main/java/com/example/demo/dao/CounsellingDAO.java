package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.models.Counselling;

@Component
public class CounsellingDAO {
	@Autowired
	private JdbcTemplate jdbctemplate;

	public List<Counselling> getalldepartements() {

		List<Counselling> counsellings = jdbctemplate.query("SELECT * FROM DEPARTMENTS ", new CounsellingMapper());

		return counsellings;

	}
	

	
}
