package com.items.springbootcrud.crudapi.dao;

import java.util.List;

import com.items.springbootcrud.crudapi.model.Items;

public interface ItemsDAO {

	List<Items> get();
	
	Items get(int id);
	
	void save(Items item);
	
	void delete(int id);
}
