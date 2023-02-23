package com.example.restapi.service;

import com.example.restapi.model.BookEntity;
import com.example.restapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<BookEntity> getBooks() {
        return bookRepository.findAll();
    }

    public BookEntity getSingleBook(long id) {
        return bookRepository.findById(id)
                .orElseThrow();
    }
}
