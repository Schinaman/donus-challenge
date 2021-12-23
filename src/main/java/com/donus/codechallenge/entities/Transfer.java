package com.donus.codechallenge.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "tb_transfer")
public class Transfer implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double amountTransfer;
	
	
	@ManyToOne
	@JoinColumn(name = "account_from")
	private Account accountFrom;

	//private Account accountTo; //representative cpf field
	private String accountTo;
	
	public Transfer() {
		super();
	}


	public Transfer(Long id, double amountTransfer, Account accountFrom, String accountTo) {
		super();
		this.id = id;
		this.amountTransfer = amountTransfer;
		this.accountFrom = accountFrom;
		this.accountTo = accountTo;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {

		this.id = id;
	}
	
	public double getAmountTransfer() {
		return amountTransfer;
	}
	public void setAmountTransfer(double amountTransfer) {

		this.amountTransfer = amountTransfer;
	}
	
	public Account getAccountFrom() {
		return accountFrom;
	}
	public void setAccountFrom(Account accountFrom) {
		this.accountFrom = accountFrom;
	}
	
	public String getAccountTo() {
		return accountTo;
	}
	public void setAccountTo(String accountTo) {
		this.accountTo = accountTo;
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
		Transfer other = (Transfer) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
}
