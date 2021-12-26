package com.donus.codechallenge.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;


@Getter
@Entity
@Table(name= "tb_account")
public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String cPF;
	@Max(value = 0) @Min(value = 0)
	private double balance;
 
	
	@OneToOne
	@MapsId
	private PF pf;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	private List<Deposit> deposits = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "accountFrom")
	private List<Transfer> transfers = new ArrayList<>();
	
	
	public Account() {
		super();
	}

	
	public Account(String cPF, PF pf) {
		super();
		this.cPF = cPF;
		this.pf = pf;
	}
	
	
	
	public String getCPF() {
		return cPF;
	}
	public void setCPF(String cPF) {
		this.cPF = cPF;
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


	public List<Deposit> getDeposits() {
		return deposits;
	}

	public List<Transfer> getTransfers() {
		return transfers;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(cPF);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(cPF, other.cPF);
	}


	public void deposita(double valor) {
		this.balance += valor;
	}
	
	public void transfere(Account cc, double valor) {
		this.balance -= valor;
		cc.balance += valor;
	}
}