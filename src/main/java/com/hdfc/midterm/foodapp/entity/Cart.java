package com.hdfc.midterm.foodapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

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

@Entity
public class Cart {

	
	@Id
	private long cartId;
	
	private long customerId;
	private long itemId;
	private double price;
	private int quantity;
	private double total;
	
	
	

	
	
	
	
	
}
