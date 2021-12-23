package com.donus.codechallenge.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name= "tb_account")
public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String CPF;
	@Max(value = 0) @Min(value = 0)
	private double balance;
 
	
	@OneToOne
	@MapsId
	private PF pf;
	
	
	@OneToMany(mappedBy = "account")
	private List<Transaction> transactions = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	private List<Deposit> deposits = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "accountFrom")
	private List<Transfer> transfers = new ArrayList<>();
	
	
	// permitido apenas 1 conta por pessoa //OK
	// checa no banco de dados se o cpf já está cadastrado //OK
	// Não aceitamos valores negativos nas contas;
	// Por questão de segurança cada transação de depósito não pode ser maior do que
	// R$2.000;
	// As transferências entre contas são gratuitas e ilimitadas;
	// não pode permitir a alteração do balance
	// revisar os sets methods
	
	
	public Account() {
		super();
	}

	
	public Account(String cPF, PF pf) {
		super();
		CPF = cPF;
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


	public PF getPf() {
		return pf;
	}


	public void setPf(PF pf) {
		this.pf = pf;
	}


	public List<Transaction> getTransactions() {
		return transactions;
	}


	public List<Deposit> getDeposits() {
		return deposits;
	}


	public List<Transfer> getTransfers() {
		return transfers;
	}


	public void Deposita(double valor) {
		this.balance += valor;
	}

	public void Transfere(Account cc, double valor) {
		//Conta não pode ser a mesma que está transferindo;
		this.balance -= valor;
		cc.balance += valor;
	}
}