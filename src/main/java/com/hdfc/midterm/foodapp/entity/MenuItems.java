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

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name="Items")
public class MenuItems {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true,name="Item_Id")
	private long menuItemId;
	
	@Column(name="Restaurant_Id")
	@NotNull
	private long restaurantId;
	
	
	@Column(name="Item_Name")
	@NotNull
	private String itemName;
	
	@Column(name="Description")
	@NotNull
	private String description;
	
	@Column(name="Price")
	@NotNull
	private double price;
	
	@Column(name="Availability")
	@NotNull
	private boolean availability;
	
}

