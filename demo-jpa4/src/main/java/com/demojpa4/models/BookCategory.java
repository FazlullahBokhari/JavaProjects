package com.demojpa4.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Iterator;
import java.util.Set;


@Entity
public class BookCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "bookCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> books;

    public BookCategory() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBook() {
        return books;
    }

    public void setBook(Set<Book> books) {
        this.books = books;
    }

    public BookCategory(String name) {
        this.name = name;
    }

    public BookCategory(int id) {
        this.id = id;
    }

    public BookCategory(int id, String name, Set<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public BookCategory(String name, Set<Book> books) {
        this.name = name;
        this.books = books;

        this.books.forEach(x->x.setBookCategory(this));

        /*Iterator it = books.iterator();

        while(it.hasNext()){
            Book book = (Book)it.next();
            book.setBookCategory(this);
        }*/
    }
}
