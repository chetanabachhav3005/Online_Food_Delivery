package com.hdfc.midterm.foodapp.service;

import com.hdfc.midterm.foodapp.dto.PaymentDto;
import com.hdfc.midterm.foodapp.entity.Payment;
import com.hdfc.midterm.foodapp.exception.PaymentException;

public interface IPaymentService {
	public Payment addPayment(PaymentDto paymentDto) throws PaymentException;
	
	public Payment updatePayment(Payment payment)throws PaymentException;
	
	public Payment removePayment(Integer paymentId)throws PaymentException;
	
	public Payment viewPayment(Integer paymentId)throws PaymentException;

	
}
