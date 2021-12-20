package com.donus.codechallenge.entities;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PFException  {

	private final String message;
	private final HttpStatus httpStatus;
	
	
	public PFException(String message, HttpStatus httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}


}
