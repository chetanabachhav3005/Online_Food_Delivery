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

public class AddressDto {

	private Integer addressId;

	private String area;

	private String city;

	private String state;

	private String country;

	private int pincode;
}
