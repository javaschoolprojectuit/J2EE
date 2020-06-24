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
	<div id="edit-user">
		<form method="post" action="AddEditUserSubmit">
			<div class="row">
				<div class="col-md-4 py-1">
					First name:<input type="text" name="fname"
						value="${inputUser.getFirstName()}" width="30" required />
				</div>
				<div class="col-md-8"></div>
				<div class="col-md-4 py-1">
					Last name:<input type="text" name="lname"
						value="${inputUser.getLastName()}" width="30" required />
				</div>
				<div class="col-md-8"></div>
				<div class="col-md-4 py-1">
					Address:<input type="text" name="address"
						value="${inputUser.getAddress()}" width="30" required />
				</div>
				<div class="col-md-8"></div>
				<div class="col-md-4 py-1">
					City:<input type="text" name="city" value="${inputUser.getCity()}"
						width="30" required />
				</div>
				<div class="col-md-8"></div>
				<div class="col-md-4 py-1">
					Phone:<input type="text" name="phone"
						value="${inputUser.getPhone()}" width="30" required />
				</div>
				<div class="col-md-8"></div>
				<div class="col-md-4 py-1">
					Email:<input type="text" name="email"
						value="${inputUser.getEmail()}" width="30" required />
				</div>
				<div class="col-md-8"></div>
				<div class="col-md-4 py-1">
					Username:<input type="text" name="username"
						value="${inputUser.getUserName()}" width="30" required />
				</div>
				<div class="col-md-8"></div>
				<div class="col-md-4 py-1">
					Password:<input id="password" type="password" name="password"
						value="${inputUser.getPassword()}" width="30" required />
				</div>
				<div class="col-md-8"></div>
				<div class="col-md-4 py-1">
					Confirm password: <input id="confirm_password" type="password"
						width="30" required>
				</div>
				<div class="col-md-8"></div>
				<div class="col-md-4 py-1">
					<c:if test="${currentSession.getRoleID() == 1}">
				Role:
				<Select name="role">
							<c:forEach items="${roles}" var="role">
								<option value="${role.getId()}">${role.getType()}</option>
							</c:forEach>
						</Select>
					</c:if>
				</div>
				<div class="col-md-8"></div>
				<input class="btn btn-primary" type="submit" value="submit" />
			</div>
		</form>
	</div>
</t:site>
<script src="client/script/form.js"></script>
</html>