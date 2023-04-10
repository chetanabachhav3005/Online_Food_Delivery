package com.hdfc.midterm.foodapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString


public class CartDto {

	
	
	private long cartId;
	
	private long customerId;
	private long itemId;
	private double price;
	private int quantity;
	private double total;
	
	
	
	
	
}
