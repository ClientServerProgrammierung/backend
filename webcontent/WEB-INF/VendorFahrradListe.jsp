<%@ page import="java.util.List"%>
<%@ page import="model.Fahrrad"%>
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
<link href="assets/css/fahrradAuswahl.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div class="topnav">
		<a href="./vendorhome" class="active">Home</a> &nbsp;&nbsp; <a
			href="./vendorcreatebike">Fahrrad anlegen</a> &nbsp;&nbsp;
	</div>

	<form class="mietForm" action="./vendorbikelist" method="POST">
		<h2>Fahrrad Liste</h2>
		<hr>
		<br>
			<table>
				<tr>
					<td><input type="search" class="form-control" name="search"
						size="25" placeholder="Search" aria-label="Sizing example input"
						aria-describedby="inputGroup-sizing-sm" /></td>
					<td>
						<button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
					</td>
				</tr>
			</table>
	</form>

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
				<form action="./vendoreditbike" method="get">
					<input type="hidden" name="marke" value=<%=fahrrad.getMarke()%>>
					<input type="hidden" name="model" value=<%=fahrrad.getModel()%>>
					<input type="hidden" name="rahmennummer" value=<%=fahrrad.getRahmennummer()%>> 
					<input class="mietenBTN" type="submit" value="Bearbeiten">
				</form>

			</div>
		</div>
		<%
		}
		%>
	</section>

</body>
</html>