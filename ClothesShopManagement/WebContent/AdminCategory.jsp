<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Management</title>
</head>
<t:site>
	<a class="btn btn-primary" href="GoToAddEditCategory">Create</a>
	<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th>id</th>
				<th>Name</th>
				<th>Image</th>
				<th>Active</th>
				<th>Description</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${categories}" var="category">
				<c:if test="${category.isActive()}">
					<tr>
						<td><a href="GoToAddEditCategory?id=${category.getId()}">${category.getId()}</a></td>
						<td>${category.getName()}</td>
						<td><img src="${category.getImage()}" alt="${category.getImage()}"></td>
						<td>${category.isActive()}</td>
						<td>${category.getDescription()}</td>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
</t:site>
</html>