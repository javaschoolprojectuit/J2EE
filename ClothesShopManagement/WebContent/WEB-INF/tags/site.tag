<%@tag description="Base Tag" pageEncoding="UTF-8"%>

<html>
	<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
		crossorigin="anonymous">
		<link rel="stylesheet" href="client/css/default.css">
	</head>
	<body>
		<div class="container-fluid bg-dark">
			<div class="row">
				<div class="col-md-10"></div>
				<div class="col-md-2">
					<img src="icon/user.png">
				</div>
			</div>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-3" style="height:100%">
					<div class="d-flex align-items-center">
						<table class= "table table-dark">
							<tr>
								<th><a href="/AdminUser">User Management</a></th>		
							</tr>
						</table>
					</div>
				</div>
				<div class="col-md-9">
		  			<jsp:doBody/>
		  		</div>
		  	</div>
	  	</div>
	  	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
			integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
			integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
			integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
			crossorigin="anonymous"></script>
	</body>
</html>