/*
Author:Chetana Bachhav
Date:
Description:User Session Service Implementation Class
*/
package com.hdfc.midterm.foodapp.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midterm.foodapp.auth.entity.SignUpModel;
import com.hdfc.midterm.foodapp.auth.entity.UserSession;
import com.hdfc.midterm.foodapp.auth.exception.AuthorizationException;
import com.hdfc.midterm.foodapp.auth.repository.SignUpRepository;

import com.hdfc.midterm.foodapp.auth.repository.UserSessionRepository;

@Service
public class UserSessionServiceImpl implements IUserSessionService {

	@Autowired
	private UserSessionRepository userSessionrepo;
	
	@Autowired
	private SignUpRepository signuprepo;
	
	
	
	@Override
	public UserSession getUserSession(String key) throws AuthorizationException {
		
		Optional<UserSession> currentUser = userSessionrepo.findByUUID(key);
		if(!currentUser.isPresent())
		{
			throw new AuthorizationException("Not Authorized..!!");
		}
		return currentUser.get();
	}

	@Override
	public Integer getUserSessionId(String key) throws AuthorizationException {
		
		Optional<UserSession> currentUser = userSessionrepo.findByUUID(key);
		if(!currentUser.isPresent())
		{
			throw new AuthorizationException("Not Authorized..!!");
		}
		return currentUser.get().getId();
		
	}


	@Override
	public SignUpModel getSignUpDetails(String key) {
		
		Optional<UserSession> currentUser = userSessionrepo.findByUUID(key);
		if(!currentUser.isPresent())
		{
			return null;
		}
		Integer SignUpUserId = currentUser.get().getUserId();
		System.out.println(SignUpUserId );
		
		return (signuprepo.findById(SignUpUserId)).get();
	}

}
