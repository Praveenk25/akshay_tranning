package com.intimetec.restaurant.persistent.impl;

import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.intimetec.restaurant.connection.DbConnection;
import com.intimetec.restaurant.constants.Constants;
import com.intimetec.restaurant.entity.RestaurantService;
import com.intimetec.restaurant.entity.UserServiceId;
import com.intimetec.restaurant.persistent.RestaurantServicePersistent;
import com.intimetec.restaurant.service.UserService;

public class RestaurantServicePersistentImpl implements RestaurantServicePersistent {
	private static RestaurantServicePersistent restaurantServicePersistent = new RestaurantServicePersistentImpl();

	private RestaurantServicePersistentImpl() {

	}

	public static RestaurantServicePersistent getRestaurantServicePersistent() {
		return restaurantServicePersistent;
	}

	public ArrayList<RestaurantService> getUserService(ArrayList<UserServiceId> userServiceID) {
		Session session = DbConnection.getSession();

		ArrayList<RestaurantService> userServices = null;

		if (session != null) {
			try {
				String hqlQuery = prepareDeleteQuery(userServiceID);

				Transaction transaction = session.beginTransaction();

				Query query = session.createQuery(hqlQuery);

				userServices = (ArrayList<RestaurantService>) query.getResultList();

				transaction.commit();

				session.close();

				return userServices;
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

	private String prepareDeleteQuery(ArrayList<UserServiceId> userServiceID) {
		String selectQuery = Constants.SELECT_RESTAURANT_SERVICE_COMPLETE_IN_CLAUSE;

		for (int i = 0; i < userServiceID.size() - 1; i++) {
			selectQuery += (userServiceID.get(i).getServiceId());
			selectQuery += ",";
		}

		selectQuery += userServiceID.get(userServiceID.size() - 1).getServiceId();
		selectQuery += ")";

		return selectQuery;
	}
}
