<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New User</title>
         <link rel="stylesheet" type="text/css" href="theme.css">
    </head>
    <body>
    <div class="login">
	<h1>Create Account</h1>
    <form method="post" action="Registration">
    	<input type="text" name="fname" placeholder="First Name" required="required" />
        <input type="email" name="email" placeholder="Email/User Name" required="required" />
        <input type="text" name="mnumber" placeholder="Mobile Number" required="required" />
        <input type="text" name="pass" placeholder="Password" required="required" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Submit Me.</button>
    </form>
        <div class="click">
          <a href="signup.jsp">Sign Up</a>
        </div>
</div>
    </body>
</html>