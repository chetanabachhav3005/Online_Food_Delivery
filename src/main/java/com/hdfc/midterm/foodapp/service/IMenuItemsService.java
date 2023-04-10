package com.hdfc.midterm.foodapp.service;

import java.util.List;

import com.hdfc.midterm.foodapp.entity.MenuItems;
import com.hdfc.midterm.foodapp.exception.ItemException;



public interface IMenuItemsService {
	public MenuItems addItem(MenuItems item) throws ItemException;

	public MenuItems updateItem(MenuItems item) throws ItemException;

	public MenuItems viewItem(Long menuItemId) throws ItemException;

	public MenuItems removeItem(Long menuItemId) throws ItemException;

	public List<MenuItems> viewAllItems() throws ItemException;

}
