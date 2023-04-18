/*
Author:Chetana Bachhav
Date:
Description:UserSession Repository Interface
*/
package com.hdfc.midterm.foodapp.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.midterm.foodapp.auth.entity.UserSession;


@Repository
public interface UserSessionRepository extends JpaRepository<UserSession, Integer> {
	
	public Optional<UserSession> findByUserId(Integer userId);
	
	public Optional<UserSession> findByUUID(String uuid);

}
