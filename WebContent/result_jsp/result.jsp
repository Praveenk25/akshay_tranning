<%@ include file = "../header_jsp/header.jsp"%>
<!DOCTYPE html>
<html>
	<head>
 		<title>Error</title>
	</head>	
	<body>
		<% String result = (String)request.getAttribute("result"); %>
		
		<h1><%= result%></h1>
	</body>
</html>