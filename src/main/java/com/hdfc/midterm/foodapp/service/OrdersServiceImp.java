/*
Author:Chetana Bachhav
Date:
Description:Orders Service Implementation Class
*/ 
package com.hdfc.midterm.foodapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midterm.foodapp.dto.OrdersDto;
import com.hdfc.midterm.foodapp.entity.Cart;
import com.hdfc.midterm.foodapp.entity.Customers;
import com.hdfc.midterm.foodapp.entity.MenuItems;
import com.hdfc.midterm.foodapp.entity.Orders;
import com.hdfc.midterm.foodapp.exception.AddressException;
import com.hdfc.midterm.foodapp.exception.CartException;
import com.hdfc.midterm.foodapp.exception.CustomerException;
import com.hdfc.midterm.foodapp.exception.OrderException;
import com.hdfc.midterm.foodapp.repository.CustomersRepository;
import com.hdfc.midterm.foodapp.repository.OrdersRepository;


@Service
public class OrdersServiceImp implements IOrdersService {

	@Autowired
	OrdersRepository repo;



	@Autowired
	IAddressService iservice;
	
	@Autowired
	CustomersRepository crepo;

	
	@Autowired
	ICustomersService cservice;
	
	
	@Autowired
	ICartService cartservice;
	
	@Override
	public Orders addOrder(OrdersDto orderDto) throws OrderException,AddressException, CartException, CustomerException {
		Optional<Orders> opt = repo.findById(orderDto.getOrderId());
		Orders o = new Orders();
		
		Cart c=cartservice.viewCart(orderDto.getCartId());
		o.setCart(c);
		
		o.setOrderId(orderDto.getOrderId());
		o.setOrderDate(orderDto.getOrderDate());
		

		if (opt.isPresent()) {
			throw new OrderException("Order already exists..");
		} else {
			return repo.save(o);
		}
	}

	@Override
	public Orders updateOrder(Orders order) throws OrderException {
		Optional<Orders> opt = repo.findById(order.getOrderId());
		if (opt.isPresent()) {
			return repo.save(order);
		} else {
			throw new OrderException("Order such Order exists..");
		}
	}

	@Override
	public Orders removeOrder(Long orderId) throws OrderException {
		Optional<Orders> opt = repo.findById(orderId);
		if (opt.isPresent()) {
			Orders order = opt.get();
			repo.delete(order);
			return order;
		} else {
			throw new OrderException("No Order found with ID: " + orderId);
		}
	}

	@Override
	public Orders viewOrder(Long orderId) throws OrderException {
		Optional<Orders> opt = repo.findById(orderId);
		if (opt.isPresent()) {
			Orders order = opt.get();
			return order;
		} else {
			throw new OrderException("No Order found with ID: " + orderId);
		}
	}

	@Override
	public List<MenuItems> viewAllOrdersByCustomer(Long customerId) throws OrderException, CustomerException {
		Optional<Customers> cOpt = crepo.findById(customerId);
		if (cOpt.isPresent()) {
			Customers customer = cOpt.get();
			List<MenuItems> itemList = customer.getCart().getItemList();
			if (itemList.size() > 0) {
				return itemList;
			} else {
				throw new OrderException("No Orders found..");
			}
		} else {
			throw new CustomerException("No Customer found with ID: " + customerId);
		}
	}
}
