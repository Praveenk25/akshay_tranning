package com.intimetec.restaurant.request.login;

import com.intimetec.restaurant.entity.User;
import com.intimetec.restaurant.persistent.UserPersistent;
import com.intimetec.restaurant.persistent.impl.UserPersistentImpl;
import com.intimetec.restaurant.util.SecurePassword;

public class Authenticator {

	public User userAuthenticator(User logInUser) {
		UserPersistent userPersistent = UserPersistentImpl.getUserPersistent();

		User user = userPersistent.getUser(logInUser.getUsername());

		if (user != null) {
			String encryptedPassword = user.getPassword();

			String originalPassword = SecurePassword.decryptPassword(encryptedPassword);

			user.setPassword(originalPassword);

			if (user.getPassword().equalsIgnoreCase(logInUser.getPassword())) {
				return user;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

}
