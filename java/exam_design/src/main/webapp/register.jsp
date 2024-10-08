<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" href="register.css">
</head>
<body>
	<div class="container">
		<h1>Create An Account</h1>
		<p class="tagp">Create an account to enjoy all the services without any ads for free!</p>
		<form action="register" method="post">
			<div class="field">
				<input type="text" name="email" placeholder="Email Address" required="required">
			</div>
			<div class="field">
				<input type="text" name="username" placeholder="Username" required="required">
			</div>
			<div class="field">
				<input type="password" name="password" placeholder="Password" required="required">
			</div>
			<div class="gender">
				<input type="radio" name="gender" value="Male">Male
				<input type="radio" name="gender" value="Female">Female
			</div>
			<div class="selectCountry">
				<select name="country" required="required">
					<option value="">-----Select Country-----</option>
					<option value="India">India</option>
					<option value="Russia">Russia</option>
					<option value="Japan">Japan</option>
					<option value="Spain">Spain</option>
					<option value="USA">USA</option>
				</select>
			</div>
			<div class="btn">
				<button id="btn">Register</button>
				<p>Have An Account? <a href="index.jsp">Sign In</a></p>
			</div>
		</form>
	</div>
</body>
<script>
	document.getElementById("btn").addEventListener("click",()=>{
		alert("***Account Created Successfully***")
	})
</script>
</html>