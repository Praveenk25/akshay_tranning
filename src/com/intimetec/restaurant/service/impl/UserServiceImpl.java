package com.intimetec.restaurant.service.impl;

import java.util.ArrayList;

import com.intimetec.restaurant.constants.Constants;
import com.intimetec.restaurant.entity.RestaurantService;
import com.intimetec.restaurant.entity.User;
import com.intimetec.restaurant.entity.UserServiceId;
import com.intimetec.restaurant.persistent.RestaurantServicePersistent;
import com.intimetec.restaurant.persistent.UserPersistent;
import com.intimetec.restaurant.persistent.UserServiceIdPersistent;
import com.intimetec.restaurant.persistent.impl.RestaurantServicePersistentImpl;
import com.intimetec.restaurant.persistent.impl.UserPersistentImpl;
import com.intimetec.restaurant.persistent.impl.UserServiceIdPersistentImpl;
import com.intimetec.restaurant.service.UserService;
import com.intimetec.restaurant.util.RestaurantUtil;
import com.intimetec.restaurant.util.SecurePassword;

public class UserServiceImpl implements UserService {

	public ArrayList<User> getUserList() {
		UserPersistent userPersistent = UserPersistentImpl.getUserPersistent();

		ArrayList<User> userList = null;

		userList = userPersistent.getUserList();

		if (userList != null) {
			for (User user : userList) {
				user.setFullName(RestaurantUtil.capitalizeFirstLetter(user.getFullName()));
			}
			return userList;
		} else {
			return null;
		}
	}

	public String addUser(User user, String userRole) {
		int userRoleId = getUserRoleId(userRole);

		user.setRoleId(userRoleId);

		String encryptPassword = SecurePassword.encryptPassword(user.getPassword());

		user.setPassword(encryptPassword);

		UserPersistent userPersistent = UserPersistentImpl.getUserPersistent();

		ArrayList<User> userList = getUserList();

		if (userList != null) {
			if (!userList.contains(user)) {
				String result = userPersistent.saveUser(user);
				return result;
			} else {
				return Constants.USERNAME_ALREADY_PRESENT;
			}
		} else {
			return null;
		}

	}

	public String deleteUser(String[] listOfUsernameToBeDeleted) {
		ArrayList<User> listOfUserToBeDeleted = prepareUserList(listOfUsernameToBeDeleted);

		UserPersistent userPersistent = UserPersistentImpl.getUserPersistent();

		if (listOfUserToBeDeleted != null) {
			String result = userPersistent.deleteUser(listOfUserToBeDeleted);

			return result;
		} else {
			return null;
		}
	}

	private ArrayList<User> prepareUserList(String[] listOfUsernameToBeDeleted) {
		ArrayList<User> userList = getUserList();

		ArrayList<User> listOfUserToBeDeleted = new ArrayList<User>();

		if (userList != null) {

			for (String username : listOfUsernameToBeDeleted) {
				User user = new User();

				user.setUsername(username);

				int index = userList.indexOf(user);

				listOfUserToBeDeleted.add(userList.get(index));
			}
			return listOfUserToBeDeleted;

		} else {
			return null;
		}

	}

	private int getUserRoleId(String userRole) {
		if (userRole.equalsIgnoreCase("admin")) {
			return 1;
		} else {
			return 2;
		}
	}

	public ArrayList<RestaurantService> getUserServices(User user) {

		UserServiceIdPersistent userServiceIdPersistent = UserServiceIdPersistentImpl.getUserServiceIdPersistent();

		ArrayList<UserServiceId> userServiceID = userServiceIdPersistent.getUserServiceId(user);

		if (userServiceID != null) {

			RestaurantServicePersistent restaurantServicePersistent = RestaurantServicePersistentImpl
					.getRestaurantServicePersistent();

			ArrayList<RestaurantService> restaurantServiceForUser = restaurantServicePersistent
					.getUserService(userServiceID);

			if (restaurantServiceForUser != null) {
				return restaurantServiceForUser;
			} else {
				return null;
			}
		} else {
			return null;
		}

	}

}
