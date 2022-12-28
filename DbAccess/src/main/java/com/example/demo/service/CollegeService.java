package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CollegeDAO;
import com.example.demo.models.College;

@Service
public class CollegeService {
	@Autowired
	private CollegeDAO collegedao;

	public College getcollege(int id) {
		try {
			return collegedao.getcollege(id);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<College> getallcolleges() {

		return collegedao.getallcolleges();

	}
}
