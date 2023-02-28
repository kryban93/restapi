package com.example.restapi.service;

import com.example.restapi.dto.BorrowerDto;
import com.example.restapi.model.BookEntity;
import com.example.restapi.model.BorrowerEntity;
import com.example.restapi.model.Borrows;
import com.example.restapi.repository.BookRepository;
import com.example.restapi.repository.BorrowersRepository;import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BorrowService {
    private final BookRepository bookRepository;
    private final BorrowersRepository borrowersRepository;

    public BorrowService(BookRepository bookRepository, BorrowersRepository borrowersRepository) {
        this.bookRepository = bookRepository;
        this.borrowersRepository = borrowersRepository;
    }


    public BorrowerDto borrowBook(Borrows borrows) {

        Optional<BookEntity> bookOptional = bookRepository.findById(borrows.getBookid());
        Optional<BorrowerEntity> borrowerOptional = borrowersRepository.findById(borrows.getBorrowerid());
        if (bookOptional.isPresent() && borrowerOptional.isPresent()) {
            BorrowerEntity borrowerEntity =  borrowerOptional.get();
            BookEntity bookEntity = bookOptional.get();

            List<BookEntity> userBooks = borrowerEntity.getBooks();
            userBooks.add(bookEntity);
            borrowerEntity.setBooks(userBooks);

            return new BorrowerDto(borrowersRepository.save(borrowerEntity));
        }
        return null;
    }

    public BorrowerDto returnBook(Borrows borrows) {
        Optional<BookEntity> bookOptional = bookRepository.findById(borrows.getBookid());
        Optional<BorrowerEntity> borrowerOptional = borrowersRepository.findById(borrows.getBorrowerid());
        if (bookOptional.isPresent() && borrowerOptional.isPresent()) {
            BorrowerEntity borrowerEntity = borrowerOptional.get();
            BookEntity bookEntity = bookOptional.get();
            UUID bookid = bookEntity.getId();

            Predicate<BookEntity> byId = book -> book.getId() != bookid;
            List<BookEntity> userBooks = borrowerEntity.getBooks().stream().filter(byId).collect(Collectors.toList());
            borrowerEntity.setBooks(userBooks);

            return new BorrowerDto(borrowersRepository.save(borrowerEntity));
        }
        return null;
    }
}
