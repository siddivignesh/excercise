package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbAccessApplication {

	public static void main(String[] args) {
	/*	int i ;
	 Integer j = null;
	 i=j;
	 */
		SpringApplication.run(DbAccessApplication.class, args);
		System.out.println("hi from main");
	}

}
