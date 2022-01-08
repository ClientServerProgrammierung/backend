<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login/SignUp</title>
<link href="assets/css/base.css" rel="stylesheet" type="text/css" />
<link href="assets/css/navbar.css" rel="stylesheet" type="text/css" />
<link href="assets/css/loginRegister.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div class="topnav">
		<a href="./home">Home</a> <a href="./fahrradAuswahl">Fahrrad
			Auswahl</a> <a href="./login" class="active">Login</a>
	</div>


	<section>
		<div class="login-hinweis">
			<span style="font-weight: bold;">Wichtig: &nbsp;</span> Das Login ist
			nur für Mitarbeiter (Email: &nbsp;<span class="font-red">contact@test.de</span>,
			Pw: &nbsp;<span class="font-red">123</span>)
		</div>
	</section>

	<div class="wrapper">
		<div class="title-text">
			<div class="title login">Login Form</div>
			<div class="title signup">Signup Form</div>
		</div>
		<div class="form-container">
			<div class="slide-controls">
				<input type="radio" name="slide" id="login" checked> <input
					type="radio" name="slide" id="signup"> <label for="login"
					class="slide login">Login</label>

				<!-- <label for="signup"
					class="slide signup">Signup</label>-->
				<div class="slider-tab"></div>
			</div>
			<div class="form-inner">
				<form action="#" class="login">
					<div class="field">
						<input type="text" placeholder="Email Address" required>
					</div>
					<div class="field">
						<input type="password" placeholder="Password" required>
					</div>
					<!--  <div class="pass-link">
						<a href="#">Forgot password?</a>
					</div> -->
					<div class="field btn">
						<div class="btn-layer"></div>
						<input type="submit" value="Login">
					</div>
					<!-- <div class="signup-link">
						Not a member? <a href="">Signup now</a>
					</div> -->
				</form>
				<!-- <form action="#" class="signup">
					<div class="field">
						<input type="text" placeholder="Email Address" required>
					</div>
					<div class="field">
						<input type="password" placeholder="Password" required>
					</div>
					<div class="field">
						<input type="password" placeholder="Confirm password" required>
					</div>
					<div class="field btn">
						<div class="btn-layer"></div>
						<input type="submit" value="Signup">
					</div>
				</form> -->
			</div>
		</div>
	</div>

</body>
</html>