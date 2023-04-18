/*
Author:Chetana Bachhav
Date:
Description:Customer DTO Class for Customer Entity Class
*/ 

package com.hdfc.midterm.foodapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class CustomersDto {

	private long customerId;
	private String name;
	private String email;
	private long phoneNumber;

	
}


