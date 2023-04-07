package com.hdfc.midterm.foodapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midterm.foodapp.entity.Orders;
import com.hdfc.midterm.foodapp.exception.OrderException;
import com.hdfc.midterm.foodapp.repository.OrdersRepository;

@Service
public class OrdersServiceImp implements IOrdersService {

	@Autowired
	OrdersRepository repo;

	@Override
	public Orders addOrder(Orders order) throws OrderException {
		Optional<Orders> opt = repo.findById(order.getOrderId());
		if (opt.isPresent()) {
			throw new OrderException("Order already exists..");
		} else {
			return repo.save(order);
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

}
