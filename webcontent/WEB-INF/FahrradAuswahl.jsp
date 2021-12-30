<%@ page import="java.util.ArrayList"%>
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
<link href="assets/css/fahrradAuswahl.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="topnav">
		<a href="./home">Home</a> <a href="./fahrradAuswahl" class="active">Fahrrad
			Auswahl</a> <a href="#contact">Contact</a> <a href="#about">About</a> <a
			href="./loginRegister">Login/Register</a>
			
			

	</div>

	<section>
		<%
		ArrayList<Fahrrad> fahrradListe = (ArrayList<Fahrrad>) request.getAttribute("fahrradListe");
		for (Fahrrad fahrrad : fahrradListe) {
		%>
		<div class="fahrradBox">
			<p>Marke: <%=fahrrad.getMarke()%></p>
			<p>Model: <%=fahrrad.getModel()%></p>
			<p>Rahmennummer: <%=fahrrad.getRahmennummer()%></p>
		</div>
		<%
		}
		%>
	</section>

</body>
</html>