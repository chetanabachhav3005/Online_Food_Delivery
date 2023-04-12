package com.hdfc.midterm.foodapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.midterm.foodapp.dto.CartDto;
import com.hdfc.midterm.foodapp.entity.Cart;
import com.hdfc.midterm.foodapp.exception.CartException;
import com.hdfc.midterm.foodapp.service.ICartService;


@RestController
@RequestMapping("/cart")
public class CartRestController {

	@Autowired
	ICartService service;

	@PostMapping("/register")
	public ResponseEntity<Cart> saveCartDetails(@Valid @RequestBody CartDto fc) throws CartException {

		Cart c = service.saveCart(fc);
		return new ResponseEntity<Cart>(c, HttpStatus.CREATED);

	}

	@DeleteMapping("/remove/{cartId}")
	public ResponseEntity<Cart> removeCart(@PathVariable("cartId") Long cartId) throws CartException {
		Cart removedCart = service.clearCart(cartId);
		return new ResponseEntity<Cart>(removedCart, HttpStatus.OK);
	}

	@GetMapping("/view/{cartId}")
	public ResponseEntity<Cart> getCartByCartId(@PathVariable("cartId") Long cartId) throws CartException {

		Cart view = service.viewCart(cartId);
		return new ResponseEntity<Cart>(view, HttpStatus.OK);

	}
}
