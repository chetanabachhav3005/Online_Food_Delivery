/*
Author:Chetana Bachhav
Date:
Description:Login Service Implementation Class
*/
package com.hdfc.midterm.foodapp.auth.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midterm.foodapp.auth.entity.LogInModel;
import com.hdfc.midterm.foodapp.auth.entity.SignUpModel;
import com.hdfc.midterm.foodapp.auth.entity.UserSession;
import com.hdfc.midterm.foodapp.auth.exception.AuthorizationException;
import com.hdfc.midterm.foodapp.auth.repository.LogInRepository;
import com.hdfc.midterm.foodapp.auth.repository.SignUpRepository;
import com.hdfc.midterm.foodapp.auth.repository.UserSessionRepository;
@Service
public class LoginServiceImp implements ILoginService{

	@Autowired
	private SignUpRepository signUprepo;
	
	@Autowired
	private UserSessionRepository userSessionrepo;
	
	@Autowired
	private IUserSessionService iservice;
	
	@Autowired
	private LogInRepository loginDatarepo;
	
	@Override
	public String LogIn(LogInModel loginData) throws AuthorizationException {
		
		Optional<SignUpModel> opt = signUprepo.findById(loginData.getUserId());
		
		if(!opt.isPresent())
		{
			throw new AuthorizationException("Invalid Login UserId");
		}
		
		SignUpModel newSignUp = opt.get();
		
		Integer newSignUpId = newSignUp.getUserId();
		Optional<UserSession> currentUserOptional = userSessionrepo.findByUserId(newSignUpId);
		
		if(currentUserOptional.isPresent()) {
			throw new AuthorizationException("User Already LoggedIn with this UserId");
		}
		
		if((newSignUp.getUserId() == loginData.getUserId()) && (newSignUp.getPassword().equals(loginData.getPassword())))
		{
			String key = RandomString.getRandomString();
			
			UserSession currentUserSession = new UserSession(newSignUp.getUserId(),key,LocalDateTime.now());
			userSessionrepo.save(currentUserSession);
			loginDatarepo.save(loginData);
			
			return currentUserSession.toString();
			
		}
		else
			throw new AuthorizationException("Invalid UserName or Password..");
			
			
		
	}

	@Override
	public String LogOut(String key) throws AuthorizationException {
		
		Optional<UserSession> currentUserOptional = userSessionrepo.findByUUID(key);
		if(!currentUserOptional.isPresent())
		{
			throw new AuthorizationException("Invalid credentials...");
		}
		UserSession currentUserSession = iservice.getUserSession(key);
		
		userSessionrepo.delete(currentUserSession);
		
		Optional<LogInModel> loginData = loginDatarepo.findById(currentUserOptional.get().getUserId());
		System.out.println(loginData);
		loginDatarepo.delete(loginData.get());
		
		
		return "Logged Out...";
	
	}
}
