<%@ page import="java.util.ArrayList"%>
<%@ page import="com.intimetec.restaurant.entity.MenuItem"%>
<%@ include file = "../header_jsp/header.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Menu List</title>
	</head>
	<body>
		<h2>Menu List</h2>
		
		<table class = "table60">
		<tr>
			<th>ItemName</th>
			<th>Price</th>
			<th>Availability</th>
		</tr>

		<%
			ArrayList<MenuItem> menuItemList;
			menuItemList = (ArrayList<MenuItem>) request.getAttribute("menuItemList");

			for (MenuItem menuItem : menuItemList) {
		%>
		<tr>
			<td><%= menuItem.getItemName()%></td>
			<td><%=menuItem.getPrice()%></td>
			<%
				boolean avail = menuItem.isAvailable();

				if (avail) {
			%>
					<td><%="Available"%></td>
					<%
				} else {
				%>
					<td><%="Not Available"%></td>
			<%
			}
		%>
		</tr>
		<%
		}
	%>
	</table>
	
</body>
</html>