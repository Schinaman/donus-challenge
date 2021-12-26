package com.donus.codechallenge.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class PFTest {

//	@Before
//	public void setup() {		
//	}
	
	@Test
	void testPF() {
		PF pf = new PF();
		pf.setConta(null);
		
	   //getters
		assertEquals(PF.class, pf.getClass());
		assertEquals(null, pf.getCPF());
		assertEquals(null, pf.getFullName());
		assertEquals(null, pf.getConta());
	
	   //setters
		pf.setCPF("18172076010");
		pf.setFullName("Abcdefghi Jklkmnopq Rstuvxz");
		
		pf.setConta(new Account("18172076010", pf));
		Account conta = new Account("18172076010", pf);
	   //getters
		assertEquals("18172076010", pf.getCPF());
		assertEquals("Abcdefghi Jklkmnopq Rstuvxz", pf.getFullName());
		assertEquals(conta, pf.getConta()); //to validando o equals de conta e se o meu getter ta puxando o setter novo
		
	}

	@Test
	void testPFStringString() {
		PF pf = new PF("97365657006","Alastair HillMorwenna Charles" );
		assertEquals(PF.class, pf.getClass());
		assertEquals("97365657006", pf.getCPF());
		assertEquals("Alastair HillMorwenna Charles", pf.getFullName());
		assertEquals(null, pf.getConta());
	}

	@Test
	void testEqualsObject() {
	    PF x = new PF("97365657006", "Foo Bar");  // equals and hashCode check name field value
	    PF y = new PF("97365657006", "Foo Bar");
	    PF z = new PF("97365657007", "Foo Bar");
	    assertNotSame(x, y);
	    assertTrue(x.equals(y) && y.equals(x));
	    assertTrue(x.hashCode() == y.hashCode());
	    
	    assertFalse(x.equals(y) && y.equals(z));
	    assertFalse(x.hashCode() == z.hashCode());
	    
	}

}
