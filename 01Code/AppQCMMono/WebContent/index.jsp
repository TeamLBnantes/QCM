<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<base href="<%=request.getScheme() + "://"
			+ request.getServerName() + ":"
			+ request.getServerPort()
			+ request.getContextPath() + "/"
			%>" />

<meta charset="UTF-8">
<title>QuizizSkillz Bienvenue</title>

<link href="resources/css/signin.css" rel="stylesheet">
<link rel="canonical"
	href="https://getbootstrap.com/docs/4.4/examples/sign-in/">

<!-- Bootstrap core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />


<base
	href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/"%>" />
</head>

<body class="text-center">

<div class="form-signin">
<img class="mb-4" src="resources/images/QuizizSkillz.png"
			alt=""  height="125">
			<br/>
<a href="inscription"><button class="btn btn-lg btn-primary btn-block" type="submit">Inscription</button></a><br>
<a href="login"><button class="btn btn-lg btn-primary btn-block" type="submit">Connexion</button></a><br>
<!-- <a href="home">home</a><br>
<a href="login/out">logout</a><br>
<a href="test">test</a><br>
<a href="test/2">test/2</a><br> -->
</div>
</body>
</html>