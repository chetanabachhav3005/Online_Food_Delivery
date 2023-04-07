package com.hdfc.midterm.foodapp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hdfc.midterm.foodapp.entity.Menu_Items;
import com.hdfc.midterm.foodapp.exception.ItemException;
import com.hdfc.midterm.foodapp.repository.Menu_ItemsRepository;

@Service
public class Menu_ItemsServiceImp implements IMenu_ItemsService {

	@Autowired
	Menu_ItemsRepository repo;

	@Override
	public Menu_Items addItem(Menu_Items item) throws ItemException {
		Optional<Menu_Items> opt = repo.findById(item.getMenuItemId());
		if (opt.isPresent()) {
			throw new ItemException("Item already exists..");
		} else {
			return repo.save(item);
		}
	}

	@Override
	public Menu_Items updateItem(Menu_Items item) throws ItemException {
		Optional<Menu_Items> opt = repo.findById(item.getMenuItemId());
		if (opt.isPresent()) {
			return repo.save(item);
		} else {
			throw new ItemException("No such Item found..");
		}
	}

	@Override
	public Menu_Items viewItem(Long menuItemId) throws ItemException {
		Optional<Menu_Items> opt = repo.findById(menuItemId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new ItemException("No Item found with ID: " + menuItemId);
		}
	}

	@Override
	public Menu_Items removeItem(Long menuItemId) throws ItemException {
		Optional<Menu_Items> opt = repo.findById(menuItemId);
		if (opt.isPresent()) {
			Menu_Items item = opt.get();
			repo.delete(item);
			return item;
		} else {
			throw new ItemException("No Item found with ID: " + menuItemId);
		}
	}

	@Override
	public List<Menu_Items> viewAllItems() throws ItemException {
		List<Menu_Items> items = repo.findAll();
		if (items.size() > 0) {
			return items;
		} else {
			throw new ItemException("No Item exists..");
		}
	}

}
