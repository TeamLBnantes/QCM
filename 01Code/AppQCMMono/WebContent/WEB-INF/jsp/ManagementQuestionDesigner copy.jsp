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



<!-- Formulaire d'ajout --> <!-- Ajouter required pour la validation des champs -->

<div class="container">
<form action="ManagementQuestionsDesigner/updateQuestion" method="post">
<table class="table table-sm">
<c:if test="${question.id!=null}">
	<input type="hidden" name="id" value="${ question.id }" />
</c:if>
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
<tr><td>
<c:if test="${(Response==false)}">
			<button type="submit" class="btn btn-primary" name="action" value="valider">
			Valider</button>
</c:if>			
			</td><td></td></tr>
</table>

</form>
</div>

<div class="container">
<br>
<c:if test="${Response==true}">
<form action="ManagementQuestionsDesigner/updateAnswer/${question.id}" method="post">
<%-- <input type="hidden" name="idQuestion" value="${ question.id }" /> --%>

<input type="hidden" name="id" value="${answer.id}" />

<table class="table table-sm">
<tr><td><b>body response:</b></td><td><input type="text" name="body" placeholder="Text de la reponse" value="${answer.body}" required/></td></tr>
<tr><td><b>expectedAnswer response:</b></td><td><input type="text" name="expectedAnswer" placeholder="status de la reponse" value="${answer.expectedAnswer}" required/></td></tr>
<tr><td><b>commentPostAnswer response:</b></td><td><input type="text" name="commentPostAnswer" placeholder="comment post answer" value="${answer.commentPostAnswer}" required/></td></tr>
<tr></tr>
<tr><td><button type="submit" class="btn btn-primary" name="action" value="valider">Valider</button></td><td></td></tr>
</table>
</form>

</c:if>
<c:if test="${(Response==false) && (question.id!=null)}">

<td><a href="ManagementQuestionsDesigner/newResponse/${question.id}">
<button type="button" class="btn btn-success" name="action" value="chercher">Ajouter une reponse</button></td>

</c:if>
<br><br><br>

</div>
<div class="container">
.................. listes des reponses proposées
<td>     --------------------------  </td>
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
<td><td align="center"><a href="ManagementQuestionsDesigner/updateResponse/${question.id}/${answer.id}"><button type="button" class="btn btn-success">Modifier</button></a>  
<a href="ManagementQuestionsDesigner/deleteResponse/${question.id}/${answer.id}"><button type="button" class="btn btn-danger">Supprimer</button></a></td>
</tr>

</c:forEach>

<!-- <tr><td><button type="submit" class="btn btn-primary" name="action" value="valider">Valider</button></td><td></td></tr> -->

<!-- </table>
</div>
</form> -->

</div>
</table>

<br>
<br>

<br/>
	<a href="ManagementQuestionsDesigner">Retour à la liste</a>
<br/>

</body>
</html>