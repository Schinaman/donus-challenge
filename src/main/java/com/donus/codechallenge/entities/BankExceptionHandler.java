package com.donus.codechallenge.entities;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BankExceptionHandler {
		
		@ExceptionHandler(value = {BankRequestException.class})
		public ResponseEntity<Object> handleException(BankRequestException e){
			HttpStatus forbidden = HttpStatus.FORBIDDEN;
			
			BankException dnaException = new BankException(e.getMessage(),forbidden);
			return new ResponseEntity<>(dnaException,forbidden);
		}
}