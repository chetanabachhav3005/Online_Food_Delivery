package com.hdfc.midterm.foodapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midterm.foodapp.entity.MenuItems;

import com.hdfc.midterm.foodapp.exception.ItemException;
import com.hdfc.midterm.foodapp.repository.MenuItemsRepository;

@Service
public class MenuItemsServiceImp implements IMenuItemsService {

	@Autowired
	MenuItemsRepository repo;

	@Override
	public MenuItems addItem(MenuItems item) throws ItemException {
		Optional<MenuItems> opt = repo.findById(item.getMenuItemId());
		
		if (opt.isPresent()) {
			throw new ItemException("Item already exists..");
		} else {
			return repo.save(item);
		}
	}

	@Override
	public MenuItems updateItem(MenuItems item) throws ItemException {
		Optional<MenuItems> opt = repo.findById(item.getMenuItemId());
		if (opt.isPresent()) {
			return repo.save(item);
		} else {
			throw new ItemException("No such Item found..");
		}
	}

	@Override
	public MenuItems viewItem(Long menuItemId) throws ItemException {
		Optional<MenuItems> opt = repo.findById(menuItemId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new ItemException("No Item found with ID: " + menuItemId);
		}
	}

	@Override
	public MenuItems removeItem(Long menuItemId) throws ItemException {
		Optional<MenuItems> opt = repo.findById(menuItemId);
		if (opt.isPresent()) {
			MenuItems item = opt.get();
			repo.delete(item);
			return item;
		} else {
			throw new ItemException("No Item found with ID: " + menuItemId);
		}
	}

	@Override
	public List<MenuItems> viewAllItems() throws ItemException {
		List<MenuItems> items = repo.findAll();
		if (items.size() > 0) {
			return items;
		} else {
			throw new ItemException("No Item exists..");
		}
	}

}
