package com.hdfc.midterm.foodapp.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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



public class Restaurants {
	
	
	private long restaurantId;
	private String restaurantName;
	private String cuisineType;
	private String location;
	private String rating;
	
	
	
}

