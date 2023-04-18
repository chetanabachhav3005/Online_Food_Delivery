
/*
Author:Chetana Bachhav
Date:
Description:Random String Class
*/
package com.hdfc.midterm.foodapp.auth.service;

import java.util.Random;

public class RandomString {
	
	public static String getRandomString() {
	   
	    Random rn = new Random();
	    int number = rn.nextInt(999999);

	    return String.format("%06d", number);
	}

}
