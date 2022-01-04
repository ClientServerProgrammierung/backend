<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fahrrad anlegen</title>
</head>
<body>
<div class="mietBox">

		<form class="mietForm" action="./vendorcreatebike" method="POST">
			<h2>Fahrrad Anlegen</h2>
			<hr>
			<br>
			<table>
				<tr>
					<td><label>Marke:</label></td>
					<td><input type="text" name="marke" required/></td>
				</tr>
				<tr>
					<td><label>Model:</label></td>
					<td><input type="text" name="model" required/></td>
				</tr>
				<tr>
					<td><label>Rahmennummer:</label></td>
					<td><input type="text" name="rahmennummer" required/></td>
				</tr>									
				<tr>
					<td></td>
					<td class="td-miet-btn"><button class="miet-btn" type="submit">Fahrrad Anlegen</button></td>
				</tr>
			</table>
		</form>



	</div>
</body>
</html>