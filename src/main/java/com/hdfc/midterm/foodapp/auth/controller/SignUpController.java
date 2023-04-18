/*
Author:Chetana Bachhav
Date:
Description:Signup Rest Controller Class
*/
package com.hdfc.midterm.foodapp.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.midterm.foodapp.auth.entity.SignUpModel;
import com.hdfc.midterm.foodapp.auth.exception.AuthorizationException;
import com.hdfc.midterm.foodapp.auth.service.SignUpServiceImp;

@RestController
@RequestMapping("/api/signup")
public class SignUpController {
	
	@Autowired
	private SignUpServiceImp signUpService;
	
	@PostMapping("/signUp")
	public ResponseEntity<SignUpModel> createNewSignUpHandler(@RequestBody SignUpModel newSignUp) throws AuthorizationException {
		
		SignUpModel newSignedUp =signUpService.newSignUp(newSignUp);
		return new ResponseEntity<SignUpModel>(newSignedUp,HttpStatus.CREATED);

	}
	
	
	@PutMapping("/updateSignUp")
	public ResponseEntity<SignUpModel> updateSignUpDetailsHandler(@RequestBody SignUpModel signUp, @RequestParam String key) throws AuthorizationException
	{
		SignUpModel newUpdatedSignUp = signUpService.updateSignUp(signUp,key);
		
		return new ResponseEntity<SignUpModel>(newUpdatedSignUp,HttpStatus.ACCEPTED);
		
	
	}

}
