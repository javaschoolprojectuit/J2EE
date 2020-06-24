<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users Management</title>
</head>
<t:site>
	<form method="post" action="AdminUser">
		<div class="row">
			<div class="col-md-4">
				First name:<input type="text" name="fname" />
			</div>
			<div class="col-md-4">
				Last name:<input type="text" name="lname" />
			</div>
			<div class="col-md-4">
				Address:<input type="text" name="address" />
			</div>
			<div class="col-md-4">
				City:<input type="text" name="city" />
			</div>
			<div class="col-md-4">
				Phone:<input type="text" name="phone" />
			</div>
			<div class="col-md-4">
				Email:<input type="text" name="email" />
			</div>
			<div class="col-md-4">
				Username:<input type="text" name="username" />
			</div>
			<input class="btn btn-primary" type="submit" value="submit" />
		</div>
	</form>
	<a class="btn btn-primary" href="GoToAddEditUser">Create</a>
	<hr>
	<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th>id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>City</th>
				<th>Email</th>
				<th>Phone</th>
				<th>UserName</th>
				<th>Role</th>
				<th>Status</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td><a href="GoToAddEditUser?id=${user.getId()}">${user.getId()}</a></td>
					<td>${user.getFirstName()}</td>
					<td>${user.getLastName()}</td>
					<td>${user.getCity()}</td>
					<td>${user.getEmail()}</td>
					<td>${user.getPhone()}</td>
					<td>${user.getUserName()}</td>
					<td>${user.getRoleID()}</td>
					<td>${user.isDeleted()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</t:site>
</html>