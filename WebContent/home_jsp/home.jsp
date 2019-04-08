<%@ page import="java.util.ArrayList"%>
<%@ page import="com.intimetec.restaurant.entity.RestaurantService"%>
<%@ include file = "../header_jsp/header.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<h2>Home</h2>
		
		<% ArrayList<RestaurantService> restaurantServiceForUser;
			restaurantServiceForUser= (ArrayList<RestaurantService>)request.getAttribute("restaurantServiceForUser"); 
			
			if(restaurantServiceForUser != null){
		%>
		
		<ol>
			<%	
				for(RestaurantService restaurantService : restaurantServiceForUser){
			%>
		
					<li><a href ="<%= restaurantService.getServiceLink() %>"><%= restaurantService.getServiceName() %></a></li>			
		
				<% } }%>
		</ol>
	</body>
</html>
		
		
		
		
		
		
		
		
		
		
		
		
		