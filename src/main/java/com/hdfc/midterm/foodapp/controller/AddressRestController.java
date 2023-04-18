/*
Author:Chetana Bachhav
Date:
Description:Address Rest Controller
*/
package com.hdfc.midterm.foodapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.midterm.foodapp.entity.Address;
import com.hdfc.midterm.foodapp.exception.AddressException;
import com.hdfc.midterm.foodapp.service.IAddressService;

@RestController
@RequestMapping("/address")
public class AddressRestController {

	@Autowired
	IAddressService service;

	@PostMapping("/register")
	public ResponseEntity<Address> addAddress(@Valid @RequestBody Address address) throws AddressException {

		Address adt = service.addAddress(address);
		return new ResponseEntity<Address>(adt, HttpStatus.CREATED);

	}

	@GetMapping("/address/{addressId}")
	public ResponseEntity<Address> viewAddress(@PathVariable("addressId") Integer addressId) throws AddressException {
		Address view = service.viewAddress(addressId);
		return new ResponseEntity<Address>(view, HttpStatus.OK);
	}
}
