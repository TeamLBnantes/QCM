
<body>
	<div class="container">
		<h3>Gestion des Questions</h3>




		<!-- Formulaire d'ajout -->
		<!-- Ajouter required pour la validation des champs -->

<a href="ManagementQuestionsDesigner">
<button class="btn btn-primary" value="retour">Retour à la liste</button></a>
	<br />

		<div class="templatemo-content-widget white-bg">
			<form action="ManagementQuestionsDesigner/updateQuestion"
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
								<td><b>Intitulé</b></td>
								<td><textarea class="form-control" name="body"
										placeholder="Texte de la question. Requis" required> ${question.body}</textarea></td>
							</tr>
							<tr>
								<td><b>Statut</b></td>
								<td><select class="form-control" name="status" id="status">
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
								<td><b>Thème(s)</b></td>
								<td><textarea class="form-control" name="topic"
										placeholder="theme(s)" rows="1">${question.topic }</textarea></td>
							</tr>
							<tr>
								<td><b>Commentaire</b></td>
								<td><textarea class="form-control" name="commentPostAnswer"
										placeholder="Expliquez pourquoi chaque réponse est vrai ou fausse. Affiché après avoir répondu.">${question.commentPostAnswer }</textarea></td>
							</tr>

							<!-- </div> -->
						</table>
						<br />
					</div>
				</div>
				<c:if test="${Response!=true}">
					<button type="submit" class="btn btn-primary" name="action"
						value="valider">Valider</button>
				</c:if>
			</form>
		</div>
	</div>
	<c:if test="${Response==true}">
		<div class="templatemo-content-widget white-bg">

			<form
				action="ManagementQuestionsDesigner/updateAnswer/${question.id}"
				method="post">
				<input type="hidden" name="id" value="${answer.id}" />
				<h2 class="text-uppercase">User Table</h2>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<%-- <input type="hidden" name="idQuestion" value="${ question.id }" /> --%>

						<tr>
							<td><b>Réponse:</b></td>
							<td><textarea name="body" class="form-control"
									placeholder="Text de la reponse" required>${answer.body}</textarea></td>
						</tr>
						<tr>
							<td><b>est -elle vrai?</b></td>
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
									<label for="c1" class="font-weight-400"><span></span> </label>
								</div>
							</td>
						</tr>
						<tr>
							<td><b>commentPostAnswer response:</b></td>
							<td><textarea name="commentPostAnswer" class="form-control"
									placeholder="comment post answer" required>${answer.commentPostAnswer}</textarea></td>
						</tr>
						<tr>
							<td><button type="submit" class="btn btn-primary"
									name="action" value="valider">Valider</button></td>
						</tr>
					</table>
				</div>
			</form>
		</div>
	</c:if>

	<div>${message}</div>
	<c:if test="${(Response==false) && (question.id!=null)}">
		<td><a
			href="ManagementQuestionsDesigner/newResponse/${question.id}">
				<button type="button" class="btn btn-primary" name="action"
					value="chercher">Ajouter une reponse</button>
		</a></td>
	</div>

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
							<th>Actions</th>
						</tr>
						<c:forEach var="answer" items="${question.answers}">
							<!-- parcours des reponses liées à cette questions pour les afficher-->
							<tr>
								<td>${answer.expectedAnswer}</td>
								<td>${answer.body}</td>
								<td>${answer.commentPostAnswer}</td>
								<td>
								<td align="center"><a
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
	</c:if>

	<br>
	<br>
	<br />
	

	<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
	<!-- jQuery -->
	<script type="text/javascript" src="js/jquery-migrate-1.2.1.min.js"></script>
	<!--  jQuery Migrate Plugin -->
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
	<script type="text/javascript" src="js/templatemo-script.js"></script>

</body>
</html>