package com.example.restapi.model;


import jakarta.persistence.*;

import java.util.List;

@Entity(name="borrowers")
public class BorrowerEntity {
    @Id
    private long id;
    private String name;
    private String lastname;
    @OneToMany()
    @JoinTable(name="borrows")
    List<BookEntity> books;

    public void BorrowerEntity(long id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }

    public String getName () {
        return name;
    }

    public String getLastname () {
        return lastname;
    }




}
