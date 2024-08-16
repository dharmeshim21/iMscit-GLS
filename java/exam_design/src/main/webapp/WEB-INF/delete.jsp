<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="delete.css">
</head>
<body>
	<div class="container">
		<h1>Delete Account</h1>
		<p class="tagp">Delete Your Account will delete your all data.</p>
		<form action="delete" method="post">
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
				<button>Delete</button>
			</div>
		</form>
	</div>
</body>
</html>