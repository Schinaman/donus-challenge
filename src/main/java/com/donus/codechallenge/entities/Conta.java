package com.donus.codechallenge.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Conta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String CPF;
	private double balance;
 
	@OneToOne
	@MapsId
	private PessoaFisica pf;
	
	// permitido apenas 1 conta por pessoa //OK
	// checa no banco de dados se o cpf já está cadastrado //OK
	// Não aceitamos valores negativos nas contas;
	// Por questão de segurança cada transação de depósito não pode ser maior do que
	// R$2.000;
	// As transferências entre contas são gratuitas e ilimitadas;

	
	public Conta() {
		super();
	}

	
	public Conta(String cPF, double balance, PessoaFisica pf) {
		super();
		CPF = cPF;
		this.balance = 1000.00;
		this.pf = pf;
	}
	
	
	
	public String getCPF() {
		return CPF;
	}


	public void setCPF(String cPF) {
		CPF = cPF;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}

	

	public PessoaFisica getPf() {
		return pf;
	}


	public void setPf(PessoaFisica pf) {
		this.pf = pf;
	}


	public void Transferir(Conta cc, double valor) {
		//Conta não pode ser a mesma que está transferindo;
		this.balance -= valor;
		cc.balance += valor;
	}
}