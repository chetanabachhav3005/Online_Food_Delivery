package com.hdfc.midterm.foodapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
@Table(name = "Address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Address_Id")
	private Integer addressId;

	@Column(name = "Area")
	@NotNull
	private String area;

	@Column(name = "City")
	@NotNull
	private String city;

	@Column(name = "State")
	@NotNull
	private String state;

	@Column(name = "Country")
	@NotNull
	private String country;

	@Column(unique=true,name = "PinCode")
	@NotNull
	private int pincode;
}
