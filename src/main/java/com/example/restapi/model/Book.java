package com.example.restapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="books")
public class Book {
    @Id
    private long id;
    private String title;
    private String isbn;
    private String author;

    public Book(long id,String title,String isbn,String author) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public Book() {}

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }


}
