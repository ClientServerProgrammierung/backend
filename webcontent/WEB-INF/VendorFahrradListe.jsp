<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fahrrad Liste</title>
<link href="assets/css/base.css" rel="stylesheet" type="text/css" />
<link href="assets/css/navbar.css" rel="stylesheet" type="text/css" />
<link href="assets/css/startpage.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<div class="mietBox">

		<form class="mietForm" action="./vendorbikelist" method="POST">
			<h2>Fahrrad Liste</h2>
			<hr>
			<br>
			<table>
				<tr>
					<td><input type="search" class="form-control" name="search"
						size="25" placeholder="Search" aria-label="Sizing example input"
						aria-describedby="inputGroup-sizing-sm" />
					</td>
					<td>
						<button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
					</td>										
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-primary my-2 my-sm-0" type="submit">Edit</button></td>
				</tr>
			</table>
		</form>

		<div id="loadList">Hier wird die Liste geladen</div>

	</div>
</body>
</html>