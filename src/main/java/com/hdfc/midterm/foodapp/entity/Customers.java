/*
Author:Chetana Bachhav
Date:
Description:Customer Entity Class
*/ 

package com.hdfc.midterm.foodapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "Customers")
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, name = "Customer_Id")
	private long customerId;

	@NotNull
	@Pattern(regexp="[a-zA-Z]{5,15}", message = "Customer Name must be of length// 5-15 alphabetical characters")
	@Column(name = "Customer_Name")
	private String name;

	@Column(name = "Email_Id")
	@Email
	private String email;

	@Column(name = "Contact_No")
	private long phoneNumber;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Cart cart;
	
	
	

}
