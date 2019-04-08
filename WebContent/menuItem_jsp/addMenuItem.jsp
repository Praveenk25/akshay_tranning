<%@ include file = "../header_jsp/header.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Add Menu Item</title>
	</head>
	<body>
		<h2>Add Menu Item</h2>
		<form action="../p/MenuItemController" method = "get" >
			<input type = "hidden" name = "requestType" value = "add">
			<table>
				<tr>
					<td> Item Name</td>
					<td><input type="text" maxlength = "30" name = "itemName" placeholder="Item Name" required></td>
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
					<td> <input type = "submit" value="Add Item"> </td>
				</tr>
			</table>
		</form>
				
	</body>
</html>