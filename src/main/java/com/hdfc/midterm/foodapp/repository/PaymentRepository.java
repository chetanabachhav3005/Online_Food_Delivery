/*
Author:Chetana Bachhav
Date:
Description:Payment Repository Interface
*/ 
package com.hdfc.midterm.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.midterm.foodapp.entity.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
