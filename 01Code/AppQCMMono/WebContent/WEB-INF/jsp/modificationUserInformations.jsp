<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulaire d'Inscription</title>
<base
	href="<%=request.getScheme() + "://"
			+ request.getServerName() + ":"
			+ request.getServerPort()
			+ request.getContextPath() + "/"
			%>" />
</head>
<body>
	
	<h1>MODIFICATION INFORMATIONS PERSONNELLES</h1>
	<br>
	<h2></h2>
	<br>
	<form class="" action="modificationUserInformations/update" method="post">
	<input type="hidden" name="id" value="${ user.id }" />
	<table>
		<tr>
			<td><label for="lastname">Nom</label></td>
			<td><input type="text" name="lastName" value="${sessionScope.user.lastName}"/></td>
		</tr>
		<tr>
			<td><label for="firstName">Prenom</label></td>
			<td><input type="text" name="firstName" value="${sessionScope.user.firstName}"/></td>
		</tr>
		<tr>
			<td><label for="email">Email</label></td>
			<td><input type="email" name="email" value="${sessionScope.user.email }" /></td>
		</tr>
		<tr>
			<td><label for="lastname">Login</label></td>
			<td><input type="text" name="login" value="${sessionScope.user.email}" /></td>
		</tr>
		<tr>
			<td><label for="password">Mot de passe</label></td>
			<td><input type="password" name="password" value="${sessionScope.user.password }" /></td>
			</tr>
	</table>
	<br />
	<input type="submit" value="Mettre à jour" />
	</form>	
</body>
</html>