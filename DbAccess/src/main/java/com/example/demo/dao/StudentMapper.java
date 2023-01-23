package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.models.Student;

public class StudentMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Student students = new Student();
		students.setId(rs.getInt("STID"));
		students.setName(rs.getNString("STN"));
		//students.setBookid(rs.getInt("BKSD"));
		//students.setBookname(rs.getNString("BKSN"));
		
		//students.setClgdeptid(rs.getInt("CLG_DEPT_ID"));
		return students;
	}
	

}
