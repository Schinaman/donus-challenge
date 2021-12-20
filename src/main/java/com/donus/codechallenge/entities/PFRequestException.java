package com.donus.codechallenge.entities;



public class PFRequestException extends RuntimeException{

	private static final long serialVersionUID = 1L;


	public PFRequestException(String message) {
		super(message);
	}


	public PFRequestException(String message, Throwable cause) {
		super(message, cause);
	}
	
	
}
