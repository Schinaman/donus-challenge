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
import com.donus.codechallenge.entities.Transaction;
import com.donus.codechallenge.repositories.AccountRepository;
import com.donus.codechallenge.repositories.TransactionRepository;
import com.donus.codechallenge.services.ContaService;
import com.donus.codechallenge.services.TransacaoService;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionResource {

	@Autowired
	private TransacaoService service;
	@Autowired
	private ContaService contaService;

	@Autowired
	private TransactionRepository repository;
	@Autowired
	private AccountRepository contaRepo;

	@GetMapping
	public ResponseEntity<List<Transaction>> findAll(){
		List<Transaction> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Transaction> findById(@PathVariable Long id){
		Transaction obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

//	@PostMapping
//	public ResponseEntity<List<Transaction>> insert(@RequestBody Transaction obj){
//		obj = service.insert(obj);
//		return ResponseEntity.ok().body(obj);
//	}
	
//	
//	public ResponseEntity<Account> deposita(@RequestBody Transaction transacao){
//		transacao = service.deposita(transacao);
//		Account conta = contaService.insert(conta);
//		return ResponseEntity.ok().body(conta);
//	}
//	
	

}
