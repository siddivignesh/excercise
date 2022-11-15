package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDAO;
import com.example.demo.models.Book;

@Service
public class BookService {

	@Autowired
	private BookDAO bookDAO;

	public List<Book> Getbooks() {
		List<Book> books = bookDAO.Getbooks();
		return books;

	}

	public void addbook(Book newbook) {
		bookDAO.addbook(newbook);
	}

	/*public void DeleteBookById(int id) {
		bookDAO.DeleteBookByid(id);
	}
	*/
	public void UpdateName(int id) {
		bookDAO.UpdateName(id);
	}

}
