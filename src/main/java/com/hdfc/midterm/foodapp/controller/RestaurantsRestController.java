package com.hdfc.midterm.foodapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.midterm.foodapp.entity.Restaurants;
import com.hdfc.midterm.foodapp.exception.RestaurantException;
import com.hdfc.midterm.foodapp.service.IRestaurantsService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantsRestController {

	@Autowired
	IRestaurantsService service;

	@PostMapping("/add/restaurant")
	public ResponseEntity<Restaurants> saveResturant(@Valid @RequestBody Restaurants restaurant)
			throws RestaurantException {

		Restaurants newRestaurant = service.addRestaurant(restaurant);

		return new ResponseEntity<Restaurants>(newRestaurant, HttpStatus.CREATED);
	}

	@PutMapping("/update/restaurant")
	public ResponseEntity<Restaurants> updateResturant(@Valid @RequestBody Restaurants restaurant)
			throws RestaurantException {

		Restaurants updatedResturant = service.updateRestaurant(restaurant);

		return new ResponseEntity<Restaurants>(updatedResturant, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/remove/restaurant/{restaurantId}")
	public ResponseEntity<Restaurants> deleteRestaurant(@PathVariable("restaurantId") Long restaurantId)
			throws RestaurantException {
		Restaurants removedRestaurant = service.removeRestaurant(restaurantId);
		return new ResponseEntity<Restaurants>(removedRestaurant, HttpStatus.OK);
	}

	@GetMapping("/view/restaurant/{restaurantId}")
	public ResponseEntity<Restaurants> getByResturantId(@PathVariable("restaurantId") Long restaurantId)
			throws RestaurantException {

		Restaurants restaurant = service.viewRestaurant(restaurantId);
		return new ResponseEntity<Restaurants>(restaurant, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getbyRestaurantName/{restaurantName}")
	public ResponseEntity<List<Restaurants>> findByRestaurantName(@PathVariable("restaurantName") String restaurantName)
			throws RestaurantException {

		List<Restaurants> restaurant = service.findByRestaurantName(restaurantName);
		return new ResponseEntity<List<Restaurants>>(restaurant, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getbyCuisineType/{cuisineType}")
	public ResponseEntity<List<Restaurants>> findByCuisineType(@PathVariable("cuisineType") String cuisineType)
			throws RestaurantException {

		List<Restaurants> restaurant = service.findByCuisineType(cuisineType);
		return new ResponseEntity<List<Restaurants>>(restaurant, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getbyLocation/{location}")
	public ResponseEntity<List<Restaurants>> findByLocation(@PathVariable("location") String location)
			throws RestaurantException {

		List<Restaurants> restaurant = service.findByLocation(location);
		return new ResponseEntity<List<Restaurants>>(restaurant, HttpStatus.ACCEPTED);

	}

}
