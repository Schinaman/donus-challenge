package com.donus.codechallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donus.codechallenge.entities.PessoaFisica;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, String> {

}
