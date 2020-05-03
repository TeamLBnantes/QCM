
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

/* pour le texte sur l'image, tmp' */
.container {
	position: relative;
}

.center {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	font-size: 24px;
	color: red;
}

/* fin pour le texte sur l'image, tmp' */
</style>

<script src="resources/media/lib/jquery-3.3.1.min.js"></script>
<script src="resources/media/lib/fancybox/dist/jquery.fancybox.min.js"></script>
</head>

<!-- j'ai ajoute les lignes ci-dessus pour integration des video -->


<!-- Dossier source : PasserMCQ.jsp -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- debut de la zone du tableau -->


<!-- debut zone formmulaire -->


<div class="templatemo-content-widget white-bg">

	Intitulé du formulaire : <h3> ${mcq.body }</h3>
	<a href=""
		onclick="open('MailEngine/fromQCM/${mcq.id}', 'Popup', 'scrollbars=1,resizable=1,height=550,width=870'); return false;">Signaler
		(vers Admin) ou échanger avec le concepteur du QCM</a>
	<!-- fin tableau affichage des questions dispo-->
	<br>

<c:if test="${tarckMcq.etape !='beforeMCQ'}">   <!-- affichage multimedia qcm seulement lorsqu'il est lancé à cet endroit -->
	<!-- ajout lien contenu media qcm tout au lon du qcm -->
										<c:if test="${mcq.multimedia.typeMultimedia=='video'}">						
										<a data-fancybox data-width="640" data-height="360"
											href="${mcq.multimedia.adresseCible}">
											revoir la vidéo liée au Formulaire : ${mcq.multimedia.legende}
										</a>
										</c:if>
										<c:if test="${mcq.multimedia.typeMultimedia=='audio'}"> 
											Ré-ecouter l'audio lié au Formulaire : ${mcq.multimedia.legende}
										<!--code pour affichage audi  -->
										<div class="audio-section">
										
											<audio controls>
												<source src="${mcq.multimedia.adresseCible}"
													type="audio/mpeg">
											</audio>
										</div>
										</c:if>
	
	<!-- fin ajoutr lien edia qcm -->
	</c:if> 
	
	 <br>


	<!-- ############################################################### beforeMCQ #######################################################################################  -->
	<c:if test="${tarckMcq.etape =='beforeMCQ'}">
		<!-- affichage de la page de présentation du qcm, avec le bouton pour le lancer -->


		<br>
		<br>
		<h2>
			Ce QCM
			<c:if test="${fn:length(mcq.theme) !=0}">
           		qui porte donc sur les themes { ${mcq.theme } }
           		</c:if>
			comporte ${tarckMcq.nbQuestionsTotal } questions.
			<p>Attention, si vous quittez la page en cours, vous ne pourrez
				pas revenir en arriere, il faudra reprendre du début.</p>
			
			<c:if test="${(mcq.multimedia.typeMultimedia=='audio')||(mcq.multimedia.typeMultimedia=='video')}">	
			<p>Un contenu Multimédia est proposé pour ce QCM, il est conseillé de le parcourir avant de se lancer ;-)
			</p>
			</c:if>
			
			C'est parti quand vous voulez .... ;-)
		</h2>

		<br>
		<!--  positionnement contenu multimedia MCQ-->
		
								<div align="center">
									<c:if test="${mcq.multimedia.typeMultimedia=='image'}">
										<figure>
											<a class="d-block mb-4" data-fancybox="images"
												href="${mcq.multimedia.adresseCible}" data-width="1200px">
												<img class="img-fluid" src="${mcq.multimedia.adresseCible}"
												width="240px" align="center" /> <!-- height="180px"  -->
											</a>
											<figcaption>
												<h6>${mcq.multimedia.legende}</h6>
												<a href="${mcq.multimedia.adresseCible}"></a>
											</figcaption>
										</figure>
									</c:if>
									<c:if test="${mcq.multimedia.typeMultimedia=='audio'}">
										<figure>
											<a class="d-block mb-4" data-fancybox="images"
												href="${mcq.multimedia.adresseVignette}" data-width="2400">
												<img class="img-fluid"
												src="${mcq.multimedia.adresseVignette}" width="240px"
												align="center" /> <!-- height="180px"  -->
											</a>
											<figcaption>
												<h6>${mcq.multimedia.legende}</h6>
												<a href="${mcq.multimedia.adresseVignette}"></a>
											</figcaption>
										</figure>
										<!--code pour affichage audi  -->
										<div class="audio-section" align="center">
											<audio controls>
												<source src="${mcq.multimedia.adresseCible}"
													type="audio/mpeg">
											</audio>
										</div>
										<!--  fin-code pour affichage audi  -->
									</c:if>
									<c:if test="${mcq.multimedia.typeMultimedia=='video'}">
										<a data-fancybox data-width="640" data-height="360"
											href="${mcq.multimedia.adresseCible}"> <img
											src="${mcq.multimedia.adresseVignette}" alt="" width="320px"
											height="180px" align="center" />
											<div class="center">Lire la video</div>
											<p align="center">${mcq.multimedia.legende}</p>
										</a>
									</c:if>
								</div>
							
		<!-- fin positionnement contenu multimedia MCQ -->
		<br>

		<div class="form-group text-center">
			<form action="passerQCM/next" class="templatemo-login-form"
				method="post">
				<button type="submit" class="templatemo-blue-button" name="action"
					value="chercher">Lancer le QCM</button>
			</form>
		</div>
	</c:if>
	<!-- ############################################################### affichage de la question #######################################################################################  -->
	<c:if test="${tarckMcq.etape=='question'}">

		<br />
		<br />
		<p>Question :</p>
		<h1>${question.body}</h1>
		<br />
									<div align="center">
		
			<c:if test="${question.multimedia.typeMultimedia =='image'}">
			<figure>
				<a class="d-block mb-4" data-fancybox="images"
					href="${question.multimedia.adresseCible}" data-width="1200px">
					<img class="img-fluid" src="${question.multimedia.adresseCible}"
					width="240px" align="center" />
				</a>
				<figcaption>
					<h6>${question.multimedia.legende}</h6>
					<a href="${question.multimedia.adresseCible}"></a>
				</figcaption>
			</figure>
		</c:if>
		<c:if test="${question.multimedia.typeMultimedia =='audio'}">
			<figure>
				<a class="d-block mb-4" data-fancybox="images"
					href="${question.multimedia.adresseVignette}" data-width="2400">
					<img class="img-fluid" src="${question.multimedia.adresseVignette}"
					width="240px" align="center" />
				</a>
				<figcaption>
					<h6>${question.multimedia.legende}</h6>
					<a href="${question.multimedia.adresseVignette}"></a>
				</figcaption>
			</figure>
			<div class="audio-section" align="center">
				<audio controls>
					<source src="${question.multimedia.adresseCible}" type="audio/mpeg">
					Your browser does not support the audio element.
				</audio>
			</div>
		</c:if>
		<c:if test="${question.multimedia.typeMultimedia=='video'}">
			<a data-fancybox data-width="640" data-height="360"
				href="${question.multimedia.adresseCible}"> <img
				src="${question.multimedia.adresseVignette}" alt="" width="320px"
				height="180px" align="center" />
				<div class="center">Lire la video</div>
				<p align="center">${question.multimedia.legende}</p>
			</a>
		</c:if>
