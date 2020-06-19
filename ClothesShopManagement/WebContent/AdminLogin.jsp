<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<jsp:include page="Component/Header.jsp"></jsp:include>
	<div class="text-primary">
		<form method="post" action="AdminLoginChecking">
			Email: <input type="email" name="email" /><br> 
			Password: <input type="password" name="password" /><br> 
			<input type="submit" value="login" />
		</form>
	</div>
	<jsp:include page="Component/Footer.jsp"></jsp:include>
</body>
</html>