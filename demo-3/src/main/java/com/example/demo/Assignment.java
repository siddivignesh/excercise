package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Assignment {
	public static void main(String[] args) {

		List<Lecturer> lecturers = new ArrayList<Lecturer>();
		List<Warden> wardens = new ArrayList<Warden>();
		List<Employee> employees = new ArrayList<Employee>();

		Lecturer l1 = new Lecturer();
		l1.setName("abhijith");
		l1.setSalary(2050.50f);
		l1.setId(101);
		l1.setDepartment("cse");

		lecturers.add(l1);

		l1.print(); 

		Lecturer l2 = new Lecturer();
		l2.setName("basker");
		l2.setSalary(3050.50f);
		l2.setId(201);
		l2.setDepartment("ece");

		l2.print();
		lecturers.add(l2);

		Warden w1 = new Warden();
		w1.setHostelName("HS1");
		w1.setName("ramesh");
		w1.setSalary(1000);
		w1.setId(301);

		w1.print();
		Student s1 = new Student();
		s1.setName("ram");
		s1.setFees(1000f);
		s1.setId(401);

		Employee e1 = new Employee();
		e1.setName("rafi");
		e1.setId(501);
		e1.setSalary(10000);
		

		// lecturers is a list of lecturer so, it doesn't allow to add warden .
		// lecturers.add(w1);
		wardens.add(w1);
		// Wardens is a list of warden so, it doesn't allow to add lecturer .
		// wardens.add(l1);
		employees.add(l1);
		employees.add(l2);
		employees.add(w1);
		// employees.add(s1); 
		employees.add(e1);
		System.out.println("starting for loop");
		for (Employee employee : employees) {
			employee.print();

		}

	}

	public static class Employee {
		float salary;
		int id;
		String name;

		public float getSalary() {
			return salary;
		}

		public void setSalary(float salary) {
			this.salary = salary;
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

		public void print() {
			System.out.println("Base id: " + getId());
			System.out.println("Base name: " + getName());
			System.out.println("Base salary: " + getSalary());
			System.out.println("im in super class");

		}

	}

	public static class Lecturer extends Employee {
		String department;

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public void print() {
			System.out.println(getDepartment());
			super.print();

		}
	}

	public static class Warden extends Employee {
		String HostelName;

		public String getHostelName() {
			return HostelName;
		}

		public void setHostelName(String hostelName) {
			HostelName = hostelName;
		}

		public void print() {
			System.out.println("class : " + this.getClass().getSimpleName());
			System.out.println("HostelName : " + getHostelName());
			System.out.println("WardenName : " + getName());
			System.out.println("WardenId : " + getId());
			System.out.println("Salary : " + getSalary());

		}

	}

	public static class Student {
		String name;
		int id;
		float fees;

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

		public float getFees() {
			return fees;
		}

		public void setFees(float fees) {
			this.fees = fees;
		}

		public void print() {
			System.out.println("Name :" + getName());
			System.out.println("id :" + getId());
			System.out.println("Fees :" + getFees());

		}
	} 

}
