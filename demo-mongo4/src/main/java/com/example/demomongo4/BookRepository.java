package com.example.demomongo4;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, Integer> {

    public List<Book> findByAuthorName(String name);
}
