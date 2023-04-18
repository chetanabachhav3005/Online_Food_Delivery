/*
Author:Chetana Bachhav
Date:
Description:Address Service Implementation Class
*/ 
package com.hdfc.midterm.foodapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midterm.foodapp.entity.Address;
import com.hdfc.midterm.foodapp.exception.AddressException;
import com.hdfc.midterm.foodapp.repository.AddressRepository;

@Service
public class AddressServiceImp implements IAddressService {

	@Autowired
	AddressRepository repo;

	@Override
	public Address addAddress(Address address) throws AddressException {
		if (repo.existsById(address.getAddressId())) {
			throw new AddressException("Address already exists..");
		} else {
			return repo.save(address);
		}
	}

	@Override
	public Address viewAddress(Integer addressId) throws AddressException {
		Optional<Address> opt = repo.findById(addressId);
		if (opt.isPresent()) {
			Address address = opt.get();
			return address;
		} else {
			throw new AddressException("No Restaurant found with ID: " + addressId);
		}
	}

}
