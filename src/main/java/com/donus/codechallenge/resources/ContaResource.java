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

import com.donus.codechallenge.entities.Conta;
import com.donus.codechallenge.services.ContaService;

@RestController
@RequestMapping(value="/contas")
public class ContaResource {

	@Autowired
	private ContaService service;
	
	@GetMapping
	public ResponseEntity<List<Conta>> findAll(){
		List<Conta> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Conta> findById(@PathVariable String id){
		Conta obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

	@PostMapping
	public ResponseEntity<Conta> insert(@RequestBody Conta obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCPF()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
}
