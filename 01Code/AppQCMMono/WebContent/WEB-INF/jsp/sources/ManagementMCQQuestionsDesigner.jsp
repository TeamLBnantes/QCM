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

<!--dossier source : ManagementMCQQuestionDesigner.jsp  -->
<!-- debut de la zone du tableau -->

<div class="templatemo-content-widget white-bg">
	<h2 class="margin-bottom-10">Questions composant le QCM</h2>
	<div class="templatemo-content-widget no-padding">
		<div class="panel panel-default table-responsive">
			<table
				class="table table-striped table-bordered templatemo-user-table">
				<thead>
					<tr>
						<td width="30px" class="white-text templatemo-sort-by">#</td>
						<td class="white-text templatemo-sort-by">Question</td>
						<td width="100px" class="white-text templatemo-sort-by">Theme</td>

						<td width="30px">Visualiser</td>
						<td width="30px">Détacher</td>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="question" items="${questions}"
						varStatus="countQuestion">
						<tr>
							<td>${question.id}</td>
							<td>${question.body}</td>
							<td>${question.topic}</td>
							<!-- affichage des detail de la question -->
							<td>
								<!-- debut  affichage bouton mode Fanzy -###########################################################################################-->
								<div class="card p-lg-3">
									<div class="card-body">
										<p class="mb-0">
											<a data-fancybox="hello"
												data-src="#hello${countQuestion.count}" href="javascript:;"
												class="templatemo-edit-btn"> détail </a>
										</p>
									</div>
								</div>

								<form id="hello${countQuestion.count}" action="" method="post"
									style="display: none; width: 100%; max-width: 660px;">
									<h4 class="mb-3">Détail de la Question</h4>
									<br />
									<p>
										texte de la Question : <br />
									<h2 class="mb-3">${question.body}</h2>
									<br /> <br /><i> Commentaire apres réponse : <br />
									${question.commentPostAnswer} </i><br /> <br />theme de la Question : <br />
									${question.topic} <br /> <br />
									
									<!--affichage multimedia de la question  -->
						             <c:if test="${question.multimedia.typeMultimedia!='aucun'}">
												<c:if test="${question.multimedia.typeMultimedia=='image'}">
												<div align="center">
											<figure>
													<img 
													src="${question.multimedia.adresseCible}" width="240px"
													align="center" /> <!-- height="180px"  -->
												<figcaption>
													<h6>${question.multimedia.legende}</h6>
												</figcaption>
											</figure>
											</div>
											</c:if>
											<c:if test="${question.multimedia.typeMultimedia=='audio'}">
											<div align="center">
											<figure>
													<img 
													src="${question.multimedia.adresseVignette}" width="240px"
													align="center" /> <!-- height="180px"  -->
												<figcaption>
													<h6>${question.multimedia.legende}</h6>
												</figcaption>
											</figure>
											<!--code pour affichage audi  -->
												<audio controls>
													<source src="${question.multimedia.adresseCible}"
														type="audio/mpeg">
													Your browser does not support the audio element.
												</audio>
											</div>
											<!--  fin-code pour affichage audi  -->
											</c:if>
											<c:if test="${question.multimedia.typeMultimedia=='video'}">
											<div align="center">
												<a data-fancybox data-width="640" data-height="360"
													href="${question.multimedia.adresseCible}"> <img
													src="${question.multimedia.adresseVignette}" alt="" width="320px"
													height="180px" align="center" />
													<div class="center">Lire la video</div>
													<p align="center">${question.multimedia.legende}</p>
												</a>
											</div>
											</c:if>
									</c:if>
									<!-- fin affichage multimedia de la question  -->			
															
									<!--             	###############tableau des reps dans la fancybox########## -->
									<div class="templatemo-content-widget no-padding"> 
										<div class="panel panel-default table-responsive">
											<table
												class="table table-striped table-bordered templatemo-user-table">
												<thead>
													<tr>
														<td width="30px" class="white-text templatemo-sort-by">#
														</td>
														<td class="white-text templatemo-sort-by">Réponses
															proposée</td>
														<td width="100px" class="white-text templatemo-sort-by">Attendue</td>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="answer" items="${question.answers}"
														varStatus="count">
														<tr>
															<td>${count.count}</td>
															<td>${answer.body}</td>
															<td>
										<c:if test="${answer.expectedAnswer}">
										<i class="fa fa-check"></i>
									</c:if> <c:if test="${!answer.expectedAnswer}">
										<i class="fa fa-times-circle" style="color: #ff4a4a"></i>
									</c:if>
									</td>
														</tr>
														<tr>
														<td colspan="3"><i>commentaire après réponse : ${answer.commentPostAnswer}</i></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
									<!--             	###############fi de tableau des reps dans la fancybox################# -->
									</p>
									<br />
									<c:if test="${question.designer.user.id==user.id}">
										<br />
										<h3>Vous êtes le propriétaire de cette question</h3>
									</c:if>
									<c:if test="${question.designer.user.id!=user.id}">
										<br />C'est question est gèrée par : 
            		<h3 align="center">
											${question.designer.user.firstName}
											${question.designer.user.lastName}</h3>
										<br />
										<p class="mb-0 text-center">
								<a href=""  onclick="open('MailEngine/questionFromGestion/${question.id}', 'Popup', 'scrollbars=1,resizable=1,height=560,width=870'); return false;" >Signaler ou Envoyer un mail</a>
										</p>
									</c:if>
									<br />
									
									<p class="mb-0 text-right">
										<input data-fancybox-close type="button"
											class="templatemo-edit-btn" value="Fermer" />
									</p>
								</form> 
			<!-- fin affichage bouton mode Fanzy ######################################################################################"-->  
							</td>
							<!-- fin affichage des detail de la question                     -->
							<td><a
								href="ManagementMCQDesigner/${idMCQ}/sup/${question.id}"
								class="templatemo-edit-btn">Sup</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- fin de la zone du tableau -->
