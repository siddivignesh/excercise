package com.example.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exceptions.MyRunTimeException;
import com.example.demo.models.Book;
import com.example.demo.models.Counselling;
import com.example.demo.models.Student;

@Component
public class StudentDAO {

	@Autowired
	private JdbcTemplate jdbctemplate;

	public List<Student> GetAllStudents() {
		// List<Student> students = new ArrayList<Student>();
		List<Map<String, Object>> resultList = jdbctemplate
				.queryForList("SELECT ST.ID STID,ST.NAME STN,BKS.ID BKSD,BKS.NAME BKSN \r\n" + "FROM STUDENTS ST\r\n"
						+ "LEFT JOIN BOOKS_RESERVATION BR ON ST.ID = BR.STUDENT_ID\r\n"
						+ "LEFT JOIN BOOKS BKS ON  BR.BOOK_ID= BKS.ID;");
		Map<Integer, Student> map = new HashMap<Integer, Student>();

		for (Map<String, Object> r1 : resultList) {
			// r1.get("STID");
			// r1.get("STN");
			// r1.get("BKSD");
			// System.out.printl
			// r1.get("BKSN");

			// Student s1 = new Student();

			// s1.setId((int) r1.get("STID"));
			// s1.setName((String) r1.get("STN"));

			// s1.setId((int)r1.get("BKSD"));
			// s1.setName((String)r1.get("BKSN"));

			// students.add(s1);

			// students.stream().filter(student -> student.getId() == ((int)
			// r1.get("STID"))).

			Student st = map.get(r1.get("STID"));

			/*
			 * List<Student> s1 = students.stream().filter(student -> student.getId() ==
			 * ((int) r1.get("STID"))) .collect(Collectors.toList());
			 * 
			 * if (!s1.isEmpty()) {// students.stream().filter(student -> student.getId() ==
			 * ((int) // r1.get("STID"))).collect(Collectors.toList()).isEmpty()){ st =
			 * s1.get(0); }
			 */

			// if(sm==null)

			if (st == null) {
				st = new Student();
				st.setId((int) r1.get("STID"));
				st.setName((String) r1.get("STN"));
				// students.add(st);
				map.put(st.getId(), st);

			}

			// for (Student student : students) {

			// if (student.getId() == ((int) r1.get("STID"))) {
			// st = student;
			// break;
			// }
			// }

			// System.out.println(st);
			/*
			 * if (st == null) { st = new Student(); st.setId((int)r1.get("STID"));
			 * st.setName((String)r1.get("STN")); students.add(st);
			 * 
			 * }
			 */
			// System.out.println(r1.get("BKSD"));
			if (r1.get("BKSD") != null) {
				Book b1 = new Book();
				b1.setId((int) r1.get("BKSD"));
				b1.setName((String) r1.get("BKSN"));
				st.getBooks().add(b1);
			}
		}
		// List<Student> students = new ArrayList<Student>();
		return new ArrayList<Student>(map.values());

	}

	public List<Book> getAllBooks() {
		List<Book> books = jdbctemplate
				.query("SELECT BKS.ID BKSID,BR.STUDENT_ID BRSD,ST.NAME STN,BKS.NAME BKSN FROM BOOKS BKS\r\n"
						+ "LEFT  JOIN BOOKS_RESERVATION BR ON BR.ID =  BKS.ID\r\n"
						+ "LEFT JOIN STUDENTS ST ON ST.ID=BR.STUDENT_ID;\r\n" + "\r\n", new RowMapper<Book>() {

							@Override
							public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
								// TODO Auto-generated method stub
								Book book = new Book();
								book.setId(rs.getInt("bksid"));
								book.setName(rs.getNString("bksn"));
								book.setStudentid(rs.getInt("brsd"));
								book.setStudentname(rs.getNString("stn"));

								return book;
							}

						});

