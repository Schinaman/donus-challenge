package com.donus.codechallenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donus.codechallenge.entities.PF;
import com.donus.codechallenge.repositories.PFRepository;
import com.donus.codechallenge.services.exceptions.BankRequestException;

@Service
public class PFService {

	@Autowired
	private PFRepository repository;
	
	public List<PF> findAll(){
		return repository.findAll();
	}
	
	public PF findById(String id) {
		Optional<PF> obj = repository.findById(id);
		return obj.orElseThrow(() -> new BankRequestException("Objeto não encontrado"));
	}
	
	public PF insert(PF obj) {
		
		if (obj.getCPF().length() != 11) {
			throw new BankRequestException("CPF precisa ter 11 digitos");
		}
		
		for (char letter : obj.getCPF().toCharArray()) {
			if (letter < 48 || letter > 57) {
				throw new BankRequestException("CPF só aceita caracteres numericos");
			}
		}
		return repository.save(obj);
	}
		
}
