<!-- dossier source : ManagementQuestionDesigner.jsp  -->
<!-- param pour fancybox -->

<!DOCTYPE html>
<html dir="ltr" lang="fr-FR">
<head>
<meta name="keywords" content="mots, clefs" />
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">


<link href="resources/media/lib/fancybox/dist/jquery.fancybox.min.css"
	rel="stylesheet">
<!-- <link href="resources/media/lib/bootstrap-4.4.1-dist/css/bootstrap.min.css" rel="stylesheet"> -->
<style type="text/css">
.thumb {
	width: 100%;
}
</style>

<script src="resources/media/lib/jquery-3.3.1.min.js"></script>
<script src="resources/media/lib/fancybox/dist/jquery.fancybox.min.js"></script>
</head>
<!-- fin param fancybox -->

<body>
	<div class="container">
		<!-- Formulaire d'ajout -->
		<!-- Ajouter required pour la validation des champs -->
		<a href="ManagementQuestionsDesigner">
			<button class="btn btn-primary" value="retour">Retour à la
				liste</button>
		</a> <br />
		<div class="templatemo-content-widget white-bg">
		<c:if test="${Response==true}"><tab><tr><td><button class="templatemo-blue-button" onclick="visibilite(`detailRep`), visibilite(`Detail`)" >Aff./Masq. infos question</button></td>
		<td><span  id="Detail" style="display:''">  <i> ${question.body} </i></span></td> </tr></tab>
		<div id="detailRep" style="display:none">
		</c:if>
			<form id="testformid" action="ManagementQuestionsDesigner/updateQuestion"
				method="post">
				<!-- <div class="templatemo-content col-1 light-gray-bg"> -->
				<div class="templatemo-content-container">
					<h2 class="text-uppercase">Créer/éditer une question</h2>
					<div class="table-responsive">
						<table class="table table-striped table-bordered">
							<c:if test="${question.id!=null}">
								<input type="hidden" name="id" value="${ question.id }" />
							</c:if>
							<tr>
								<td><b>Intitulé   </b></td>
