<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
        <!-- debut de la zone du tableau -->
        
       <h3>je suis sur la page est on passe le QCM : ${mcq.body }</h3> 
       <h3>nombre de Question restantes : ${tarckMcq.nbQuestionsTotal-tarckMcq.nbQuestionsPassed} </h3> 

    
    
     <!-- debut zone formmulaire -->   


                   <div class="templatemo-content-widget white-bg">
            
           <h3>Zone de Travail </h3> 
<!-- fin tableau affichage des questions dispo-->           
           <br>
           		<br>
      
           
 <!-- ############################################################### beforeMCQ #######################################################################################  -->          
           <c:if test="${tarckMcq.etape =='beforeMCQ'}">
           <!-- affichage de la page de présentation du qcm, avec le bouton pour le lancer -->
           

           		<br>
           		<br>
           		<h2>Ce QCM 
           		<c:if test="${fn:length(mcq.theme) !=0}">
           		qui porte donc sur les themes { ${mcq.theme } }
           		</c:if>
           		 comporte ${tarckMcq.nbQuestionsTotal } Question. 
           		 <p>Attention, si vous quiter la page en cours, 
           		vous ne pourrez pas revenir en arriere, il faudra reprendre du début.</p>
           		 C'est partie Quand vous voulez .... ;-)  </h2>
           
           		<br>
           		<br>
           
           		<div class="form-group text-center">
           		 	<form action="passerQCM/next" class="templatemo-login-form" method="post" >
           				<button type="submit" class="templatemo-blue-button" name="action" value="chercher">Lancer le QCM</button>
           			</form>
           		</div>
           </c:if>
<!-- ############################################################### affichage de la question #######################################################################################  -->  
           <c:if test="${tarckMcq.etape=='question'}">
          <!-- affichage de la question, avec ces réponses il faudra donc mettre ici un formulair epour recupèrer le resultat-->
    <form action="passerQCM/next" class="templatemo-login-form" method="post" >   
        <p>   question id :      ${question.id }         </p>
        <p>   question body :      ${question.body }          </p>
        <p>   question theme :     ${question.theme }           </p>
        <p>   question commentPostAnswer :     ${question.commentPostAnswer }           </p>
           <div class="templatemo-content-widget no-padding">
            <div class="panel panel-default table-responsive">
              <table class="table table-striped table-bordered templatemo-user-table">
                <thead>
                  <tr>
                    <td width="30px"><a href="" class="white-text templatemo-sort-by">True <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">body <span class="caret"></span></a></td>


                  </tr>
                </thead>
                <tbody>
                <c:forEach var="answer" items="${question.answers}">
                  <tr>
                    <td><!-- td de la case à cocher -->
                    	
                    	<input type="checkbox" name="${reponsesUser[answer.id]}" id="${answer.id}" value="true" > 
                      	<label for="${answer.id}" class="font-weight-400"><span></span></label>
                      	
                    </td>
                    <td>${answer.body}</td>
                  </tr>
                 </c:forEach>           
                </tbody>
              </table>    
            </div>                          
          </div>           
<%--         <div class="container">
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
					</table>
				</div>
			</div>
		</div>
	</div> --%>

           
           		<div class="form-group text-center">
           		 	
           				<button type="submit" class="templatemo-blue-button " name="action" value="chercher">Corriger</button>
           			</form>
           		</div>
           </c:if>
 <!-- ############################################################### affichage de la Correction de la question #######################################################################################  -->          
                
           <c:if test="${tarckMcq.etape=='correction'}">
           <!-- affichage de la correction de la question précédente-->
           
           
           
           		<div class="form-group text-center">
           		 	<form action="passerQCM/next" class="templatemo-login-form" method="post" >
           				<button type="submit" class="templatemo-blue-button" name="action" value="chercher">Question Suivante</button>
           			</form>
           		</div>	
           </c:if>
           
<!-- ############################################################### affichage de la Cloture de qcm #######################################################################################  -->          
           
           <c:if test="${tarckMcq.etape=='endMCQ'}">
           <!-- affichage de page de cloture de ce QCM, avec les résultats, un lien pour envoyer un message au concepteur du QCM-->
           
           
          
           
           
           		<a href="passerQCM">Retour vers la lste des QCM</a>	
           </c:if>
           
           
          </div> 
        <!-- fin de la zone formulaire --> 
        
        
         <!-- debut de la zone du tableau -->
 
        <div>
        <p>   mcq id :      ${mcq.id }         </p>
        <p>   mcq body :      ${mcq.body }          </p>
        <p>   mcq theme :     ${mcq.theme }           </p>
        <p>   mcq designer :     ${mcq.designer }           </p>
        <p>############################### </p>
        <p>   tarckMcq liste de question used :     ${tarckMcq.listQuestionsUsed }           </p>
        <p>   tarckMcq nbQuestionsTotal :     ${tarckMcq.nbQuestionsTotal }           </p>
        <p>   tarckMcq nbQuestionsPassed:     ${tarckMcq.nbQuestionsPassed }           </p>
        <p>   tarckMcq nbBonnesReponses:    ${tarckMcq.nbBonnesReponses }            </p>
        <p>   tarckMcq mcqPassed:     ${tarckMcq.mcqPassed }           </p>
        <p>   tarckMcq etape:     ${tarckMcq.etape }           </p>
        
        <br/>

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
                      <p>Copyright &copy; 2084 Company Name 
            | Design: Template Mo</p>
          </footer>  
          
          
          
