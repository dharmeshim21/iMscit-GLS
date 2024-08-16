<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, jakarta.servlet.http.* , jakarta.servlet.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style>
	@charset "UTF-8";
	@import url('https://fonts.googleapis.com/css2?family=Karla:ital@0;1&display=swap');
*{
	margin: 0;
	padding: 0;
	font-family: "Karla", sans-serif;
}
body{
	background-color:#A7D7C5;
}
header{
	background-color: white;
	padding:10px;
	margin:4px;
	border: 1px solid #32403B;
	border-radius: 7px;
	box-shadow: 2px 4px 3px 1px #39b183;
	position: sticky;
	top:0;
}
nav{
	display: flex;
	justify-content: space-between;
	padding: 1px 10px;
}
nav ul{
	display: flex;
	gap:10px;
}
nav ul li{
	list-style: none;
	color:#32403B;
}
nav ul li a{
	text-decoration: none;
	color:#32403B;
	font-weight: bold;
	font-size: 22px;
}
nav ul li a:hover{
	color:#A7D7C5
}
.delete{
	background-color: #749689;
	border-radius: 8px;
	display: flex;
	justify-content: center;
	align-items: center;
	padding:3px;
}
.delete img{
	width: 35px;
}
.delete a{
	text-decoration: none;
    background: transparent;
    border: none;
    padding: 10px;
    font-weight: bolder;
    color: #32403B;
    font-size: 18px;
    cursor: pointer;
}
.delete:hover{
	background-color: #c9f0e1;
	color:#32403B;
}

main{
	display: flex;
	justify-content: center;
	align-items: center;
}
.container{
	width: 60vw;
    height: 80vh;
    background-color: #ffffff;
    margin-top: 5vh;
    padding: 10px;
    display: flex;
    align-items: center;
    gap: 20px;
    flex-direction: column;
    opacity: 0.9;
    border-radius: 5px;
}
.container .upper h1{
	font-size: 34px;
	color:#32403B;
	font-weight: bolder;
}
.lower #todo{
	padding: 5px;
    width: 297px;
    height: 35px;
    border-radius: 9px;
}
.lower #add{
	    width: 60px;
    height: 47px;
    border-radius: 10px;
    background-color: #A7D7C5;
    padding: 5px;
    cursor:pointer;
}
.todos{
	width: 80%;
}
.todos ul li{
	width: 50%;
    margin: 0 auto;
    background: #A7D7C5;
    list-style: none;
    display: flex;
    justify-content: space-between;
    padding: 10px;
    border-radius: 10px;
}
.svgs{
	display: flex;
	gap:10px;
}
#edit ,#delete{
	cursor: pointer;
}
</style>
</head>
<body>
	<%
		HttpSession userSession = request.getSession(false);
		String username = null;
		if(userSession != null){
			String email = (String) session.getAttribute("email");
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","d191");
				PreparedStatement ps = conn.prepareStatement("select username from users where email=?;");
				ps.setString(1, email);
				
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					username = rs.getString("username");
				}
				else {
					response.sendRedirect("index.jsp");
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		else{
			response.sendRedirect("index.jsp");
		}
	%>
	
	<header>
		<nav>
			<ul>
				<li><a href="home.jsp">Home</a></li>
				<li><a href="index.jsp">Login</a></li>
				<li><a href="register.jsp">Register</a></li>
				<li><a href="#">About us</a></li>
			</ul>
			<div class="delete">
			<img alt="user" src="user.svg">
				 <% if(username != null) { %>
						<a href="delete.jsp"> <%= username %> </a>
				<% } %>
			</div>
		</nav>
	</header>
	
	<main>
		<div class="container">
			<div class="upper">
				<h1>Todo Application</h1>
			</div>
			<div class="lower">
				<form action="todo" method="post">
					<input id="todo" type="text" name="todo" >
					<button id="add">Add</button>
				</form>
			</div>
			<div class="todos">
				<ul>
					<li>
						<span>Alarm</span>
						<div class="svgs">
							<img id="edit" alt="" src="edit.svg">
							<img id="delete" alt="" src="delete.svg">
						</div>
					</li>
				</ul>
			</div>
		</div>
	</main>
</body>
<script>
	
</script>
</html>