/*
Author:Chetana Bachhav
Date:
Description:Login Entity Class
*/
package com.hdfc.midterm.foodapp.auth.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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
public class LogInModel {

	
	@Id
	@NotNull
	private Integer userId;
	
	private String userName;
	private String password;
}
