package com.example.restapi.controller;

import com.example.restapi.dto.BorrowerDto;
import com.example.restapi.model.BorrowerEntity;
import com.example.restapi.service.BorrowersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
