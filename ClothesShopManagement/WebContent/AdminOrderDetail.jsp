<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Management</title>
</head>
<t:site>
	<div id="order-list">
		<form method="post" action="AdminOrderDetail">
			<div class="row">
				<div class="col-md-4 py-1">
					ID:<input type="text" name="id" />
				</div>
				<div class="col-md-12 py-1">
					<input class="btn btn-primary" type="submit" value="submit" />
				</div>
			</div>
		</form>
		<hr>
		<h4 class="my-2">Action</h4>
		<hr>
		<table  class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th>id</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Discount</th>
				<th>Order ID</th>
				<th>Product ID</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${OrderDetails}" var="OrderDetail">
				<tr>
					<td>${OrderDetails.getId()}</td>
					<td>${OrderDetails.getPrice()}</td>
					<td>${OrderDetails.getQuantity()}</td>
					<td>${OrderDetails.getDiscount()}</td>
					<td>${OrderDetails.getOrderId()}</td>
					<td>${OrderDetails.getProductId()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</t:site>
<t:site>
	
</t:site>
</html>