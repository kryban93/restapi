package com.example.restapi.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity(name="borrowers")
public class BorrowerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String lastname;
    @OneToMany()
    @JoinTable(name="borrows")
    List<BookEntity> books;

    public void BorrowerEntity(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public void BorrowerEntity() {}
}
