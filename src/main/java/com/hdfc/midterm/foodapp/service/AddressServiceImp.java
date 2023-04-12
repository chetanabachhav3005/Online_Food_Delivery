package com.hdfc.midterm.foodapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midterm.foodapp.dto.AddressDto;
import com.hdfc.midterm.foodapp.entity.Address;
import com.hdfc.midterm.foodapp.exception.AddressException;
import com.hdfc.midterm.foodapp.repository.AddressRepository;

@Service
public class AddressServiceImp implements IAddressService{

	
	@Autowired
	AddressRepository repo;

	@Override
	public Address addAddress(AddressDto addressDto) throws AddressException {
		
		Address ad=new Address();
		ad.setAddressId(addressDto.getAddressId());
		ad.setArea(addressDto.getArea());
		ad.setCity(addressDto.getCity());
		ad.setCountry(addressDto.getCountry());
		ad.setPincode(addressDto.getPincode());
		ad.setState(addressDto.getState());		
	
		Optional<Address> opt = repo.findById(addressDto.getAddressId());
		if (opt.isPresent()) {
			throw new AddressException("Address already exists..");
		} else {
			return repo.save(ad);
		}
	}
	
	
	
	
}
