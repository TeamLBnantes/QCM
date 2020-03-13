
<!-- debut de la zone du tableau -->

<h3>je suis sur la page test MCQ Designer</h3>

<!-- debut zone formmulaire -->


<div class="templatemo-content-widget white-bg">
	<h2 class="margin-bottom-10">Info sur le QCM</h2>
	<form action="ManagementMCQDesigner/${mcq.id}"
		class="templatemo-login-form" method="post">
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
			<label for="inputUsername">Statut</label> 
				
								
				<select class="form-control" name="status" id="status" >
										<c:forEach items="${ enumStatus }" var="status">
											<option value="${ status }"
												${ question.status == status ? 'selected' : '' }>
												<tag:message code="${ status.libelle }"
													text="${status.libelle }" />
											</option>
										</c:forEach>
								</select>				
								
								
								
								
			</div>
			<div class="col-lg-6 col-md-6 form-group">
				<label for="inputEmail">Créé le </label> ${ mcq.createDate} <br/> <label for="inputEmail">Derniere modification </label> ${ mcq.editDate}
			</div>
		</div>
<br/>
<c:if test="${mcq.multimedia.typeMultimedia}=='image'">

<img src="${mcq.multimedia.adresseCible}"/>
</c:if>
<c:if test="${mcq.multimedia.typeMultimedia}=='audio'">



</c:if>
<c:if test="${mcq.multimedia.typeMultimedia}=='video'">



</c:if>

<br/>



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
			<button type="submit" class="templatemo-blue-button">Ajouter/supprimer
				des Questions</button>
		</div>
	</form>
	<div class="templatemo-content-widget no-padding">
		<div class="panel panel-default table-responsive">
			<table
				class="table table-striped table-bordered templatemo-user-table">
				<thead>
					<tr>
						<td width="3%"
							class="white-text templatemo-sort-by">#</td>
						<td width="80%" class="white-text templatemo-sort-by">body
						</td>
						<td width="10%"
							class="white-text templatemo-sort-by">theme</td>
						<td width="7%">Edit</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="question" items="${questions}">
						<tr>
							<td>${question.id}</td>
							<td>${question.body}</td>
							<td>${question.theme}</td>
							<td><a href="" class="templatemo-blue-button"><i class="fa fa-edit"></i></a></td>
							<!--                     <td><a href="" class="templatemo-link">Action</a></td> -->
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- fin de la zone du tableau -->
	<form action="ManagementMCQDesigner"
		class="templatemo-login-form" method="get">
		<input type="hidden" name="id" value="${mcq.id}" />
		<div class="form-group text-right">
			<button type="submit" class="templatemo-blue-button">Retourà la liste des QCM</button>
		</div>
		</form>
</div>

<!--           <div class="templatemo-flex-row flex-content-row">

          <div class="pagination-wrap"> -->

<!--             <ul class="pagination">
              <li><a href="#">1</a></li>
              <li><a href="#">2</a></li>
              <li class="active"><a href="#">3 <span class="sr-only">(current)</span></a></li>
              <li><a href="#">4</a></li>
              <li><a href="#">5</a></li>
              <li>
                <a href="#" aria-label="Next">
                  <span aria-hidden="true"><i class="fa fa-play"></i></span>
                </a>
              </li>
            </ul> -->
<!--  </div>       -->
<footer class="text-right">
	<p>Copyright &copy; 2020 QuizizSkillz | Design: Template Mo</p>
</footer>




