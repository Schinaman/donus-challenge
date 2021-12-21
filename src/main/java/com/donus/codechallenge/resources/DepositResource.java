package com.donus.codechallenge.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.donus.codechallenge.entities.Account;
import com.donus.codechallenge.entities.Deposit;
import com.donus.codechallenge.entities.Transaction;
import com.donus.codechallenge.services.DepositService;

@RestController
@RequestMapping(value = "/deposits")
public class DepositResource {

	@Autowired
	private DepositService service;

	@GetMapping
	public ResponseEntity<List<Deposit>> findAll(){
		List<Deposit> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Deposit> findById(@PathVariable Long id){
		Deposit obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Deposit> insert(@RequestBody Deposit obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

}
