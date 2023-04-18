/*
Author:Chetana Bachhav
Date:
Description:Cart Service Interface
*/ 
package com.hdfc.midterm.foodapp.service;

import com.hdfc.midterm.foodapp.dto.CartDto;
import com.hdfc.midterm.foodapp.entity.Cart;
import com.hdfc.midterm.foodapp.exception.CartException;
import com.hdfc.midterm.foodapp.exception.CustomerException;
import com.hdfc.midterm.foodapp.exception.ItemException;

public interface ICartService {
	
	public Cart saveCart(CartDto cartDto) throws CartException, CustomerException, ItemException;

	public Cart addItem(Long cartId, Long itemId)throws CartException,ItemException;
	
	public Cart clearCart(Long cartId) throws CartException;

	public Cart viewCart(Long cartId) throws CartException;
}
