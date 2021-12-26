package com.donus.codechallenge.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {

	private Account object0;
	private Account object1;
	private Account object2 = new Account("33344455566", new PF("33344455566", "Isaias"));
	

	private double balance;
	private String name;
	private String cpf;
	private PF pf;
//	private Deposit deposit;
//	private Transfer transfer;
	
	@BeforeEach
	public void setup() {
		object0 = new Account();

		name = "Abcdefghi Jklkmnopq Rstuvxz";
		balance = 123456.78;
		cpf = "18172076010";
		
		pf = new PF(cpf, name);
		object1 = new Account(cpf, pf);
//		deposit = new Deposit(null, balance, new Account(cpf, pf));
//		transfer = new Transfer(null, balance, object1, cpf);
	}

	@Test
	void testAccount() {

		// getters
		assertEquals(Account.class, object0.getClass());
		assertEquals(0, object0.getBalance(),0.01);
		assertEquals(null, object0.getCPF());
		assertEquals(null, object0.getPf());
		assertTrue(object0.getDeposits().isEmpty());
		assertTrue(object0.getTransfers().isEmpty());

		// setters
		object0.setBalance(balance);
		object0.setCPF(cpf);
		object0.setPf(pf);
		// getters
		assertEquals(balance, object0.getBalance(), 0.01);
		assertEquals(cpf, object0.getCPF());
		assertEquals(pf, object0.getPf());
	}

	@Test
	void testAccountStringAccount() {
		assertEquals(Account.class, object1.getClass());
		assertEquals(0.00, object1.getBalance(), 0.01);
		assertEquals(cpf, object1.getCPF());
	}


	@Test
	void testDeposita() {
		object0.deposita(balance);
		assertEquals(123456.78, object0.getBalance(), 0.01);
	}

	@Test
	void testTransfere() {
		object1.deposita(balance);
		object1.transfere(object0, balance);
		assertEquals(123456.78, object0.getBalance(), 0.01);
		assertEquals(00.00, object1.getBalance(), 0.01);
	}
	
	@Test
	void testEqualsObject() {
		Account object1b = new Account(cpf, pf); 
	
		assertNotSame(object1b, object1);
	    assertTrue(object1b.equals(object1) && object1.equals(object1b));
	    assertTrue(object1b.hashCode() == object1.hashCode());
	    
	    assertFalse(object1.equals(object2) && object2.equals(object1));
	    assertFalse(object1.hashCode() == object2.hashCode());
	    
	}

}
