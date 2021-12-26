package com.donus.codechallenge.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransferTest {

	private Transfer object0;
	private Transfer object1;
	private Transfer object2 = new Transfer(4L, 1.000, new Account("37322979850", new PF("37322979850", "Charlinhos")),"37322979873");

	private double balance;
	private String name;
	private String cpf;
	private PF pf;
	private Account account;
	private Deposit deposit;

	@BeforeEach
	public void setup() {
		object0 = new Transfer();

		name = "Abcdefghi Jklkmnopq Rstuvxz";
		balance = 123456.78;
		cpf = "18172076010";

		pf = new PF(cpf, name);
		account = new Account(cpf, pf);
		deposit = new Deposit(null, balance, account);
		object1 = new Transfer(null, balance, account, cpf);
	}


	@Test
	void testTransfer() {
		// getters
		assertEquals(Transfer.class, object0.getClass());
		
		assertEquals(null, object0.getAccountFrom());
		assertEquals(null, object0.getAccountTo());
		assertEquals(0, object0.getAmountTransfer(), 0.01);
		assertEquals(null, object0.getId());

		// setters
		object0.setAccountFrom(account);
		object0.setAccountTo("37322979861");
		object0.setAmountTransfer(balance);
		object0.setId(1L);
		// getters
		assertEquals(account, object0.getAccountFrom());
		assertEquals("37322979861", object0.getAccountTo());
		assertEquals(balance, object0.getAmountTransfer(), 0.01);
		assertEquals(1L, object0.getId());
	}

	@Test
	void testTransferLongDoubleAccountString() {
		assertEquals(Transfer.class, object1.getClass());
		assertEquals(account, object1.getAccountFrom());
		assertEquals(cpf, object1.getAccountTo());
		assertEquals(balance, object1.getAmountTransfer(), 0.01);
		assertEquals(null, object1.getId());	
	}


	@Test
	void testEqualsObject() {
		Transfer object1b = new Transfer(null, balance, account, "37322979861"); 
		
		assertNotSame(object1b, object1);
	    assertTrue(object1b.equals(object1) && object1.equals(object1b));
	    assertTrue(object1b.hashCode() == object1.hashCode());
	    
	    assertFalse(object1.equals(object2) && object2.equals(object1));
	    assertFalse(object1.hashCode() == object2.hashCode());
	}

}
