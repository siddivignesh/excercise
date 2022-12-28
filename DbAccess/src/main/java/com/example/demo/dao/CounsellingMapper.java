package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.models.Counselling;

public class CounsellingMapper implements RowMapper<Counselling> {

	@Override
	public Counselling mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Counselling counsellings = new Counselling();
		counsellings.setId(rs.getInt("CDI"));
		 counsellings.setCollege(rs.getNString("CLN"));
		counsellings.setDepartment(rs.getNString("DPN"));
		 counsellings.setSeats(rs.getInt("NOS"));
		 counsellings.setClgdeptid(rs.getInt("CLI"));
		 counsellings.setDepartementid(rs.getInt("DPI"));
		 counsellings.setAvailableseats(rs.getInt("AVAILABLE_SEATS"));

		return counsellings;
	}
	

}
