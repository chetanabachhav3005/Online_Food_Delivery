
/*
Author:Chetana Bachhav
Date:
Description:Order Service Interface
*/ 
package com.hdfc.midterm.foodapp.service;

import java.util.List;

import com.hdfc.midterm.foodapp.dto.OrdersDto;
import com.hdfc.midterm.foodapp.entity.MenuItems;
import com.hdfc.midterm.foodapp.entity.Orders;
import com.hdfc.midterm.foodapp.exception.AddressException;
import com.hdfc.midterm.foodapp.exception.CartException;
import com.hdfc.midterm.foodapp.exception.CustomerException;
import com.hdfc.midterm.foodapp.exception.OrderException;
import com.hdfc.midterm.foodapp.exception.PaymentException;

public interface IOrdersService {

	public Orders addOrder(OrdersDto orderDto)throws OrderException, PaymentException, AddressException, CartException, CustomerException;
	
	public Orders updateOrder(Orders order)throws OrderException;
	
	public Orders removeOrder(Long orderId)throws OrderException;
	
	public Orders viewOrder(Long orderId)throws OrderException;
	
	public List<MenuItems> viewAllOrdersByCustomer(Long customerId)throws OrderException,CustomerException;

}
