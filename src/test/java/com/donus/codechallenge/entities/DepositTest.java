package com.donus.codechallenge.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DepositTest {


	private Deposit object0;
	private Deposit object1;
	private Deposit object2 = new Deposit(4L, 1.000, new Account("37322979850", new PF("37322979850", "Charlinhos")));
	
	private double balance;
	private String name;
	private String cpf;
	private PF pf;
	private Account account;
	private Transfer transfer;
	
	
	@BeforeEach
	public void setup() {
		object0 = new Deposit();

		name = "Abcdefghi Jklkmnopq Rstuvxz";
		balance = 123456.78;
		cpf = "18172076010";
		
		pf = new PF(cpf, name);
		account = new Account(cpf, pf);
		object1 = new Deposit(null, balance, account);
		transfer = new Transfer(null, balance, account, cpf);
	}
	
	
	@Test
	void testDeposit() {

		// getters
		assertEquals(Deposit.class, object0.getClass());
		assertEquals(null, object0.getAccount());
		assertEquals(0, object0.getAmountDeposit(), 0.01);
		assertEquals(null, object0.getId());

		// setters
		object0.setAccount(account);
		object0.setAmountDeposit(balance);
		object0.setId(1L);
		// getters
		assertEquals(account, object0.getAccount());
		assertEquals(balance, object0.getAmountDeposit(), 0.01);
		assertEquals(1L, object0.getId());
	}

	@Test
	void testDepositLongDoubleDeposit() {
		assertEquals(Deposit.class, object1.getClass());
		assertEquals(new Account(cpf, pf), object1.getAccount());
		assertEquals(balance, object1.getAmountDeposit(), 0.01);
		assertEquals(null, object1.getId());
	}

	@Test
	void testGetId() {
		assertEquals(null, object0.getId());
	}

	@Test
	void testSetId() {
		object0.setId(1L);
		assertEquals(1, object0.getId());
	}

	@Test
	void testGetAmountDeposit() {
		assertEquals(0, object0.getAmountDeposit(), 0.01);
	}

	@Test
	void testSetAmountDeposit() {
		object0.setAmountDeposit(balance);
		assertEquals(balance, object0.getAmountDeposit(), 0.01);
	}

	@Test
	void testGetAccount() {
		assertEquals(null, object0.getAccount());
	}

	@Test
	void testSetAccount() {
		object0.setAccount(account);
		assertEquals(account, object0.getAccount());
	}

	@Test
	void testEqualsObject() {
		Deposit object1b = new Deposit(null, balance, account); 
		
		assertNotSame(object1b, object1);
	    assertTrue(object1b.equals(object1) && object1.equals(object1b));
	    assertTrue(object1b.hashCode() == object1.hashCode());
	    
	    assertFalse(object1.equals(object2) && object2.equals(object1));
	    assertFalse(object1.hashCode() == object2.hashCode());
	}

}
