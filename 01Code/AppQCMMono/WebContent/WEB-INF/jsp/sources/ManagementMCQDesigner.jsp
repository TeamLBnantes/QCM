
        <!-- debut de la zone du tableau -->
        
       <h3>je suis sur la page test MCQ Designer: ${idTest} </h3> 
        
     <!-- debut zone formmulaire -->   


                   <div class="templatemo-content-widget white-bg">
            <h2 class="margin-bottom-10">Info sur le QCM</h2>
            <p>Here goes another form and form controls.</p>
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
                <button type="submit" class="templatemo-blue-button">Update</button>
                <button type="reset" class="templatemo-white-button">Reset</button>
              </div>                           
           </form>
          </div> 
        <!-- fin de la zone formulaire --> 
        
        
         <!-- debut de la zone du tableau -->
 <div class="templatemo-content-widget white-bg">
       	<form action="ManagementMCQDesigner/${mcq.id}/questions" class="templatemo-login-form" method="get" >
               <input type="hidden" name="id" value="${mcq.id}" />
             <div class="form-group text-center">
                <button type="submit" class="templatemo-blue-button">Ajouter/supprimer des Questions</button>
              </div>
              </form>
         
          <div class="templatemo-content-widget no-padding">
            <div class="panel panel-default table-responsive">
              <table class="table table-striped table-bordered templatemo-user-table">
                <thead>
                  <tr>
                    <td width="30px"><a href="" class="white-text templatemo-sort-by"># <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">body <span class="caret"></span></a></td>
                    <td width="100px"><a href="" class="white-text templatemo-sort-by">theme <span class="caret"></span></a></td>
                    
                    <td width="30px">Edit</td>


                  </tr>
                </thead>
                <tbody>
                <c:forEach var="question" items="${questions}">
                  <tr>
                    <td>${question.id}</td>
                    <td>${question.body}</td>
                    <td>${question.theme}</td>

                    <td><a href="" class="templatemo-edit-btn">Edit</a></td>
<!--                     <td><a href="" class="templatemo-link">Action</a></td> -->

                  </tr>
                 </c:forEach>           
                </tbody>
              </table>    
            </div>                          
          </div>       
        <!-- fin de la zone du tableau -->        
        
 </div>      
        
        
>>>>>>> devLaurent
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
          
          
          

