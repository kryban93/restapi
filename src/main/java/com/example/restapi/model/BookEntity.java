package com.example.restapi.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Setter
@Getter
@Entity(name="books")
public class BookEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String isbn;
    private String author;

    public BookEntity( String title, String isbn, String author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public BookEntity() {}

}
