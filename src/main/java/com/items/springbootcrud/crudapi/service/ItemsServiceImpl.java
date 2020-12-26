package com.items.springbootcrud.crudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.items.springbootcrud.crudapi.dao.ItemsDAO;
import com.items.springbootcrud.crudapi.model.Items;

@Service
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsDAO itemsDAO;
	
	@Transactional
	@Override
	public List<Items> get() {
		return itemsDAO.get();
	}

	@Transactional
	@Override
	public Items get(int id) {
		return itemsDAO.get(id);
	}

	@Transactional
	@Override
	public void save(Items item) {
		itemsDAO.save(item);
	}

	@Transactional
	@Override
	public void delete(int id) {
		itemsDAO.delete(id);
	}

}
