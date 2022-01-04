<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fahrrad anlegen</title>
<link href="assets/css/base.css" rel="stylesheet" type="text/css" />
<link href="assets/css/navbar.css" rel="stylesheet" type="text/css" />
<link href="assets/css/startpage.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="mietBox">

		<form class="mietForm" action="./vendorcreatebike" method="POST">
			<h2>Fahrrad anlegen</h2>
			<hr>
			<br>
			<table>
				<tr>
					<td><label>Marke:</label></td>
					<td><input type="text" name="marke" placeholder="Marke" required/></td>
				</tr>
				<tr>
					<td><label>Model:</label></td>
					<td><input type="text" name="model" placeholder="Model" required/></td>
				</tr>
				<tr>
					<td><label>Rahmennummer:</label></td>
					<td><input type="text" name="rahmennummer" placeholder="Rahmennummer" required/></td>
				</tr>	
				<tr>
					<td><label>Anschaffungspreis:</label></td>
					<td><input type="number" name="anschaffungspreis"  placeholder="Anschaffungspreis" required/></td>
				</tr>	
				<tr>
					<td><label>Mietpreis:</label></td>
					<td><input type="number" name="mietpreis" placeholder="Mietpreis" required/></td>
				</tr>							
				<tr>
					<td></td>
					<td class="td-miet-btn"><button class="miet-btn" type="submit">Fahrrad anlegen</button></td>
				</tr>
			</table>
		</form>



	</div>
</body>
</html>