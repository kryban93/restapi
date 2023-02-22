package com.example.restapi.service;

import com.example.restapi.model.Book;
import com.example.restapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getSingleBook(long id) {
        return bookRepository.findById(id)
                .orElseThrow();
    }
}
