package com.example.restapi.service;

import com.example.restapi.model.BorrowerEntity;
import com.example.restapi.repository.BorrowersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowersService {
    private final BorrowersRepository borrowersRepository;

    public BorrowersService(BorrowersRepository borrowersRepository) {
        this.borrowersRepository = borrowersRepository;
    }

    public List<BorrowerEntity> getBorrowers() {
        return borrowersRepository.findAll();
    }
}
