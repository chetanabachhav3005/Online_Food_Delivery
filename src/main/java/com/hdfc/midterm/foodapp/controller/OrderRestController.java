/*
Author:Chetana Bachhav
Date:
Description:Order Rest Controller
*/
package com.hdfc.midterm.foodapp.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.hdfc.midterm.foodapp.dto.OrdersDto;
import com.hdfc.midterm.foodapp.entity.MenuItems;
import com.hdfc.midterm.foodapp.entity.Orders;
import com.hdfc.midterm.foodapp.exception.AddressException;
import com.hdfc.midterm.foodapp.exception.CartException;
import com.hdfc.midterm.foodapp.exception.CustomerException;
import com.hdfc.midterm.foodapp.exception.OrderException;
import com.hdfc.midterm.foodapp.exception.PaymentException;
import com.hdfc.midterm.foodapp.service.IOrdersService;

@RestController
@RequestMapping("/api/order")
public class OrderRestController {

	@Autowired
	IOrdersService service;

	@PostMapping("/save/order")
	public ResponseEntity<Orders> saveOrder(@Valid @RequestBody OrdersDto order)
			throws OrderException, PaymentException, AddressException, CartException, CustomerException {

		Orders order1 = service.addOrder(order);

		return new ResponseEntity<Orders>(order1, HttpStatus.CREATED);
	}

	@PutMapping("/update/order")
	public ResponseEntity<Orders> updateOrder(@Valid @RequestBody Orders order) throws OrderException {
		Orders order1 = service.updateOrder(order);

		return new ResponseEntity<Orders>(order1, HttpStatus.CREATED);

	}

	@DeleteMapping("/remove/order/{orderId}")
	public ResponseEntity<Orders> deleteOrder(@PathVariable("orderId") Long orderId) throws OrderException {

		Orders order = service.removeOrder(orderId);

		return new ResponseEntity<Orders>(order, HttpStatus.CREATED);
	}

	@GetMapping("/view/order/{orderId}")
	public ResponseEntity<Orders> viewOrder(@PathVariable("orderId") Long orderId) throws OrderException {

		Orders order = service.viewOrder(orderId);
		return new ResponseEntity<Orders>(order, HttpStatus.CREATED);
	}

	@GetMapping("/viewbycustomer/{customerId}")
	public ResponseEntity<List<MenuItems>> viewAllOrders(@PathVariable("customerId") Long customerId)
			throws OrderException, CustomerException {

		return new ResponseEntity<List<MenuItems>>(service.viewAllOrdersByCustomer(customerId), HttpStatus.FOUND);

	}

}
