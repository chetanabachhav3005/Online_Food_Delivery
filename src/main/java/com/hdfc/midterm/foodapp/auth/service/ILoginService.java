/*
Author:Chetana Bachhav
Date:
Description:Login Service Interface
*/
package com.hdfc.midterm.foodapp.auth.service;

import com.hdfc.midterm.foodapp.auth.entity.LogInModel;
import com.hdfc.midterm.foodapp.auth.exception.AuthorizationException;

public interface ILoginService {


	public String LogIn(LogInModel login) throws AuthorizationException;
	
	public String LogOut(String key) throws AuthorizationException;
}
