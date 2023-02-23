package com.example.restapi.service;

import com.example.restapi.dto.BookDto;
import com.example.restapi.model.BookEntity;
import com.example.restapi.repository.BookRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {


    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<BookDto> getBooks() {
        return   bookRepository.findAll().stream().map(book -> new BookDto(book)).collect(Collectors.toList());
    }

    public BookEntity getSingleBook(long id) {
        return bookRepository.findById(id)
                .orElseThrow();
    }

    public ResponseEntity<BookEntity> createBook(@RequestBody BookEntity book) {
        try {
            BookEntity _book = bookRepository.save(new BookEntity(book.getTitle(),book.getIsbn(),book.getAuthor()));
            return new ResponseEntity<>(_book, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
