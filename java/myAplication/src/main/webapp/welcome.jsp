<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style type="text/css">
    	*{
    		margin:0;
    		padding:0;
    	}
    	body{
    		background-color:black;
    	}
    	header{
    		background-color:grey;
    		height:7vh;
    		width:100vw;
    	}
    	nav{
    		display:flex;
    		justify-content:space-between;
    		align-itmes:center;
    		padding:10px;
    	}
    	nav ul{
    		display:flex;
    		gap:10px;
    	}
    	nav ul li{
    		list-style:none;
    	}
    	nav ul li a{
    		text-decoration:none;
    		color:white;
    	}
    	.logout a{
    		background-color:orange;
    		padding:4px;
    		border-radius:5px;
    		color:pink;
    		text-decoration:none;
    		cursor:pointer;
    		transtion:all ease-out;
    	}
    	.logout a:hover{
    		color:blue;
    		font-size:20px
    	}
    </style>
</head>
<body>
	<header>
		<nav>
			<ul>
				<li><a href="#">Home</a></li>
				<li><a href="login.jsp">Login</a></li>
				<li><a href="signup.jsp">Register</a></li>
				<li><a href="#">About us</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
			<div class="logout"><a href="deleteac.jsp">Delete account ?</a></div>
		</nav>
	</header>
</body>
</html>