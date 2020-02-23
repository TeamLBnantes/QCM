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
	<h1>INSCRIPTION Du designer</h1>
	<br>
	<h2>${message}</h2>
	<br>
	<form class="form-signin" action="inscription/designer" method="post">
	<table>
		<tr>
			<td><label for="lastname ">Nom : ${user.lastName}</label></td>
		</tr>
		<tr>
			<td><label for="firstName">Prenom : ${user.firstName}</label></td>
		<tr>
			<td><label for="presentation">Presentation</label></td>
			<td><input type="text" name="presentation" /></td>
		</tr>
		<tr>
			<td><label for="expertise">Expertise</label></td>
			<td><input type="text" name="expertiseField" /></td>
		</tr>
	</table>
	<br />
	<input type="submit" value="Valider" />
	</form>	
</body>
</html>