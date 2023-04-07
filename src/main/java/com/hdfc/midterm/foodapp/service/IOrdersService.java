package com.hdfc.midterm.foodapp.service;

import com.hdfc.midterm.foodapp.entity.Orders;
import com.hdfc.midterm.foodapp.exception.OrderException;

public interface IOrdersService {

public Orders addOrder(Orders order)throws OrderException;
	
	public Orders updateOrder(Orders order)throws OrderException;
	
	public Orders removeOrder(Long orderId)throws OrderException;
	
	public Orders viewOrder(Long orderId)throws OrderException;
	
	
}
