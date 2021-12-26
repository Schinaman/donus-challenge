package com.donus.codechallenge.resources.exceptions;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.donus.codechallenge.services.exceptions.BankRequestException;

@ControllerAdvice
public class BankExceptionHandler {
		
		@ExceptionHandler(value = {BankRequestException.class})
		public ResponseEntity<Object> handleException(BankRequestException e){
			HttpStatus forbidden = HttpStatus.FORBIDDEN;
			
			BankException bankException = new BankException(e.getMessage(),forbidden);
			return new ResponseEntity<>(bankException,forbidden);
		}
}