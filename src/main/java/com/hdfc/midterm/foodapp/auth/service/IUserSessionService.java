/*
Author:Chetana Bachhav
Date:
Description:User Session Service Interface
*/
package com.hdfc.midterm.foodapp.auth.service;

import com.hdfc.midterm.foodapp.auth.entity.SignUpModel;
import com.hdfc.midterm.foodapp.auth.entity.UserSession;
import com.hdfc.midterm.foodapp.auth.exception.AuthorizationException;

public interface IUserSessionService {
	
	public UserSession getUserSession(String key) throws AuthorizationException;
	
	public Integer getUserSessionId(String key) throws AuthorizationException;
	
	public SignUpModel getSignUpDetails(String key) throws AuthorizationException;
	

}
