package com.intimetec.restaurant.constants;

public class Constants {
	public static final String SELECT_MENU_ITEMS = "FROM MenuItem ORDER BY itemName";
	
	public static final String SELECT_USER_SERVICE_ID_WHERE_ROLL_ID = "FROM UserServiceId u where u.roleId = :roleId";
	
	public static final String SELECT_USERS = "FROM User ORDER BY fullName";

	public static final String SUCCESSFUL = "successfull";

	public static final String DELETE_MENU_ITEM_QUERY_COMPLETE_IN_CLAUSE = "DELETE FROM MenuItem WHERE ID IN(";
	
	public static final String SELECT_RESTAURANT_SERVICE_COMPLETE_IN_CLAUSE = "FROM RestaurantService WHERE serviceID IN(";
	
	public static final String DELETE_USER_QUERY_COMPLETE_IN_CLAUSE = "DELETE FROM User WHERE Username IN(";

	public static final String MENU_ITEM_ALREADY_PRESENT = "This Menu Item is already present";

	public static final String USERNAME_ALREADY_PRESENT = "This Username is already exist";
}