</div>

<br />
<!-- affichage de la question, avec ces réponses il faudra donc mettre ici un formulair epour recupèrer le resultat-->
<form action="passerQCM/next" class="templatemo-login-form"
	method="post">
	<div class="templatemo-content-widget no-padding">
		<div class="panel panel-default table-responsive">
			<table
				class="table table-striped table-bordered templatemo-user-table">
				<thead>
					<tr>

						<td width="30px">Vrai</td>
						<td>Réponse</td>

					</tr>
				</thead>
				<tbody>
					<c:set var="count" value="0" scope="page" />
					<c:forEach var="answer" items="${question.answers}">
						<tr>

							<td>
								<!-- td de la case à cocher --> <input type="hidden"
								name="reponsesUser[${count}].idRepCor" value="${answer.id}">
								<input type="checkbox" name="reponsesUser[${count}].repUser"
								id="${answer.id}" value="true"> <label
								for="${answer.id}" class="font-weight-400"><span></span></label>
								<c:set var="count" value="${count + 1}" scope="page" />
							</td>
							<td>${answer.body}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div class="form-group text-center">

		<button type="submit" class="templatemo-blue-button " name="action"
			value="chercher">Corriger</button>
</form>
</div>

</c:if>
<!-- ############################################################### affichage de la Correction de la question #######################################################################################  -->

