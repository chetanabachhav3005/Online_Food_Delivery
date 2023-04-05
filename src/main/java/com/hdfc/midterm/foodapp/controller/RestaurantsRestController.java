package com.hdfc.midterm.foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.midterm.foodapp.service.IRestaurantsService;

@RestController
@RequestMapping
public class RestaurantsRestController {
	
	@Autowired
	IRestaurantsService service;
}
