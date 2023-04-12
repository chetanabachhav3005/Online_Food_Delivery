package com.hdfc.midterm.foodapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.midterm.foodapp.dto.AddressDto;
import com.hdfc.midterm.foodapp.entity.Address;
import com.hdfc.midterm.foodapp.exception.AddressException;
import com.hdfc.midterm.foodapp.service.IAddressService;

@RestController
@RequestMapping("/address")
public class AddressRestController {

	
	@Autowired
	IAddressService service;
	
	
	@PostMapping("/register")
	public ResponseEntity<Address> addAddress(@Valid @RequestBody AddressDto addressDto) throws AddressException {

		Address adt = service.addAddress(addressDto);
		return new ResponseEntity<Address>(adt,HttpStatus.CREATED);

	}
}
