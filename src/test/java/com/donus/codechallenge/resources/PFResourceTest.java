package com.donus.codechallenge.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.donus.codechallenge.entities.PF;
import com.donus.codechallenge.services.PFService;

class PFResourceTest {

	@InjectMocks
	private PFResource resource;

	@Mock
	private PFService service;

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
		when(service.findAll()).thenReturn(List.of(pf));
		ResponseEntity<List<PF>> response = resource.findAll();
		
		assertNotNull(response);
		assertNotNull(response.getBody());
		assertEquals(HttpStatus.OK,response.getStatusCode());
		assertEquals(ResponseEntity.class, response.getClass());
		//assertEquals(ArrayList.class, response.getBody().getClass());
		assertEquals(1, response.getBody().size());
		assertEquals(cpf, response.getBody().get(0).getCPF());
		assertEquals(name, response.getBody().get(0).getFullName());
	}
	

	@Test
	void whenFindByIdThenReturSuccess() {
		when(service.findById(Mockito.anyString())).thenReturn(pf);
		
		ResponseEntity<PF> response = resource.findById(cpf);
		assertNotNull(response);
		assertNotNull(response.getBody());
		assertEquals(ResponseEntity.class, response.getClass());
		assertEquals(PF.class, response.getBody().getClass());
		assertEquals(cpf, response.getBody().getCPF());
		assertEquals(name, response.getBody().getFullName());
	}

	@Test
	void whenInsertThenReturnSuccess() {
		when(service.insert(Mockito.any())).thenReturn(pf);
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		ResponseEntity<PF> response = resource.insert(pf);
				
		assertNotNull(response);
		assertNotNull(response.getBody());
		assertEquals(ResponseEntity.class, response.getClass());
		assertEquals(PF.class, response.getBody().getClass());
		assertEquals(cpf, response.getBody().getCPF());
		assertEquals(name, response.getBody().getFullName());
	}

}
