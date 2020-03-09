<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="tag"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base
	href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/"%>" />

<!-- mise en forme via bootstrap -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,700'
	rel='stylesheet' type='text/css'>
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/templatemo-style.css" rel="stylesheet">

<title>Management Question by Designer</title>
</head>
<body>
	<div class="container">
		<h3>Gestion des Questions</h3>
		<b>
			<p align="right">${sessionScope.user.getFirstName()}
				(<a href="login/out">Déconnexion</a>)
			</p>
		</b><br /> <br />
	</div>



	<!-- Formulaire d'ajout -->
	<!-- Ajouter required pour la validation des champs -->

	<div class="container">

		<form action="ManagementQuestionsDesigner/updateQuestion"
			method="post">

			<div class="templatemo-content col-1 light-gray-bg">
				<div class="templatemo-content-container">
					<div class="templatemo-flex-row flex-content-row">
						<div class="col-1">
							<div
								class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden">
								<i class="fa fa-times"></i>
								<div class="panel-heading templatemo-position-relative">
									<h2 class="text-uppercase">User Table</h2>
								</div>
								<div class="table-responsive">
									<table class="table table-striped table-bordered">




										<c:if test="${question.id!=null}">
											<input type="hidden" name="id" value="${ question.id }" />
										</c:if>
										<tr>
											<td><b>body:</b></td>
											<td><input type="text" name="body"
												placeholder="Text de la question" value="${question.body}"
												required /></td>
										</tr>
										<tr>
											<td><b>Status:</b></td>
											<td><select name="status" id="status">
													<c:forEach items="${ enumStatus }" var="status">
														<option value="${ status }"
															${ question.status == status ? 'selected' : '' }>
															<tag:message code="${ status.libelle }"
																text="${status.libelle }" />
														</option>
													</c:forEach>
											</select></td>
										</tr>

										<tr>
											<td><b>commentPostAnswer:</b></td>
											<td><input type="text" name="commentPostAnswer"
												placeholder="commentPostAnswer"
												value="${question.commentPostAnswer }" width="300px" /></td>
										</tr>


										<!-- </div> -->
										<tr>
											<td><c:if test="${(Response==false)}">
													<button type="submit" class="btn btn-primary" name="action"
														value="valider">Valider</button>
												</c:if></td>
											<td></td>
										</tr>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>

	<br>

	<div class="container">
		<c:if test="${Response==true}">
			<form
				action="ManagementQuestionsDesigner/updateAnswer/${question.id}"
				method="post">
				<input type="hidden" name="id" value="${answer.id}" />

				<div class="templatemo-content col-1 light-gray-bg">
					<div class="templatemo-content-container">
						<div class="templatemo-flex-row flex-content-row">
							<div class="col-1">
								<div
									class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden">
									<i class="fa fa-times"></i>
									<div class="panel-heading templatemo-position-relative">
										<h2 class="text-uppercase">User Table</h2>
									</div>
									<div class="table-responsive">
										<table class="table table-striped table-bordered">






											<div class="container">



												<%-- <input type="hidden" name="idQuestion" value="${ question.id }" /> --%>
											<tr>
												<td><b>body response:</b></td>
												<td><input type="text" name="body"
													placeholder="Text de la reponse" value="${answer.body}"
													required /></td>
											</tr>
											<tr>
												<td><b>expectedAnswer response:</b></td>
												<td><input type="text" name="expectedAnswer"
													placeholder="status de la reponse"
													value="${answer.expectedAnswer}" required /></td>
											</tr>
											<tr>
												<td><b>commentPostAnswer response:</b></td>
												<td><input type="text" name="commentPostAnswer"
													placeholder="comment post answer"
													value="${answer.commentPostAnswer}" required /></td>
											</tr>
											<tr></tr>
											<tr>
												<td><button type="submit" class="btn btn-primary"
														name="action" value="valider">Valider</button></td>
												<td></td>
											</tr>
											



										
										</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
			</form>

		</c:if>
		<c:if test="${(Response==false) && (question.id!=null)}">

			<td><a
				href="ManagementQuestionsDesigner/newResponse/${question.id}"></a>
				<button type="button" class="btn btn-success" name="action"
					value="chercher">Ajouter une reponse</button></td>

		</c:if>
		<br> <br> <br>

	</div>
	<div class="container">
		.................. listes des reponses proposées
		<td>--------------------------</td>






		<div class="templatemo-content col-1 light-gray-bg">
			<div class="templatemo-content-container">
				<div class="templatemo-flex-row flex-content-row">
					<div class="col-1">
						<div
							class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden">
							<i class="fa fa-times"></i>
							<div class="panel-heading templatemo-position-relative">
								<h2 class="text-uppercase">User Table</h2>
							</div>
							<div class="table-responsive">
								<table class="table table-striped table-bordered">




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
											<td>
											<td align="center"><a
												href="ManagementQuestionsDesigner/updateResponse/${question.id}/${answer.id}"><button
														type="button" class="btn btn-success">Modifier</button></a> <a
												href="ManagementQuestionsDesigner/deleteResponse/${question.id}/${answer.id}"><button
														type="button" class="btn btn-danger">Supprimer</button></a></td>
										</tr>

									</c:forEach>

									<!-- <tr><td><button type="submit" class="btn btn-primary" name="action" value="valider">Valider</button></td><td></td></tr> -->

									<!-- </table>
</div>
</form> -->


								</table>
							</div>

						</div>


					</div>
				</div>
			</div>
		</div>
		</div>
		

		<br> <br> <br /> <a href="ManagementQuestionsDesigner">Retour
			à la liste</a> <br />

<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>      <!-- jQuery -->
    <script type="text/javascript" src="js/jquery-migrate-1.2.1.min.js"></script> <!--  jQuery Migrate Plugin -->
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
	<script type="text/javascript" src="js/templatemo-script.js"></script>

</body>
</html>