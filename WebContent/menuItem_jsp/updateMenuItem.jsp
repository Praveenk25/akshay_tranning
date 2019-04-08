<%@ page import="java.util.ArrayList"%>
<%@ page import="com.intimetec.restaurant.entity.MenuItem"%>
<%@ include file = "../header_jsp/header.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Update Menu Item</title>
	</head>
	<body>
		<h2>Update Menu Item</h2>
		<% 
			ArrayList<MenuItem> menuItemList;
			menuItemList = (ArrayList<MenuItem>) request.getAttribute("menuItemList");
		%>
		<form action="../p/MenuItemController" method = "get" >
			<input type = "hidden" name = "requestType" value = "update">
			<table>	
				<tr>
					<td> Item Name</td>
					<td><select name="itemName">
							<%	for (MenuItem menuItem : menuItemList) {%>
		 							<option value="<%= menuItem.getItemName() %>"><%= menuItem.getItemName() %></option>
    						<% } %>
    					</select></td>
    			</tr>
    			<tr>
					<td> Price</td>
					<td><input type="number" step = "0.01"  min="1" max="50000" name = "price" placeholder="Price" required></td>
				</tr>
				<tr>
					<td> Availability </td> 
					<td><select name="available">
		 					<option value="yes">Yes</option>
    						<option value="No">No</option>
    					</select></td>
				</tr>
				<tr>
					<td> <input type = "submit" value="Update Item"> </td>
				</tr>
		 	</table>
	    </form>
		
	</body>
</html>		
		
		