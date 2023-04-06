package com.hdfc.midterm.foodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midterm.foodapp.repository.Menu_ItemsRepository;

@Service
public class Menu_ItemsServiceImp implements IMenu_ItemsService{
//
	@Autowired
	Menu_ItemsRepository repo;
}
