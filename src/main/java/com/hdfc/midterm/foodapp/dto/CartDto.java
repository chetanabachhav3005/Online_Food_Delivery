/*
Author:Chetana Bachhav
Date:
Description:Cart DTO Class for Cart Entity Class
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


public class CartDto {

	
	
	private long cartId;
	
	private long customerId;

	private List<MenuItems> itemList;
	
	
	
	
	
	
	
}
