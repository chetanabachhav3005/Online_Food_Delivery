/*
Author:Chetana Bachhav
Date:
Description:login Repository Interface
*/
package com.hdfc.midterm.foodapp.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.midterm.foodapp.auth.entity.LogInModel;

@Repository
public interface LogInRepository extends JpaRepository<LogInModel, Integer>{

}