</div>
<!-- debut zone formmulaire -->
<div class="templatemo-content-widget white-bg">
	<h2 class="margin-bottom-10">Rechercher et Sélectionner des
		questions suplémentaires</h2>
	<p>Ce formulaire va servir à filtrer les questions disponibles dans
		le systeme et qui peuvent donc être ajoutées au QCM</p>
	<form action="ManagementMCQDesigner/${idMCQ}/filtres"
		class="templatemo-login-form" method="post">

		<div class="row form-group">
			<div class="col-lg-6 col-md-6 form-group">
				<label for="inputBody">Corps</label> <input type="text"
					class="form-control" name="bodyFiltre"
					placeholder="presentation QCM contient"
					value="${filtresQuestion.bodyFiltre}">

			</div>
			<div class="col-lg-6 col-md-6 form-group">
				<label for="inputTheme">Theme</label> <input type="text"
					class="form-control" name="themeFiltre"
					placeholder="Theme du QCM contient"
					value="${filtresQuestion.themeFiltre}">
			</div>
			<div class="templatemo-block margin-bottom-5 text-center">
				<c:if test="${filtresQuestion.yoursFiltre}">
					<input type="checkbox" name="yoursFiltre" id="c1" value="true"
						checked>
				</c:if>
				<c:if test="${!filtresQuestion.yoursFiltre}">
					<input type="checkbox" name="yoursFiltre" id="c1" value="true">
				</c:if>
				<label for="c1" class="font-weight-400"><span></span>
					Uniquement Vos Questions</label>
			</div>
		</div>

		<div class="form-group text-right">
			<button type="submit" class="templatemo-blue-button">Rechercher</button>
			<button type="reset" class="templatemo-white-button">Vider
				les champs</button>
	</form>
	<!-- un petit form, juste pour le bouton re-init recherche -->
	<form action="ManagementMCQDesigner/${idMCQ}/filtres"
		class="templatemo-login-form" method="post">
		<input type="hidden" class="form-control" name="bodyFiltre" value="">
		<input type="hidden" class="form-control" name="themeFiltre" value="">
		<input type="hidden" class="form-control" name="yoursFiltre"
			value="false">
		<div class="form-group text-left">
			<button type="submit" class="templatemo-blue-button">Re-initialiser
				la liste</button>
		</div>
	</form>
