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
import com.donus.codechallenge.entities.PFException;
import com.donus.codechallenge.entities.PFRequestException;
import com.donus.codechallenge.entities.PessoaFisica;
import com.donus.codechallenge.services.PessoaFisicaService;

@RestController
@RequestMapping(value="/pf")
public class PessoaFisicaResource {

	@Autowired
	private PessoaFisicaService service; 
	
	@GetMapping
	public ResponseEntity<List<PessoaFisica>> findAll(){
		List<PessoaFisica> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PessoaFisica> findById(@PathVariable String id){
		PessoaFisica obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<PessoaFisica> insert(@RequestBody PessoaFisica obj){
		
		if (obj.getCPF().length() != 11) {
			throw new PFRequestException("CPF precisa ter 11 digitos");
		}
		
		for (char letter : obj.getCPF().toCharArray()) {
			if (letter < 48 || letter > 57) {
				throw new PFRequestException("CPF só aceita caracteres numericos");
			}
		}
		
		
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCPF()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
