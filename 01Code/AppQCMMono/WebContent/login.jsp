<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<form action="servletLogin" method="post" class="login">
<div class="login">
    <label for="name">Mail : </label>
    <input type="email" name="email" id="email" required>
  </div>
  <div class="login">
    <label for="password">Password: </label>
    <input type="password" name="password" id="password" required>
  </div>
  <div class="login">
    <input type="submit" value="GO!!!!!">
  </div>

</form>

</body>
</html>