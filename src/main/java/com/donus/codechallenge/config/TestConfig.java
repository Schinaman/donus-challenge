package com.donus.codechallenge.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.donus.codechallenge.entities.Account;
import com.donus.codechallenge.entities.Deposit;
import com.donus.codechallenge.entities.PF;
import com.donus.codechallenge.entities.Transfer;
import com.donus.codechallenge.repositories.AccountRepository;
import com.donus.codechallenge.repositories.DepositRepository;
import com.donus.codechallenge.repositories.PFRepository;
import com.donus.codechallenge.repositories.TransferRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private AccountRepository contaRepository;
	@Autowired
	private PFRepository pfRepository;
	@Autowired
	private DepositRepository dRepo;
	@Autowired
	private TransferRepository transfRepo;
	
	@Override
	public void run(String... args) throws Exception {
	
		PF pf1 = new PF ("37322979850", "Guiga");
		PF pf2 = new PF("37322979851", "Juquinha");
		pfRepository.saveAll(Arrays.asList(pf1,pf2));
				
		Account cc1 = new Account("37322979850", pf1);
		Account cc2 = new Account("37322979851", pf2);
		contaRepository.saveAll(Arrays.asList(cc1,cc2));

//		Transaction tr1 = new Transaction(null, cc2);
//		Transaction tr2 = new Transaction(null, cc2);
//		transactionRepository.saveAll(Arrays.asList(tr1,tr2));
		
		Deposit dp1 = new Deposit(null, 1.000, cc2);
		Deposit dp2 = new Deposit (null, 1000.00, cc2);
		dRepo.saveAll(Arrays.asList(dp1,dp2));
		
		Transfer trf1 = new Transfer(null, 100.00, cc2, "37322979850");
		Transfer trf2 = new Transfer(null, 100.00, cc2, "37322979850");
		transfRepo.saveAll(Arrays.asList(trf1,trf2));
		
	}
	
}
