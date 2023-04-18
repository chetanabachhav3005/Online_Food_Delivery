/*
Author:Chetana Bachhav
Date:
Description:Global Exception class for all exception classes
*/ 
package com.hdfc.midterm.foodapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.hdfc.midterm.foodapp.auth.exception.AuthorizationException;



@RestControllerAdvice
public class GlobalExceptionClass {

	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ErrorDetails>  handleExp(CustomerException ce){
		ErrorDetails err = new ErrorDetails();
		
		err.setMessage(ce.getMessage());
		
		return  new ResponseEntity<ErrorDetails>(err,HttpStatus.EXPECTATION_FAILED);
		
	}
	
	

	@ExceptionHandler(OrderException.class)
	public ResponseEntity<ErrorDetails>  handleExp(OrderException ce){
		ErrorDetails err = new ErrorDetails();
		
		err.setMessage(ce.getMessage());
		
		return  new ResponseEntity<ErrorDetails>(err,HttpStatus.EXPECTATION_FAILED);
		
	}
	
	
	

	@ExceptionHandler(RestaurantException.class)
	public ResponseEntity<ErrorDetails>  handleExp(RestaurantException ce){
		ErrorDetails err = new ErrorDetails();
		
		err.setMessage(ce.getMessage());
		
		return  new ResponseEntity<ErrorDetails>(err,HttpStatus.EXPECTATION_FAILED);
		
	}
	
	
	

	@ExceptionHandler(ItemException.class)
	public ResponseEntity<ErrorDetails>  handleExp(ItemException ce){
		ErrorDetails err = new ErrorDetails();
		
		err.setMessage(ce.getMessage());
		
		return  new ResponseEntity<ErrorDetails>(err,HttpStatus.EXPECTATION_FAILED);
		
	}
	
	
	@ExceptionHandler(CartException.class)
	public ResponseEntity<ErrorDetails>  handleExp(CartException ce){
		ErrorDetails err = new ErrorDetails();
		
		err.setMessage(ce.getMessage());
		
		return  new ResponseEntity<ErrorDetails>(err,HttpStatus.EXPECTATION_FAILED);
		
	}
	
	
	@ExceptionHandler(PaymentException.class)
	public ResponseEntity<ErrorDetails>  handleExp(PaymentException ce){
		ErrorDetails err = new ErrorDetails();
		
		err.setMessage(ce.getMessage());
		
		return  new ResponseEntity<ErrorDetails>(err,HttpStatus.EXPECTATION_FAILED);
		
	}
	
	
	@ExceptionHandler(AddressException.class)
	public ResponseEntity<ErrorDetails>  handleExp(AddressException ce){
		ErrorDetails err = new ErrorDetails();
		
		err.setMessage(ce.getMessage());
		
		return  new ResponseEntity<ErrorDetails>(err,HttpStatus.EXPECTATION_FAILED);
		
	}
	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<ErrorDetails> authExceptionHandler(AuthorizationException ae , WebRequest wr){
		ErrorDetails err = new ErrorDetails();
		
		err.setMessage(ae.getMessage());
	
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	
}
