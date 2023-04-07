package com.hdfc.midterm.foodapp.entity;

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
public class Menu_Items {

	@Id
	private long menuItemId;
	private long restaurantId;
	private String itemName;
	private String description;
	private double price;
	private boolean availability;
	
}

