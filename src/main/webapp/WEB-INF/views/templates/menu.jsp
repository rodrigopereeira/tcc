<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"  %>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Inicio</title>
      <script src="resources/lib/jquery.js"></script>
      <script src="resources/angular/angular.min.js"></script>
      <script src="resources/angular/angular-locale_pt-br.js"></script>
      <script src="resources/angularstrap/angular-strap.min.js"></script>
      <script src="resources/angularstrap/angular-strap.tpl.min.js"></script>
      
      <script src="resources/bootstrap/js/bootstrap.min.js"></script>
      <link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.min.css">
      
      <script src="resources/uigrid/ui-grid.min.js"></script>
      <link rel="stylesheet" type="text/css" href="resources/uigrid/ui-grid.min.css">
      
   </head>
   <style>
   </style>
   <body ng-app="tcc">
      <div class="container-fluid">
         <div class="row ">
            <nav class="navbar navbar-default">
               <div class="container-fluid">
                  <!-- Brand and toggle get grouped for better mobile display -->
                  <div class="navbar-header">
                  	 <a class="navbar-brand" href="#">
				     	<img alt="Brand" width="15px" height="15px" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACgAAAAoCAMAAAC7IEhfAAAA81BMVEX///9VPnxWPXxWPXxWPXxWPXxWPXxWPXz///9hSYT6+vuFc6BXPn37+vz8+/z9/f2LeqWMe6aOfqiTg6uXiK5bQ4BZQX9iS4VdRYFdRYJfSINuWI5vWY9xXJF0YJR3Y5Z4ZZd5ZZd6Z5h9apq0qcW1qsW1q8a6sMqpnLyrn76tocCvpMGwpMJoUoprVYxeRoJjS4abjLGilLemmbrDutDFvdLPx9nX0eDa1OLb1uPd1+Td2OXe2eXh3Ofj3+nk4Orl4evp5u7u7PLv7fPx7/T08vb08/f19Pf29Pj39vn6+fuEcZ9YP35aQn/8/P1ZQH5fR4PINAOdAAAAB3RSTlMAIWWOw/P002ipnAAAAPhJREFUeF6NldWOhEAUBRvtRsfdfd3d3e3/v2ZPmGSWZNPDqScqqaSBSy4CGJbtSi2ubRkiwXRkBo6ZdJIApeEwoWMIS1JYwuZCW7hc6ApJkgrr+T/eW1V9uKXS5I5GXAjW2VAV9KFfSfgJpk+w4yXhwoqwl5AIGwp4RPgdK3XNHD2ETYiwe6nUa18f5jYSxle4vulw7/EtoCdzvqkPv3bn7M0eYbc7xFPXzqCrRCgH0Hsm/IjgTSb04W0i7EGjz+xw+wR6oZ1MnJ9TWrtToEx+4QfcZJ5X6tnhw+nhvqebdVhZUJX/oFcKvaTotUcvUnY188ue/n38AunzPPE8yg7bAAAAAElFTkSuQmCC">
				     </a>
                     <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                     <span class="sr-only">Toggle navigation</span>
                     <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                     </button>
                  </div>
                  <!-- Collect the nav links, forms, and other content for toggling -->
                  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                     <ul class="nav navbar-nav">
                        <li class="dropdown">
                           <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Inicio <span class="caret"></span></a>
                           <ul class="dropdown-menu">
                           		<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USUARIO')">
	                            	<li><a href="cadastro">Cadastros</a></li>
	                        	</sec:authorize>
                              
                              <li><a href="frota">Controle de Frota</a></li>
                           		<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
	                            	<li><a href="relatorio">Relatórios</a></li>
	                        	</sec:authorize>
                           </ul>
                        </li>
                     </ul>
                     <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                           <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> ${nome} <span class="caret"></span></a>
                           <ul class="dropdown-menu">
                              <li>
                              <a href="javascript:formSubmit()"> Sair</a>
                              </li>
                           </ul>
                        </li>
                     </ul>
                     
                     <form action="j_spring_security_logout" method="post" id="logoutForm">
					 	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						
					</form>
                  </div>
                  <!-- /.navbar-collapse -->
               </div>
               <!-- /.container-fluid -->
            </nav>
         </div>
      </div>
   </body>
   <script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>
</html>