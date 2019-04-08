<%@ page import="java.util.ArrayList"%>
<%@ page import="com.intimetec.restaurant.entity.MenuItem"%>
<%@ include file = "../header_jsp/header.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Delete Menu Item</title>
	</head>
	<body>
		<h2>Delete Menu Item</h2>
		<% 
			ArrayList<MenuItem> menuItemList;
			menuItemList = (ArrayList<MenuItem>) request.getAttribute("menuItemList");
		%>
		<form action="../p/MenuItemController" method = "get" >
			<input type = "hidden" name = "requestType" value = "delete">
			<table class = "table60">
				<tr>
		
					<th >ItemName</th>
					<th>Price</th>
					<th>Availability</th>
				</tr>
		
			<%	for (MenuItem menuItem : menuItemList) {%>
					<tr>
						<td><input type="checkbox" name="itemName" value ="<%= menuItem.getItemName()%>" /><%=menuItem.getItemName()%></td>
						<td><%=menuItem.getPrice()%></td>
					<% boolean avail = menuItem.isAvailable();

						if (avail) { %>
							<td><%="is available"%></td>
					<% } else { %>
							<td><%="is not available"%></td>
				<% } %>
					</tr>
			<% } %>
			<tr>
				<td><input type="submit" value="Delete"></td>
			</tr>
			</table>
			
	</form>
	</body>
</html>		
	
	
	
	
	