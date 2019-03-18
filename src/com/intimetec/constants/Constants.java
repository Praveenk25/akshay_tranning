package com.intimetec.constants;

public class Constants {
	public static final String DB_FILE = "db.properties";

	public static final String DB_CONNECTION_ISSUE = "Connectivity issue";

	public static final String DELETE_ITEM = "enter item name you want to delete : ";
	
	public static final String APPLICATION_FEATURES = "1.View Menu List\n2.Add Menu Item\n3.Delete Menu Item\n4.Update Menu Item\n5.Create Order\n6.View Order\n7.Exit";

	public static final String WRONG_INPUT = "you give wrong input";
	
	public static final String SELECT_MENU_ITEM = "from MenuItem where itemName = :itemName";
	
	public static final String UPDATE_ITEM_NAME = "Enter Item name you want to update : ";
	
	public static final String ITEM_NAME = "Enter the item name";
	
	public static final String ASKING_ORDER = "\n Enter your order by serial no";
	
	public static final String ASKING_FOR_MORE_ORDER = "For add more press Y  &  to Submit order press any key ";
	
	public static final String ITEM_PRICE = "ENTER THE PRICE";
	
	public static final String ITEM_AVAILABILITY = "\nPress Y for available  &  N for not available: ";
	
	public static final String ITEM_ALREADY_PRESENT = "this item is already present";
	
	public static final String ITEM_NOT_PRESENT = "item not exist";
	
	public static final String ITEM_NOT_EXIST = "Item Is Not Exist";
	
	public static final String GET_ORDER = "from Order where orderNo = :orderNo";
	
	public static final String CONFIGURATION_LOCATION = "D:\\practice\\RestaurentApp1\\src\\configuration\\";

	public static final String SELECT_MENU_ITEMS = "FROM MenuItem ORDER BY itemName";

	public static final String ORDER_NOT_EXIST = "this order no is not exist";
	
	public static final String GET_ORDER_ITEM = "SELECT * FROM OrderItems WHERE OrderNo = (?)";
}
