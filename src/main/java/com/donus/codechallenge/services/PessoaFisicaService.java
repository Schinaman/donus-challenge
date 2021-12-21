package com.donus.codechallenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donus.codechallenge.entities.PF;
import com.donus.codechallenge.repositories.PFRepository;

@Service
public class PessoaFisicaService {

	@Autowired
	private PFRepository repository;
	
	public List<PF> findAll(){
		return repository.findAll();
	}
	
	public PF findById(String id) {
		Optional<PF> obj = repository.findById(id);
		return obj.get();
	}
	
	public PF insert(PF obj) {
		return repository.save(obj);
	}
		
}
