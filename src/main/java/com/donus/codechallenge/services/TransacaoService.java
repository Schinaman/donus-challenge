package com.donus.codechallenge.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.donus.codechallenge.entities.BankRequestException;
import com.donus.codechallenge.entities.Account;
import com.donus.codechallenge.entities.Transaction;
import com.donus.codechallenge.entities.PF;
import com.donus.codechallenge.entities.Transaction;
import com.donus.codechallenge.repositories.AccountRepository;
import com.donus.codechallenge.repositories.TransactionRepository;

@Service
public class TransacaoService {

	@Autowired
	private TransactionRepository repository;
	
	
	public List<Transaction> findAll(){
		return repository.findAll();
	}
	
	public Transaction findById(Long id) {
		Optional<Transaction> obj = repository.findById(id);
		return obj.get();
	}
	
	public Transaction insert(Transaction obj) {	
		return repository.save(obj);
	}

//	
//	public Transaction deposita(Transaction obj) {
//		obj.deposita(obj.getConta(), obj.getValor());
//		return obj;
//	}

	
}
