package com.hdfc.midterm.foodapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
@Table(name="Cart")
public class Cart {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true,name="Cart_Id")
	private long cartId;
	
	@Column(name="Customer_Id")
	@NotNull
	private long customerId;
	
	
	@Column(name="Item_Id")
	@NotNull
	private long itemId;
	
	
	@Column(name="Price")
	@NotNull
	private double price;
	
	@Column(name="Quantity")
	@NotNull
	private int quantity;
	
	@Column(name="Total")
	@NotNull
	private double total;
	
	
	

	
	
	
	
	
}