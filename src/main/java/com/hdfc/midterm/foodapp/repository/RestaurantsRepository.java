package com.hdfc.midterm.foodapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.midterm.foodapp.entity.Restaurants;


@Repository
public interface RestaurantsRepository extends JpaRepository<Restaurants, Long>{

	public List<Restaurants> findByrestaurantName(String restaurantName);
	
	public List<Restaurants> findBycuisineType(String cuisineType);
	
	public List<Restaurants> findByLocation(String Location);
}
