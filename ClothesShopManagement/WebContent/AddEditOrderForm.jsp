<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Profile</title>
</head>
<t:site>
	<form method="post" action="AddEditOrderSubmit">
		<div class="row">
			<div class="col-md-4 py-1">
				${inputOrder.getId()}<input type="hidden" name="id"
					value="${inputOrder.getId()}" />
			</div>
			<div class="col-md-8"></div>		
			<div class="col-md-4 py-1">
				Number:<input type="text" name="number" value="${inputOrder.getNumber()}" />
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				Order Date:<input type="text" name="orderDate"
					value="${inputOrder.getOrderDate()}" />
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				Shipping Date:<input type="text" name="shippingDate"
					value="${inputOrder.getShippingDate()}" />
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				Tax:<input type="text" name="tax"
					value="${inputOrder.getTax()}" />
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				Status:<input type="text" name="status"
					value="${inputOrder.getStatus()}" />
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				Payment Date:<input type="text" name="paymentDate"
					value="${inputOrder.getPaymentDate()}" />
			</div>
			<div class="col-md-8"></div>
			<input type="submit" value="submit" />
		</div>
	</form>
</t:site>
</html>