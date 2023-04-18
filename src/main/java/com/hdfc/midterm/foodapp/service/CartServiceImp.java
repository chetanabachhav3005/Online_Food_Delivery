/*
Author:Chetana Bachhav
Date:
Description:Cart Service Implementation Class
*/ 

package com.hdfc.midterm.foodapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midterm.foodapp.dto.CartDto;
import com.hdfc.midterm.foodapp.entity.Cart;
import com.hdfc.midterm.foodapp.entity.Customers;
import com.hdfc.midterm.foodapp.entity.MenuItems;
import com.hdfc.midterm.foodapp.exception.CartException;
import com.hdfc.midterm.foodapp.exception.CustomerException;
import com.hdfc.midterm.foodapp.exception.ItemException;
import com.hdfc.midterm.foodapp.repository.CartRepository;
import com.hdfc.midterm.foodapp.repository.CustomersRepository;
import com.hdfc.midterm.foodapp.repository.MenuItemsRepository;

@Service
public class CartServiceImp implements ICartService {

	@Autowired
	CartRepository repo;

	@Autowired
	MenuItemsRepository mrepo;
	@Autowired
	CustomersRepository crepo;

	@Autowired
	ICustomersService service;

	@Autowired
	IMenuItemsService iservice;

	@Override
	public Cart saveCart(CartDto cartDto) throws CartException, CustomerException, ItemException {

		Cart cart = new Cart();

		Customers customer = service.viewCustomer(cartDto.getCustomerId());

		cart.setItemList(cartDto.getItemList());
		
		cart.setCustomer(customer);
		cart.setCartId(cartDto.getCartId());

		if (repo.existsById(cart.getCartId())) {
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

	@Override
	public Cart addItem(Long cartId, Long itemId) throws CartException, ItemException {
		Optional<Cart> ct = repo.findById(cartId);
		if (ct.isPresent()) {

			Optional<MenuItems> it = mrepo.findById(itemId);

			if (it.isPresent()) {

				Cart cart = ct.get();
				MenuItems item = it.get();
				List<MenuItems> list = new ArrayList<>();
				list.addAll(cart.getItemList());
				list.add(item);
				cart.setItemList(list);

				return cart;

			} else {
				throw new ItemException("No Item found with ID: " + itemId);
			}

		} else {
			throw new CartException("No Cart found with ID: " + cartId);
		}
	}

}
