<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="theme.css">
    </head>
    <body>
        <div class="login">
	<h1>Login</h1>
        <form method="post" action="singup">
    	<input type="text" name="email" placeholder="Username" required="required" />
        <input type="password" name="pass" placeholder="Password" required="required" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
        </form>
         <div class="click">
          <a href="index.jsp">NewHere</a>
        </div>
</div>
    </body>
</html>