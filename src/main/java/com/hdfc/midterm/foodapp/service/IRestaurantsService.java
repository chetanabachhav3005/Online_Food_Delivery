/*
Author:Chetana Bachhav
Date:
Description:Restaurant Service Interface
*/ 
package com.hdfc.midterm.foodapp.service;

import java.util.List;

import com.hdfc.midterm.foodapp.dto.RestaurantsDto;
import com.hdfc.midterm.foodapp.entity.Restaurants;
import com.hdfc.midterm.foodapp.exception.AddressException;
import com.hdfc.midterm.foodapp.exception.RestaurantException;

public interface IRestaurantsService {
  
	
	public Restaurants addRestaurant(RestaurantsDto restaurantsDto) throws RestaurantException, AddressException;
	
	public Restaurants updateRestaurant(Restaurants restaurant) throws RestaurantException;
	
	public Restaurants removeRestaurant(Long restaurantId) throws RestaurantException;
	
	public Restaurants viewRestaurant(Long restaurantId) throws RestaurantException;
	
	
	public List<Restaurants> findByRestaurantName(String restaurantName) throws RestaurantException;
	
	public List<Restaurants> findByCuisineType(String cuisineType) throws RestaurantException;
	
	public List<Restaurants> findByLocation(String Location) throws RestaurantException;

}
