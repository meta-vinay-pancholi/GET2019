<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
</head>
<body>

 <h4>${errorMsg}</h4>
   <h1>Login</h1>
   <form name='loginForm' action="/login" method = "post">
  
      <table>
         <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
         </tr>
         <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
         </tr>
      </table>
  </form>
</body>
</html>
