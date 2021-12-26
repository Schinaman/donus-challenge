package com.donus.codechallenge.services.exceptions;



public class BankRequestException extends RuntimeException{

	private static final long serialVersionUID = 1L;


	public BankRequestException(String message) {
		super(message);
	}


	public BankRequestException(String message, Throwable cause) {
		super(message, cause);
	}
	
	
}
