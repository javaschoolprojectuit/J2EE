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
	<div class="text-primary" id="login">
		<form method="post" action="AdminLoginChecking">
			<div class="row">
				<div class="col-md-4">
					<span>Email:</span> <input type="email" name="email" />
				</div>
				<div class="col-md-8"></div>
				<div class="col-md-4 my-2">
					<span>Password:</span> <input type="password" name="password" />
				</div>
				<div class="col-md-8"></div>
				<div class="col-md-12 pt-2">
					<input class="btn btn-primary" type="submit" value="login" />
				</div>
			</div>

		</form>
	</div>
	<jsp:include page="Component/Footer.jsp"></jsp:include>
</body>
</html>