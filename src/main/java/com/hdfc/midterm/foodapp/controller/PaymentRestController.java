package com.hdfc.midterm.foodapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.midterm.foodapp.dto.PaymentDto;
import com.hdfc.midterm.foodapp.entity.Payment;
import com.hdfc.midterm.foodapp.exception.PaymentException;
import com.hdfc.midterm.foodapp.service.IPaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentRestController {

	@Autowired
	IPaymentService service;

	@PostMapping("/add")
	public ResponseEntity<Payment> generateBill(@Valid @RequestBody PaymentDto payment) throws PaymentException {
		Payment pt = service.addPayment(payment);
		return new ResponseEntity<Payment>(pt, HttpStatus.CREATED);

	}

	@PutMapping("/update")
	public ResponseEntity<Payment> updatePayment(@Valid @RequestBody Payment payment) throws PaymentException {
		Payment pt = service.updatePayment(payment);
		return new ResponseEntity<Payment>(pt, HttpStatus.ACCEPTED);

	}

	@GetMapping("/view/{paymentId}")
	public ResponseEntity<Payment> viewPayment(@PathVariable("paymentId") int paymentId) throws PaymentException {
		Payment pt = service.viewPayment(paymentId);
		return new ResponseEntity<Payment>(pt, HttpStatus.ACCEPTED);
	}

}
