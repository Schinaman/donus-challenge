package com.donus.codechallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donus.codechallenge.entities.Deposit;

public interface DepositRepository extends JpaRepository<Deposit, Long> {

}
