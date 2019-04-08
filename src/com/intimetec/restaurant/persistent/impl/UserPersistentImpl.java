package com.intimetec.restaurant.persistent.impl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.intimetec.restaurant.connection.DbConnection;
import com.intimetec.restaurant.constants.Constants;
import com.intimetec.restaurant.entity.User;
import com.intimetec.restaurant.persistent.UserPersistent;

public class UserPersistentImpl implements UserPersistent {
	private static UserPersistent userPersistent = new UserPersistentImpl();

	private UserPersistentImpl() {

	}

	public static UserPersistent getUserPersistent() {

		return userPersistent;
	}

	public ArrayList<User> getUserList() {
		ArrayList<User> userList = null;

		Session session = DbConnection.getSession();

		if (session != null) {
			try {
				Query query = session.createQuery(Constants.SELECT_USERS);
				userList = (ArrayList<User>) query.list();

				session.close();
				return userList;
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

	public String saveUser(User user) {
		Session session = DbConnection.getSession();

		if (session != null) {
			try {
				Transaction transaction = session.beginTransaction();

				session.save(user);

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

	public String deleteUser(ArrayList<User> listOfUserToBeDeleted) {
		Session session = DbConnection.getSession();

		if (session != null) {
			try {
				String hqlQuery = prepareDeleteQuery(listOfUserToBeDeleted);

				Transaction transaction = session.beginTransaction();

				Query query = session.createQuery(hqlQuery);

				query.executeUpdate();

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

	private String prepareDeleteQuery(ArrayList<User> listOfUserToBeDeleted) {
		String deleteQuery = Constants.DELETE_USER_QUERY_COMPLETE_IN_CLAUSE;

		for (int i = 0; i < listOfUserToBeDeleted.size() - 1; i++) {
			deleteQuery += "'" + listOfUserToBeDeleted.get(i).getUsername() + "'";
			deleteQuery += ",";
		}
		deleteQuery += "'" + listOfUserToBeDeleted.get(listOfUserToBeDeleted.size() - 1).getUsername() + "'";
		deleteQuery += ")";

		return deleteQuery;
	}

	public User getUser(String username) {//
		Session session = DbConnection.getSession();

		if (session != null) {
			User user = session.get(User.class, username);
			session.close();
			return user;
		} else {
			return null;
		}

	}

}
