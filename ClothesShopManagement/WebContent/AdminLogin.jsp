<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="client/css/login.css">
</head>
<body>
	<jsp:include page="Component/Header.jsp"></jsp:include>
	<div class="text-primary container-fluid" id="login">
		<div class="row">
			<div class="col-md-6" id="brand">
				<div class="d-flex flex-column justify-content-center align-items-center">
					<h1 class="text-capitalize">
						<b>clothes shop management</b>
					</h1>
					<p class="mt-2 text-white">A better way to manage your store.</p>
				</div>
			</div>
			<div class="col-md-6 d-flex flex-column justify-content-center align-items-center">
				<form method="post" action="AdminLoginChecking">
					<div class="row">
						<div class="col-md-12">
							<input class="form-control" type="email" name="email" placeholder="Email" required/>
						</div>
						<div class="col-md-12 my-2">
							<input class="form-control" type="password" name="password" placeholder="Password" required/>
							<hr class="mt-4">
						</div>
						
						<div class="col-md-12 mx-auto pt-2">
							<input class="btn form-control btn-primary" type="submit" value="login" />
						</div>
					</div>
				</form>
				<p class="mt-3">Contact us via <a href="#"><b>here</b></a>.</p>
			</div>
		</div>
	</div>
	<jsp:include page="Component/Footer.jsp"></jsp:include>
</body>
</html>