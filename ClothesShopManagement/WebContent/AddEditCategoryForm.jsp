<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
</head>
<t:site>
	<form method="post" action="AddEditCategorySubmit">
		<div class="row">
			<div class="col-md-4 py-1">
				Name:<input type="text" name="name" value="${inputCat.getName()}" />
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				Description:<input type="text" name="address"
					value="${inputCat.getDescription()}" />
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				<Select name="active">
					<option value="true">true</option>
					<option value="false">false</option>
				</Select>
			</div>
			<div class="col-md-8"></div>
			<input type="submit" value="submit" />
		</div>
	</form>
</t:site>
</html>