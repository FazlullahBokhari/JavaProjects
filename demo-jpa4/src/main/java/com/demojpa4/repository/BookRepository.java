package com.demojpa4.repository;

import com.demojpa4.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    //Custom function for database work
    @Query(value = "select * from Book b where b.author_name=:my_name", nativeQuery = true)
    public List<Book> findByAuthor(String my_name);

    @Query(value = "select b from Book b where b.authorName=:authors_name")
    public List<Book> findByAuthors(String authors_name);

    public List<Book> findByAuthorName(String name);

    List<Book> findByCost(int cost);

    Book findById(int id);


}
