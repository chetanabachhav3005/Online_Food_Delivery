/*
Author:Chetana Bachhav
Date:
Description:Payment DTO Class for Payment Entity Class
*/ 
package com.hdfc.midterm.foodapp.dto;

import java.time.LocalDate;

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



public class PaymentDto {
	
	private Integer paymentId;
	private long orderId;
	private LocalDate paymentDate;
	private Double totalCost;
	private Integer totalItem;
	


	
	
}
