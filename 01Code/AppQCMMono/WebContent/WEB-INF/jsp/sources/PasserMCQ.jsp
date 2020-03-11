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
           		<a href="passerQCM/${id}/next">
           		<button type="button" class="templatemo-blue-button" name="action" value="chercher">Lancer le QCM</button></a>
           		</div>
           </c:if>
           <c:if test="${tarckMcq.etape=='question'}">
          <!-- affichage dela question, avec ces réponses il faudra donc mettre ici un formulair epour recupèrer le resultat-->
           
           
           
           
           
           
          		 <a href="passerQCM/${id}/next">Corriger</a>	
           </c:if>
           <c:if test="${tarckMcq.etape=='correction'}">
           <!-- affichage de la correction de la question précédente-->
           
           
           
           
           		<a href="passerQCM/${id}/next">Question Suivante</a>	
           </c:if>
           <c:if test="${tarckMcq.etape=='endMCQ'}">
           <!-- affichage de page de cloture de ce QCM, avec les résultats, un lien pour envoyer un message au concepteur du QCM-->
           
           
           
           
           
           
           		<a href="passerQCM/${id}/next">Retour vers la lste des QCM</a>	
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
          
          
          
