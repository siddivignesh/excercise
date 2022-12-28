package com.example.demo.models;

public class Student {
	int id;
	int clgdeptid;
	String name;
	int availableseats;
	

	public int getAvailableseats() {
		return availableseats;
	}

	public void setAvailableseats(int availableseats) {
		this.availableseats = availableseats;
	}

	public int getClgdeptid() {
		return clgdeptid;
	}

	public void setClgdeptid(int clgdeptid) {
		this.clgdeptid = clgdeptid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