<c:if test="${tarckMcq.etape=='correction'}">
	<!-- affichage de la correction de la question précédente-->
	<c:if test="${bonnesReponses}">
		<h3>C'est une bonne réponse</h3>
	</c:if>
	<c:if test="${!bonnesReponses}">
		<h3>oups,il y a erreur</h3>
	</c:if>

	<br />
	<br />
	<p>Question :</p>
	<h1>${question.body}</h1>
	<br />
	
							<div align="center">
								<c:if test="${question.multimedia.typeMultimedia =='image'}">
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
								<c:if test="${question.multimedia.typeMultimedia =='audio'}">
									<figure>
										<a class="d-block mb-4" data-fancybox="images"
											href="${question.multimedia.adresseVignette}"
											data-width="2400"> <img class="img-fluid"
											src="${question.multimedia.adresseVignette}" width="240px"
											align="center" />
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
								<c:if test="${question.multimedia.typeMultimedia=='video'}">
									<a data-fancybox data-width="640" data-height="360"
										href="${question.multimedia.adresseCible}"> <img
										src="${question.multimedia.adresseVignette}" alt=""
										width="320px" height="180px" align="center" />
										<div class="center">Lire la video</div>
										<p align="center">${question.multimedia.legende}</p>
									</a>
								</c:if>
							</div>
						
	<br />
	${question.commentPostAnswer}
	<form action="passerQCM/next" class="templatemo-login-form"
		method="post">
		<div class="templatemo-content-widget no-padding">
			<div class="panel panel-default table-responsive">
				<table
					class="table table-striped table-bordered templatemo-user-table">
					<thead>
						<tr>
							<td width="30px">Erreur</td>
							<td width="30px">Vrai</td>
							<td>Reponse</td>
							<td>Commentaire de la réponse</td>

						</tr>
					</thead>
					<tbody>

						<c:forEach var="answer" items="${question.answers}">
							<tr>
								<c:forEach var="reponse" items="${repsUserCOrrigees}">
									<c:if test="${answer.id==reponse.idRepCor}">
										<td><c:if test="${!reponse.asDesigner}"> 
                  	    			ici ->
                  	    		</c:if></td>
										<td>
											<!-- td de la case à cocher --> <c:if
												test="${reponse.repUser}">
												<input type="checkbox" name="${reponses.repUser}"
													id="${answer.id}" value="true" checked disabled>
											</c:if> <c:if test="${!reponse.repUser}">
												<input type="checkbox" name="${reponses.repUser}"
													id="${answer.id}" value="true" disabled>
											</c:if> <label for="${answer.id}" class="font-weight-400"><span></span></label>
										</td>
									</c:if>
								</c:forEach>
								<td>${answer.body}</td>
								<td>${answer.commentPostAnswer}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<br /> <a href=""
			onclick="open('MailEngine/${mcq.id}/questionFromQCM/${question.id}', 'Popup', 'scrollbars=1,resizable=1,height=600,width=870'); return false;">Signaler
			(vers Admin) ou échanger avec le concepteur de la Question</a> <br /> <br />
		<p>Nombre de questions dans le QCM : ${tarckMcq.nbQuestionsTotal }
		</p>
		<p>Nombre de question(s) passée(s) : ${tarckMcq.nbQuestionsPassed }
		</p>
		<p>Nombre de bonne(s) réponse(s) : ${tarckMcq.nbBonnesReponses }</p>
		<p>Il reste ${tarckMcq.nbQuestionsTotal -  tarckMcq.nbQuestionsPassed  }
			question(s) dans ce QCM</p>
		<br /> <br />
		<div class="form-group text-center">
			<form action="passerQCM/next" class="templatemo-login-form"
				method="post">
				<button type="submit" class="templatemo-blue-button" name="action"
					value="chercher">

					<c:if
						test="${tarckMcq.nbQuestionsTotal -  tarckMcq.nbQuestionsPassed==0}"> 
           				Terminer
           				</c:if>
					<c:if
						test="${tarckMcq.nbQuestionsTotal -  tarckMcq.nbQuestionsPassed!=0}"> 
           				Question Suivante
           				</c:if>
				</button>
			</form>
		</div>
</c:if>

<!-- ############################################################### affichage de la Cloture de qcm #######################################################################################  -->

<c:if test="${tarckMcq.etape=='endMCQ'}">
	<!-- affichage de page de cloture de ce QCM, avec les résultats, un lien pour envoyer un message au concepteur du QCM-->

	<p>Nombre de questions dans le QCM : ${tarckMcq.nbQuestionsTotal }
	</p>
	<p>Nombre de question(s) passée(s) : ${tarckMcq.nbQuestionsPassed }
	</p>
	<p>Nombre de bonne(s) réponse(s) : ${tarckMcq.nbBonnesReponses }</p>

	<p>Commentaire du QCM : ${question.commentPostAnswer }</p>
	<br />
	<br />
	<br />
	<a href="passerQCM">Retour à la liste des QCM</a>
</c:if>


</div>
<!-- fin de la zone formulaire -->


<!-- debut de la zone du tableau -->

<div>

	<br />
</div>

<
<footer class="text-right">
	<p>Copyright &copy; 2020 QuizizSkillz | Design: Template Mo</p>
</footer>