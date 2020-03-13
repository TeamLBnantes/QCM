<!-- dossier source : inscriptionDesigner -->

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
	<h1>Inscription en tant que "Créateur de QCM"</h1>
	<br>
	<h2>${message}</h2>
	<br>
	
	<div class="templatemo-content-container">
		<div class="templatemo-content-widget white-bg">
		
	<form class="form-signin" action="inscription/designer" method="post">
	<div class="text-center">
	<table class="table ">
		<tr>
			<td colspan="2"><label for="lastname ">Nom : ${user.lastName}</label></td>
		</tr>
		<tr>
			<td colspan="2"><label for="firstName">Prenom : ${user.firstName}</label></td>
		<tr>
			<td><label for="presentation">Presentation</label></td>
			<td><textarea class="form-control" name="presentation" placeholder="Présentez vous"></textarea></td>
		</tr>
		<tr>
			<td><label for="expertise">Expertises</label></td>
			<td><textarea class="form-control" name="expertiseField" placeholder="Liste de vos champs d'expertise" /></textarea></td>
		</tr>
	</table>
	<br />
	<input type="submit" value="Valider" />
	</div>
	</form>	
	</div>
	</div>
</body>
</html>