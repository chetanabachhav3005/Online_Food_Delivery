package com.hdfc.midterm.foodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midterm.foodapp.repository.CustomersRepository;

@Service
public class CustomersServiceImp implements ICustomersService{

	@Autowired
	CustomersRepository repo;
	//
}
