package com.hdfc.midterm.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.midterm.foodapp.entity.Restaurants;


@Repository
public interface RestaurantsRepository extends JpaRepository<Restaurants, Long>{
//
}
