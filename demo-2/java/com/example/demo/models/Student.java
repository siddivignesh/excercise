package com.example.demo.models;

public class Student {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	int id;
	String branch;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

}
