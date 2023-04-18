
/*
Author:Chetana Bachhav
Date:
Description:Payment Service Implementation Class
*/
package com.hdfc.midterm.foodapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midterm.foodapp.dto.PaymentDto;
import com.hdfc.midterm.foodapp.entity.Customers;
import com.hdfc.midterm.foodapp.entity.MenuItems;
import com.hdfc.midterm.foodapp.entity.Orders;
import com.hdfc.midterm.foodapp.entity.Payment;
import com.hdfc.midterm.foodapp.exception.CustomerException;
import com.hdfc.midterm.foodapp.exception.ItemException;
import com.hdfc.midterm.foodapp.exception.OrderException;
import com.hdfc.midterm.foodapp.exception.PaymentException;
import com.hdfc.midterm.foodapp.repository.CustomersRepository;
import com.hdfc.midterm.foodapp.repository.PaymentRepository;


@Service
public class PaymentServiceImp implements IPaymentService {

	@Autowired
	PaymentRepository repo;
	
	
	@Autowired
	IOrdersService service;
	
	@Autowired
	CustomersRepository crepo;
	
	@Override
	public Payment addPayment(PaymentDto paymentDto) throws PaymentException, OrderException {
		
		
		Optional<Payment> opt = repo.findById(paymentDto.getPaymentId());
		Payment pt=new Payment();
		
		Orders order=service.viewOrder(paymentDto.getOrderId());
		pt.setOrder(order);
		
		pt.setPaymentId(paymentDto.getPaymentId());
		pt.setPaymentDate(paymentDto.getPaymentDate());
		pt.setTotalCost(paymentDto.getTotalCost());
		pt.setTotalItem(paymentDto.getTotalItem());
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
	
	

	@Override
	public String generateTotalBillById(Long customerId) throws ItemException, CustomerException {
		Optional<Customers> cOpt = crepo.findById(customerId);
		if(cOpt.isPresent()) {
			Customers customer = cOpt.get();
			List<MenuItems> items = customer.getCart().getItemList();
			
			if(items.size() > 0) {
				
				Double total = 0.0;
				for(MenuItems item : items) {
					total += (item.getPrice()*item.getQuantity()); 
				}
				
				return "The total bill for "+customer.getName()+" is "+total;
				
			}else {
				throw new ItemException("No order items found for "+customer.getName());
			}
			
		}else {
			throw new CustomerException("No Customer found with ID: "+customerId);
		}
	}

	
	
}
