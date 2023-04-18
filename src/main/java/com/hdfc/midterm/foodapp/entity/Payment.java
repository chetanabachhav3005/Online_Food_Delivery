/*
Author:Chetana Bachhav
Date:
Description:Payement Entity Class
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
@Setter
@Getter
@ToString

@Entity
@Table(name = "Payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true,name = "Payment_Id")
	private int paymentId;

	@Column(name = "Payment_Date")
	private LocalDate paymentDate;

	@Column(name = "Total_cost")
	@NotNull
	private Double totalCost;


	@Column(name="Total_Item")
	private Integer totalItem;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Orders order;

}
