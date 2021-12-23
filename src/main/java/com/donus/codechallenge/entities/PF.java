package com.donus.codechallenge.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "tb_pf")
public class PF implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Size(min = 11, max = 11)
	private String CPF;
	
	@NotNull(message = "Digite um nome valido")
	private String fullName;

	@JsonIgnore
	@OneToOne(mappedBy = "pf", cascade = CascadeType.ALL)
	private Account conta;

	
	public PF() {
		super();
	}	
	public PF(String cPF, String fullName) {
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

	public Account getConta() {
		return conta;
	}
	public void setConta(Account conta) {
		this.conta = conta;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(CPF);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PF other = (PF) obj;
		return Objects.equals(CPF, other.CPF);
	}
	
	

}
