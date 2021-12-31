<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fahrrad Mieten</title>
<link href="assets/css/base.css" rel="stylesheet" type="text/css" />
<link href="assets/css/navbar.css" rel="stylesheet" type="text/css" />
<link href="assets/css/fahrradMieten.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div class="topnav">
		<a href="./home">Home</a> <a href="./fahrradAuswahl" class="active">Fahrrad
			Auswahl</a> <a href="#contact">Contact</a> <a href="#about">About</a> <a
			href="./login">Login</a>

	</div>

	<div class="mietBox">

		<form class="mietForm" action="./fahrradMieten" method="POST">
			<h2>Fahrrad Mieten</h2>
			<hr>
			<br>
			<table>
				<tr>
					<td><label>Marke:</label></td>
					<td><input type="text" name="marke"
						value="<%=request.getParameter("marke")%>" readonly required
						class="readonly" /></td>
				</tr>
				<tr>
					<td><label>Model:</label></td>
					<td><input type="text" name="model"
						value="<%=request.getParameter("model")%>" readonly required
						class="readonly" /></td>
				</tr>
				<tr>
					<td><label>Rahmennummer:</label></td>
					<td><input type="text" name="rahmennummer"
						value="<%=request.getParameter("rahmennummer")%>" readonly
						required class="readonly" /></td>
				</tr>
				<tr>
					<td><label>Vorname:</label></td>
					<td><input type="text" name="vorname" required /></td>
				</tr>
					<tr>
					<td><label>Nachname:</label></td>
					<td><input type="text" name="nachname" required /></td>
				</tr>
				<tr>
					<td><label>E-mail:</label></td>
					<td><input type="email" name="email" required /></td>
				</tr>
				<tr>
					<td><label>Dauer (Max. 14 Tage):</label></td>
					<td><input type="number" min="1" max="14" name="dauer"
						required /></td>
				</tr>
				<tr>
					<td></td>
					<td class="td-miet-btn"><button class="miet-btn" type="submit">Fahrrad Mieten</button></td>
				</tr>
			</table>
		</form>



	</div>
</body>
</html>