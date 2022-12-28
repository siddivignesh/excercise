package com.example.demo.models;

import java.sql.ResultSet;

public class Counselling {
	int id;
	int departementid;
	int clgdeptid;
	String Department;
	String College;
	int Seats;
	int availableseats;
	

	public int getAvailableseats() {
		return availableseats;
	}

	public void setAvailableseats(int availableseats) {
		this.availableseats = availableseats;
	}

	public String getCollege() {
		return College;
	}

	public int getDepartementid() {
		return departementid;
	}

	public void setDepartementid(int departementid) {
		this.departementid = departementid;
	}

	public int getClgdeptid() {
		return clgdeptid;
	}

	public void setClgdeptid(int clgdeptid) {
		this.clgdeptid = clgdeptid;
	}

	public void setCollege(String college) {
		College = college;
	}

	public int getSeats() {
		return Seats;
	}

	public void setSeats(int seats) {
		Seats = seats;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public void setName(ResultSet rs) {
		// TODO Auto-generated method stub

	}

}
