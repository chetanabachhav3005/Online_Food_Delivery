package com.hdfc.midterm.foodapp.DTO;

import javax.persistence.Entity;
import javax.persistence.Id;

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

@Entity
public class Customers {
	@Id
	private long customerId;
	private String name;
	private String email;
	private long phoneNumber;
	private String deliveryAddress;	
}


