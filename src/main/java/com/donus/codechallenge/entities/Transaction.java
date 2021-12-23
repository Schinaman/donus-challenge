package com.donus.codechallenge.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name= "tb_transaction")
public class Transaction implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
 

	@ManyToOne
	@JoinColumn(name = "account_cpf")
	private Account account;

	
	public Transaction() {
		super();
	}

	public Transaction(Long id, Account conta) {
		super();
		this.id = id;
		this.account = conta;
	}

	@JsonIgnore
	public Account getConta() {
		return account;
	}

	public void setConta(Account conta) {
		this.account = conta;
	}

	public Long getId() {
		return id; 
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
		Transaction other = (Transaction) obj;
		return Objects.equals(id, other.id);
	}
	
}