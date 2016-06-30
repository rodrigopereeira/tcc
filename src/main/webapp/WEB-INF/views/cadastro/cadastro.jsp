<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="../templates/menu.jsp" />

<script src="resources/js/controllers/cadastroController.js"></script>
<script src="resources/js/directives/gridVeiculos.js"></script>
<script src="resources/js/directives/gridUsuarios.js"></script>
<script src="resources/js/directives/gridFornecedores.js"></script>
  
<link rel="stylesheet" type="text/css" href="resources/angularstrap/angular-strap.css">

<div ng-controller="cadastroController" class="container">

  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" ng-class="{'active': tabAtiva == 'veiculos'}"><a ng-click="alteraTab('veiculos')"  role="tab" data-toggle="tab">Veículos</a></li>
    <li role="presentation" ng-class="{'active': tabAtiva == 'usuarios'}"><a ng-click="alteraTab('usuarios');"  role="tab" data-toggle="tab">Usuários</a></li>
    <li role="presentation" ng-class="{'active': tabAtiva == 'fornecedores'}"><a ng-click="alteraTab('fornecedores');"  role="tab" data-toggle="tab">Fornecedores</a></li>
  </ul>
  <!-- Tab panes -->
  <div class="tab-content">
    <div role="tabpanel" class="tab-pane" ng-class="{'active': tabAtiva == 'veiculos'}" id="veiculos" ng-if="tabAtiva == 'veiculos'">
    	<div class="col-md-8" style="margin-top:5px;">
    		<grid-veiculos></grid-veiculos>
    	</div>
    	<div class="col-md-4" >
    		<c:import url="form/veiculo.jsp" />
    	</div>
    </div>
    <div role="tabpanel" class="tab-pane" ng-class="{'active': tabAtiva == 'usuarios'}" id="usuarios" ng-if="tabAtiva == 'usuarios'">
    	<div class="col-md-8" style="margin-top:5px;">
    		<grid-usuarios></grid-usuarios>
    	</div>
    	<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
	    	<div class="col-md-4" >
    			<c:import url="form/funcionario.jsp" />
    		</div>
		</sec:authorize>
    </div>
    	
    <div role="tabpanel" class="tab-pane" ng-class="{'active': tabAtiva == 'fornecedores'}" id="fornecedores" ng-if="tabAtiva == 'fornecedores'">
    	<div class="col-md-8" style="margin-top:5px;">
    		<grid-fornecedores></grid-fornecedores>
    	</div>
    	<div class="col-md-4" >
    		<c:import url="form/fornecedor.jsp" />
		</div>
    </div>
  </div>

</div>