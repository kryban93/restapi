package com.example.restapi.dto;

import com.example.restapi.model.BorrowerEntity;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class BorrowerDto {
    private long id;
    private String name;
    private String lastname;

    public BorrowerDto(@NotNull BorrowerEntity borrower) {
        this.id = borrower.getId();
        this.name = borrower.getName();
        this.lastname = borrower.getLastname();
    }
}
