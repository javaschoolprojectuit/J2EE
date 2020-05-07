<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List, javax.clothes.model.Category"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<p>Redirected to HomePage</p>
	<%
		List<Category> categories = (List<Category>) request.getAttribute("categories");

		for (Category category : categories) {
			out.println(category.getId());
			out.println(category.getName());
		}
	%>
</body>
</html>