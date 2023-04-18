/*
Author:Chetana Bachhav
Date:
Description:Login Rest Controller Class
*/
package com.hdfc.midterm.foodapp.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.midterm.foodapp.auth.entity.LogInModel;
import com.hdfc.midterm.foodapp.auth.exception.AuthorizationException;
import com.hdfc.midterm.foodapp.auth.service.LoginServiceImp;

@RestController
@RequestMapping("/login/api")
public class LoginController {
	
	@Autowired
	private LoginServiceImp loginService;
	
	@PostMapping("/login")
	public String loginHandler(@RequestBody LogInModel loginData) throws AuthorizationException {
		return loginService.LogIn(loginData);
	}
	
	@PatchMapping("/logout")
	public String logOutFromAccount(@RequestParam String key) throws AuthorizationException
	{
		return loginService.LogOut(key);
	}
	

}
