
/*
Author:Chetana Bachhav
Date:
Description:Cart Entity Class
*/ 
package com.hdfc.midterm.foodapp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="Cart")
public class Cart {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true,name="Cart_Id")
	private long cartId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customers customer;
	
	
	@OneToMany(targetEntity = MenuItems.class,cascade = CascadeType.ALL)
	private List<MenuItems> itemList;

	
	
}
