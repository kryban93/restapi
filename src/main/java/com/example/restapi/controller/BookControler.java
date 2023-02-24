package com.example.restapi.controller;

import com.example.restapi.dto.BookDto;
import com.example.restapi.model.BookEntity;
import com.example.restapi.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public List<BookDto> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/books/{id}")
    public BookEntity getBook(@PathVariable("id") UUID id) {
        return bookService.getSingleBook(id);
    }

    @PostMapping("/books")
    public ResponseEntity<BookEntity> createBook(@RequestBody BookEntity book) {
        return bookService.createBook(book);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto book) {
      return new ResponseEntity<>(bookService.updateBook(book), HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable UUID id) {
        return bookService.deleteBook(id);
    }
}
