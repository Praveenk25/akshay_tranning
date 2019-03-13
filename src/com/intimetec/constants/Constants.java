package com.intimetec.constants;

public class Constants {
	public static final String DB_FILE = "db.properties";

	public static final String CONFIGURATION_LOCATION = "D:\\practice\\RestaurentApp1\\src\\configuration\\";

	public static final String SELECT_MENU_ITEMS = "SELECT itemName,price,availability FROM MenuItem";

	public static final String ADD_MENU_ITEM = "INSERT INTO MenuItem(ItemName,Price,Availability) VALUES(?,?,?)";

	public static final String DELETE_MENU_ITEM = "DELETE FROM MenuItem WHERE ItemName = (?)";

	public static final String UPDATE_MENU_ITEM = "UPDATE MenuItem SET Price=(?),Availability=(?) WHERE ItemName=(?)";

	public static final String ADD_ORDER = "INSERT INTO Orders(CustomerName,OrderDate,PaymentStatus,TotalAmount,MobileNo,Time) VALUES(?,?,?,?,?,?)";

	public static final String GET_ORDER_NO = "SELECT OrderNo FROM Orders WHERE CustomerName = (?) and MobileNo = (?) and Time = (?)";

	public static final String ADD_ORDER_ITEM = "INSERT INTO OrderItems(orderNo,OrderItem,price,Quantity) VALUES (?,?,?,?)";

	public static final String GET_ORDER = "SELECT * FROM Orders WHERE OrderNo = (?)";

	public static final String GET_ORDER_ITEM = "SELECT * FROM OrderItems WHERE OrderNo = (?)";
}
