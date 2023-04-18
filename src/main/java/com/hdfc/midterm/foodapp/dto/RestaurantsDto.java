/*
Author:Chetana Bachhav
Date:
Description:Restaurant DTO Class fro Restaurant Entity Class
*/ 
package com.hdfc.midterm.foodapp.dto;

import java.util.List;

import com.hdfc.midterm.foodapp.entity.MenuItems;

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



public class RestaurantsDto {
	
	
	private long restaurantId;
	private String restaurantName;
	private String cuisineType;
	private String location;
	private int addressId;
	
	private List<MenuItems> itemList;
}