</div>
<!-- tableau affichage des questions dispo-->

<div class="templatemo-content-widget no-padding">
	<!-- enctype="multipart/form-data" -->
	<input type="hidden" name="questionsTrouveesDTO"
		value="${questionsTrouveesDTO}" />
	<div class="panel panel-default table-responsive">
		<table
			class="table table-striped table-bordered templatemo-user-table">
			<thead>
				<tr>
					<td width="30px" class="white-text templatemo-sort-by">#</td>
					<td width="30px">Selection</td>
					<td class="white-text templatemo-sort-by">Question</td>
					<td width="100px" class="white-text templatemo-sort-by">Theme</td>

					<td width="30px">Visualiser</td>


				</tr>
			</thead>
			<tbody>
				<c:forEach var="qDTO" items="${questionsTrouveesDTO}" varStatus="countQuestionDTO">
					<tr>
						<form action="ManagementMCQDesigner/${idMCQ}/addQuestion"
							class="templatemo-login-form" method="post">
							<!-- je fournis les info du filtre pour le retour de la selection d'une question -->
							<input type="hidden" class="form-control" name="bodyFiltre"
								value="${filtresQuestion.bodyFiltre}"> <input
								type="hidden" class="form-control" name="themeFiltre"
								value="${filtresQuestion.themeFiltre}">
							<c:if test="${filtresQuestion.yoursFiltre}">
								<input type="hidden" name="yoursFiltre" value="true">
							</c:if>
							<c:if test="${!filtresQuestion.yoursFiltre}">
								<input type="hidden" name="yoursFiltre" value="false">
							</c:if>
							<!-- info recup par le controleur -->

							<td>${qDTO.question.id}</td>
							<td width="30px">
								<!-- <div class="margin-right-15 templatemo-inline-block">	 -->
								<input type="hidden" name="id" value="${qDTO.question.id}">
								<button type="submit" class="templatemo-edit-btn">selectionner</button>
								<!-- </div> -->
							</td>
						</form>
							<td>${qDTO.question.body}</td>
						<td>${qDTO.question.topic}</td>

						<td>
								<!-- debut  affichage bouton mode Fanzy pour les question à ajouter-########################################################################################### -->
								<div class="card p-lg-3">
									<div class="card-body">
										<p class="mb-0">
											<a data-fancybox="hello"
												data-src="#helloDTO${countQuestionDTO.count}" href="javascript:;"
												class="templatemo-edit-btn"> détail </a>
										</p>
									</div>
								</div>
				
							<form id="helloDTO${countQuestionDTO.count}" action="" method="post" style="display: none; width: 100%; max-width: 660px;">
									<h4 class="mb-3">Détail de la Question</h4>
									<br />
									<p>
										texte de la Question : <br />
									<h2 class="mb-3">${qDTO.question.body}</h2>
									<br /> <br /><i> Commentaire apres réponse : <br />
									${qDTO.question.commentPostAnswer} </i><br /> <br /> theme de la Question : <br />
									${qDTO.question.topic} <br /> <br />
									
									<!--affichage multimedia de la question  -->
						             <c:if test="${qDTO.question.multimedia.typeMultimedia!='aucun'}">
												<c:if test="${qDTO.question.multimedia.typeMultimedia=='image'}">
												<div align="center">
											<figure>
													<img 
													src="${qDTO.question.multimedia.adresseCible}" width="240px"
													align="center" /> <!-- height="180px"  -->
												<figcaption>
													<h6>${qDTO.question.multimedia.legende}</h6>
												</figcaption>
											</figure>
											</div>
											</c:if>
											<c:if test="${qDTO.question.multimedia.typeMultimedia=='audio'}">
											<div align="center">
											<figure>
													<img 
													src="${qDTO.question.multimedia.adresseVignette}" width="240px"
													align="center" /> <!-- height="180px"  -->
												<figcaption>
													<h6>${qDTO.question.multimedia.legende}</h6>
												</figcaption>
											</figure>
											<!--code pour affichage audi  -->
												<audio controls>
													<source src="${qDTO.question.multimedia.adresseCible}"
														type="audio/mpeg">
													Your browser does not support the audio element.
												</audio>
											</div>
											<!--  fin-code pour affichage audi  -->
											</c:if>
											<c:if test="${qDTO.question.multimedia.typeMultimedia=='video'}">
											<div align="center">
												<a data-fancybox data-width="640" data-height="360"
													href="${qDTO.question.multimedia.adresseCible}"> <img
													src="${qDTO.question.multimedia.adresseVignette}" alt="" width="320px"
													height="180px" align="center" />
													<div class="center">Lire la video</div>
													<p align="center">${qDTO.question.multimedia.legende}</p>
												</a>
											</div>
											</c:if>
									</c:if>
									<!-- fin affichage multimedia de la question  -->
									
									<!--             	###############tableau des reps dans la fancybox########## -->
									<div class="templatemo-content-widget no-padding">
										<div class="panel panel-default table-responsive">
											<table
												class="table table-striped table-bordered templatemo-user-table">
												<thead>
													<tr>
														<td width="30px" class="white-text templatemo-sort-by">#
														</td>
														<td class="white-text templatemo-sort-by">Réponses
															proposée</td>
														<td width="100px" class="white-text templatemo-sort-by">Attendue</td>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="answer" items="${qDTO.question.answers}"
														varStatus="count">
														<tr>
															<td>${count.count}</td>
															<td>${answer.body}</td>
															<td>
											<c:if test="${answer.expectedAnswer}">
										<i class="fa fa-check"></i>
									</c:if> <c:if test="${!answer.expectedAnswer}">
										<i class="fa fa-times-circle" style="color: #ff4a4a"></i>
									</c:if></td>
														</tr>														<tr>
														<td colspan="3"><i>commentaire après reponse : ${answer.commentPostAnswer}</i></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
									<!--             	###############fi de tableau des reps dans la fancybox################# -->
									</p>
									<br />
									<c:if test="${qDTO.question.designer.user.id==user.id}">
										<br />
										<h3>Vous êtes le propriétaire de cette question</h3>
									</c:if>
									<c:if test="${qDTO.question.designer.user.id!=user.id}">
										<br />C'est question est gèrée par : 
            		<h3 align="center">
											${qDTO.question.designer.user.firstName}
											${qDTO.question.designer.user.lastName}</h3>
										<br />
										<p class="mb-0 text-center">
	<a href=""  onclick="open('MailEngine/questionFromGestion/${qDTO.question.id}', 'Popup', 'scrollbars=1,resizable=1,height=560,width=870'); return false;" >Signaler ou Envoyer un mail</a>
										</p>
									</c:if>
									<br />
									
									<p class="mb-0 text-right">
										<input data-fancybox-close type="button"
											class="templatemo-edit-btn" value="Fermer" />
									</p>
								</form> <!-- fin affichage bouton mode Fanzy pour les quetion à ajouter ######################################################################################"-->	 				
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<!-- fin tableau affichage des questions dispo-->
	<form action="ManagementMCQDesigner/${idMCQ}"
		class="templatemo-login-form" method="get">
		<div class="form-group text-right">
			<button type="submit" class="templatemo-blue-button">Retour
				au QCM</button>
		</div>
	</form>
</div>
<!-- fin de la zone formulaire -->

<footer class="text-right">
	<p>Copyright &copy; 2020 QuizizSkillz | Design: Template Mo</p>
</footer>