package com.hdfc.midterm.foodapp.dto;

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
	private String rating;
	
	
	
}

