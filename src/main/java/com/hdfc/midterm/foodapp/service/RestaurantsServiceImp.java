/*
Author:Chetana Bachhav
Date:
Description:Restaurant Service Implementation Class
*/

package com.hdfc.midterm.foodapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midterm.foodapp.dto.RestaurantsDto;
import com.hdfc.midterm.foodapp.entity.Address;
import com.hdfc.midterm.foodapp.entity.Restaurants;
import com.hdfc.midterm.foodapp.exception.AddressException;
import com.hdfc.midterm.foodapp.exception.RestaurantException;
import com.hdfc.midterm.foodapp.repository.AddressRepository;
import com.hdfc.midterm.foodapp.repository.RestaurantsRepository;

@Service
public class RestaurantsServiceImp implements IRestaurantsService {

	@Autowired
	RestaurantsRepository repo;
	
	
	@Autowired
	AddressRepository arepo;
	
	@Autowired
	IAddressService service;

	@Override
	public Restaurants addRestaurant(RestaurantsDto restaurantDto) throws RestaurantException, AddressException {
		Optional<Restaurants> opt = repo.findById(restaurantDto.getRestaurantId());
		
		Address address=service.viewAddress(restaurantDto.getAddressId()); 
		
		
		Restaurants rs=new Restaurants();
		rs.setRestaurantId(restaurantDto.getRestaurantId());
		rs.setRestaurantName(restaurantDto.getRestaurantName());
		rs.setCuisineType(restaurantDto.getCuisineType());
		rs.setLocation(restaurantDto.getLocation());
		rs.setItemList(restaurantDto.getItemList());
	
		rs.setAddress(address);
		
		
		if (opt.isPresent()) {
			throw new RestaurantException("Restaurant already exists..");
		} else {
			return repo.save(rs);
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

		Optional<Restaurants> res = repo.findById(restaurantId);
		if (res.isEmpty()) {
			throw new RestaurantException("No Resturant found with Id: " + restaurantId);
		}
		repo.deleteById(restaurantId);
		return res.orElse(null);

	}

	@Override
	public Restaurants viewRestaurant(Long restaurantId) throws RestaurantException {

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
