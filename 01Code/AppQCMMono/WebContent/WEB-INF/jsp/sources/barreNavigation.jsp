<link href="resources/media/lib/fancybox/dist/jquery.fancybox.min.css"
	rel="stylesheet">
<script src="resources/media/lib/jquery-3.3.1.min.js"></script>
<script src="resources/media/lib/fancybox/dist/jquery.fancybox.min.js"></script>

          <div class="row" >
            <nav class="templatemo-top-nav col-lg-12 col-md-12">
              <ul class="text-uppercase">
                <li><a href="home" class="active">Création</a></li>
                <li><a href="passerQCM">Passer QCM</a></li>
                <li><a href="" onclick="open('MailEngine', 'Popup', 'scrollbars=1,resizable=1,height=500,width=870'); return false;">Ecrire aux Administrateurs</a></li>
                <c:if test="${!sessionScope.user.isAdmin()}">
                <li>
                	<a data-fancybox="hello"
					data-src="#helloAdmin" href="javascript:;"> Administration </a>
						<form id="helloAdmin" action="login/admin" method="post"
									style="display: none; width: 80%; ">
						
                				Pour acceder à l'administration, merci de renseigner le mot de passe Ad'hoc :<br>
                				<input class="form-control" type="password"
										name="password" id="password"
										value="" />
						
						  										<br />
                				<input type="submit" id="valider" value="valider"
							class="btn-lg btn-primary" />
									
                		</form>
                </li>
                </c:if>
                <c:if test="${sessionScope.user.isAdmin()}">
                	 <li><a href="login/admin">Quitter mode Admin</a></li>
                </c:if>
                <li><a href="login.html"></a></li>
              </ul>  
            </nav> 
          </div>

