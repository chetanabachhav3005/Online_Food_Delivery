package com.hdfc.midterm.foodapp.entity;

import java.time.LocalDate;

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
@Getter
@Setter
@ToString

@Entity
@Table(name = "Orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true,name = "Order_Id")
	private long orderId;

	// foreign key
	@Column(name = "Customer_Id")
	@NotNull
	private long customerId;

	// foreign key
	@Column(name = "Restaurant_Id")
	@NotNull
	private long restaurant_id;

	@Column(name = "Order_Date")
	@NotNull
	private LocalDate orderDate;

	@Column(name = "Delivery_Address")
	@NotNull
	private String deliveryAddress;

	@Column(name = "Payment")
	@NotNull
	// paymentMethod
	private String payment;

	@Column(name = "Total_Amount")
	@NotNull
	private double totalAmount;

}
