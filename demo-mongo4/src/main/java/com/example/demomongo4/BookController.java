package com.example.demomongo4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/getBooks")
    public List<Book> getBook(){

        return bookRepository.findAll();
    }

    @PostMapping("/insertBook")
    public void insertBook(@RequestBody CreateRequest request){

        Book book = new Book(request.getName(), request.getAuthorName(), request.getCost());

        bookRepository.save(book);

    }

    @GetMapping("/getBookByAuthor")
    public List<Book> getBookByAuthorName(@RequestParam(value = "name") String name){

        List<Book> byAuthorName = bookRepository.findByAuthorName(name);

        return byAuthorName;
    }

}
