package com.hdfc.midterm.foodapp.service;

import com.hdfc.midterm.foodapp.dto.AddressDto;
import com.hdfc.midterm.foodapp.entity.Address;
import com.hdfc.midterm.foodapp.exception.AddressException;

public interface IAddressService {

	

	public Address addAddress(AddressDto addressDto) throws AddressException;
	
}
