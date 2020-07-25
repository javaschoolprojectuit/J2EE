<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Supplier Management</title>
</head>
<t:site>
	<div id="supplier-list">
		<form method="post" action="AdminSupplier">
			<div class="row">
				<div class="col-md-4 py-1">
					Name:<input type="text" name="name" />
				</div>
				<div class="col-md-4 py-1">
					City:<input type="text" name="City" />
				</div>
				<div class="col-md-4 py-1">
					District:<input type="text" name="district" />
				</div>
				<div class="col-md-4 py-1">
					Address:<input type="text" name="address" />
				</div>
				<div class="col-md-4 py-1">
					Email:<input type="text" name="email" />
				</div>
				<div class="col-md-4 py-1">
					Phone:<input type="text" name="phone" />
				</div>
				<div class="col-md-12 py-1">
					<input class="btn btn-primary" type="submit" value="submit" />
				</div>
			</div>
		</form>
		<hr>
		<h4 class="my-2">Action</h4>
		<a class="btn-primary" href="GoToAddEditSupplier">Create</a>
		<hr>
		<table  class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th>id</th>
				<th>Name</th>
				<th>City</th>
				<th>District</th>
				<th>Address</th>
				<th>Email</th>
				<th>Phone</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${suppliers}" var="supplier">
				<tr>
					<td><a href="/GoToAddEditSupplier?id=${supplier.getId()}">${supplier.getId()}</a></td>
					<td>${supplier.getName()}</td>
					<td>${supplier.getCity()}</td>
					<td>${supplier.getDistrict()}</td>
					<td>${supplier.getAddress()}</td>
					<td>${supplier.getEmail()}</td>
					<td>${supplier.getPhone()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</t:site>
</html>