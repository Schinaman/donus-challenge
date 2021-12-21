package com.donus.codechallenge.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Deposit implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double amountDeposit;
	
	
	@ManyToOne
	@JoinColumn(name = "account_cpf")
	private Account account;

	
	public Deposit() {
		super();
	}

	public Deposit(Long id, double amountDeposit, Account account) {
		super();
		this.id = id;
		this.amountDeposit = amountDeposit;
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmountDeposit() {
		return amountDeposit;
	}

	public void setAmountDeposit(double amountDeposit) {
		this.amountDeposit = amountDeposit;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deposit other = (Deposit) obj;
		return Objects.equals(id, other.id);
	}

	
}
