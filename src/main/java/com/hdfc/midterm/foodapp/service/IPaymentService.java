/*
Author:Chetana Bachhav
Date:
Description:Payment Service Interface
*/ 
package com.hdfc.midterm.foodapp.service;

import org.springframework.expression.AccessException;

import com.hdfc.midterm.foodapp.dto.PaymentDto;
import com.hdfc.midterm.foodapp.entity.Payment;
import com.hdfc.midterm.foodapp.exception.CustomerException;
import com.hdfc.midterm.foodapp.exception.ItemException;
import com.hdfc.midterm.foodapp.exception.OrderException;
import com.hdfc.midterm.foodapp.exception.PaymentException;

public interface IPaymentService {
	
	
	
	public Payment addPayment(PaymentDto paymentDto) throws PaymentException, OrderException;
	
	public Payment updatePayment(Payment payment)throws PaymentException;
	
	public Payment viewPayment(int paymentId)throws PaymentException;

	public String generateTotalBillById(Long customerId)throws AccessException,CustomerException, ItemException;
	
}
