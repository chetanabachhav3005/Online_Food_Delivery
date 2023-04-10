package com.hdfc.midterm.foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hdfc.midterm.foodapp.entity.Customers;
import com.hdfc.midterm.foodapp.exception.CustomerException;
import com.hdfc.midterm.foodapp.service.ICustomersService;


@RestController
@RequestMapping("/customer")
public class CustomersRestController {
	@Autowired
	ICustomersService service;


	  @PostMapping("/add/customer") 
	  public ResponseEntity<Customers> addCustomer(@RequestBody Customers customer) throws CustomerException{
	  Customers newCustomer =service.addCustomer(customer); 
	  return new ResponseEntity<Customers>(newCustomer, HttpStatus.CREATED); }
	

	@PutMapping("/update/customer")
	public ResponseEntity<Customers> updateCustomer(@RequestBody Customers customer) throws CustomerException {
		Customers updatedCustomer = service.updateCustomer(customer);
		return new ResponseEntity<Customers>(updatedCustomer, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/remove/customer/{customerId}")
	public ResponseEntity<Customers> removeCustomer(@PathVariable("customerId") Long customerId)
			throws CustomerException {
		Customers removedCustomer = service.removeCustomerById(customerId);
		return new ResponseEntity<Customers>(removedCustomer, HttpStatus.OK);
	}

	@GetMapping("/view/customer/{customerId}")
	public ResponseEntity<Customers> viewCustomer(@PathVariable("customerId") Long customerId)
			throws CustomerException {
		Customers customer = service.viewCustomer(customerId);
		return new ResponseEntity<Customers>(customer, HttpStatus.OK);
	}

}
