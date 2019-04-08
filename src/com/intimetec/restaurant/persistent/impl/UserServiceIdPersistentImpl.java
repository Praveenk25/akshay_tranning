package com.intimetec.restaurant.persistent.impl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.intimetec.restaurant.connection.DbConnection;
import com.intimetec.restaurant.constants.Constants;
import com.intimetec.restaurant.entity.User;
import com.intimetec.restaurant.entity.UserServiceId;
import com.intimetec.restaurant.persistent.UserServiceIdPersistent;

public class UserServiceIdPersistentImpl implements UserServiceIdPersistent {
	private static UserServiceIdPersistent userServiceIdPersistent = new UserServiceIdPersistentImpl();

	private UserServiceIdPersistentImpl() {

	}

	public static UserServiceIdPersistent getUserServiceIdPersistent() {

		return userServiceIdPersistent;
	}

	public ArrayList<UserServiceId> getUserServiceId(User user) {
		ArrayList<UserServiceId> userServiceId = null;

		Session session = DbConnection.getSession();

		if (session != null) {
			try {
				Query query = session.createQuery(Constants.SELECT_USER_SERVICE_ID_WHERE_ROLL_ID);

				query.setParameter("roleId", user.getRoleId());

				userServiceId = (ArrayList<UserServiceId>) query.list();

				session.close();
				return userServiceId;
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

}
