
<!DOCTYPE html>
<html dir="ltr" lang="fr-FR">
<head>
<meta name="description"/>
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



<div class="templatemo-content-widget white-bg">
	<h2 class="margin-bottom-10">Informations sur le QCM</h2>
	<form action="ManagementMCQDesigner/${mcq.id}"
		class="templatemo-login-form" method="post" accept-charset="UTF-8">
		<!-- enctype="multipart/form-data" -->
		<input type="hidden" name="id" value="${mcq.id}" />
		<div class="row form-group">
			<div class="col-lg-6 col-md-6 form-group">
				<label for="inputBody">Intitulé</label>
				<textarea class="form-control" name="body"
					placeholder="presentation QCM">${mcq.body}</textarea>
			</div>
			<div class="col-lg-6 col-md-6 form-group">
				<label for="inputTheme">Theme(s)</label> <input type="text"
					class="form-control" name="topic" id="inputTheme"
					placeholder="Theme du QCM" value="${mcq.topic}">
			</div>
		</div>
		<div class="row form-group">
			<div class="col-lg-6 col-md-6 form-group">
				<label for="inputUsername">Statut</label> <select
					class="form-control" name="status" id="status">
					<c:forEach items="${ enumStatus }" var="status">
						<option value="${ status }"
							${ mcq.status == status ? 'selected' : '' }>
							<tag:message code="${ status.libelle }" text="${status.libelle }" />
						</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-lg-6 col-md-6 form-group">
				<label for="inputEmail">Créé le </label> ${ mcq.createDate} <br />
				<label for="inputEmail">Derniere modification </label> ${ mcq.editDate}
			</div>
		</div>
		<br />
		<!--  zone multimedia -->
		<div class="row form-group">
			<div class="col-lg-6 col-md-6 form-group">
					<div class="album py-5 bg-light">
						<div class="container">
							<div class="row">
								<div class="col-md-4">
									<div class="card mb-4 shadow-sm">
										<div align="center">
											<c:if test="${mcq.multimedia.typeMultimedia=='image'}">
											<figure>
												<a class="d-block mb-4" data-fancybox="images"
													href="${mcq.multimedia.adresseCible}" data-width="1200px">
													<img class="img-fluid"
													src="${mcq.multimedia.adresseCible}" width="240px"
													align="center" /> <!-- height="180px"  -->
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
													Your browser does not support the audio element.
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
												<p align="center">${mcq.multimedia.legende}</p> <!-- <img class="thumb" src="resources/media/kayak.jpg" alt="" /> -->
											</a>
											</c:if>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

			</div>
			<!-- fin de l'affichage de la zone multimedia -->
			<br/>
			<div class="col-12 form-group row">
			<div class="col-lg-6 col-md-6 form-group">
			<table>
				<!-- div pour les attributs champs media -->
				<!-- enum du typ emultimedia -->
				<tr>
					<td><b>Type Multimedia:</b></td>
					<td><select class="form-control"
						name="multimedia.typeMultimedia" id="typeMultimedia">
							<c:forEach items="${ enumTypeMultimedia }" var="typeMultimedia">
								<option value="${ typeMultimedia }"
									${ mcq.multimedia.typeMultimedia == typeMultimedia ? 'selected' : '' }>
									<tag:message code="${ typeMultimedia.libelle }"
										text="${typeMultimedia.libelle }" />
								</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td><b>cible (jpg) Vignette du contenu
							multimedia (audio/video)</b></td>
					<td><input type="text" class="form-control"
						name="multimedia.adresseVignette" placeholder="adresse image"
						value="${mcq.multimedia.adresseVignette}" /></td>
				</tr>
				<tr>
					<td><b>cible du contenu multimedia</b></td>
					<td><input type="text" class="form-control"
						name="multimedia.adresseCible" placeholder="cible multimedia"
						value="${mcq.multimedia.adresseCible}" /></td>
				</tr>
				<tr>
					<td><b>legende du contenu multimedia</b></td>
					<td><input type="text" class="form-control"
						name="multimedia.legende" placeholder="legende"
						value="${mcq.multimedia.legende}" /></td>
				</tr>
				</table>
			</div>
			</div>
			<!-- div pour les champs media -->


	</div>

			<div class="form-group text-right">
				<button type="submit" class="templatemo-blue-button">Mise à
					jour</button>
				<button type="reset" class="templatemo-white-button">Retour
					à l'état précédent</button>
			</div>
	</form>
</div>

<!-- fin de la zone formulaire -->


<!-- debut de la zone du tableau -->
<div class="templatemo-content-widget white-bg">
	<form action="ManagementMCQDesigner/${mcq.id}/questions"
		class="templatemo-login-form" method="get">
		<input type="hidden" name="id" value="${mcq.id}" />
		<div class="form-group text-center">
			<button type="submit" class="templatemo-blue-button">Ajouter
				/ Supprimer des Questions</button>
		</div>
	</form>
	<div class="templatemo-content-widget no-padding">
		<div class="panel panel-default table-responsive">
			<table
				class="table table-striped table-bordered templatemo-user-table">
				<thead>
					<tr>
						<td width="3%" class="white-text templatemo-sort-by">#</td>
						<td width="80%" class="white-text templatemo-sort-by">Question
						</td>
						<td width="10%" class="white-text templatemo-sort-by">Theme</td>
						<td width="7%">Visualiser</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="question" items="${questions}" varStatus="countQuestion">
						<tr>
							<td>${question.id}</td>
							<td>${question.body}</td>
							<td>${question.topic}</td>
<!-- 							<td><a href="" class="templatemo-edit-btn"><i -->
<!-- 									class="fa fa-edit"></i></a></td> -->
							<td>
							
								<!-- debut  affichage bouton detail d'une question et fenetre mode Fanzybox -###########################################################################################-->
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
															<td><c:if test="${answer.expectedAnswer}">
										<i class="fa fa-check"></i>
									</c:if> <c:if test="${!answer.expectedAnswer}">
										<i class="fa fa-times-circle" style="color: #ff4a4a"></i>
									</c:if></td>
														</tr>
														<tr>
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
									<c:if test="${question.designer.user.id==user.id}">
										<br />
										<h3>Vous êtes le propriétaire de cette question</h3>
									</c:if>
									<c:if test="${question.designer.user.id!=user.id}">   <!-- ce n'est pas une question de l'utilisateur actuel -->
										
										<br />C'est question est gèrée par : 
            							<h3 align="center">
											${question.designer.user.firstName}
											${question.designer.user.lastName}</h3>
										<br />
										<p class="mb-0 text-center">
												<a href=""  onclick="open('MailEngine/questionFromGestion/${question.id}', 'Popup', 'scrollbars=1,resizable=1,height=550,width=870'); return false;" >Signaler ou Envoyer un mail</a>
										</p>
									
										
									</c:if>
									<br />

									<p class="mb-0 text-right">
										<input data-fancybox-close type="button"
											class="templatemo-edit-btn" value="Fermer" />
										<!--  -->
									</p>
								</form> 
			<!-- fin affichage bouton detail d'une question et fenetre mode Fanzybox#############################################################################"--> 
							
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- fin de la zone du tableau -->
	<form action="ManagementMCQDesigner" class="templatemo-login-form"
		method="get">
		<input type="hidden" name="id" value="${mcq.id}" />
		<div class="form-group text-right">
			<button type="submit" class="templatemo-blue-button">Retour
				à la liste des QCM</button>
		</div>
	</form>
</div>

<footer class="text-right">
	<p>Copyright &copy; 2020 QuizizSkillz | Design: Template Mo</p>
</footer>