<%@ include file = "../header_jsp/header.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Add User</title>
	</head>
	<body>
		<h2>Add User</h2>
		<form action="../p/UserController" method = "post" >
			<input type = "hidden" name = "requestType" value = "add">
			<table>
				<tr>
					<td>Full Name</td>
					<td><input type="text" maxlength = "30" name = "fullName" placeholder="Full Name" required></td>
				</tr>
				<tr>
					<td>Username</td>
					<td><input type="text" maxlength = "16" name = "username" placeholder="Username" required></td>	
				</tr>
				<tr>
					<td>Mobile Number</td>
					<td><input type="number" min="1000000000" max="9999999999" name = "mobileNumber" placeholder="Mobile Number" required ></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" minlength = "8" maxlength = "16" name = "password" placeholder="Password" required></td>
				</tr>
				<tr>
					<td>User Role</td>
					<td><select name="userRole">
			 				<option value="staff">Staff</option>
    						<option value="admin">Admin</option>
    						</select></td>
    			</tr>
    			<tr>
    				<td><input type = "submit" value="Add User"></td>
    			</tr>				
			</table>
		</form>
	
	</body>
</html>			
					
					
					
					
					
					
					
					
					
