package com.hdfc.midterm.foodapp.DTO;

import javax.persistence.Entity;

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

	private long restaurant_id;
	private String restaurant_name;
	private String cuisine_type;
	private String location;
	private String rating;
	
	
	
}

