package com.items.springbootcrud.crudapi.service;

import java.util.List;

import com.items.springbootcrud.crudapi.model.Items;

public interface ItemsService {

	List<Items> get();
	
	Items get(int id);
	
	void save(Items item);
	
	void delete(int id);
}
