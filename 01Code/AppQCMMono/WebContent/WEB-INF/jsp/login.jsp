<!-- login.jsp  -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v3.8.6">
<title>QuizizSkillz Authentification</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.4/examples/sign-in/">

<!-- Bootstrap core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
     <link rel="shortcut icon" href="resources/images/favicon.ico">


<!--     Favicons
<link rel="apple-touch-icon" href="/docs/4.4/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="/docs/4.4/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="/docs/4.4/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/4.4/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="/docs/4.4/assets/img/favicons/safari-pinned-tab.svg" color="#563d7c">
<link rel="icon" href="/docs/4.4/assets/img/favicons/favicon.ico">
<meta name="msapplication-config" content="/docs/4.4/assets/img/favicons/browserconfig.xml">
<meta name="theme-color" content="#563d7c"> -->


<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}"src/main/java/fr/dawan/formation/AppQCMMono/controllers/LoginController.java"

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<link href="resources/css/signin.css" rel="stylesheet">


<head>

	<base
	href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/"%>" />
</head> 
  
  
  
  
  
  
  </head>


  <body class="text-center">
	<input type="hidden" name="returnUrl" value="${param.returnUrl}">
    <form class="form-signin" action="login" method="post">
  <img class="mb-4" src="resources/images/QuizizSkillz.png"
			alt=""  height="100">
  <h1 class="h3 mb-3 font-weight-normal"> ${message}  Authentification</h1>
  <label for="inputEmail" class="sr-only">Email address</label>
  <input type="email" name="email" id="inputEmail" value="${email}" class="form-control"
			placeholder="Utilisateur"  required autofocus>
	
  <label for="inputPassword" class="sr-only">Password</label>
  <input type="password" name="password" id="inputPassword"
			class="form-control" placeholder="Mot de passe" >
			
  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" value="remember-me"> Se souvenir de moi?
    </label>
  </div>
  <button class="btn btn-lg btn-primary btn-block" type="submit">Connexion</button>
  <p class="mt-5 mb-3 text-muted">&copy; 2019-2020</p>
</form>
</body>
</html>