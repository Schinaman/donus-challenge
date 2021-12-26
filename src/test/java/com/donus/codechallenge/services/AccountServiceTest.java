package com.donus.codechallenge.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.donus.codechallenge.entities.Account;
import com.donus.codechallenge.entities.PF;
import com.donus.codechallenge.repositories.AccountRepository;
import com.donus.codechallenge.services.exceptions.BankRequestException;

class AccountServiceTest {


	@InjectMocks
	private AccountService service;
	
	@Mock
	private AccountRepository repository;

	private Account account;
	private Optional<Account> optionalAccount;
	private PF pf;
	private Optional<PF> optionalPF;
	private String cpf;
	private String name;
	private double balance;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		cpf = "37322979850";
		name = "Zequinha do Vale";
		//balance = 1000.00;
		pf = new PF(cpf, name);
		optionalPF = Optional.of(new PF(cpf, name));
		account = new Account(cpf, pf);
		account.setBalance(balance);
		optionalAccount = Optional.of(new Account(cpf, pf));
	}
	
	@Test
	void whenFindAllThenReturnAllAccountInstances() {
		when(repository.findAll()).thenReturn(List.of(account));
		List<Account> response = service.findAll();
		
		assertNotNull(response);
		assertEquals(1, response.size());
		assertEquals(Account.class, response.get(0).getClass());
	}

	@Test
	void whenFindByIdThenReturnAnAccountInstance() {
		when(repository.findById(Mockito.anyString())).thenReturn(optionalAccount);
		
		balance = 1000.00;
		Account response = service.findById(cpf);
		response.setBalance(balance);
		
		assertNotNull(response);
		assertEquals(Account.class, response.getClass());
		assertEquals(cpf, response.getCPF());
		assertEquals(balance, response.getBalance(), 1000.00);
	}

	@Test
	void whenInsertThenReturnSuccess() {
		when(repository.save(Mockito.any())).thenReturn(account);
		
		Account response = service.insert(account);
				
		assertNotNull(response);
		assertEquals(Account.class, response.getClass());
		assertEquals(cpf, response.getCPF());
		assertEquals(0.00, response.getBalance(), 0.01);
	}
	
	@Test
	void whenInsertThenReturnBankRequestExceptionBalanceShoubleBeZero() {
		when(repository.save(Mockito.any())).thenReturn(account);
		account.setBalance(12348.25);
		
		try {
			service.insert(account);
			fail("deveria lançar exceção");
		} catch (Exception e) {
			assertEquals(BankRequestException.class, e.getClass());
			assertEquals("Use a função 'deposita' ou 'transfere' para alterar o saldo da conta", e.getMessage());		
		}	
	}
}
