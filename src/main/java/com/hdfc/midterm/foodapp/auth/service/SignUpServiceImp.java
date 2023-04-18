/*
Author:Chetana Bachhav
Date:
Description:Signup Service Implementation Class
*/
package com.hdfc.midterm.foodapp.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midterm.foodapp.auth.entity.SignUpModel;
import com.hdfc.midterm.foodapp.auth.exception.AuthorizationException;
import com.hdfc.midterm.foodapp.auth.repository.SignUpRepository;
@Service
public class SignUpServiceImp implements ISignUpService {


	@Autowired
	private SignUpRepository signUprepo;
	
	@Autowired
	private IUserSessionService userLoginSession;
	
	
	
	
	@Override
	public SignUpModel newSignUp(SignUpModel signUp) throws AuthorizationException {
		
		Optional<SignUpModel> opt = signUprepo.findByUserName(signUp.getUserName());
		if(opt.isPresent())
		{
			throw new AuthorizationException("User Already Exists..!!");
		}
		
		return signUprepo.save(signUp);
	}

	
	@Override
	public SignUpModel updateSignUp(SignUpModel signUp, String key) throws AuthorizationException {
		
		SignUpModel signUpDetails = userLoginSession.getSignUpDetails(key);
		
		if(signUpDetails == null)
		{
			throw new AuthorizationException("User not LoggedIn...!! Try To Login first..");
		}
		
		if(signUpDetails.getUserId() == signUp.getUserId())
			{
			signUprepo.save(signUp);
			return signUp;
			}
		else
			throw new AuthorizationException("UserId not found..!!");
	}

}
