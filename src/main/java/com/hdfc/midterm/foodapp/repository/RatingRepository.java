/*
Author:Chetana Bachhav
Date:
Description:Rating Repository Interface
*/ 
package com.hdfc.midterm.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdfc.midterm.foodapp.entity.Ratings;

public interface RatingRepository extends JpaRepository<Ratings, Integer>{

}
