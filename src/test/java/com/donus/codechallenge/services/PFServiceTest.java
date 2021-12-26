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

import com.donus.codechallenge.entities.PF;
import com.donus.codechallenge.repositories.PFRepository;
import com.donus.codechallenge.services.exceptions.BankRequestException;

class PFServiceTest {

	@InjectMocks
	private PFService service;
	
	@Mock
	private PFRepository repository;

	private PF pf;
	private Optional<PF> optionalPF;
	private String cpf;
	private String name;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		cpf = "37322979850";
		name = "Zequinha do Vale";
		pf = new PF(cpf, name);
		optionalPF = Optional.of(new PF(cpf, name));
	}
	
	@Test
	void whenFindAllThenReturnAllPFInstances() {
		when(repository.findAll()).thenReturn(List.of(pf));
		List<PF> response = service.findAll();
		
		assertNotNull(response);
		assertEquals(1, response.size());
		assertEquals(PF.class, response.get(0).getClass());
	}

	@Test
	void whenFindByIdThenReturnAnPFInstance() {
		when(repository.findById(Mockito.anyString())).thenReturn(optionalPF);
		
		PF response = service.findById(cpf);
		assertNotNull(response);
		assertEquals(PF.class, response.getClass());
		assertEquals(cpf, response.getCPF());
		assertEquals(name, response.getFullName());
	}
	
	@Test
	void whenFindByIdThenReturnBankRequestException() {
		when(repository.findById(Mockito.anyString())).thenThrow(new BankRequestException("Objeto não encontrado"));
		
		try {
			service.findById(cpf);
			fail("deveria lançar exceção");
		} catch (Exception e) {
			assertEquals(BankRequestException.class, e.getClass());
			assertEquals("Objeto não encontrado", e.getMessage());
			
		}
	}


	@Test
	void whenInsertThenReturnSuccess() {
		when(repository.save(Mockito.any())).thenReturn(pf);
		
		PF response = service.insert(pf);
				
		assertNotNull(response);
		assertEquals(PF.class, response.getClass());
		assertEquals(cpf, response.getCPF());
		assertEquals(name, response.getFullName());
	}

	@Test
	void whenInsertThenReturnBankRequestExceptionCpfWrongLength() {
		pf.setCPF("373229798");
		when(repository.save(Mockito.any())).thenReturn(pf);
		
		try {
			service.insert(pf);
			fail("deveria lançar exceção");
		} catch (Exception e) {
			assertEquals(BankRequestException.class, e.getClass());
			assertEquals("CPF precisa ter 11 digitos", e.getMessage());		
		}	
	}
	
	@Test
	void whenInsertThenReturnBankRequestExceptionCpfInvalidChar() {
		pf.setCPF("3732297985a");
		when(repository.save(Mockito.any())).thenReturn(pf);
		
		try {
			service.insert(pf);
			fail("deveria lançar exceção");
		} catch (Exception e) {
			assertEquals(BankRequestException.class, e.getClass());
			assertEquals("CPF só aceita caracteres numericos", e.getMessage());		
		}	
	}
}
