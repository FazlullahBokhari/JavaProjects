package com.demojpa4;

import com.demojpa4.models.Book;
import com.demojpa4.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJpa4Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoJpa4Application.class, args);
	}

	@Autowired
	BookRepository bookRepository;


	@Override
	public void run(String... args) throws Exception {
		/*Book b1 = new Book();

		b1.setId(1);
		b1.setCost(30);
		b1.setName("ABC");
		b1.setAuthorName("ABC1234");*//*

		bookRepository.save(b1);*/

		System.out.println(bookRepository.findAll());

		System.out.println(bookRepository.findByAuthorName("ABC1234"));

		System.out.println(bookRepository.findByCost(30));
		System.out.println(bookRepository.findById(1));

	}
}
