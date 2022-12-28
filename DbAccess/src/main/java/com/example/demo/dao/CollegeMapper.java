package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.models.College;

public class CollegeMapper implements RowMapper<College> {

	@Override
	public College mapRow(ResultSet rs, int rowNum) throws SQLException { // TODO Auto-generated method stub
		College college = new College();
		college.setId(rs.getInt("ID"));
		college.setName(rs.getNString("NAME"));

		return college;
	}

}
