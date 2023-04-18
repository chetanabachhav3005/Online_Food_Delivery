/*
Author:Chetana Bachhav
Date:
Description:Order DTO Class for Order Entity Class
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
@Getter
@Setter
@ToString

public class OrdersDto {

    private long orderId;
    private LocalDate orderDate;
    private long customerId;
	private long cartId;
}


