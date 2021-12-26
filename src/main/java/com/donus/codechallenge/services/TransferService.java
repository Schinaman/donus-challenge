package com.donus.codechallenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.donus.codechallenge.entities.Account;
import com.donus.codechallenge.entities.Transfer;
import com.donus.codechallenge.repositories.AccountRepository;
import com.donus.codechallenge.repositories.TransferRepository;
import com.donus.codechallenge.services.exceptions.BankRequestException;

@Service
public class TransferService {

	@Autowired
	private TransferRepository repository;
	@Autowired
	private AccountRepository acRepository;
	

	public List<Transfer> findAll(){
		return repository.findAll();
	}
	
	public Transfer findById(Long id) {
		Optional<Transfer> obj = repository.findById(id);
		return obj.get();
	}
	

	public Transfer insert(Transfer obj) {
		Optional<Account> accFrom = acRepository.findById(obj.getAccountFrom().getCPF());
		Optional<Account> accTo = acRepository.findById(obj.getAccountTo());
		accFrom.get().transfere(accTo.get(), obj.getAmountTransfer());
		
		if (obj.getAccountTo().length() != 11) {
			throw new BankRequestException("CPF precisa ter 11 digitos");
		}
		
		for (char letter : obj.getAccountTo().toCharArray()) {
			if (letter < 48 || letter > 57) {
				throw new BankRequestException("CPF só aceita caracteres numericos");
			}
		}
		
		if (obj.getAccountFrom().getCPF() == obj.getAccountTo()) {
			throw new BankRequestException("Não é possível fazer transferência para a mesma conta");
		}
		
		if (obj.getAmountTransfer() < 0) {
			throw new BankRequestException("Transfira uma quantia positiva"); 
		}
		
		if (accFrom.get().getBalance()<0.0 || accTo.get().getBalance()<0.0) {
			throw new BankRequestException("Não há saldo para efetuar a transferência"); 
		}
		
		acRepository.save(accFrom.get());
		acRepository.save(accTo.get());
		return repository.save(obj);
	}

	
}
