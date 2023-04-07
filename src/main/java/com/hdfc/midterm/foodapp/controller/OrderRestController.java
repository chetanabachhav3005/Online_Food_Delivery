package com.hdfc.midterm.foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.midterm.foodapp.entity.Orders;
import com.hdfc.midterm.foodapp.entity.Restaurants;
import com.hdfc.midterm.foodapp.exception.OrderException;
import com.hdfc.midterm.foodapp.service.IOrdersService;

@RestController
@RequestMapping
public class OrderRestController {
//
	@Autowired
	IOrdersService service;

	@PostMapping("/save")
	public ResponseEntity<Orders> saveOrder(@RequestBody Orders order) throws OrderException {

		Orders order1 = service.addOrder(order);

		return new ResponseEntity<Orders>(order1, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Orders> updateOrder(@RequestBody Orders order) throws OrderException {
		Orders order1 = service.updateOrder(order);

		return new ResponseEntity<Orders>(order1, HttpStatus.CREATED);

	}

	@DeleteMapping("/remove/{orderId}")
	public ResponseEntity<Orders> deleteOrder(@PathVariable("orderId") Long orderId) throws OrderException {

		Orders order = service.removeOrder(orderId);

		return new ResponseEntity<Orders>(order, HttpStatus.CREATED);
	}

	@GetMapping("/view/{orderId}")
	public ResponseEntity<Orders> viewOrder(@PathVariable("orderId") Long orderId) throws OrderException {

		Orders order = service.viewOrder(orderId);
		return new ResponseEntity<Orders>(order, HttpStatus.CREATED);
	}

}
