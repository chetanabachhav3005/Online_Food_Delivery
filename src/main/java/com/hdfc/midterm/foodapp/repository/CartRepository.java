/*
Author:Chetana Bachhav
Date:
Description:Cart Repository Interface
*/ 
package com.hdfc.midterm.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.midterm.foodapp.entity.Cart;


@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

}
