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
	<h1>INSCRIPTION</h1>
	<form class="form-signin" action="inscription" method="post">
	<table>
		<tr>
			<td><label for="lastname">Nom</label></td>
			<td><input type="text" name="lastname" /></td>
		</tr>
		<tr>
			<td><label for="firstName">Prenom</label></td>
			<td><input type="text" name="firstName" /></td>
		</tr>
		<tr>
			<td><label for="email">Email (Sera utilisé pour comme login)</label></td>
			<td><input type="email" name="email" /></td>
		</tr>
		<tr>
			<td><label for="lastname">Login</label></td>
			<td><input type="text" name="login" /></td>
		</tr>
		<tr>
			<td><label for="password">Mot de passe</label></td>
			<td><input type="password" name="password" /></td>
		</tr>
	</table>
	<br />
	<input type="submit" value="Valider" />
	</form>	
</body>
</html>