package com.example.restapi.service;

import com.example.restapi.dto.BorrowerDto;
import com.example.restapi.repository.BorrowersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowersService {
    private final BorrowersRepository borrowersRepository;

    public BorrowersService(BorrowersRepository borrowersRepository) {
        this.borrowersRepository = borrowersRepository;
    }

    public List<BorrowerDto> getBorrowers() {
        return borrowersRepository.findAll().stream().map(borrower -> new BorrowerDto(borrower)).collect(Collectors.toList());
    }
}
