package com.donus.codechallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donus.codechallenge.entities.Conta;

public interface ContaRepository extends JpaRepository<Conta, String> {

}
