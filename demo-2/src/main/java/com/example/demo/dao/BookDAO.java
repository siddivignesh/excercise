package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.example.demo.models.Book;

@Component
public class BookDAO {
	List<Book> books = new ArrayList<Book>();

	@PostConstruct
	public void init() {
		Book b1 = new Book();
		b1.setName("Mathematics");
		b1.setId(1001);
		books.add(b1);

		Book b2 = new Book();
		b2.setName("science");
		b2.setId(1002);
		books.add(b2);
	}

	public void addbook(Book newbook) {
		books.add(newbook);

	}

	/*public void DeleteBookByid(int id) {
		System.out.println(id);

		// System.out.println("point1 " + books.get(0).getName());
		// System.out.println("point2 " + books.get(1).getId());

		for (Book book : books) {

			System.out.println("enhance " + book.getId());
		}
		int result = -1;
		for (int i = 0; i < books.size(); i++) {
			System.out.println("in for loop " + i);
			if (books.get(i).getId() == id) {
				System.out.println("id found");

				result = i;
				break;
			}
			// System.out.println(i);
		}
		if (result == -1) {
			System.out.println("id not found");
		} else {
			System.out.println("Position where id was found = " + result);
			books.remove(result);

		}

	}
*/
	public void UpdateName(int id) {
		for (Book book : books) {
			if (book.getId() == id) {
				//System.out.println("name :" + "Arts");
				book.setName("Arts");
				break;
				
			}
		}

	}

	public List<Book> Getbooks() {

		return books;
	}

}
