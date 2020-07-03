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
	<div id="user-list">
		<form method="post" action="AdminUser">
			<div class="row">
				<div class="col-md-4 py-1">
					First name:<input class="form-control" type="text" name="fname" />
				</div>
				<div class="col-md-4 py-1">
					Last name:<input class="form-control" type="text" name="lname" />
				</div>
				<div class="col-md-4 py-1">
					Address:<input class="form-control" type="text" name="address" />
				</div>
				<div class="col-md-4 py-1">
					City:<input class="form-control" type="text" name="city" />
				</div>
				<div class="col-md-4 py-1">
					Phone:<input class="form-control" type="text" name="phone" />
				</div>
				<div class="col-md-4 py-1">
					Email:<input class="form-control" type="text" name="email" />
				</div>
				<div class="col-md-4 py-1">
					Username:<input class="form-control" type="text" name="username" />
				</div>
				<div class="col-md-12 py-1">
					<input class="btn btn-primary" type="submit" value="submit" />
				</div>
			</div>
		</form>
		<hr>
		<h4 class="my-2">Action</h4>
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
					<th>DELETED</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${users}" var="user">
					<c:if test="${!user.isDeleted()}">
						<tr>
							<td><a href="GoToAddEditUser?id=${user.getId()}">${user.getId()}</a></td>
							<td>${user.getFirstName()}</td>
							<td>${user.getLastName()}</td>
							<td>${user.getCity()}</td>
							<td>${user.getEmail()}</td>
							<td>${user.getPhone()}</td>
							<td>${user.getUserName()}</td>
							<td>${user.getRoleID()}</td>
							<c:choose>
								<c:when test="${user.isDeleted()}">
									<td class="text-danger text-uppercase">${user.isDeleted()}</td>
								</c:when>
								<c:otherwise>
									<td class="text-success text-uppercase">${user.isDeleted()}</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
</t:site>
</html>