/*
Author:Chetana Bachhav
Date:
Description:Items Rest Controller
*/
package com.hdfc.midterm.foodapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.midterm.foodapp.dto.MenuItemsDto;
import com.hdfc.midterm.foodapp.entity.MenuItems;
import com.hdfc.midterm.foodapp.exception.ItemException;
import com.hdfc.midterm.foodapp.exception.RestaurantException;
import com.hdfc.midterm.foodapp.service.IMenuItemsService;

@RestController
@RequestMapping("/item")
public class MenuItemsRestController {

	@Autowired
	IMenuItemsService service;

	@PostMapping("/add/item")
	public ResponseEntity<MenuItems> addItem(@Valid @RequestBody MenuItemsDto item)
			throws ItemException, RestaurantException {
		MenuItems newItem = service.addItem(item);
		return new ResponseEntity<MenuItems>(newItem, HttpStatus.CREATED);
	}

	@PutMapping("/update/item")
	public ResponseEntity<MenuItems> updateItem(@Valid @RequestBody MenuItems item) throws ItemException {
		MenuItems updatedItem = service.updateItem(item);
		return new ResponseEntity<MenuItems>(updatedItem, HttpStatus.OK);
	}

	@GetMapping("/view/item/{itemId}")
	public ResponseEntity<MenuItems> getItem(@PathVariable("itemId") Long itemId) throws ItemException {
		MenuItems item = service.viewItem(itemId);
		return new ResponseEntity<MenuItems>(item, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/remove/item/{itemId}")
	public ResponseEntity<MenuItems> removeItem(@PathVariable("itemId") Long itemId) throws ItemException {
		MenuItems removedItem = service.removeItem(itemId);
		return new ResponseEntity<MenuItems>(removedItem, HttpStatus.ACCEPTED);
	}

	@GetMapping("/viewall/item")
	public ResponseEntity<List<MenuItems>> getAllItems() throws ItemException {
		List<MenuItems> items = service.viewAllItems();
		return new ResponseEntity<List<MenuItems>>(items, HttpStatus.OK);

	}

}
