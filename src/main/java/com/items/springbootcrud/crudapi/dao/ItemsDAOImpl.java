package com.items.springbootcrud.crudapi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.items.springbootcrud.crudapi.model.Items;

@Repository
public class ItemsDAOImpl implements ItemsDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Items> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Items> query = currentSession.createQuery("from Items", Items.class);
		List<Items> list = query.getResultList();
		return list;
	}

	@Override
	public Items get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Items itemsObj = currentSession.get(Items.class, id);
		return itemsObj;
	}

	@Override
	public void save(Items item) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(item);
	}

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Items itemsObj = currentSession.get(Items.class, id);
		currentSession.delete(itemsObj);
	}

}
