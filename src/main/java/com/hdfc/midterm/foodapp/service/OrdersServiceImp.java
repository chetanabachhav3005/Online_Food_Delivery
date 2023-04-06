package com.hdfc.midterm.foodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midterm.foodapp.repository.OrdersRepository;

@Service
public class OrdersServiceImp implements IOrdersService {
//	
	@Autowired
	OrdersRepository repo;
}
