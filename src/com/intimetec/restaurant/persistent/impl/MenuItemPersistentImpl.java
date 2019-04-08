package com.intimetec.restaurant.persistent.impl;

import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.intimetec.restaurant.connection.DbConnection;
import com.intimetec.restaurant.constants.Constants;
import com.intimetec.restaurant.entity.MenuItem;
import com.intimetec.restaurant.persistent.MenuItemPersistent;

public class MenuItemPersistentImpl implements MenuItemPersistent {
	private static MenuItemPersistent menuItemPersistent = new MenuItemPersistentImpl();

	private MenuItemPersistentImpl() {

	}

	public static MenuItemPersistent getMenuItemPersistent() {

		return menuItemPersistent;
	}

	public ArrayList<MenuItem> getMenuItemList() {
		ArrayList<MenuItem> menuItemlist = null;

		Session session = DbConnection.getSession();

		if (session != null) {
			try {
				Query query = session.createQuery(Constants.SELECT_MENU_ITEMS);
				menuItemlist = (ArrayList<MenuItem>) query.getResultList();

				session.close();
				return menuItemlist;
			} catch (Exception e) {
				session.close();
				System.err.println(e.getMessage());
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}

	}

	public String saveOrUpdateMenuItem(MenuItem menuItem) {
		Session session = DbConnection.getSession();

		if (session != null) {
			try {
				Transaction transaction = session.beginTransaction();

				session.saveOrUpdate(menuItem);

				transaction.commit();

				session.close();

				return Constants.SUCCESSFUL;
			} catch (Exception e) {
				session.close();
				System.err.println(e.getMessage());
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}

	}

	public String deleteMenuItem(ArrayList<MenuItem> listOfMenuItemToBeDeleted) {
		Session session = DbConnection.getSession();

		if (session != null) {
			try {
				String hqlQuery = prepareDeleteQuery(listOfMenuItemToBeDeleted);

				Transaction transaction = session.beginTransaction();

				Query query = session.createQuery(hqlQuery);

				query.executeUpdate();

				transaction.commit();

				session.close();

				return Constants.SUCCESSFUL;
			} catch (Exception e) {
				session.close();
				System.err.println(e.getMessage());
				e.printStackTrace();
				return null;
			}

		} else {
			return null;
		}
	}

	private String prepareDeleteQuery(ArrayList<MenuItem> listOfMenuItemToBeDeleted) {
		String deleteQuery = Constants.DELETE_MENU_ITEM_QUERY_COMPLETE_IN_CLAUSE;

		for (int i = 0; i < listOfMenuItemToBeDeleted.size() - 1; i++) {
			deleteQuery += (listOfMenuItemToBeDeleted.get(i)).getId();
			deleteQuery += ",";
		}

		deleteQuery += listOfMenuItemToBeDeleted.get(listOfMenuItemToBeDeleted.size() - 1).getId();
		deleteQuery += ")";

		return deleteQuery;
	}
}