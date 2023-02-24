package com.example.restapi.service;

import com.example.restapi.dto.BookDto;
import com.example.restapi.model.BookEntity;
import com.example.restapi.repository.BookRepository;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {


    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<BookDto> getBooks() {
        return   bookRepository.findAll().stream().map(BookDto::new).collect(Collectors.toList());
    }

    public BookEntity getSingleBook(long id) {
        return bookRepository.findById(id)
                .orElseThrow();
    }

    public ResponseEntity<BookEntity> createBook(@RequestBody BookEntity book) {
        try {
            BookEntity savedBook = bookRepository.save(new BookEntity(book.getTitle(),book.getIsbn(),book.getAuthor()));
            return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public BookDto updateBook(BookDto book) {
        Optional<BookEntity> bookEntityOptional = bookRepository.findById(book.getId());
//        bookEntityOptional.ifPresent(bookEntity -> {
//            bookEntity.setTitle(book.getTitle());
//            bookEntity.setIsbn(book.getIsbn());
//            bookEntity.setAuthor(book.getAuthor());
//
//             bookRepository.save(bookEntity);
//        });
//        return bookRepository.findById(book.getId()).map(BookDto::new).orElseThrow();


        if (bookEntityOptional.isPresent()) {
            BookEntity bookEntity = bookEntityOptional.get();
            bookEntity.setTitle(book.getTitle());
            bookEntity.setIsbn(book.getIsbn());
            bookEntity.setAuthor(book.getAuthor());

            return new BookDto(bookRepository.save(bookEntity));
        }
        return null;
    }

    public ResponseEntity<HttpStatus> deleteBook(UUID id) {
        try {
            bookRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
