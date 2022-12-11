package com.example.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exceptions.MyRunTimeException;
import com.example.demo.models.Student;

@Component
public class StudentDAO {

	@Autowired
	private JdbcTemplate jdbctemplate;

	public List<Student> GetAllStudents() {

		List<Student> students = jdbctemplate.query("SELECT * FROM STUDENTS", new StudentMapper());
		return students;
	}

	public Student addStudent(Student student) {
		System.out.println("point1");

		KeyHolder keyHolder = new GeneratedKeyHolder();

		String query = "INSERT INTO students (name) VALUES (?)";

		jdbctemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement st = connection.prepareStatement(query, new String[] { "id" });
				st.setString(1, student.getName());
				return st;
			}
		}, keyHolder);
		student.setId(keyHolder.getKey().intValue());
		// System.out.println(keyHolder.getKey().intValue());
		/*
		 * jdbctemplate.update(
		 * "SELECT last_insert_id(); where TABLE_NAME = students,INSERT INTO students (id,name) VALUES (?,?)"
		 * , student.getName(),student.getId() );
		 */

		// System.out.println("point2");
		/*
		 * try { Thread.sleep(20000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * System.out.println("point3"); jdbctemplate.update(
		 * "INSERT INTO students (name) VALUES (?)", student.getName() );
		 * System.out.println("point4");
		 */
		return student;
	}

	public Student getStudent(int id) {

		List<Student> students = jdbctemplate.query("SELECT * FROM STUDENTS WHERE ID = ? ", new StudentMapper(), id);
		if (students.isEmpty()) {
			System.out.println("not exists");
			MyRunTimeException r1 = new MyRunTimeException();
			r1.setReason("invalid id");
			r1.setCode(1001);
			throw r1;

		}
		return students.get(0);
	}

		@Transactional
	public Student addStudentTransac(Student student) {
		System.out.println("point1");
		jdbctemplate.update("INSERT INTO students (name) VALUES (?)", student.getName());
		System.out.println("point2");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("point3");
		jdbctemplate.update("INSERT INTO students (name) VALUES (?)", student.getName());
		System.out.println("point4");
		return student;
	}

}
