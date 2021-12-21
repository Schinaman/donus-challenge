package com.donus.codechallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donus.codechallenge.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
