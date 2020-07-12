<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Supplier Profile</title>
</head>
<t:site>
	<form method="post" action="AddEditSupplierSubmit">
		<div class="row">
			<div class="col-md-4 py-1">
				${inputSupplier.getId()}<input type="hidden" name="id"
					value="${inputSupplier.getId()}" />
			</div>
			<div class="col-md-8"></div>		
			<div class="col-md-4 py-1">
				Name:<input type="text" name="name" value="${inputSupplier.getName()}" />
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				City:<input type="text" name="city"
					value="${inputSupplier.getCity()}" />
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				District:<input type="text" name="district"
					value="${inputSupplier.getDistrict()}" />
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				Address:<input type="text" name="address"
					value="${inputSupplier.getAddress()}" />
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				Email:<input type="text" name="email"
					value="${inputSupplier.getEmail()}" />
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				Phone:<input type="text" name="phone"
					value="${inputSupplier.getPhone()}" />
			</div>
			<div class="col-md-8"></div>
			<input type="submit" value="submit" />
		</div>
	</form>
</t:site>
</html>