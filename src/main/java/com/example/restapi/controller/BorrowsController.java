package com.example.restapi.controller;

import com.example.restapi.dto.BookDto;
import com.example.restapi.dto.BorrowerDto;
import com.example.restapi.model.Borrows;
import com.example.restapi.service.BorrowService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BorrowsController {

    private final BorrowService borrowService;

    public BorrowsController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }
    @PutMapping("/borrow")
    public BorrowerDto borrowBook(@RequestBody Borrows borrows) {
        return borrowService.borrowBook(borrows);
    }
}
