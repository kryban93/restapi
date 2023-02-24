package com.example.restapi.dto;

import com.example.restapi.model.BorrowerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowerDto {
    private UUID id;
    private String name;
    private String lastname;

    private List<BookDto> books;

    public BorrowerDto(BorrowerEntity borrower) {
        this.id = borrower.getId();
        this.name = borrower.getName();
        this.lastname = borrower.getLastname();
        this.books = borrower.getBooks().stream().map(BookDto::new).collect(Collectors.toList());
    }
}
