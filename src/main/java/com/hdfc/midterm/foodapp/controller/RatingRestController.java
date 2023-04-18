
/*
Author:Chetana Bachhav
Date:
Description:Rating Rest Controller
*/
package com.hdfc.midterm.foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.midterm.foodapp.dto.RatingDto;
import com.hdfc.midterm.foodapp.entity.Ratings;
import com.hdfc.midterm.foodapp.exception.CustomerException;
import com.hdfc.midterm.foodapp.exception.OrderException;
import com.hdfc.midterm.foodapp.exception.RestaurantException;
import com.hdfc.midterm.foodapp.service.IRatingService;

@RestController
@RequestMapping("/ratings")
public class RatingRestController {
	
	@Autowired
	IRatingService rservice;
	
	@PostMapping("/add/rating")
	public ResponseEntity<Ratings> saveRating(@RequestBody RatingDto ratingDto)
			throws RestaurantException, CustomerException {

		Ratings newRating = rservice.addRatings(ratingDto);

		return new ResponseEntity<Ratings>(newRating, HttpStatus.CREATED);
	}

	
	
	
	@GetMapping("/view/rating/{ratingId}")
	public ResponseEntity<Ratings> getByRatingId(@PathVariable("ratingId") int ratingId)
		{

		Ratings rt=rservice.viewRatings(ratingId);
		return new ResponseEntity<Ratings>(rt, HttpStatus.ACCEPTED);

	}
	
	
}
