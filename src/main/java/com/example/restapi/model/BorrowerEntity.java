package com.example.restapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="borrowers")
public class BorrowerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String lastname;
    @ManyToMany()
    @JoinTable(name ="borrows")
    List<BookEntity> books = new ArrayList<>();



    public BorrowerEntity(String name, String lastname,List<BookEntity> books) {
        this.name = name;
        this.lastname = lastname;
        this.books = books;
    }
}
