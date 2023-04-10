package com.hdfc.midterm.foodapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midterm.foodapp.dto.CartDto;
import com.hdfc.midterm.foodapp.entity.Cart;
import com.hdfc.midterm.foodapp.exception.CartException;
import com.hdfc.midterm.foodapp.repository.CartRepository;

@Service
public class CartServiceImp implements ICartService {

	@Autowired
	CartRepository repo;

	@Override
	public Cart saveCart(CartDto cartDto) throws CartException {

		Cart cart = new Cart();
		cart.setCartId(cartDto.getCartId());
		cart.setCustomerId(cartDto.getCustomerId());
		cart.setItemId(cartDto.getItemId());
		cart.setPrice(cartDto.getPrice());
		cart.setQuantity(cartDto.getQuantity());
		cart.setTotal(cartDto.getTotal());
		Optional<Cart> opt = repo.findById(cartDto.getCartId());
		if (opt.isPresent()) {
			throw new CartException("Cart already exists..");
		} else {
			return repo.save(cart);
		}
	}

	@Override
	public Cart clearCart(Long cartId) throws CartException {
		Optional<Cart> opt = repo.findById(cartId);
		if (opt.isPresent()) {
			Cart cart = opt.get();
			repo.delete(cart);
			return cart;
		} else {
			throw new CartException("No Cart found with ID: " + cartId);
		}
	}

	@Override
	public Cart viewCart(Long cartId) throws CartException {
		Optional<Cart> opt = repo.findById(cartId);
		if (opt.isPresent()) {
			Cart cart = opt.get();
			return cart;
		} else {
			throw new CartException("No Cart found with ID: " + cartId);
		}
	}

}
