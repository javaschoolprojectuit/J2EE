<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products Management</title>
</head>
<t:site>
	<div id="product-list">
		<form method="post" action="AdminProduct">
			<div class="row">
				<div class="col-md-4 py-1">
					Name:<input class="ml-1 form-control" type="text" name="name" />
				</div>
				<div class="col-md-4 py-1">
					Id:<input class="ml-1 form-control" pattern="[0-9]+" type="text" name="id" />
				</div>
				<div class="col-md-4"></div>
				<div class="col-md-3 py-1">
					<button type="button" class="btn btn-info" data-toggle="collapse"
						data-target="#advance-search">Advance Filter</button>
				</div>
				<div class="col-md-9 py-1"></div>
				<div id="advance-search" class="collapse">
					<div class="col-md-12 py-1">
						Category ID:<input class="ml-1 form-control" pattern="[0-9]+" type="text" name="catid" />
					</div>
					<div class="col-md-12 py-1">
						Supplier ID:<input class="ml-1 form-control" pattern="[0-9]+" type="text" name="suppid" />
					</div>
					<div class="col-md-12 py-1">
						<div class="row">
							<div class="col-md-6">
							Price 
							<select class="mx-1 form-control" name="priceorder">
								<option value="=">equals</option>
								<option value=">=">Higher than</option>
								<option value="<=">Lower than</option>
							</select>
							</div> 
							<div class="col-md-6">
								<input class="form-control mt-4" type="text" pattern="[0-9]+" name="price" />
							</div>
						</div>
					</div>
					<div class="col-md-12 py-1">
					<div class="row">
						<div class="col-md-6">
							Size 
							<select class="mx-1 form-control" name="sizeorder">
								<option value="=">equals</option>
								<option value=">=">Higher than</option>
								<option value="<=">Lower than</option>
							</select> 
						</div>
						<div class="col-md-6">
							<Select class="form-control mt-4" name="size">
								<option value="68">XS</option>
								<option value="72">S</option>
								<option value="76">M</option>
								<option value="80">L</option>
								<option value="84">XL</option>
								<option value="88">XXL</option>
							</Select>
						</div>
						</div>
					</div>
					<div class="col-md-12 py-1">
						<div class="row">
							<div class="col-md-6">
								Quantity 
								<select class="mx-1 form-control" name="quantityorder">
									<option value="=">equals</option>
									<option value=">=">Higher than</option>
									<option value="<=">Lower than</option>
								</select>
							</div>
							<div class="col-md-6">
								<input class="form-control mt-4" type="text" pattern="[0-9]+" name="quantity" />
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-12 py-1">
					<input class="btn btn-primary" type="submit" value="submit" />
				</div>
			</div>
		</form>
		<hr>
		<h4 class="my-2">Action</h4>
		<a class="btn btn-primary" href="GoToAddEditProduct">Create</a>
		<hr>
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th>id</th>
					<th>Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Size</th>
					<th>Image</th>
					<th>Category</th>
					<th>Supplier</th>
					<th>Quantity</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${products}" var="product">
					<c:if test="${!product.isDeleted()}">
						<tr>
							<td><a href="GoToAddEditProduct?id=${product.getId()}">${product.getId()}</a></td>
							<td>${product.getName()}</td>
							<td>${product.getDescription()}</td>
							<td>${product.getPrice()}</td>
							<td>${product.getSize()}</td>
							<td>${product.getImage()}</td>
							<td>${product.getCatId()}</td>
							<td>${product.getSuppId()}</td>
							<td>${product.getQuantity()}</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
</t:site>
</html>