/*
Author:Chetana Bachhav
Date:
Description:sign up Entity Class
*/
package com.hdfc.midterm.foodapp.auth.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="Users")
public class SignUpModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;


	@NotNull
	@Pattern(regexp="[a-zA-Z]{5,15}", message = "Username must be of length 5-15 alphabetical characters")
	private String userName;

	@NotNull
	@Pattern(regexp="[a-zA-Z0-9]{5,20}", message="Password must be of length 5-20 alphanumeric characters")
	private String password;

	@NotNull
	@Pattern(regexp="[0-9]{10}", message = "Mobile number must be of 10 digits")
	private String mobileNo;

	@NotNull
	@Email
	private String email;

}
