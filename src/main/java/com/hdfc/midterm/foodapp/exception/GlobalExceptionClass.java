package com.hdfc.midterm.foodapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



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
	
}
