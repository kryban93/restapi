package com.example.restapi.service;

import com.example.restapi.dto.BookDto;
import com.example.restapi.model.BookEntity;
import com.example.restapi.repository.BookRepository;

import org.springframework.stereotype.Service;

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
}
