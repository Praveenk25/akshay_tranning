package com.intimetec.model;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.intimetec.constants.Constants;
import com.intimetec.entity.MenuItem;

public class MenuPersistentImpl implements MenuPersistent {
	CreateSessionFactory createSessionFactory = new CreateSessionFactory();

	public ArrayList<MenuItem> getMenuList() {
		ArrayList<MenuItem> menuList = new ArrayList<MenuItem>();

		Session session = createSessionFactory.getSession();

		menuList = (ArrayList<MenuItem>) session.createQuery(Constants.SELECT_MENU_ITEMS).list();

		session.close();

		return menuList;

	}

	public void addMenuItem(MenuItem menuItem) {
		Session session = createSessionFactory.getSession();

		Transaction transaction = session.beginTransaction();

		session.save(menuItem);

		transaction.commit();

		session.close();

	}

	public void deleteMenuItem(MenuItem menuItem) {
		Session session = createSessionFactory.getSession();

		Transaction transaction = session.beginTransaction();

		session.delete(menuItem);

		transaction.commit();
		session.close();

	}

	public void updateItem(MenuItem menuItem) {
		Session session = createSessionFactory.getSession();

		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(menuItem);

		transaction.commit();

		session.close();

	}

}
