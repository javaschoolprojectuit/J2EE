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
		<form name="editUserForm" method="post" action="AddEditUserSubmit">
			<div class="row">
				<div class="col-md-4 py-1">
					${inputUser.getId()}<input type="hidden" name="id"
						value="${inputUser.getId()}" />
				</div>
				<div class="col-md-8"></div>
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
					Email:<input type="email" name="email"
						value="${inputUser.getEmail()}" width="30" required />
				</div>
				<div class="col-md-8"></div>
				<div class="col-md-4 py-1">
					Username:<input type="text" name="username"
						value="${inputUser.getUserName()}" width="30" required />
				</div>
				<div class="col-md-8"></div>
				<c:set var="type" value='type="password"' />
				<c:if test="${currentSession.getRoleID() == 1}">
					<c:set var="type" value='type="text"' />
				</c:if>
				<div class="col-md-4 py-1">
					Password:<input id="password" <c:out value='${type}' />
						name="password" value="${inputUser.getPassword()}" width="30"
						required />
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
								<c:choose>
									<c:when test="${inputUser.getRoleID() == role.getId()}">
										<c:set var="selected" value='selected="selected"' />
									</c:when>
									<c:otherwise>
										<c:set var="selected" value='' />
									</c:otherwise>
								</c:choose>
								<option value="${role.getId()}" <c:out value='${selected}' />>${role.getType()}</option>
							</c:forEach>
						</Select>
					</c:if>
				</div>
				<div class="col-md-8"></div>
				<input type="hidden" name="action" />
				<c:set var="act" value="Create" />
				<c:if test="${inputUser.getId() > 0}">
					<c:set var="act" value="Edit" />
				</c:if>
				<div class="col-md-1 float-none">
					<input class="btn btn-primary" type="submit"
						value="<c:out value='${act}' />"
						onclick="{document.editUserForm.action.value=this.value;document.editUserForm.submit();}" />
				</div>

				<c:if
					test="${currentSession.getRoleID() == 1 && inputUser.getId() > 0 }">
					<div class="col-md-1 float-none">
						<input class="btn btn-danger" type="submit" value="Delete"
							onclick="{document.editUserForm.action.value=this.value;document.editUserForm.submit();}" />
					</div>
				</c:if>
			</div>
		</form>
	</div>
</t:site>
<script src="client/script/form.js"></script>
</html>