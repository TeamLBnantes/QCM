<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="tag" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base
	href="<%=request.getScheme() + "://"
			+ request.getServerName() + ":"
			+ request.getServerPort()
			+ request.getContextPath() + "/"
			%>" />
			
<!-- mise en forme via bootstrap -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>Management Question by Designer</title>
</head>
<body>
<div class="container">
<h3>Gestion des Questions</h3> <b><p align="right">${sessionScope.user.getFirstName()} (<a href="login/out">Déconnexion</a>)</p></b><br /><br />
</div>

<!-- Formulaire de recherche -->

<div class="container">
<form action="ManagementQuestionsDesigner/search" method="post">
<table>
<tr>
<td>Mot clé: </td>
<td><input type="text" name="motCle" /></td>
<td><button type="submit" class="btn btn-dark" name="action" value="chercher">Chercher</button></td>
</tr>
</table>
</form>
</div><br /><br />

<!-- Formulaire d'ajout --> <!-- Ajouter required pour la validation des champs -->

<div class="container">
<form action="ManagementQuestionsDesigner/new" method="post">
<table class="table table-sm">
<tr><td><b>body:</b></td><td><input type="text" name="body" placeholder="Text de la question" value="${question.body}" required/></td></tr>
<tr>
	<td>
		<b>Status:</b></td>
	<td>
		<select name="status" id="status" >
			<c:forEach items="${ enumStatus }" var="status">
				<option value="${ status }" ${ question.status == status ? 'selected' : '' } >
					<tag:message code="${ status.libelle }" text="${status.libelle }" />
				</option>
			</c:forEach>
		</select>
	</td>
</tr>

<tr><td><b>commentPostAnswer:</b></td><td><input type="text" name="commentPostAnswer" placeholder="commentPostAnswer" value="${question.commentPostAnswer }" width="300px"/></td></tr>

</table>

<!-- </div> -->



listes des reonses proposées
<div class="container">
<table class="table">
 <thead class="thead-yellow">
	<tr>
	<th scope="col">ok</th>
	<th scope="col">body</th>
	<th scope="col">commentPostAnswer</th>
	<th scope="col">opérations</th>
	</tr>
<c:forEach var="answer" items="${question.answers}">
<!-- parcours des reponses liées à cette questions pour les afficher-->
<tr>
<td>${answer.expectedAnswer}</td>
<td>${answer.body}</td>
<td>${answer.commentPostAnswer}</td>
<td align="center"><a href="produits?action=moins&ref=${produit.reference}"> < </a>${produit.quantite}<a href="produits?action=plus&ref=${produit.reference}"> > </a></td>
<td><a href="produits?action=modifier&ref=${produit.reference}"><button type="button" class="btn btn-success">Modifier</button></a>  <a href="produits?action=supprimer&ref=${produit.reference}"><button type="button" class="btn btn-danger">Supprimer</button></a></td>
</tr>

</c:forEach>

<tr><td><button type="submit" class="btn btn-primary" name="action" value="valider">Valider</button></td><td></td></tr>

</table>
</div>
</form>

</div>


<br>
<br>

<!-- Formulaire d'affichage des produits -->

<div class="container">
<table class="table">
 <thead class="thead-dark">
<tr>
<th scope="col">body</th>
<th scope="col">status</th>
<th scope="col">theme</th>
<th scope="col">commentPostAnswer</th>
<th scope="col">help</th>
</tr>
</thead>
<c:forEach var="question" items="${questions}">
<tr>
<td>${question.body}</td>
<td>${question.Status}</td>
<td>${question.theme}</td>
<td align="center"><a href="produits?action=moins&ref=${produit.reference}"> < </a>${produit.quantite}<a href="produits?action=plus&ref=${produit.reference}"> > </a></td>
<td><a href="produits?action=modifier&ref=${produit.reference}"><button type="button" class="btn btn-success">Modifier</button></a>  <a href="produits?action=supprimer&ref=${produit.reference}"><button type="button" class="btn btn-danger">Supprimer</button></a></td>
</tr>
</c:forEach>
</table>

</div>


</body>
</html>