/*
Author:Chetana Bachhav
Date:
Description:Rating DTO Class for Rating Entity class
*/ 

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

public class RatingDto {

	private int ratingId;
	private long restaurantId;
	private long customerId;
	//private int rating;
	
}
