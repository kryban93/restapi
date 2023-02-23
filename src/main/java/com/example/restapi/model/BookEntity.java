package com.example.restapi.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Setter;


@Setter
@Entity(name="books")
public class BookEntity {
    @Id()
    private long id;
    private String title;
    private String isbn;
    private String author;

    public BookEntity(long id, String title, String isbn, String author) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public BookEntity() {}

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }
}
