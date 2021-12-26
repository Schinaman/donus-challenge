package com.donus.codechallenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donus.codechallenge.entities.Account;
import com.donus.codechallenge.entities.Deposit;
import com.donus.codechallenge.repositories.AccountRepository;
import com.donus.codechallenge.repositories.DepositRepository;
import com.donus.codechallenge.services.exceptions.BankRequestException;

@Service
public class DepositService {

	@Autowired
	private DepositRepository repository;
	@Autowired
	private AccountRepository acRepository;
	
	public List<Deposit> findAll(){
		return repository.findAll();
	}
	
	public Deposit findById(Long id) {
		Optional<Deposit> obj = repository.findById(id);
		return obj.get();
	}
	
	public Deposit insert(Deposit obj) {
		
		
		if (obj.getAmountDeposit() < 0) {
			throw new BankRequestException("Deposite uma quantia positiva"); 
		}
		
		if (obj.getAmountDeposit() > 2000.0) {
			throw new BankRequestException("Não é permitido depositos acima de 2.000"); 
		}
		
		Optional<Account> acc = acRepository.findById(obj.getAccount().getCPF());
		acc.get().deposita(obj.getAmountDeposit());
		acRepository.save(acc.get());
		return repository.save(obj);
	}

}
