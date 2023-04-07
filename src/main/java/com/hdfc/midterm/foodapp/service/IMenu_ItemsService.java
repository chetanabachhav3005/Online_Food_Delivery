package com.hdfc.midterm.foodapp.service;

import java.util.List;

import com.hdfc.midterm.foodapp.entity.Menu_Items;
import com.hdfc.midterm.foodapp.exception.ItemException;



public interface IMenu_ItemsService {
	public Menu_Items addItem(Menu_Items item) throws ItemException;

	public Menu_Items updateItem(Menu_Items item) throws ItemException;

	public Menu_Items viewItem(Long menuItemId) throws ItemException;

	public Menu_Items removeItem(Long menuItemId) throws ItemException;

	public List<Menu_Items> viewAllItems() throws ItemException;

}
