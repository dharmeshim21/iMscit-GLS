<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
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
        height: 75vh;
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
    .gender{
        display: flex;
        gap: 10px;
        margin: 10px 0;
    }

    .gen{
        display: flex;
        gap:4px;
        align-items: center;
    }
    .gen input{
        height: 19px;
        width: 29px;
    }
    .country select{
        width: 312px;   
        height: 44px;
        text-align: center;
        border: 1px solid #D9D9D9;
        color: #838383;

    }
    .termcondition {
        margin-top: 10px;
        width: 312px; 
        color: #838383;
    }
    .termcondition a {
        text-decoration: none;
        color: #FF8F52;
        cursor: pointer;
        /* font-size: 13px; */
    }
    .termcondition a:hover {
        color: blue;
        text-decoration: underline;
    }
    .right {
        height: 81vh;
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
    .btn button:hover{
        color: black;
        background-color: #f59a69;
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
                <h1>Register</h1>
                <p>Register and help us help you</p>
            </div>
            <div class="lform">
                <form action="register" method="post">
                    <div class="field">
                        <input type="text" name="email" id="email" placeholder="Email">
                    </div>
                    <div class="field">
                        <input type="text" name="username" id="username" placeholder="Username">
                    </div>
                    <div class="field">
                        <input type="password" name="password" id="password" placeholder="Password">
                    </div>
                    <div class="gender">
                        <div class="gen"><input type="radio" name="gender" id="gender" value="Male"><p>Male</p></div>
                        <div class="gen"><input type="radio" name="gender" id="gender" value="Female"><p>Female</p></div>
                    </div>
                    <div class="country">
                        <select name="country" id="country">
                            <option value="">-----Select Country-----</option>
                            <option value="India">India</option>
                            <option value="Russia">Russia</option>
                            <option value="USA">USA</option>
                            <option value="Spain">Spain</option>
                            <option value="Japan">Japan</option>
                        </select>
                    </div>
                    <div class="termcondition">
                        <p>with registering your accepting our <a>terms</a> and <a>privacy policy</a></p>
                    </div>
                    <div class="btn">
                        <button>Register</button>
                    </div>
                    <div class="signup">
                        <p>Already have an account? <a href="login.jsp">Login</a></p>
                    </div>
                </form>
            </div>
        </div>
        <div class="right">
            <img src="register.png" alt="">
        </div>
    </div>
</body>

</html>