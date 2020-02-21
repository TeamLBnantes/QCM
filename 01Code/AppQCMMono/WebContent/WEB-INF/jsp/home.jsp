<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome home !</title>
	<base href="<%=request.getScheme() + "://"
			+ request.getServerName() + ":"
			+ request.getServerPort()
			+ request.getContextPath() + "/"
			%>" />
</head>
<body>
	<h1>Home, sweet home !</h1>

	${ message }<br/>

	<a href="home.jsp">I'll be back</a>
</body>
</html>