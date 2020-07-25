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
		<form method="post" action="AdminOrder">
			<div class="row">
				<div class="col-md-4 py-1">
					Number:<input type="text" name="number" />
				</div>
				<div class="col-md-4 py-1">
					Status:<input type="text" name="status" />
				</div>
				<div class="col-md-4 py-1">
					Payment Id:<input type="text" name="paymentId" />
				</div>
				<div class="col-md-4 py-1">
					User Id:<input type="text" name="userId" />
				</div>
				<div class="col-md-12 py-1">
					<input class="btn btn-primary" type="submit" value="submit" />
				</div>
			</div>
		</form>
		<hr>
		<h4 class="my-2">Action</h4>
		<a class="btn-primary" href="GoToAddEditOrder">Create</a>
		<hr>
		<table  class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th>id</th>
                <th>Number</th>
                <th>Tax</th>
                <th>Status</th>
                <th>Shipping Date</th>
                <th>Order Date</th>
                <th>Payment Date</th>
                <th>User id</th>
                <th>Payment id</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${orders}" var="order">
				<tr>
					<td><a href="/AdminOrderDetail?id=${order.getId()}">${order.getId()}</a></td>
					<td>${order.getNumber()}</td>
                    <td>${order.getTax()}</td>
                    <td>${order.getStatus()}</td>
                    <td>${order.getShippingDate()}</td>
                    <td>${order.getOrderDate()}</td>
                    <td>${order.getPaymentDate()}</td>
                    <td>${order.getUserid()}</td>
                    <td>${order.getPaymentid()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</t:site>
</html>