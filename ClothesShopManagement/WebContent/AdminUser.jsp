<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users Management</title>
</head>
<t:site>
	<form method = "post" action="AdminUser">
		First name:<input type="text" name="fname" /><br>
		Last name:<input type="text" name="lname" /><br>
		Address:<input type="text" name="address" /><br>
		City:<input type="text" name="city" /><br>
		Phone:<input type="text" name="phone" /><br>
		Email:<input type="text" name="email" /><br>
		Username:<input type="text" name="username" /><br>
		<input class="btn-primary" type="submit" value="submit" />  
	</form>
	<a class="btn-primary" href="GoToAddEditUser">Create</a>
	<table  class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th>id</th>
				<th>First Name </th>
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
					<td><a href="/GoToAddEditUser?id=${user.getId()}">${user.getId()}</a></td>
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