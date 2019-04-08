package com.intimetec.restaurant.persistent;

import java.util.ArrayList;

import com.intimetec.restaurant.entity.User;

public interface UserPersistent {
	ArrayList<User> getUserList();

	String saveUser(User user);

	String deleteUser(ArrayList<User> listOfUserToBeDeleted);

	User getUser(String username);
}
