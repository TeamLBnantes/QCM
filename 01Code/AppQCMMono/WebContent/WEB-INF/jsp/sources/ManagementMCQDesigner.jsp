
        <!-- debut de la zone du tableau -->
        
       <h3>je suis sur la page test : ${idTest} </h3> 
        
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
       	<form action="index.html" class="templatemo-login-form" method="post" enctype="multipart/form-data">
               <input type="hidden" name="id" value="${mcq.id}" />
             <div class="form-group text-center">
                <button type="submit" class="templatemo-blue-button">Ajouter Question</button>
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
                    <td><a href="" class="templatemo-link">Action</a></td>

                  </tr>
                 </c:forEach>           
                </tbody>
              </table>    
            </div>                          
          </div>       
        <!-- fin de la zone du tableau -->        
        
 </div>      
        
        
<!--           <div class="templatemo-flex-row flex-content-row">
            <div class="col-1">
              <div class="panel panel-default margin-10">
                <div class="panel-heading"><h2 class="text-uppercase">Login Form</h2></div>
                <div class="panel-body">
                  <form action="index.html" class="templatemo-login-form">
                    <div class="form-group">
                      <label for="inputEmail">Email address</label>
                      <input type="email" class="form-control" id="inputEmail" placeholder="Enter email">
                    </div>
                    <div class="form-group">                      
                      <label for="inputEmail">Password</label>
                      <input type="password" class="form-control" placeholder="Enter password">                                 
                    </div>              
                    <div class="form-group">
                        <div class="checkbox squaredTwo">
                            <label>
                              <input type="checkbox"> Remember me
                            </label>
                        </div>            
                    </div>
                    <div class="form-group">
                      <button type="submit" class="templatemo-blue-button">Submit</button>
                    </div>
                  </form>
                </div>                
              </div>              
            </div>
            <div class="col-1">              
              <div class="templatemo-content-widget pink-bg">
                <i class="fa fa-times"></i>                
                <h2 class="text-uppercase margin-bottom-10">Latest Data</h2>
                <p class="margin-bottom-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc mi sapien, fringilla at orci nec, viverra rhoncus leo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus rhoncus erat non purus commodo, sit amet varius dolor sagittis.</p>                  
              </div>            
              <div class="templatemo-content-widget blue-bg">
                <i class="fa fa-times"></i>
                <h2 class="text-uppercase margin-bottom-10">Older Data</h2>
                <p class="margin-bottom-0">Phasellus dapibus nulla quis risus auctor, non placerat augue consectetur. Aliquam convallis pharetra odio, in convallis erat molestie sed. Fusce mi lacus, semper sit amet mattis eu, volutpat vitae enim.</p>                
              </div>            
            </div>                       
          </div> Second row ends
          <div class="templatemo-flex-row flex-content-row">
            <div class="templatemo-content-widget white-bg col-2">
              <i class="fa fa-times"></i>
              <div class="media margin-bottom-30">
                <div class="media-left padding-right-25">
                  <a href="#">
                    <img class="media-object img-circle templatemo-img-bordered" src="images/person.jpg" alt="Sunset">
                  </a>
                </div>
                <div class="media-body">
                  <h2 class="media-heading text-uppercase blue-text">John Barnet</h2>
                  <p>Project Manager</p>
                </div>        
              </div>
              <div class="table-responsive">
                <table class="table">
                  <tbody>
                    <tr>
                      <td><div class="circle green-bg"></div></td>
                      <td>New Task Issued</td>
                      <td>02</td>                    
                    </tr> 
                    <tr>
                      <td><div class="circle pink-bg"></div></td>
                      <td>Task Pending</td>
                      <td>22</td>                    
                    </tr>  
                    <tr>
                      <td><div class="circle blue-bg"></div></td>
                      <td>Inbox</td>
                      <td>13</td>                    
                    </tr>  
                    <tr>
                      <td><div class="circle yellow-bg"></div></td>
                      <td>New Notification</td>
                      <td>18</td>                    
                    </tr>                                      
                  </tbody>
                </table>
              </div>             
            </div>
            <div class="templatemo-content-widget white-bg col-1 text-center templatemo-position-relative">
              <i class="fa fa-times"></i>
              <img src="images/person.jpg" alt="Bicycle" class="img-circle img-thumbnail margin-bottom-30">
              <h2 class="text-uppercase blue-text margin-bottom-5">Paul Smith</h2>
              <h3 class="text-uppercase margin-bottom-70">Managing Director</h3>
              <div class="templatemo-social-icons-container">
                <div class="social-icon-wrap">
                  <i class="fa fa-facebook templatemo-social-icon"></i>  
                </div>
                <div class="social-icon-wrap">
                  <i class="fa fa-twitter templatemo-social-icon"></i>  
                </div>
                <div class="social-icon-wrap">
                  <i class="fa fa-google-plus templatemo-social-icon"></i>  
                </div>                
              </div>
            </div>
            <div class="templatemo-content-widget white-bg col-1 templatemo-position-relative templatemo-content-img-bg">
              <img src="resources/images/sunset-big.jpg" alt="Sunset" class="img-responsive content-bg-img">
              <i class="fa fa-heart"></i>
              <h2 class="templatemo-position-relative white-text">Sunset</h2>
              <div class="view-img-btn-wrap">
                <a href="" class="btn btn-default templatemo-view-img-btn">View</a>  
              </div>              
            </div>
          </div>
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
          
          
          
