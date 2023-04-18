/*
Author:Chetana Bachhav
Date:
Description:Rating service Interface
*/ 
package com.hdfc.midterm.foodapp.service;

import com.hdfc.midterm.foodapp.dto.RatingDto;
import com.hdfc.midterm.foodapp.entity.Ratings;
import com.hdfc.midterm.foodapp.exception.CustomerException;
import com.hdfc.midterm.foodapp.exception.RestaurantException;

public interface IRatingService {

	

public Ratings viewRatings(int ratingId);

   Ratings addRatings(RatingDto ratingDto) throws  RestaurantException, CustomerException;



	
}
