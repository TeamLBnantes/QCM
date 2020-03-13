<!--dossier source : ManagementMCQQuestionDesigner.jsp  -->
        <!-- debut de la zone du tableau -->
        
    <div class="templatemo-content-widget white-bg">
    <h2 class="margin-bottom-10">Editer des questions</h2>
          <div class="templatemo-content-widget no-padding">
            <div class="panel panel-default table-responsive">
              <table class="table table-striped table-bordered templatemo-user-table">
                <thead>
                  <tr>
                    <td width="30px" class="white-text templatemo-sort-by"># </td>
                    <td class="white-text templatemo-sort-by">Question </td>
                    <td width="100px" class="white-text templatemo-sort-by">Theme</td>
                    
                    <td width="30px">Editer</td>
                    <td width="30px">Action</td>

                  </tr>
                </thead>
                <tbody>
                <c:forEach var="question" items="${questions}">
                  <tr>
                    <td>${question.id}</td>
                    <td>${question.body}</td>
                    <td>${question.theme}</td>

                    <td><a href="" class="templatemo-edit-btn">Editer</a></td>
                    <td><a href="ManagementMCQDesigner/${idMCQ}/sup/${question.id}" class="templatemo-link">sup</a></td>

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
            <h2 class="margin-bottom-10">Rechercher des questions</h2>
            <p>Ce formulaire va servir à filtrer les questions disponibles dans le systeme et qui peuvent donc être ajoutées au QCM</p>
            <form action="ManagementMCQDesigner/${idMCQ}/filtres" class="templatemo-login-form" method="post" >                        <!-- enctype="multipart/form-data" -->
<%--                <input type="hidden" name="id" value="${mcq.id}" /> --%>
              <div class="row form-group">
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputBody">Corps</label>
                    <input type="text" class="form-control" name="bodyFiltre" placeholder="presentation QCM contient" value="${filtresQuestion.bodyFiltre}">      
                              
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputTheme">Theme</label>
                    <input type="text" class="form-control" name="themeFiltre" placeholder="Theme du QCM contient" value="${filtresQuestion.themeFiltre}">                  
                </div>  
<!--               </div>
              <div class="row form-group">
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputUsername">xxxxxxxxxxx</label>
                    <input type="text" class="form-control" id="inputUsername" placeholder="Admin">                  
                </div> -->
                    <div class="templatemo-block margin-bottom-5 text-center">
                    <c:if test="${filtresQuestion.yoursFiltre}">
                    <input type="checkbox" name="yoursFiltre" id="c1" value="true" checked> 
                    </c:if> 
                    <c:if test="${!filtresQuestion.yoursFiltre}">
                      <input type="checkbox" name="yoursFiltre" id="c1" value="true" > 
                      </c:if> 
                      <label for="c1" class="font-weight-400"><span></span> Uniquement Vos Questions</label> 
                    </div> 
            </div>      
 
              <div class="form-group text-right">
                <button type="submit" class="templatemo-blue-button">Rechercher</button>
                <button type="reset" class="templatemo-white-button">Vider les champs</button>
         </form>
         <!-- un petit form, juste pour le bouton re-init recherche -->
         <form action="ManagementMCQDesigner/${idMCQ}/filtres" class="templatemo-login-form" method="post" >
          <input type="hidden" class="form-control" name="bodyFiltre" value="">
          <input type="hidden" class="form-control" name="themeFiltre" value="">
          <input type="hidden" class="form-control" name="yoursFiltre" value="false">
                        <div class="form-group text-left"> 
                <button type="submit" class="templatemo-blue-button">Re-initialiser la liste</button>
                		</div> 
         </form>
              </div>  
               
<!--            </form> -->
           
      
<!-- tableau affichage des questions dispo-->     

           <div class="templatemo-content-widget no-padding">
                     <!-- enctype="multipart/form-data" -->
              <%--  <input type="hidden" name="id" value="${idMCQ}" /> --%>
               <input type="hidden" name="questionsTrouveesDTO" value="${questionsTrouveesDTO}" />
            <div class="panel panel-default table-responsive">
              <table class="table table-striped table-bordered templatemo-user-table">
                <thead>
                  <tr>
                    <td width="30px" class="white-text templatemo-sort-by"># </td>
                    <td width="30px">Selection</td>
                    <td class="white-text templatemo-sort-by">Question </td>
                    <td width="100px" class="white-text templatemo-sort-by">Theme</td>
                    
                    <td width="30px">Editer</td>
                    

                  </tr>
                </thead>
                <tbody>
                <c:forEach var="qDTO" items="${questionsTrouveesDTO}">
                  <tr>
                  <form action="ManagementMCQDesigner/${idMCQ}/addQuestion" class="templatemo-login-form" method="post" >
                  			<!-- je fournis les info du filtre pour le retour de la selection d'une question -->
                            <input type="hidden" class="form-control" name="bodyFiltre" value="${filtresQuestion.bodyFiltre}">
         					 <input type="hidden" class="form-control" name="themeFiltre" value="${filtresQuestion.themeFiltre}">
         					 <c:if test="${filtresQuestion.yoursFiltre}">
                    			<input type="hidden" name="yoursFiltre"  value="true" > 
                    		</c:if> 
                    		<c:if test="${!filtresQuestion.yoursFiltre}">
                     			 <input type="hidden" name="yoursFiltre"  value="false" > 
                      		</c:if> 
                  			<!-- info recup par le controleur -->
                  
                    <td>${qDTO.question.id}</td>
                     <td width="30px"><!-- <div class="margin-right-15 templatemo-inline-block">	 -->
                      		<input type="hidden" name="id"  value="${qDTO.question.id}" >
                      		<button type="submit" class="templatemo-edit-btn">selectionner</button>	
                    <!-- </div> -->
                    </td>
                    <td>${qDTO.question.body}</td>
                    <td>${qDTO.question.theme}</td>
             		   
                    <td><a href="" class="templatemo-edit-btn">Editer</a></td>

					</form>
                  </tr>
                 </c:forEach>           
                </tbody>
              </table>     
                      
          </div>       
           
<!-- fin tableau affichage des questions dispo-->           
           	<form action="ManagementMCQDesigner/${idMCQ}"
		class="templatemo-login-form" method="get">
		<div class="form-group text-right">
			<button type="submit" class="templatemo-blue-button">Retour au QCM</button>
		</div>
		</form>
          </div> 
        <!-- fin de la zone formulaire --> 
        
        
         <!-- debut de la zone du tableau -->
 
        
        
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
          
          
          
