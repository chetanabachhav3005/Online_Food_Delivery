/*
Author:Chetana Bachhav
Date:
Description:Signup Repository Interface
*/
package com.hdfc.midterm.foodapp.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.midterm.foodapp.auth.entity.SignUpModel;

@Repository
public interface SignUpRepository extends JpaRepository<SignUpModel, Integer>{

	public Optional<SignUpModel> findByUserName(String userName);
}
