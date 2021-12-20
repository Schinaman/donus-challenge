package com.donus.codechallenge.entities;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PFExceptionHandler {
		
		@ExceptionHandler(value = {PFRequestException.class})
		public ResponseEntity<Object> handleException(PFRequestException e){
			HttpStatus forbidden = HttpStatus.FORBIDDEN;
			
			PFException dnaException = new PFException(e.getMessage(),forbidden);
			return new ResponseEntity<>(dnaException,forbidden);
		}
}