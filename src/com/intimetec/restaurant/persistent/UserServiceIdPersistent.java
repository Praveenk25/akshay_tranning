package com.intimetec.restaurant.persistent;

import java.util.ArrayList;

import com.intimetec.restaurant.entity.User;
import com.intimetec.restaurant.entity.UserServiceId;

public interface UserServiceIdPersistent {

	ArrayList<UserServiceId> getUserServiceId(User user);

}
