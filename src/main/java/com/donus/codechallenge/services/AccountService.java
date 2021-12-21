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

import com.donus.codechallenge.entities.BankRequestException;
import com.donus.codechallenge.entities.Account;
import com.donus.codechallenge.entities.PF;
import com.donus.codechallenge.entities.Transaction;
import com.donus.codechallenge.repositories.AccountRepository;
import com.donus.codechallenge.repositories.TransactionRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repository;
	
	@Autowired
	private TransactionRepository transacaoRepository;
	
	public List<Account> findAll(){
		return repository.findAll();
	}
	
	public Account findById(String id) {
		Optional<Account> obj = repository.findById(id);
		return obj.get();
	}
	
	public Account insert(Account obj) {
		if (obj.getBalance() != 0.0) throw new BankRequestException("Use a função 'deposita' ou 'transfere' para alterar o saldo da conta");	
		return repository.save(obj);
	}

	
	
}
