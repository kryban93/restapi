package com.example.restapi.controller;

import com.example.restapi.dto.BorrowerDto;
import com.example.restapi.model.BorrowerEntity;
import com.example.restapi.service.BorrowersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BorrowersController {

    private final BorrowersService borrowersService;

    public  BorrowersController(BorrowersService borrowersService) {
        this.borrowersService = borrowersService;
    }

    @GetMapping("/users")
    public List<BorrowerDto> getBorrowers() {
        return borrowersService.getBorrowers();
    }

    @GetMapping("/users/{id}")
    public BorrowerDto getBorrower(@PathVariable UUID id) {
        return borrowersService.getBorrower(id);
    }

    @PostMapping("/users")
    public ResponseEntity<BorrowerDto> createBorrower(@RequestBody BorrowerEntity borrower) {
        return borrowersService.createBorrower(borrower);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<BorrowerDto> updateBorrower(@RequestBody BorrowerDto borrower) {
        return new ResponseEntity<>(borrowersService.updateBorrower(borrower), HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteBorrower(@PathVariable UUID id) {
        return borrowersService.deleteBorrower(id);
    }
}
