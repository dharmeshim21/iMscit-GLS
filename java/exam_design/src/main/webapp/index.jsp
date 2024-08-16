<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<h1>Login</h1>
		<p class="tagp">Login Your account to enjoy all the services without any ads for free!</p>
		<form action="login" method="post">
			<div class="field">
				<input type="text" name="email" placeholder="Email Address">
			</div>
			<div class="field">
				<input type="password" name="password" placeholder="Password">
			</div>
			<div class="forgot">
				<a href="forgotPass.jsp">Forgot Password?</a>
			</div>
			<div class="btn">
				<button>Login</button>
				<p>Don`t Have An Account? <a href="register.jsp">Sign Up</a></p>
			</div>
		</form>
	</div>
</body>
</html>