package com.example.restapi.service;

import com.example.restapi.dto.BorrowerDto;
import com.example.restapi.model.BorrowerEntity;
import com.example.restapi.repository.BorrowersRepository;
import jakarta.persistence.ManyToOne;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
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

    public BorrowerDto getBorrower(UUID id) {
        Optional<BorrowerEntity> borrowerEntityOptional = borrowersRepository.findById(id);
        if (borrowerEntityOptional.isPresent()) {
            BorrowerEntity borrowerEntity = borrowerEntityOptional.get();
            return new BorrowerDto(borrowerEntity);
        }
        return null;
    }

    public ResponseEntity<BorrowerDto> createBorrower(@RequestBody BorrowerEntity borrower) {
        try {
            BorrowerEntity savedBorrower = borrowersRepository.save(new BorrowerEntity(borrower.getName(),borrower.getLastname(),borrower.getBooks()));
            return new ResponseEntity<>(new BorrowerDto(savedBorrower), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public BorrowerDto updateBorrower(BorrowerDto borrower) {
        Optional<BorrowerEntity> borrowerEntityOptional = borrowersRepository.findById(borrower.getId());

        if (borrowerEntityOptional.isPresent()) {
            BorrowerEntity borrowerEntity  = borrowerEntityOptional.get();
            borrowerEntity.setName(borrower.getName());
            borrowerEntity.setLastname(borrower.getLastname());

            return new BorrowerDto(borrowersRepository.save(borrowerEntity));
        }
        return null;
    }

    public ResponseEntity<HttpStatus> deleteBorrower(UUID id) {
        try {
            borrowersRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
