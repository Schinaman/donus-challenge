package com.donus.codechallenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donus.codechallenge.entities.Account;
import com.donus.codechallenge.repositories.AccountRepository;
import com.donus.codechallenge.services.exceptions.BankRequestException;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repository;
	
	
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
