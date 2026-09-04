package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Book;
import com.example.demo.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/getbooks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Book> Getbooks() {
		List<Book> books = bookService.Getbooks();
		return books;

	}

	@RequestMapping(value = "/addbook", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Book addbook(@RequestBody Book newbook) {
		bookService.addbook(newbook);
		return newbook;
	}

	/*
	 * @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE,
	 * produces = MediaType.APPLICATION_JSON_VALUE) 
	 * public void DeleteBookById(@PathVariable int id) { 
	 * bookService.DeleteBookById(id);
	 * 
	 * }
	 */

	@RequestMapping(value = "/books/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void UpdateName(@PathVariable int id) {
		bookService.UpdateName(id);
	}

}
