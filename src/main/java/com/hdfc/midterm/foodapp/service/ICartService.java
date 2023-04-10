package com.hdfc.midterm.foodapp.service;

import com.hdfc.midterm.foodapp.dto.CartDto;
import com.hdfc.midterm.foodapp.entity.Cart;
import com.hdfc.midterm.foodapp.exception.CartException;

public interface ICartService {
	public Cart saveCart(CartDto cartDto) throws CartException;

	
	public Cart clearCart(Long cartId) throws CartException;

	public Cart viewCart(Long cartId) throws CartException;
}
