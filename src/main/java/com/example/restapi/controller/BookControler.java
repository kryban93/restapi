package com.example.restapi.controller;

import com.example.restapi.model.BookEntity;
import com.example.restapi.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookControler {

    private final BookService bookService;

    public BookControler(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/books")
    public List<BookEntity> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/books/{id}")
    public BookEntity getBook(@PathVariable long id) {
        return bookService.getSingleBook(id);
    }
}
