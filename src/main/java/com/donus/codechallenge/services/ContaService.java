package com.donus.codechallenge.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.donus.codechallenge.entities.Conta;
import com.donus.codechallenge.entities.PessoaFisica;
import com.donus.codechallenge.repositories.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repository;
	
	public List<Conta> findAll(){
		return repository.findAll();
	}
	
	public Conta findById(String id) {
		Optional<Conta> obj = repository.findById(id);
		return obj.get();
	}
	
	public Conta insert(Conta obj) {
		return repository.save(obj);
	}
	
}
