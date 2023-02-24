package com.example.restapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="books")
public class BookEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String isbn;
    private String author;

    @ManyToMany
    @JoinTable(name="borrows")
    List<BorrowerEntity> borrowers = new ArrayList<>();
    public BookEntity( String title, String isbn, String author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }
}
