package com.example.restapi.dto;

import com.example.restapi.model.BookEntity;
import lombok.Data;

@Data
public class BookDto {

    private long id;
    private String title;
    private String isbn;
    private String author;

    public BookDto(BookEntity book) {
        this.title = book.getTitle();
        this.id = book.getId();
        this.isbn = book.getIsbn();
        this.author = book.getAuthor();

    }

}
