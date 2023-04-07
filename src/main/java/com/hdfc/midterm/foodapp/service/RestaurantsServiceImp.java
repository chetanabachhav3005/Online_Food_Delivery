package com.hdfc.midterm.foodapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midterm.foodapp.entity.Restaurants;
import com.hdfc.midterm.foodapp.exception.RestaurantException;
import com.hdfc.midterm.foodapp.repository.RestaurantsRepository;

@Service
public class RestaurantsServiceImp implements IRestaurantsService {

	@Autowired
	RestaurantsRepository repo;

	@Override
	public Restaurants addRestaurant(Restaurants restaurant) throws RestaurantException {
		Optional<Restaurants> opt = repo.findById(restaurant.getRestaurantId());
		if (opt.isPresent()) {
			throw new RestaurantException("Restaurant already exists..");
		} else {
			return repo.save(restaurant);
		}
	}

	@Override
	public Restaurants updateRestaurant(Restaurants restaurant) throws RestaurantException {
		Optional<Restaurants> opt = repo.findById(restaurant.getRestaurantId());
		if (opt.isPresent()) {
			return repo.save(restaurant);
		} else {
			throw new RestaurantException("No such Restaurant exists..");
		}

	}

	@Override
	public Restaurants removeRestaurant(Long restaurantId) throws RestaurantException {
//		Optional<Restaurants> opt = repo.findById(restaurantId);
//		if(opt.isPresent()) {
//			Restaurants restaurant = opt.get();
//			repo.delete(restaurant);
//			return restaurant;
//		}else {
//			throw new RestaurantException("No Restaurant found with ID: "+restaurantId);
//		}

		Optional<Restaurants> res = repo.findById(restaurantId);
		if (res.isEmpty()) {
			throw new RestaurantException("No Resturant found with Id: " + restaurantId);
		}
		repo.deleteById(restaurantId);
		return res.orElse(null);

	}

	@Override
	public Restaurants viewRestaurant(Long restaurantId) throws RestaurantException {
//		Optional<Restaurants> opt = repo.findById(restaurantId);
//		if(opt.isPresent()) {
//			Restaurants restaurant = opt.get();
//			return restaurant;
//		}else {
//			throw new RestaurantException("No Restaurant found with ID: "+restaurantId);
//		}

		Optional<Restaurants> res = repo.findById(restaurantId);
		if (res.isEmpty()) {
			throw new RestaurantException("No Resturant found with Id: " + restaurantId);
		}
		return res.orElse(null);

	}

	@Override
	public List<Restaurants> findByRestaurantName(String restaurantName) throws RestaurantException {
		List<Restaurants> res = repo.findByrestaurantName(restaurantName);
		if (res.isEmpty()) {
			throw new RestaurantException("No Restaurant found with Name: " + restaurantName);
		}
		return res;

	}

	@Override
	public List<Restaurants> findByCuisineType(String cuisineType) throws RestaurantException {

		List<Restaurants> res = repo.findBycuisineType(cuisineType);
		if (res.isEmpty()) {
			throw new RestaurantException("No Restaurant found with cuisine_type: " + cuisineType);
		}
		return res;
	}

	@Override
	public List<Restaurants> findByLocation(String Location) throws RestaurantException {
		List<Restaurants> res = repo.findByLocation(Location);
		if (res.isEmpty()) {
			throw new RestaurantException("No Restaurant found : " + Location);
		}
		return res;

	}

}
