/*
Author:Chetana Bachhav
Date:
Description:Address Service Interface
*/ 
package com.hdfc.midterm.foodapp.service;

import com.hdfc.midterm.foodapp.entity.Address;
import com.hdfc.midterm.foodapp.exception.AddressException;

public interface IAddressService {
	
	public Address viewAddress(Integer addressId) throws AddressException;
	

	public Address addAddress(Address address) throws AddressException;
	
}
