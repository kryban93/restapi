package com.example.restapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Borrowers {
    @Id
    private long id;
    private String name;
    private String lastname;
    private String bookid;

    public void Borrowers(long id, String name, String lastname, String bookid) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.bookid = bookid;
    }

    public String getName () {
        return name;
    }

    public String getLastname () {
        return lastname;
    }

    public String getBookid () {
        return bookid;
    }

}
