package com.donus.codechallenge.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.donus.codechallenge.entities.Account;
import com.donus.codechallenge.entities.PF;
import com.donus.codechallenge.entities.Transaction;
import com.donus.codechallenge.repositories.AccountRepository;
import com.donus.codechallenge.repositories.PFRepository;
import com.donus.codechallenge.repositories.TransactionRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private AccountRepository contaRepository;
	@Autowired
	private PFRepository pfRepository;
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		PF pf1 = new PF ("37322979850", "Guiga");
		PF pf2 = new PF("37322979851", "Juquinha");
		pfRepository.saveAll(Arrays.asList(pf1,pf2));
				
		Account cc1 = new Account("37322979850", pf1);
		Account cc2 = new Account("37322979851", pf2);
		contaRepository.saveAll(Arrays.asList(cc1,cc2));

		Transaction tr1 = new Transaction(null, cc2);
		Transaction tr2 = new Transaction(null, cc2);
		transactionRepository.saveAll(Arrays.asList(tr1,tr2));
		
	}
	
}
