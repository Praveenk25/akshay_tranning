<%@ page import="java.util.ArrayList"%>
<%@ page import="com.intimetec.restaurant.entity.User"%>
<%@ include file = "../header_jsp/header.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<title>User List</title>
	</head>
	<body>
		<h2>User List</h2>
		
		<table class = "table60">
		<tr>
			<th>Full Name</th>
			<th>Username</th>
			<th>Role</th>
			<th>Mobile Number</th>
		</tr>
		
		<%
			ArrayList<User> userList;
			userList = (ArrayList<User>) request.getAttribute("userList");
			
			for(User user : userList){
		%>
		<tr>
			<td><%= user.getFullName() %>
			<td><%= user.getUsername() %>
			<%
				int roleId = user.getRoleId();
				if(roleId == 1){
			%>
					<td><%= "admin" %></td>
				<%
				} else {
				%>
					<td><%= "staff" %></td>
				<%
				}
			%>
			<td><%= user.getMobileNumber() %></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>		
			
			
		
		
		
		
		
		
		
		
		
