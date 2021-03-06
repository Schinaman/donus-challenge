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

import com.donus.codechallenge.entities.Deposit;
import com.donus.codechallenge.entities.Transfer;
import com.donus.codechallenge.services.TransferService;

@RestController
@RequestMapping(value = "/transfers")
public class TransferResource {

	@Autowired
	private TransferService service;

	@GetMapping
	public ResponseEntity<List<Transfer>> findAll(){
		List<Transfer> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Transfer> findById(@PathVariable Long id){
		Transfer obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Transfer> insert(@RequestBody Transfer obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

}
