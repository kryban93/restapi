package com.example.restapi.repository;

import com.example.restapi.model.BorrowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BorrowersRepository extends JpaRepository<BorrowerEntity, UUID> {
}
