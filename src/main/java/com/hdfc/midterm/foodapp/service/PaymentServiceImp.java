package com.hdfc.midterm.foodapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midterm.foodapp.dto.PaymentDto;
import com.hdfc.midterm.foodapp.entity.Payment;
import com.hdfc.midterm.foodapp.exception.PaymentException;
import com.hdfc.midterm.foodapp.repository.PaymentRepository;


@Service
public class PaymentServiceImp implements IPaymentService {

	@Autowired
	PaymentRepository repo;
	
	
	
	
	@Override
	public Payment addPayment(PaymentDto paymentDto) throws PaymentException {
		
		Payment pt=new Payment();
		pt.setPaymentId(paymentDto.getPaymentId());
		pt.setPaymentDate(paymentDto.getPaymentDate());
		pt.setTotalCost(paymentDto.getTotalCost());
		pt.setTotalItem(paymentDto.getTotalItem());
		Optional<Payment> opt = repo.findById(paymentDto.getPaymentId());
		if(opt.isPresent()) {
			throw new PaymentException("Bill already exists..");
		}else {
			return repo.save(pt);
		}
	}


	@Override
	public Payment updatePayment(Payment payment) throws PaymentException {
		Optional<Payment> opt = repo.findById(payment.getPaymentId());
		if(opt.isPresent()) {
			return repo.save(payment);
		}else {
			throw new PaymentException("Bill doesn't exists..");
		}
	}

	@Override
	public Payment viewPayment(int paymentId) throws PaymentException {
		Optional<Payment> opt = repo.findById(paymentId);
		if(opt.isPresent()) {
			return opt.get();
		}else{
			throw new PaymentException("Bill not found with ID: "+paymentId);
		}
	}
}
