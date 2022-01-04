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
</head>
<body>
<div class="mietBox">

		<form class="mietForm" action="./vendorcreatebike" method="POST">
			<h2>Fahrrad Liste</h2>
			<hr>
			<br>
			<table>
				<tr>
					<td><input type="text" name="suche" placeholder="Suche" required/></td>
					<td class="td-miet-btn"><button class="miet-btn" type="submit">Fahrrad suchen</button></td>
					<td class="td-miet-btn"><button class="miet-btn" type="submit">Fahrrad bearbeiten</button></td>
				</tr>					
			</table>
		</form>

<div id="loadList">

Hier wird die Liste geladen
</div>

	</div>
</body>
</html>