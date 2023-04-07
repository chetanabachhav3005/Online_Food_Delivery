package com.hdfc.midterm.foodapp.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hdfc.midterm.foodapp.entity.Customers;
import com.hdfc.midterm.foodapp.exception.CustomerException;
import com.hdfc.midterm.foodapp.repository.CustomersRepository;

@Service
public class CustomersServiceImp implements ICustomersService{

	@Autowired
	CustomersRepository repo;
	
	@Override
	public Customers addCustomer(Customers customer) throws CustomerException {
		Optional<Customers> opt = repo.findById(customer.getCustomerId());
		if(opt.isPresent()) {
			throw new CustomerException("Customer already exists..");
		}else {
			return repo.save(customer);
		}
	}


	@Override
	public Customers updateCustomer(Customers customer) throws CustomerException {
		Optional<Customers> opt = repo.findById(customer.getCustomerId());
		if(opt.isPresent()) {
			return repo.save(customer);
		}else {
			throw new CustomerException("No such customer exists..");
		}
	}


	@Override
	public Customers removeCustomerById(Long customerId) throws CustomerException {
		Optional<Customers> opt = repo.findById(customerId);
		if(opt.isPresent()) {
			Customers customer = opt.get();
			repo.delete(customer);
			return customer;
		}else {
			throw new CustomerException("No Customer found with ID: "+customerId);
		}
	}


	@Override
	public Customers viewCustomer(Long customerId) throws CustomerException {
		Optional<Customers> opt =repo.findById(customerId);
		if(opt.isPresent()) {
			Customers customer = opt.get();
			return customer;
		}else {
			throw new CustomerException("No Customer found with ID: "+customerId);
		}
	}

	
}
