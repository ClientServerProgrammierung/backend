<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fahrrad bearbeiten</title>
<link href="assets/css/base.css" rel="stylesheet" type="text/css" />
<link href="assets/css/navbar.css" rel="stylesheet" type="text/css" />
<link href="assets/css/fahrradMieten.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div class="topnav">
		<a href="./vendorhome" class="active">Home</a> &nbsp;&nbsp; 
		<a href="./vendorbikelist">Fahrrad Liste</a> &nbsp;&nbsp;
		<a href="./vendorcreatebike">Fahrrad anlegen</a> &nbsp;&nbsp;
	</div>

	<div class="mietBox">

		<form class="mietForm" action="./vendoreditbike" method="POST">
			<h2>Fahrrad bearbeiten</h2>
			<hr>
			<br>
			<table>
				<tr>
					<td><label>Marke:</label></td>
					<td><input type="text" name="marke"
						value="<%=request.getParameter("marke")%>"  
						 /></td>
				</tr>
				<tr>
					<td><label>Model:</label></td>
					<td><input type="text" name="model"
						value="<%=request.getParameter("model")%>"  
						 /></td>
				</tr>
				<tr>
					<td><label>Rahmennummer:</label></td>
					<td><input type="text" name="rahmennummer"
						value="<%=request.getParameter("rahmennummer")%>" 
						  /></td>
				</tr>				
				<tr>
					<td></td>
					<td class="td-miet-btn"><button class="miet-btn" type="submit">Bearbeiten
							</button></td>
				</tr>
			</table>
		</form>



	</div>
</body>
</html>