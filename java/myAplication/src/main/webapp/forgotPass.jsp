<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
</head>
<style>
    @import url('https://fonts.googleapis.com/css2?family=Inter:wght@400&display=swap');

    * {
        margin: 0;
        padding: 0;
        font-family: 'Inter', sans-serif;

    }

    body {
        background-color: #f2f2f2;
    }

    .container {
        display: flex;
        align-items: center;
        justify-content: center;
        width: 100vw;
        height: 100vh;
    }

    .left {
        border-radius: 6px;
        height: 70vh;
        width: 25vw;
        padding: 20px;
        background-color: #FFFFFF;
    }

    .head {
        display: flex;
        flex-direction: column;
        gap: 10px;
    }

    .head p {
        margin-bottom: 20px;
        color: #838383;
    }

    .lform form{
        display: flex;
        flex-direction: column;
        gap: 10px;
    }

    .field input {
        width: 312px;   
        height: 44px;
        padding-left: 3px;
        border-radius: 5px;
        border: none;
        border: 1px solid #D9D9D9;
    }

    .field input::placeholder {
        position: relative;
        left: 10px;
        color: #838383;
    }

    .remeberforgot {
        display: flex;
        justify-content: space-between;
        margin-top: 10px;
        color: #838383;
    }
    .right {
        height: 76vh;
        width: 25vw;
    }

    .right img {
        height: 100%;
        width: 100%;
        border-radius: 6px;
    }
    .btn button{
        width: 312px;
        height: 45px;
        border-radius: 5px;
        border: none;
        color: white;
        background-color: #FF8F52;
        cursor: pointer;
    }
    .btn1 button{
        width: 312px;
        height: 45px;
        border-radius: 5px;
        border: none;
        background-color: #838383;
        cursor: pointer;
    }
    .btn1 a{
        text-decoration: none;
        color: #FF8F52;
    }
    .btn button:hover{
        color: black;
        background-color: #f59a69;
    }
    .btn1 button:hover{
        background-color: #726d6d;
    }
    .btn1 a:hover{
        color: black;
    }
    .signup{
        color: #838383;
        margin-top: 25px;
        display: flex;
        align-items: center;
        justify-content: center;
        position: relative;
        right: 25px;
    }
    .signup a{
        color: #FF8F52;
    }
</style>

<body>
    <div class="container">
        <div class="left">
            <div class="head">
                <h1>Forgot Password</h1>
                <p>Reset Password for login</p>
            </div>
            <div class="lform">
                <form action="forgotPass" method="post">
                    <div class="field">
                    	<input type="text" name="username" id="username" placeholder="Username">
                	</div>
                	<div class="field">
                    	<input type="password" name="password" id="password" placeholder="Password">
                	</div>
                	<div class="field">
                    	<input type="password" name="password1" id="password" placeholder="Password">
                	</div>
                	<div class="remeberforgot">
                    	<div><input type="checkbox" name="remeberme" id="remeberme">Remember me</div>
                	</div>
                	<div class="btn">
                    	<button>Reset Password</button>
                	</div>
                	<div class="signup">
                    	<p>Already have an account? <a href="login.jsp">Login</a></p>
                	</div>
                </form>
            </div>
        </div>
        <div class="right">
            <img src="login.png" alt="">
        </div>
    </div>
</body>

</html>