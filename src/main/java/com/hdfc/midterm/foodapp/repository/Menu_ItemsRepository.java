package com.hdfc.midterm.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.midterm.foodapp.entity.Menu_Items;

@Repository
public interface Menu_ItemsRepository extends JpaRepository<Menu_Items, Long> {

	
}
