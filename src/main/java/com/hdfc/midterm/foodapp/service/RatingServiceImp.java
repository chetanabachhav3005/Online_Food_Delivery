/*
Author:Chetana Bachhav
Date:
Description:Rating Service Implementation Class
*/
package com.hdfc.midterm.foodapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midterm.foodapp.dto.RatingDto;
import com.hdfc.midterm.foodapp.entity.Customers;
import com.hdfc.midterm.foodapp.entity.Ratings;
import com.hdfc.midterm.foodapp.entity.Restaurants;
import com.hdfc.midterm.foodapp.exception.CustomerException;
import com.hdfc.midterm.foodapp.exception.RestaurantException;
import com.hdfc.midterm.foodapp.repository.RatingRepository;
@Service
public class RatingServiceImp implements IRatingService{

	
	
	@Autowired
	RatingRepository repo;
	
	
	@Autowired
	IRestaurantsService service;
	
	@Autowired
	ICustomersService rservice;
	
	@Override
	public Ratings addRatings(RatingDto ratingDto) throws RestaurantException, CustomerException{
		Optional<Ratings> opt = repo.findById(ratingDto.getRatingId());
		
		Ratings rt=new Ratings();
		rt.setRatingId(ratingDto.getRatingId());
		
		Restaurants rs=service.viewRestaurant(ratingDto.getRestaurantId());
		rt.setRestaurant(rs);
		
		Customers customer=rservice.viewCustomer(ratingDto.getCustomerId());
		rt.setCustomer(customer);
		
		return repo.save(rt);
	}
	
	@Override
	public Ratings viewRatings(int ratingId){

		Optional<Ratings> res = repo.findById(ratingId);
		
		return res.orElse(null);

	}
}
