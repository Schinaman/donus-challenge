package com.donus.codechallenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donus.codechallenge.entities.PessoaFisica;
import com.donus.codechallenge.repositories.PessoaFisicaRepository;

@Service
public class PessoaFisicaService {

	@Autowired
	private PessoaFisicaRepository repository;
	
	public List<PessoaFisica> findAll(){
		return repository.findAll();
	}
	
	public PessoaFisica findById(String id) {
		Optional<PessoaFisica> obj = repository.findById(id);
		return obj.get();
	}
	
	public PessoaFisica insert(PessoaFisica obj) {
		return repository.save(obj);
	}
		
}
