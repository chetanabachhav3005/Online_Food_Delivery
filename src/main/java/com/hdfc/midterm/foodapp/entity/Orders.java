/*
Author:Chetana Bachhav
Date:
Description:Order Entity Class
*/ 

package com.hdfc.midterm.foodapp.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
	@Column(unique = true, name = "Order_Id")
	private long orderId;

	@Column(name = "Order_Date")
	@NotNull
	private LocalDate orderDate;

	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart;

}
