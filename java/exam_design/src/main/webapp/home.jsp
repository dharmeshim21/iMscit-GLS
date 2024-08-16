<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, jakarta.servlet.http.* , jakarta.servlet.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="home.css">
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
			<input type="text" name="todo" >
			<button id="button">Add</button>
		</form>
		</div>
		<div class="todos">
			<ul>
				<li>
					<p></p>
					<img alt="" src="">
					<img alt="" src="">
				</li>
			</ul>
		</div>
	</div>
	</main>
</body>
</html>