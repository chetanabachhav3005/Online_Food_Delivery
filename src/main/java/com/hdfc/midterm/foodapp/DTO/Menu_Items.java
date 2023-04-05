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


public class Menu_Items {

	
	private long menu_item_id;
	private long restaurant_id;
	private String item_name;
	private String description;
	private double price;
	private String availability;
	
}

