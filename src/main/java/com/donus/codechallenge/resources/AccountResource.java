package com.donus.codechallenge.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.donus.codechallenge.entities.Account;
import com.donus.codechallenge.services.ContaService;

@RestController
@RequestMapping(value="/contas")
public class AccountResource {

	@Autowired
	private ContaService service;
	
	@GetMapping
	public ResponseEntity<List<Account>> findAll(){
		List<Account> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Account> findById(@PathVariable String id){
		Account obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

	@PostMapping
	public ResponseEntity<Account> insert(@RequestBody Account obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCPF()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
//	@PutMapping (value = "/{id}")
//	public ResponseEntity<Conta> deposit(@PathVariable String id,@RequestBody Conta conta){
//		Conta obj = service.deposita(id, valor);
//		return ResponseEntity.ok().body(obj);	
//	}

	
}
