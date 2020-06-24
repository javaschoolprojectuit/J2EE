<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
</head>
<t:site>
	<form method="post" action="AddEditCategorySubmit">
		Name:<input type="text" name="name" value="${inputCat.getName()}"/><br>
		Description:<input type="text" name="address" value="${inputUser.getDescription()}"/><br>
		<Select name="active">
			<option value="true">true</option>
			<option value="false">false</option>
		</Select>
		<input type="submit" value="submit" /> 
	</form>
</t:site>
</html>