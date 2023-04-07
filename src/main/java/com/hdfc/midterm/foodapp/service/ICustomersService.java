package com.hdfc.midterm.foodapp.service;

import com.hdfc.midterm.foodapp.entity.Customers;
import com.hdfc.midterm.foodapp.exception.CustomerException;

public interface ICustomersService {
	public Customers addCustomer(Customers customer) throws CustomerException;

	public Customers updateCustomer(Customers customer) throws CustomerException;

	public Customers removeCustomerById(Long customerId) throws CustomerException;

	public Customers viewCustomer(Long customerId) throws CustomerException;

}
