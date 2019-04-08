package com.intimetec.restaurant.service;

import java.util.ArrayList;

import com.intimetec.restaurant.entity.RestaurantService;
import com.intimetec.restaurant.entity.User;

public interface UserService {
	
	ArrayList<RestaurantService> getUserServices(User user);

	String addUser(User user, String userRole);

	ArrayList<User> getUserList();

	String deleteUser(String[] listOfUsernameToBeDeleted);
}
