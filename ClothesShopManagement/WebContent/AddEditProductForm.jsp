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
	<form method="post" name="editProductForm"
		onSubmit="return validateProductForm(event);"
		action="AddEditProductSubmit" enctype="multipart/form-data">
		<div id="edit-product" class="row">
			<div class="col-md-4 py-1">
				<input type="hidden" name="id" value="${inputProd.getId()}" />
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				Name:<input class="form-control" type="text" name="name" value="${inputProd.getName()}"
					required />
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				Description:<input class="form-control" type="text" name="description"
					value="${inputProd.getDescription()}" />
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				<c:set var="selected" value='selected="selected"' />
				Size:
				<Select class="form-control" name="size">
					<option value="">none</option>
					<option value="68" <c:if test="${inputProd.getSize() == 68}"> <c:out value='${selected}' /></c:if>>XS</option>
					<option value="72" <c:if test="${inputProd.getSize() == 72}"> <c:out value='${selected}' /></c:if>>S</option>
					<option value="76" <c:if test="${inputProd.getSize() == 76}"> <c:out value='${selected}' /></c:if>>M</option>
					<option value="80" <c:if test="${inputProd.getSize() == 80}"> <c:out value='${selected}' /></c:if>>L</option>
					<option value="84" <c:if test="${inputProd.getSize() == 84}"> <c:out value='${selected}' /></c:if>>XL</option>
					<option value="88" <c:if test="${inputProd.getSize() == 88}"> <c:out value='${selected}' /></c:if>>XXL</option>
				</Select>
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				Price:<input class="form-control" type="text" pattern="[0-9]+" name="price"
					value="${inputProd.getPrice()}" required />
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				<p>Current image: ${inputProd.getImage()}</p>
				<input type="hidden" name="image" value="${inputProd.getImage()}" />
				<p>
					<img src="${inputProd.getImage()}" alt="image" />
				</p>
				<input type="file" class="form-control" name="file" size="50" />
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				Category: <select name="category" class="form-control" required>
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
				Supplier ID: <select name="supplier" class="form-control" required>
					<c:forEach items="${suppliers}" var="supplier">
						<c:choose>
							<c:when test="${inputProd.getSuppId() == supplier.getId()}">
								<c:set var="selected" value='selected="selected"' />
							</c:when>
							<c:otherwise>
								<c:set var="selected" value='' />
							</c:otherwise>
						</c:choose>
						<option value="${supplier.getId()}" <c:out value='${selected}' />>${supplier.getName()}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-8"></div>
			<div class="col-md-4 py-1">
				Quantity: <input type="number" class="form-control" name="quantity" value="${inputProd.getQuantity()}" required />
			</div>
			<input type="hidden" name="action" required />
			<c:set var="act" value="Create" />
			<c:if test="${inputProd.getId() > 0}">
				<c:set var="act" value="Edit" />
			</c:if>
			<div class="col-md-1 float-none">
				<input class="btn btn-primary" type="submit"
					value="<c:out value='${act}' />"
					onclick="{document.editProductForm.action.value=this.value;}" />
			</div>

			<c:if
				test="${currentSession.getRoleID() == 1 && inputProd.getId() > 0 }">
				<div class="col-md-1 float-none">
					<input class="btn btn-danger" type="submit" value="Delete"
						onclick="{document.editProductForm.action.value=this.value;}" />
				</div>
			</c:if>
		</div>
	</form>
</t:site>
<script src="client/script/productForm.js"></script>
</html>