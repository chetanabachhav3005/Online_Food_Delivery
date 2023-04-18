/*
Author:Chetana Bachhav
Date:
Description:SignUp Sevice Interface
*/
package com.hdfc.midterm.foodapp.auth.service;

import com.hdfc.midterm.foodapp.auth.entity.SignUpModel;
import com.hdfc.midterm.foodapp.auth.exception.AuthorizationException;

public interface ISignUpService {

public SignUpModel newSignUp(SignUpModel signUp) throws AuthorizationException;;
	
	public SignUpModel updateSignUp(SignUpModel signUp, String key) throws AuthorizationException;

}
