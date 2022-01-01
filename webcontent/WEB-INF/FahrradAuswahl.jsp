<%@ page import="java.util.List"%>
<%@ page import="model.Fahrrad"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fahrrad Auswahl</title>
<link href="assets/css/base.css" rel="stylesheet" type="text/css" />
<link href="assets/css/navbar.css" rel="stylesheet" type="text/css" />
<link href="assets/css/fahrradAuswahl.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div class="topnav">
		<a href="./home">Home</a> <a href="./fahrradAuswahl" class="active">Fahrrad
			Auswahl</a> <a href="#contact">Contact</a> <a href="#about">About</a> <a
			href="./login">Login</a>

	</div>

	<section>
		<%
		List<Fahrrad> fahrradListe = (List<Fahrrad>) request.getAttribute("fahrradListe");
		for (Fahrrad fahrrad : fahrradListe) {
		%>
		<div class="fahrradBox">
			<div class="left-flex">
				<p>
					Marke:
					<%=fahrrad.getMarke()%></p>
				<p>
					Model:
					<%=fahrrad.getModel()%></p>
				<p>
					Rahmennummer:
					<%=fahrrad.getRahmennummer()%></p>
			</div>
			<div class="right-flex">
				<form action="./fahrradMieten" method="get">
					<input type="hidden" name="marke" value=<%=fahrrad.getMarke()%>>
					<input type="hidden" name="model" value=<%=fahrrad.getModel()%>>
					<input type="hidden" name="rahmennummer" value=<%=fahrrad.getRahmennummer()%>>
					<input class="mietenBTN" type="submit" value="Auswählen">
				</form>

			</div>
		</div>
		<%
		}
		%>
	</section>

</body>
</html>