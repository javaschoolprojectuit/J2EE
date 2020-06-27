<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Detail</title>
</head>
<t:site>
	<form method="post" name="edirProductForm"
		action="AddEditProductSubmit" enctype="multipart/form-data">
		<div id="edit-product" class="row">
			<div class="col-md-4 py-1">
				<input type="hidden" name="id" value="${inputProd.getId()}" />
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				Name:<input type="text" name="name" value="${inputProd.getName()}"
					required />
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				Description:<input type="text" name="description"
					value="${inputProd.getDescription()}" required />
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				<Select name="size">
					<option value="68">XS</option>
					<option value="72">S</option>
					<option value="76">M</option>
					<option value="80">L</option>
					<option value="84">XL</option>
					<option value="88">XXL</option>
				</Select>
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				Price:<input type="text" pattern="[0-9]" name="price"
					value="${inputProd.getPrice()}" required />
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				<p>Current image: ${inputProd.getImage()}</p>
				<p>
					<img src="${inputProd.getImage()}" alt="image" />
				</p>
				<input type="file" name="file" size="50" />
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				Category: <select name="category" required>
					<c:forEach items="${categories}" var="category">
						<c:choose>
							<c:when test="${inputProd.getCatId() == category.getId()}">
								<c:set var="selected" value='selected="selected"' />
							</c:when>
							<c:otherwise>
								<c:set var="selected" value='' />
							</c:otherwise>
						</c:choose>
						<option value="${category.getId()}" <c:out value='${selected}' />>${category.getName()}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				Supplier ID: <input type="number" name="supplier" required />
				<!--  <select name="category">
					<c:forEach items="${categories}" var="category">
						<c:choose>
							<c:when test="${inputProd.getCatId() == category.getId()}">
								<c:set var="selected" value='selected="selected"' />
							</c:when>
							<c:otherwise>
								<c:set var="selected" value='' />
							</c:otherwise>
						</c:choose>
						<option value="${category.getId()}" <c:out value='${selected}' />>${category.getName()}</option>
					</c:forEach>
				</select> -->
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				Quantity: <input type="number" name="quantity" required />
			</div>
			<input type="hidden" name="action" />
			<c:set var="act" value="Create" />
			<c:if test="${inputProd.getId() > 0}">
				<c:set var="act" value="Edit" />
			</c:if>
			<div class="col-md-1 float-none">
				<input class="btn btn-primary" type="submit"
					value="<c:out value='${act}' />"
					onclick="{document.edirProductForm.action.value=this.value;document.edirProductForm.submit();}" />
			</div>

			<c:if
				test="${currentSession.getRoleID() == 1 && inputProd.getId() > 0 }">
				<div class="col-md-1 float-none">
					<input class="btn btn-danger" type="submit" value="Delete"
						onclick="{document.edirProductForm.action.value=this.value;document.edirProductForm.submit();}" />
				</div>
			</c:if>
		</div>
	</form>
</t:site>
</html>