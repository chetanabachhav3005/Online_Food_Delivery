package com.hdfc.midterm.foodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midterm.foodapp.repository.RestaurantsRepository;

@Service
public class RestaurantsServiceImp implements IRestaurantsService {
//
	@Autowired
	RestaurantsRepository repo;
}
