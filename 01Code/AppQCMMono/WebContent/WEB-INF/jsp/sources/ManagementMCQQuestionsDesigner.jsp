
        <!-- debut de la zone du tableau -->
        
       <h3>je suis sur la page test ManagementMCQQuestionsDesigner.jsp: ${idTest} </h3> 
        <h3>Body du MCQ: ${BodyMCQ} </h3> 
    <div class="templatemo-content-widget white-bg">

         
          <div class="templatemo-content-widget no-padding">
            <div class="panel panel-default table-responsive">
              <table class="table table-striped table-bordered templatemo-user-table">
                <thead>
                  <tr>
                    <td width="30px"><a href="" class="white-text templatemo-sort-by"># <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">body <span class="caret"></span></a></td>
                    <td width="100px"><a href="" class="white-text templatemo-sort-by">theme <span class="caret"></span></a></td>
                    
                    <td width="30px">Edit</td>
                    <td width="30px">Action</td>

                  </tr>
                </thead>
                <tbody>
                <c:forEach var="question" items="${questions}">
                  <tr>
                    <td>${question.id}</td>
                    <td>${question.body}</td>
                    <td>${question.theme}</td>

                    <td><a href="" class="templatemo-edit-btn">Edit</a></td>
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
            <p>ce formulaire va servir à filtre les questions dispo dans le systeme, et qui peuvent donc être ajoutées au QCM</p>
            <form action="ManagementMCQDesigner/${mcq.id}" class="templatemo-login-form" method="post" >                        <!-- enctype="multipart/form-data" -->
               <input type="hidden" name="id" value="${mcq.id}" />
              <div class="row form-group">
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputBody">Body</label>
                    <input type="text" class="form-control" name="body" placeholder="presentation QCM" value="${mcq.body}">      
                              
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputTheme">Themexxxx</label>
                    <input type="text" class="form-control" name="themexxxxx" id="inputTheme" placeholder="Theme du QCM" value="${mcq.theme}">                  
                </div> 
              </div>
              <div class="row form-group">
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputUsername">xxxxxxxxxxx</label>
                    <input type="text" class="form-control" id="inputUsername" placeholder="Admin">                  
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputEmail">xxxxxxxxxxxxxx</label>
                    <input type="text" class="form-control" id="inputEmail" placeholder="admin@company.com">                  
                </div> 
             </div>       
 
              <div class="form-group text-right">
                <button type="submit" class="templatemo-blue-button">Rechercher</button>
                <button type="reset" class="templatemo-white-button">Reset</button>
              </div>                           
           </form>
           
      
<!-- tableau affichage des questions dispo-->     

           <div class="templatemo-content-widget no-padding">
                     <!-- enctype="multipart/form-data" -->
              <%--  <input type="hidden" name="id" value="${idMCQ}" /> --%>
               <input type="hidden" name="questionsTrouveesDTO" value="${questionsTrouveesDTO}" />
            <div class="panel panel-default table-responsive">
              <table class="table table-striped table-bordered templatemo-user-table">
                <thead>
                  <tr>
                    <td width="30px"><a href="" class="white-text templatemo-sort-by"># <span class="caret"></span></a></td>
                    <td width="30px">Select</td>
                    <td><a href="" class="white-text templatemo-sort-by">body <span class="caret"></span></a></td>
                    <td width="100px"><a href="" class="white-text templatemo-sort-by">theme <span class="caret"></span></a></td>
                    
                    <td width="30px">Edit</td>
                    

                  </tr>
                </thead>
                <tbody>
                <c:forEach var="qDTO" items="${questionsTrouveesDTO}">
                  <tr>
                  <form action="ManagementMCQDesigner/${idMCQ}/addQuestion" class="templatemo-login-form" method="post" >
                    <td>${qDTO.question.id}</td>
                     <td width="30px"><!-- <div class="margin-right-15 templatemo-inline-block">	 -->
                      		<input type="hidden" name="id"  value="${qDTO.question.id}" >
                      		<button type="submit" class="templatemo-edit-btn">select.</button>	
                    <!-- </div> -->
                    </td>
                    <td>${qDTO.question.body}</td>
                    <td>${qDTO.question.theme}</td>
             		   
                    <td><a href="" class="templatemo-edit-btn">Edit</a></td>

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
            <ul class="pagination">
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
            </ul>
         <!--  </div>       -->    
          <footer class="text-right">
                      <p>Copyright &copy; 2084 Company Name 
            | Design: Template Mo</p>
          </footer>  
          
          
          
