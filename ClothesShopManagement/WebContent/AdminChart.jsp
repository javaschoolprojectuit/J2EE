<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report</title>
</head>
<t:site>
	<div>
		<form method="get" action="AdminChart">
			<div class="row">
				<div class="col-md-4">
					start date: <input class="form-control" type="date" name="start">
				</div>
				<div class="col-md-4">
					end date: <input class="form-control" type="date" name="end">
				</div>
			</div>
			<input type="submit" class="btn btn-primary" value="Submit">
		</form>
	</div>
	<hr>
	<div>
		<img src="AdminShowChart" width="600" height="400" border="0"
			usemap="#chart" />
	</div>
</t:site>
</html>