package com.donus.codechallenge.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.donus.codechallenge.entities.Conta;
import com.donus.codechallenge.entities.PessoaFisica;
import com.donus.codechallenge.repositories.ContaRepository;
import com.donus.codechallenge.repositories.PessoaFisicaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ContaRepository contaRepository;
	@Autowired
	private PessoaFisicaRepository pfRepository;

	@Override
	public void run(String... args) throws Exception {
	
		PessoaFisica pf1 = new PessoaFisica ("3732297850", "Guiga");
		PessoaFisica pf2 = new PessoaFisica("3732297851", "Juquinha");
		pfRepository.saveAll(Arrays.asList(pf1,pf2));
		
		
		Conta cc1 = new Conta("3732297850", 0, pf1);
		Conta cc2 = new Conta("3732297850", 0, pf2);
		contaRepository.saveAll(Arrays.asList(cc1,cc2));

	}
	
}
