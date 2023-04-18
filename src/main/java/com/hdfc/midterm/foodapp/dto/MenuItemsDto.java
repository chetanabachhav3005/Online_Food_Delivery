/*
Author:Chetana Bachhav
Date:
Description:Items DTO Class for Items Entity Class
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


public class MenuItemsDto {

	
	private long menuItemId;
	private String itemName;
	private String description;
	private double price;
	private boolean availability;
	private Integer quantity;
	
}

