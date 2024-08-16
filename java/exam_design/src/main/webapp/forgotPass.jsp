<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ForgotPass</title>
<link rel="stylesheet" href="forgotPass.css">
</head>
<body>
	<div class="container">
		<h1>Reset Password</h1>
		<p class="tagp">Reset Your Password to enjoy all the services without any ads for free!</p>
		<form action="forgotPass" method="post">
			<div class="field">
				<input type="text" name="email" placeholder="Email Address">
			</div>
			<div class="field">
				<input type="password" id="password" name="password" placeholder="Password">
			</div>
			<div class="field">
				<input type="password" id="password1" name="password" placeholder="Confirm Password">
			</div>
			<div class="btn">
				<button id="btn">Reset Password</button>
				<p>Login to Your Account <a href="index.jsp">Sign In</a></p>
			</div>
		</form>
	</div>
</body>
<script>
	document.getElementById("btn").addEventListener("click",()=>{
		alert("***Password Updated Successfully***")
	})
</script>
</html>