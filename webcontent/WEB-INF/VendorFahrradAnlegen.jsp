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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

	<div class="mietBox">
		<form class="mietForm" action="./vendorcreatebike" method="POST">
			<h2>Fahrrad anlegen</h2>
			<hr>
			<br>
			<table>
				<tr class="input-group input-group-sm mb-3">

					<td><input type="text" class="form-control" name="marke"
						size="20" placeholder="Marke" required
						aria-label="Sizing example input"
						aria-describedby="inputGroup-sizing-sm" /></td>

				</tr>

				<tr class="input-group input-group-sm mb-3">

					<td><input type="text" class="form-control" name="model"
						size="20" placeholder="Model" required
						aria-label="Sizing example input"
						aria-describedby="inputGroup-sizing-sm" /></td>

				</tr>

				<tr class="input-group input-group-sm mb-3">

					<td><input type="text" class="form-control"
						name="rahmennummer" size="20" placeholder="Rahmennummer" required
						aria-label="Sizing example input"
						aria-describedby="inputGroup-sizing-sm" /></td>

				</tr>

				<tr class="input-group input-group-sm mb-3">

					<td><input type="number" class="form-control"
						name="anschaffungspreis" size="50" placeholder="Anschaffungspreis"
						required aria-label="Sizing example input"
						aria-describedby="inputGroup-sizing-sm" /></td>
				</tr>
				<tr>
					<td>
						<button type="submit" class="btn btn-success">Fahrrad
							anlegen</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>