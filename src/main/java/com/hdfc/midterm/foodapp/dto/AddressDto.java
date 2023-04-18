/*
Author:Chetana Bachhav
Date:
Description:Address DTO class for Address Entity Class
*/ 
package com.hdfc.midterm.foodapp.dto;

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

public class AddressDto {

	@NotNull
	private Integer addressId;

	private String area;

	private String city;

	private String state;

	private String country;

	private int pincode;
}
