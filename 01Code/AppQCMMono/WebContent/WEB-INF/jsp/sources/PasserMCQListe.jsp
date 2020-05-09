<!-- dossier source : PasserMCQListe.jsp-->
        <!-- debut de la zone du tableau -->
        
       <!-- <h3>je suis sur la page de liste des MCQ, pour les passer: ${idTest} </h3> --> 

    
    
     <!-- debut zone formmulaire -->   


                   <div class="templatemo-content-widget white-bg">
            <h2 class="margin-bottom-10">Rechercher des QCM</h2>
            <p>Ce formulaire va servir à filtrer les QCMs disponibles dans le systeme et que vous pouvez passer</p>
            <form action="passerQCM/filtres" class="templatemo-login-form" method="post" >                        <!-- enctype="multipart/form-data" -->
<%--                <input type="hidden" name="id" value="${mcq.id}" /> --%>
              <div class="row form-group">
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputBody">Corps</label>
                    <input type="text" class="form-control" name="bodyFiltre" placeholder="presentation QCM contient" value="${filtresMCQ.bodyFiltre}">      
                              
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputTheme">Theme</label>
                    <input type="text" class="form-control" name="themeFiltre" placeholder="Theme du QCM contient" value="${filtresMCQ.themeFiltre}">                  
                </div>  
<!--               </div>
              <div class="row form-group">
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputUsername">xxxxxxxxxxx</label>
                    <input type="text" class="form-control" id="inputUsername" placeholder="Admin">                  
                </div> -->
                
                <!-- je desactive la case a cocher uniquemet ceux que vous n'avez jamais passés, pas encore implementée -->
<%--                    <div class="templatemo-block margin-bottom-5 text-center">
                    <c:if test="${filtresMCQ.nonPassedFiltre}">
                    <input type="checkbox" name="yoursFiltre" id="c1" value="true" checked> 
                    </c:if> 
                    <c:if test="${!filtresMCQ.nonPassedFiltre}">
                      <input type="checkbox" name="yoursFiltre" id="c1" value="true" > 
                      </c:if> 
                      <label for="c1" class="font-weight-400"><span></span>Uniquement ceux que vous n'avez jamais passé</label> 
                    </div>  --%>
            </div>      
 
              <div class="form-group text-right">
                <button type="submit" class="templatemo-blue-button">Rechercher</button>
               <!--  <button type="reset" class="templatemo-white-button">Reset</button> -->
         </form>
         <!-- un petit form, juste pour le bouton re-init recherche -->
         <form action="passerQCM/filtres" class="templatemo-login-form" method="post" >
          <input type="hidden" class="form-control" name="bodyFiltre" value="">
          <input type="hidden" class="form-control" name="themeFiltre" value="">
          <input type="hidden" class="form-control" name="nonPassedFiltre" value="false">
                        <div class="form-group text-left"> 
                <button type="submit" class="templatemo-edit-btn">re-Initialiser la liste</button>
                		</div> 
         </form>
              </div>  
               
<!--            </form> -->
           
      
<!-- tableau affichage les MCQ dispo-->     

           <div class="templatemo-content-widget no-padding">
                     <!-- enctype="multipart/form-data" -->
              <%--  <input type="hidden" name="id" value="${idMCQ}" /> --%>
               <input type="hidden" name="mcqTrouvesDTO" value="${mcqs}" />
            <div class="panel panel-default table-responsive">
              <table class="table table-striped table-bordered templatemo-user-table">
                <thead>
                  <tr>
                    <td width="30px"><a href="" class="white-text templatemo-sort-by"># <span class="caret"></span></a></td>
                    <td width="30px">Selection</td>
                    <td><a href="" class="white-text templatemo-sort-by">Corps <span class="caret"></span></a></td>
                    <td width="100px"><a href="" class="white-text templatemo-sort-by">theme <span class="caret"></span></a></td>
                    
                    
                    

                  </tr>
                </thead>
                <tbody>
                <c:forEach var="mcq" items="${mcqs}">
                  <tr>
                  <form action="passerQCM/${mcq.id}/init" class="templatemo-login-form" method="get" >

                  
                    <td>${mcq.id}</td>
                     <td width="30px"><!-- <div class="margin-right-15 templatemo-inline-block">	 -->
                      		<input type="hidden" name="id"  value="${mcq.id}" >
                      		<button type="submit" class="templatemo-edit-btn">Choisir</button>	
                    <!-- </div> -->
                    </td>
                    <td>${mcq.body}</td>
                    <td>${mcq.topic}</td>
             		   
                    

					</form>
                  </tr>
                 </c:forEach>           
                </tbody>
              </table>     
                      
          </div>       
           
<!-- fin tableau affichage des questions dispo-->           
           
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
          
          
          
