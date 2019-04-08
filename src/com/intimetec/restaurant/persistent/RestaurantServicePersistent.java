package com.intimetec.restaurant.persistent;

import java.util.ArrayList;

import com.intimetec.restaurant.entity.RestaurantService;
import com.intimetec.restaurant.entity.UserServiceId;
import com.intimetec.restaurant.service.UserService;

public interface RestaurantServicePersistent {

	ArrayList<RestaurantService> getUserService(ArrayList<UserServiceId> userServiceID);

}
