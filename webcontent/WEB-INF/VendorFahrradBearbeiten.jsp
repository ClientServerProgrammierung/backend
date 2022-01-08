<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page import="frontendVendor.VendorFahrradBearbeiten"%>
<%@ page import="model.Kosten"%>
<%@ page import="gateway.KostenArtenGateway"%>
<%@ page import="gateway.KostenGateway"%>
<%@ page import="model.KostenArten"%>
<%@ page import="model.Fahrrad"%>
<%@ page import="java.util.List"%>
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
<link href="assets/css/fahrradAuswahl.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div class="topnav">
		<a href="./vendorhome" class="active">Home</a> &nbsp;&nbsp; <a
			href="./vendorbikelist">Fahrrad Liste</a> &nbsp;&nbsp; <a
			href="./vendorcreatebike">Fahrrad anlegen</a> &nbsp;&nbsp;
	</div>


	<%
	if (request.getAttribute("fahrradBearbeitet") != null) {
	%>
	<section>
		<div class="mietenFeedback"
			style="background-color: #d5ffd5; color: #005b00; text-align: center;">
			<%=request.getAttribute("fahrradBearbeitet")%>
		</div>
	</section>
	<%
	}
	%>

	<div class="mietBox">

		<form class="mietForm" action="./vendoreditbike" method="POST">
			<h1 style="text-align: center;">Fahrrad &Uuml;bersicht</h1>
			<hr>
			<br>
			<table>
				<tr>
					<td><label>Marke:</label></td>
					<td><input type="text" name="marke"
						value="<%=request.getParameter("marke")%>" /></td>
				</tr>
				<tr>
					<td><label>Model:</label></td>
					<td><input type="text" name="model"
						value="<%=request.getParameter("model")%>" /></td>
				</tr>
				<tr>
					<td><label>Rahmennummer:</label></td>
					<td><input type="text" name="rahmennummer"
						value="<%=request.getParameter("rahmennummer")%>" readonly
						class="readonly" /></td>
				</tr>
				<tr>
					<td class="td-miet-btn"><button class="miet-btn" type="submit" name="deleteBike">Fahrrad Löschen
						</button></td>
					<td class="td-miet-btn"><button class="miet-btn" type="submit" name="updateBike">Änderung Speichern
						</button></td>
				</tr>
			</table>
		</form>
	</div>
	<section>
		<%
		KostenArtenGateway kostenArtenGateway = new KostenArtenGateway();
		KostenGateway kostenGateway = new KostenGateway();
		List<Kosten> balanceList = kostenGateway.getKostenByRahmennummer(request.getParameter("rahmennummer"));
		%>
		<div class="mietForm">
		<!-- <h2 style="text-align: center;">Finanzen</h2> -->
			<table style="width: 100%">
				<tr>
					<th style="text-align: left;">Art</th>
					<th style="text-align: center;">Wertstellung</th>
					<th style="text-align: right;">Betrag</th>
				</tr>

				<%
				int total = 0;
				for (Kosten kostenpunkt : balanceList) {
				    if(kostenpunkt.getKostenArtenObj().getIsIncome()){
				        total += kostenpunkt.getHoehe();
					%>
	
					<tr>
						<td style="text-align: left;"><%=kostenpunkt.getKostenArtenObj().getBeschreibung()%></td>
						<td style="text-align: center;"><%=kostenpunkt.getDatum()%></td>
						<td style="text-align: right; color: green"><%=kostenpunkt.getHoehe() + "&euro;"%></td>
					</tr>
					<%} else {
				        total -= kostenpunkt.getHoehe();
				        %>
				        					<tr>
						<td style="text-align: left;"><%=kostenpunkt.getKostenArtenObj().getBeschreibung()%></td>
						<td style="text-align: center;"><%=kostenpunkt.getDatum()%></td>
						<td style="text-align: right; color: red"><%=kostenpunkt.getHoehe() + "&euro;"%></td>
					</tr>
					 <% 
				    } 
				    %>
					
	
	
					<%
				}
				%>
			</table>
		</div>

		<div class="mietForm">
		<%
		
		%>
			<table>
				<tr>
					<td><h2 style="text-align: left;">Total:</h2></td>
					<%if(total< 0){ %>
					<td><h2 style="text-align: right; margin-left: 11em; color: red"><%=total%>
							&euro;</h2></td>
					<% } else {%>
						<td><h2 style="text-align: right; margin-left: 11em; color: green"><%=total%>
						&euro;</h2></td>
					<% } %>
				</tr>
			</table>


		</div>
	</section>
</body>
</html>