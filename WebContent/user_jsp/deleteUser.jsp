<%@ page import="java.util.ArrayList"%>
<%@ page import="com.intimetec.restaurant.entity.User"%>
<%@ include file = "../header_jsp/header.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Delete User</title>
	</head>
	<body>
		<h2>Delete User</h2>
		<%
			ArrayList<User> userList;
			userList = (ArrayList<User>) request.getAttribute("userList");
		%>
		<form action="../p/UserController" method = "get" >
			<input type = "hidden" name = "requestType" value = "delete">
			<table class = "table60">
				<tr>
		
					<th >Username</th>
					<th>Full Name</th>
					<th>Role</th>
					<th>Mobile Number</th>
				</tr>
				<% for(User user : userList) { %>
					<tr>
						<td><input type="checkbox" name = "username" value = "<%= user.getUsername() %>" /><%= user.getUsername() %></td>
						<td><%= user.getFullName() %>	
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
		<tr>
				<td><input type="submit" value="Delete"></td>
			</tr>
	</table>

</form>
</body>
</html>
			
			
			
			
			
			
