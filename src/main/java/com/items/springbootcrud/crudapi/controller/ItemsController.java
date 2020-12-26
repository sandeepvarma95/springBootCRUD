package com.items.springbootcrud.crudapi.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.items.springbootcrud.crudapi.model.Items;
import com.items.springbootcrud.crudapi.service.ItemsService;

@RestController
@RequestMapping("/api")
public class ItemsController {

	@Autowired
	private ItemsService itemsService;

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@GetMapping("/items")
	public List<Items> get() {
		return itemsService.get();
	}

	@PostMapping("/items")
	public Items save(@RequestBody Items itemsObj) {
		itemsService.save(itemsObj);
		return itemsObj;
	}

	@GetMapping("/items/{id}")
	public Items get(@PathVariable int id) {
		/*
		 * Items itemsObj = itemsService.get(id); if(itemsObj == null) { throw new
		 * RuntimeException("Employee with id: "+ id +" is not found or is deleted"); }
		 * else { return itemsObj; }
		 */
		Items itemsObj = itemsService.get(id);
		try {

			if (itemsObj == null) {
				throw new RuntimeException();
			}
		} catch (RuntimeException e) {
			LOGGER.info("The entered id: " + id + " is not present. The Exception is " + e);

		}
		return itemsObj;
	}

	@DeleteMapping("/items/{id}")
	public String delete(@PathVariable int id) {
		itemsService.delete(id);
		return "Item has been deleted with the id: " + id;
	}

	@PutMapping("/items")
	public Items update(@RequestBody Items itemsObj) {
		itemsService.save(itemsObj);
		return itemsObj;
	}
}
