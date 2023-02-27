package com.example.restapi.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Borrows {

    @Id
    private UUID bookid;

    @Id
    private UUID borrowerid;


}