<%-- 								<td><textarea class="form-control" name="body"
										placeholder="Texte de la question. Requis" required > ${question.body}</textarea></td> --%>
								<td><textarea class="form-control" form ="testformid" name="body"
										placeholder="Texte de la question. Requis" required <c:if test="${Response==true}">disabled </c:if>>${question.body}</textarea></td>		
							</tr>
							<tr>
								<td><b>Statut</b></td>
								<td><select class="form-control" name="status" id="status" <c:if test="${Response==true}">disabled </c:if>>
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
								<td><b>Theme(s)</b></td>
								<td><textarea class="form-control" name="topic"
										placeholder="theme(s)" rows="1" <c:if test="${Response==true}">disabled </c:if>>${question.topic }</textarea></td>
							</tr>
							<tr>
								<td><b>Commentaire</b></td>
								<td><textarea class="form-control" name="commentPostAnswer"
										placeholder="Expliquez pourquoi chaque réponse est vraie ou fausse. Affiché après avoir répondu." <c:if test="${Response==true}">disabled </c:if>>${question.commentPostAnswer }</textarea></td>
							</tr>
							<!--  zone multimedia -->


						</table>
						
						<c:if test="${question.id!=null}">	
						<input type="hidden" name="id" value="${question.multimedia.id}" />
						<div class="row form-group">
							<div class="col-lg-6 col-md-6 form-group">
								<div class="album py-5 bg-light">
									<div class="container">
										<div class="row">
											<div class="col-md-4">
												<div class="card mb-4 shadow-sm">
													<div align="center">
														<c:if
															test="${question.multimedia.typeMultimedia =='image'}">
															<figure>
																<a class="d-block mb-4" data-fancybox="images"
																	href="${question.multimedia.adresseCible}"
																	data-width="1200px"> <img class="img-fluid"
																	src="${question.multimedia.adresseCible}" width="240px"
																	align="center" /> 
																</a>
																<figcaption>
																	<h6>${question.multimedia.legende}</h6>
																	<a href="${question.multimedia.adresseCible}"></a>
																</figcaption>
															</figure>
														</c:if>
														<c:if
															test="${question.multimedia.typeMultimedia =='audio'}">
															<figure>
																<a class="d-block mb-4" data-fancybox="images"
																	href="${question.multimedia.adresseVignette}"
																	data-width="2400"> <img class="img-fluid"
																	src="${question.multimedia.adresseVignette}"
																	width="240px" align="center" /> 
																</a>
																<figcaption>
																	<h6>${question.multimedia.legende}</h6>
																	<a href="${question.multimedia.adresseVignette}"></a>
																</figcaption>
															</figure>
															<div class="audio-section" align="center">
																<audio controls>
																	<source src="${question.multimedia.adresseCible}"
																		type="audio/mpeg">
																	Your browser does not support the audio element.
																</audio>
															</div>
														</c:if>
														<c:if
															test="${question.multimedia.typeMultimedia=='video'}">
															<a data-fancybox data-width="640" data-height="360"
																href="${question.multimedia.adresseCible}"> <img
																src="${question.multimedia.adresseVignette}" alt=""
																width="320px" height="180px" align="center" />
																<div class="center">Lire la video</div>
																<p align="center">${question.multimedia.legende}</p>
															</a>
														</c:if>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 form-group">
								
								<table>
									<tr>
										<td><b>Type Multimedia:</b></td>
										<td><select class="form-control"
											name="multimedia.typeMultimedia" id="typeMultimedia" <c:if test="${Response==true}">disabled </c:if>>
												<c:forEach items="${ enumTypeMultimedia }"
													var="typeMultimedia">
													<option value="${ typeMultimedia }"
														${ question.multimedia.typeMultimedia == typeMultimedia ? 'selected' : '' }>
														<tag:message code="${ typeMultimedia.libelle }"
															text="${typeMultimedia.libelle }" />
													</option>
												</c:forEach>
										</select></td>
									</tr>
									<tr>
										<td><b>cible (jpg) Vignette du contenu multimedia
												(audio/video)</b></td>
										<td><input type="text" class="form-control"
											name="multimedia.adresseVignette" placeholder="adresse image"
											value="${question.multimedia.adresseVignette}" <c:if test="${Response==true}">disabled </c:if>/></td>
									</tr>
									<tr>
										<td><b>cible du contenu multimedia</b></td>
										<td><input type="text" class="form-control"
											name="multimedia.adresseCible" placeholder="cible multimedia"
											value="${question.multimedia.adresseCible}" <c:if test="${Response==true}">disabled </c:if>/></td>
									</tr>
									<tr>
										<td><b>legende du contenu multimedia</b></td>
										<td><input type="text" class="form-control"
											name="multimedia.legende" placeholder="legende"
											value="${question.multimedia.legende}" <c:if test="${Response==true}">disabled </c:if>/></td>
									</tr>
									</div>
								</table>
								<br />
							</div>
						</div>
						</c:if>
						 

					</div>
					<br />
					<c:if test="${Response!=true}">
						<button type="submit" class="btn btn-primary" name="action"
							value="valider">Valider</button>
					</c:if>

			</form>
		  <c:if test="${Response==true}"> </div></c:if>
		</div>
	</div>
	<c:if test="${Response==true}">
		<div class=container >
			<div class="templatemo-content-widget white-bg">

				<form
					action="ManagementQuestionsDesigner/updateAnswer/${question.id}"
					method="post">
					<input type="hidden" name="id" value="${answer.id}" />
					<h2 class="text-uppercase">Ajout / Modification d'une réponse</h2>
					<div class="table-responsive">
						<table class="table table-striped table-bordered">
							<%-- <input type="hidden" name="idQuestion" value="${ question.id }" /> --%>

							<tr>
								<td><b>Réponse:</b></td>
								<td><textarea name="body" class="form-control"
										placeholder="Text de la reponse" required>${answer.body}</textarea></td>
							</tr>
							<tr>
								<td><b>Est -elle vrai?</b></td>
								<td>
									<!-- 
							<input type="checkbox" value="${answer.expectedAnswer}"
								name="expectedAnswer"><label><span></span></label>
 -->
									<div class="templatemo-block margin-bottom-5 text-center">
										<c:if test="${answer.expectedAnswer}">
											<input type="checkbox" name="expectedAnswer" id="c1"
												value="true" checked>
										</c:if>
										<c:if test="${!answer.expectedAnswer}">
											<input type="checkbox" name="expectedAnswer" id="c1"
												value="true">
										</c:if>
										<label for="c1" class="font-weight-400"><span></span>
										</label>
									</div>
								</td>
							</tr>
							<tr>
								<td><b>Commentaire response:</b></td>
								<td><textarea name="commentPostAnswer" class="form-control"
										placeholder="Expliquez pourquoi cette réponse en particulier est vraie ou fausse. Affiché après avoir répondu.">${answer.commentPostAnswer}</textarea></td>
							</tr>
							<tr>
								<td><button type="submit" class="btn btn-primary"
										name="action" value="valider">Valider</button></td>
							</tr>
						</table>
					</div>
				</form>
			</div>
		</div>
	</c:if>
	<div class="container">
		<c:if test="${maxQ}">
			<h3>
				<div class="blue-text">
					<i class="fas fa-exclamation-circle"></i> ${message}
				</div>
			</h3>
		</c:if>
		<c:if test="${(Response==false) && (question.id!=null)}">     
			<c:if test="${!maxQ}">
				<td><a
					href="ManagementQuestionsDesigner/newResponse/${question.id}">
						<button type="button" class="btn btn-primary" name="action"
							value="chercher">Ajouter une reponse</button>
				</a></td>
			</c:if>
         </c:if>
	</div>
	<c:if test="${(question.id!=null)}">    
