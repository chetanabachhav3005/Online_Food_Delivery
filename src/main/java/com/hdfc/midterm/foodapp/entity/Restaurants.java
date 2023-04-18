/*
Author:Chetana Bachhav
Date:
Description:Restaurant Entity Class
*/ 
package com.hdfc.midterm.foodapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table(name="Restaurant")
public class Restaurants {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true,name = "Restaurant_Id")
	private long restaurantId;

	@Column(name = "Restaurant_Name")
	private String restaurantName;

	@Column(name = "Cuisine_Type")
	private String cuisineType;

	@Column(name = "Location")
	private String location;
	

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Address_Id")
	private Address address;
	
	
	@OneToMany(targetEntity = MenuItems.class,cascade = CascadeType.MERGE)
	private List<MenuItems> itemList = new ArrayList<>();

}
