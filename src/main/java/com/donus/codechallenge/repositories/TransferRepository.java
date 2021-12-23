package com.donus.codechallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donus.codechallenge.entities.Transfer;;

public interface TransferRepository extends JpaRepository<Transfer, Long> {

}
