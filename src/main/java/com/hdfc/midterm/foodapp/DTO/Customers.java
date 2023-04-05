package com.hdfc.midterm.foodapp.DTO;

import javax.persistence.Entity;

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


public class Customers {	
	private long customer_id;
	private String name;
	private String email;
	private long phone_number;
	private String delivery_address;	
}