<%--    <c:if test="${(Response==false) && (question.id!=null)}">   --%>
	<div class="container">
		<div class="templatemo-content-widget white-bg">
			<div class="templatemo-content-container">
				<h2 class="text-uppercase">liste des reponses</h2>
				<div class="table-responsive">
					<table class="table table-bordered">
						<tr>
							<th>Véracité</th>
							<th>Intitulé</th>
							<th>Commentaire</th>
							<c:if test="${(Response==false)}"> 
							<th>Actions</th>
							</c:if>
						</tr>
						<c:forEach var="answer" items="${question.answers}">
							<!-- parcours des reponses liées à cette questions pour les afficher-->
							<tr>								
								<td><c:if test="${answer.expectedAnswer}">
										<i class="fa fa-check"></i>
									</c:if> <c:if test="${!answer.expectedAnswer}">
										<i class="fa fa-times-circle" style="color: #ff4a4a"></i>
									</c:if></td>
								<td>${answer.body}</td>
								<td>${answer.commentPostAnswer}</td>
								<c:if test="${(Response==false)}"> 
								<td align="center">
								<a
									href="ManagementQuestionsDesigner/updateResponse/${question.id}/${answer.id}">
										<button type="button" class="templatemo-blue-button">
											<i class="far fa-edit"></i>
										</button>
								</a> <a
									href="ManagementQuestionsDesigner/deleteResponse/${question.id}/${answer.id}">
										<button type="button" class="templatemo-white-button">
											<i class="far fa-trash-alt" style="color: #ff4a4a"></i>
										</button>
								</a></td>
								</c:if>
							</tr>
						</c:forEach>
						
					</table>
				</div>
			</div>
		</div>
	</div>
		</c:if>



	<br>
	<br>

	<!-- 	liste des MCQ utilisant cette question -->

	<div class="container">
		<div class="templatemo-content-widget white-bg">
			<div class="templatemo-content-container">
				<h2 class="text-uppercase">liste des Formulaires utilisants
					cette Question</h2>
				<div class="table-responsive">
					<table class="table table-bordered">
						<tr>
							<th>Body</th>
						</tr>
						<c:forEach var="mcq" items="${listDto.mcqs}">
							<!-- parcours des reponses liées à cette questions pour les afficher-->
							<tr>
								<td>${mcq.body}</td>
								<%-- 								<td>${liste.designerName}</td> --%>
							</tr>
						</c:forEach>

					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- 	fin liste des MCQ utilisant cette question -->
	<br />


	<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
	<!-- jQuery -->
	<script type="text/javascript" src="js/jquery-migrate-1.2.1.min.js"></script>
	<!--  jQuery Migrate Plugin -->
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
	<script type="text/javascript" src="js/templatemo-script.js"></script>

</body>
<footer class="text-right">
	<p>Copyright &copy; 2020 QuizizSkillz | Design: Template Mo</p>
</footer>
</html>