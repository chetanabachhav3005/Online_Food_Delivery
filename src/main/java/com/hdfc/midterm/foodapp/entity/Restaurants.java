package com.hdfc.midterm.foodapp.entity;

import javax.persistence.Entity;
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


@Entity
public class Restaurants {
	
	@Id
	private long restaurantId;
	private String restaurantName;
	private String cuisineType;
	private String location;
	private String rating;
	
	
	
}

