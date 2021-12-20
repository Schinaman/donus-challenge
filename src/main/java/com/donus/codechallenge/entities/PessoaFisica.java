package com.donus.codechallenge.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PessoaFisica implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String CPF;
	private String fullName;

	@JsonIgnore
	@OneToOne(mappedBy = "pf", cascade = CascadeType.ALL)
	private Conta conta;

	public PessoaFisica() {
		super();
	}
	
	public PessoaFisica(String cPF, String fullName) {
		super();
		this.CPF = cPF;
		this.fullName = fullName;;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}


	

}
