package com.hdfc.midterm.foodapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name="Restaurant")
public class Restaurants {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true,name = "Restaurant_Id")
	private long restaurantId;

	@Column(name = "Restaurant_Name")
	@NotNull
	private String restaurantName;

	@Column(name = "Cuisine_Type")
	@NotNull
	private String cuisineType;

	@Column(name = "Location")
	@NotNull
	private String location;

	@Column(name = "Ratings")
	@NotNull
	private int rating;
	
	
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	private Address address;

}
