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
	<form method="post" name="editCategoryForm" action="AddEditCategorySubmit"
		enctype="multipart/form-data">
		<div id="edit-category" class="row">
			<div class="col-md-4 py-1">
				<input type="hidden" name="id" value="${inputCat.getId()}" />
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				Name:<input type="text" name="name" value="${inputCat.getName()}"
					required />
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
			<div class="col-md-4 py-1">
				<p>Current image: ${inputCat.getImage()}</p>
				<p>
					<img src="${inputCat.getImage()}" alt="image" />
				</p>
				<input type="file" name="file" size="50" />
			</div>
			<div class="col-md-8"></div>
			<input type="hidden" name="action" />
			<c:set var="act" value="Create" />
			<c:if test="${inputCat.getId() > 0}">
				<c:set var="act" value="Edit" />
			</c:if>
			<div class="col-md-1 float-none">
				<input class="btn btn-primary" type="submit"
					value="<c:out value='${act}' />"
					onclick="{document.editCategoryForm.action.value=this.value;document.editCategoryForm.submit();}" />
			</div>

			<c:if
				test="${currentSession.getRoleID() == 1 && inputUser.getId() > 0 }">
				<div class="col-md-1 float-none">
					<input class="btn btn-danger" type="submit" value="Delete"
						onclick="{document.editCategoryForm.action.value=this.value;document.editCategoryForm.submit();}" />
				</div>
			</c:if>
		</div>
	</form>
</t:site>
</html>