		return books;

	}

	public List<Book> getbook(int id) {
		List<Book> book = jdbctemplate.query("SELECT * FROM BOOKS WHERE ID = ?", new RowMapper<Book>() {

			@Override
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Book book = new Book();
				book.setId(rs.getInt("ID"));
				book.setName(rs.getNString("NAME"));
				return book;
			}

		}, id);

		return book;

	}

	/*
	 * public List<Book> bookallocation(int id) { List<Book> books =
	 * jdbctemplate.query("SELECT * FROM BOOKS_RESERVATION WHERE ID = ? ;", new
	 * RowMapper<Book>() {
	 * 
	 * @Override public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
	 * // TODO Auto-generated method stub Book books = new Book();
	 * books.setId(rs.getInt("ID")); return books; }
	 * 
	 * }, id); if (books.isEmpty()) { System.out.println("not alloted"); } Book book
	 * = books.get(0);
	 * 
	 * return books;
	 * 
	 * }
	 */

	// ADDBOOK
	public Book addbook(Book book) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String query = "INSERT INTO BOOKS(ID,NAME) VALUES(?,?)";
		jdbctemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement st = connection.prepareStatement(query, new String[] { "id", "name" });
				st.setInt(1, book.getId());
				st.setString(2, book.getName());
				return st;
			}
		}, keyHolder);

		return book;

	}

	public List<Counselling> getclgdepartment() {
		List<Counselling> counselling = jdbctemplate.query(
				"SELECT  CL.NAME CLN,DP.NAME DPN,CD.ID CDI,CL.ID CLI,DP.ID DPI,CD.CLG_ID CCLI,CD.DEPT_ID DPI,CD.NO_OF_SEATS,AVAILABLE_SEATS NOS\r\n"
						+ "FROM COLLEGE_DEPARTMENTS CD\r\n" + "INNER JOIN COLLEGES CL ON CL.ID = CD.CLG_ID\r\n"
						+ "INNER JOIN DEPARTMENTS DP ON DP.ID=CD.DEPT_ID;",
				new CounsellingMapper());
		return counselling;

	}

	public Student addStudent(Student student) {
		System.out.println("point1");

		KeyHolder keyHolder = new GeneratedKeyHolder();

		String query = "INSERT INTO STUDENTS (NAME,CLG_DEPT_ID) VALUES (?,?)";

		PreparedStatementCreator preparedstatementcreator1 = new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement st = connection.prepareStatement(query, new String[] { "name", "CLG_DEPT_ID" });
				st.setString(1, student.getName());
				st.setLong(2, student.getClgdeptid());

				return st;
			}
		};

		int s2 = jdbctemplate.update(preparedstatementcreator1, keyHolder);

		if (s2 == 0) {
			MyRunTimeException r4 = new MyRunTimeException();
			r4.setReason("Invalid id");
			throw r4;
		}

		// student.setName(keyHolder.getKey().toString());
		// student.setClgdeptid(keyHolder.getKey().intValue());
		// System.out.println(keyHolder.getKey().intValue());
		/*
		 * jdbctemplate.update(
		 * "SELECT last_insert_id(); where TABLE_NAME = students,INSERT INTO students (id,name) VALUES (?,?)"
		 * , student.getName(),student.getId() );
		 */
		return student;
	}

	public Student updateavailableseats(int id) {
		KeyHolder keyHolder1 = new GeneratedKeyHolder();
 
		String query = "UPDATE COLLEGE_DEPARTMENTS \r\n" + "SET AVAILABLE_SEATS = AVAILABLE_SEATS-1\r\n"
				+ "WHERE ID = ?;";
		// we are creating anonymous class which implements the interface
		// PreparedStatementCreator()
		jdbctemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement st = connection.prepareStatement(query, new String[] {});

				st.setInt(1, id);

				return st;

			}
		}, keyHolder1);

		return null;

	}

	public int getAvailableseats(int id) {
		List<Counselling> counsellings = jdbctemplate.query("SELECT * FROM COLLEGE_DEPARTMENTS WHERE ID = ?;",
				new RowMapper<Counselling>() {

					@Override
					public Counselling mapRow(ResultSet sr, int num) throws SQLException {
						Counselling counselling = new Counselling();
						counselling.setAvailableseats(sr.getInt("AVAILABLE_SEATS"));
						return counselling;
					}

				}, id);

		if (counsellings.isEmpty()) {

			MyRunTimeException r1 = new MyRunTimeException();
			r1.setReason("invalid id");
			throw r1;
		}
		Counselling counselling = counsellings.get(0);

		// return 0;
		if (counselling.getAvailableseats() == 0) {
			System.out.println("Exception");

			MyRunTimeException r2 = new MyRunTimeException();
			r2.setReason("seats not available");
			throw r2;
			// seats not available

			// MyRunTimeException r1 = new MyRunTimeException();
			// throw r1;

		}

		return counselling.getAvailableseats();
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

	public void updatestudent(int id, String name) {

		KeyHolder keyHolder1 = new GeneratedKeyHolder();

		String query = "UPDATE STUDENTS SET NAME = ? WHERE ID = ? ;";
		// we are creating anonymous class which implements the interface
		// PreparedStatementCreator()
		PreparedStatementCreator preparedstatmentcreator = new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement st = connection.prepareStatement(query, new String[] {});
				st.setString(1, name);
				st.setInt(2, id);

				return st;

			}
		};

		int s1 = jdbctemplate.update(preparedstatmentcreator, keyHolder1);

		if (s1 == 0) {
			MyRunTimeException r2 = new MyRunTimeException();
			r2.setReason("invalid id");
			throw r2;
		}

		// student.setId(keyHolder1.getKey().intValue());
	}

	public void deletestudent(int id) {
		String deletequery = "DELETE FROM STUDENTS WHERE ID = ?;";

		/*
		 * PreparedStatementCreator preparedstatmentcreator = new
		 * PreparedStatementCreator() { public PreparedStatement
		 * createPreparedStatement(Connection connection) throws SQLException {
		 * PreparedStatement st = connection.prepareStatement(deletequery, new String[]
		 * {}); st.setInt(1, id);
		 * 
		 * return st;
		 * 
		 * } };
		 */

		// int s2 = jdbctemplate.update(preparedstatmentcreator, new
		// GeneratedKeyHolder());
		int s2 = jdbctemplate.update(deletequery, id);
		if (s2 == 0) {
			MyRunTimeException r3 = new MyRunTimeException();
			r3.setReason("invalid id to delete");
			throw r3; 
		}
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
