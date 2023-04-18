/*
Author:Chetana Bachhav
Date:
Description:Rating Entity Class
*/ 
package com.hdfc.midterm.foodapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table(name="Ratings")
public class Ratings {
	
	@Id
	@Column(name = "Rating")
	private int ratingId;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Restaurants restaurant;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customers customer;
	
	
}
