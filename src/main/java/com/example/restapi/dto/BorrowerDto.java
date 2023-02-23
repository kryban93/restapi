package com.example.restapi.dto;

import com.example.restapi.model.BorrowerEntity;
import lombok.Data;

import java.util.UUID;

@Data
public class BorrowerDto {
    private UUID id;
    private String name;
    private String lastname;

    public BorrowerDto(BorrowerEntity borrower) {
        this.id = borrower.getId();
        this.name = borrower.getName();
        this.lastname = borrower.getLastname();
    }
}
