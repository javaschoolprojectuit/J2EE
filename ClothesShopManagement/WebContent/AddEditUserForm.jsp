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
	<form method="post" action="AddEditUserSubmit">
		First name:<input type="text" name="fname" value="${inputUser.getFirstName()}"/><br>
		Last name:<input type="text" name="lname" value="${inputUser.getLastName()}"/><br>
		Address:<input type="text" name="address" value="${inputUser.getAddress()}"/><br>
		City:<input type="text" name="city" value="${inputUser.getCity()}"/><br>
		Phone:<input type="text" name="phone" value="${inputUser.getPhone()}"/><br>
		Email:<input type="text" name="email" value="${inputUser.getEmail()}"/><br>
		Username:<input type="text" name="username" value="${inputUser.getUserName()}"/><br>
		Password:<input id="password" type="password" name="password" value="${inputUser.getPassword()}"/><br>
		Confirm password: <input id="confirm-password" type="password"><br>
		<c:if test="${currentSession.getRoleID() == 1}" >
			Role:
			<Select name="role">
				<c:forEach items="${roles}" var="role">
					<option value="${role.getId()}">${role.getType()}</option>
				</c:forEach>	
			</Select>
		</c:if>
		<input type="submit" value="submit" /> 
	</form>
</t:site>
</html>