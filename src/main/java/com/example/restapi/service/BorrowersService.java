package com.example.restapi.service;

import com.example.restapi.model.Borrowers;
import com.example.restapi.repository.BorrowersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowersService {
    private final BorrowersRepository borrowersRepository;

    public BorrowersService(BorrowersRepository borrowersRepository) {
        this.borrowersRepository = borrowersRepository;
    }

    public List<Borrowers> getBorrowers() {
        return borrowersRepository.findAll();
    }
}
