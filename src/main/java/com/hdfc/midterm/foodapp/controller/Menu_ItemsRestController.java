package com.hdfc.midterm.foodapp.controller;

import java.util.List;
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
import com.hdfc.midterm.foodapp.entity.Menu_Items;
import com.hdfc.midterm.foodapp.exception.ItemException;
import com.hdfc.midterm.foodapp.service.IMenu_ItemsService;

@RestController
@RequestMapping
public class Menu_ItemsRestController {

	@Autowired
	IMenu_ItemsService service;
	
	
	@PostMapping("/add")
	public ResponseEntity<Menu_Items> addItem(@RequestBody Menu_Items item) throws ItemException{
		Menu_Items newItem = service.addItem(item);
		return new ResponseEntity<Menu_Items>(newItem, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Menu_Items> updateItem(@RequestBody Menu_Items item) throws ItemException{
		Menu_Items updatedItem = service.updateItem(item);
		return new ResponseEntity<Menu_Items>(updatedItem, HttpStatus.OK);
	}
	
	@GetMapping("/view/{itemId}")
	public ResponseEntity<Menu_Items> getItem(@PathVariable("itemId") Long itemId) throws ItemException{
		Menu_Items item = service.viewItem(itemId);
		return new ResponseEntity<Menu_Items>(item, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/remove/{itemId}")
	public ResponseEntity<Menu_Items> removeItem(@PathVariable("itemId") Long itemId) throws ItemException{
		Menu_Items removedItem = service.removeItem(itemId);
		return new ResponseEntity<Menu_Items>(removedItem, HttpStatus.ACCEPTED);
	}

	
	@GetMapping("/viewall")
	public ResponseEntity<List<Menu_Items>> getAllItems() throws ItemException{
		List<Menu_Items> items = service.viewAllItems();
		return new ResponseEntity<List<Menu_Items>>(items, HttpStatus.OK);
		
	}
	
}
