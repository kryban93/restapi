package com.example.restapi.service;

import com.example.restapi.dto.BorrowerDto;
import com.example.restapi.model.BorrowerEntity;
import com.example.restapi.repository.BorrowersRepository;
import jakarta.persistence.ManyToOne;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowersService {
    private final BorrowersRepository borrowersRepository;

    public BorrowersService(BorrowersRepository borrowersRepository) {
        this.borrowersRepository = borrowersRepository;
    }

    List<BorrowerEntity> borrowers = new ArrayList<>();
    public List<BorrowerDto> getBorrowers() {
        return borrowersRepository.findAll().stream().map(borrower -> new BorrowerDto(borrower)).collect(Collectors.toList());
    }

}
