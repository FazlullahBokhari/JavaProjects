package com.demojpa4.repository;

import com.demojpa4.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    public List<Book> findByAuthorName(String name);

    List<Book> findByCost(int cost);

    Book findById(int id);


}
