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
	<div class="wrapper">
		<nav id="sidebar">
			<div class="sidebar-header">
				<h3>Bootstrap Sidebar</h3>
			</div>

			<ul class="list-unstyled components">
				<p class="text-uppercase">store management</p>
				<li class="active"><a href="#homeSubmenu"
					data-toggle="collapse" aria-expanded="false"
					class="dropdown-toggle">Home</a>
					<ul class="collapse list-unstyled" id="homeSubmenu">
						<li><a href="AdminUser">Users Management</a></li>
						<li><a href="AdminCategory">Categories Management</a></li>
						<li><a href="#">Home 3</a></li>
					</ul></li>
				<li><a href="AdminUser">Users Management</a></li>
				<li><a href="AdminCategory">Categories Management</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
		</nav>

		<div id="content">

			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container-fluid">

					<button type="button" id="sidebarCollapse" class="btn btn-info">
						<i class="fas fa-align-left"></i> <span>Toggle Sidebar</span>
					</button>
					<button class="btn btn-dark d-inline-block d-lg-none ml-auto"
						type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<i class="fas fa-align-justify"></i>
					</button>

					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="nav navbar-nav ml-auto">
							<li><img class="img-fluid" alt="user" src="icon/user.png"></li>
						</ul>
					</div>
				</div>
			</nav>
			<jsp:doBody />
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
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="client/script/site.js"></script>
</body>
</html>