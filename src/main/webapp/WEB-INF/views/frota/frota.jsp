<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="../templates/menu.jsp" />

<script src="resources/js/controllers/frotaController.js"></script>
<script src="resources/js/directives/gridAgenda.js"></script>
<script src="resources/js/directives/gridAbastecimento.js"></script>
<script src="resources/js/directives/gridManutencao.js"></script>
<script src="resources/js/directives/gridQuilometragem.js"></script>
<script src="resources/js/directives/gridMulta.js"></script>

<script src="resources/js/services/ServiceVeiculo.js"></script>
<script src="resources/js/services/ServiceFornecedor.js"></script>
<script src="resources/js/services/ServiceMotorista.js"></script>
 <script src="resources/js/services/ServicePagamento.js"></script>
 
<link rel="stylesheet" type="text/css" href="resources/css/custom.css">

<link rel="stylesheet" type="text/css" href="resources/angularstrap/angular-strap.css">
<link rel="stylesheet" type="text/css" href="resources/font-awesome/css/font-awesome.min.css">


<div ng-controller="frotaController" class="container">
	
	<div class="col-md-12">
		<div class="col-md-8">
			<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USUARIO')">
		    	<a class="btn btn-default" ng-click="alteraTab('agenda')" href="#" data-animation="am-flip-x" data-trigger="hover" data-title="Agenda" bs-tooltip> 
	  				<i class="fa fa-calendar fa-lg"></i> Agenda
	  			</a>
			</sec:authorize>
			<a class="btn btn-primary" ng-click="alteraTab('abastecimento')" href="#" data-animation="am-flip-x" data-trigger="hover" data-title="Abastecimentos" bs-tooltip> 
  				<i class="fa fa-tint fa-lg "></i> Abastecimento
  			</a>
  			<a class="btn btn-success" ng-click="alteraTab('manutencao')" href="#" data-animation="am-flip-x" data-trigger="hover" data-title="Manutenções" bs-tooltip> 
  				<i class="fa fa-wrench fa-lg "></i> Manutenção
  			</a>
  			<a class="btn btn-warning" ng-click="alteraTab('km')" href="#" data-animation="am-flip-x" data-trigger="hover" data-title="Quilometragens" bs-tooltip> 
  				<i class="fa fa-tachometer fa-lg "></i> Km
  			</a>
  			<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USUARIO')">
		    	<a class="btn btn-danger" ng-click="alteraTab('multa')" href="#" data-animation="am-flip-x" data-trigger="hover" data-title="Multas" bs-tooltip> 
  				<i class="fa fa-pencil-square-o fa-lg "></i> Multa
  			</a>
			</sec:authorize>
  		</div>
		<div class="col-md-12">
			<hr>
		</div>
		<div class="col-md-12">
			<div class="tab-content">
		    	<div role="tabpanel" class="tab-pane" ng-class="{'active': tabAtiva == 'agenda'}" ng-if="tabAtiva == 'agenda'">
			    	<div class="col-md-1">
			    		<a class="btn btn-default " ng-click="novoAgendamento();" href="#" data-animation="am-flip-x" data-trigger="hover" data-title="Novo Agendamento" bs-tooltip> 
			  				<i class="fa fa-plus "></i> Novo Agendamento
			  			</a>
			    	</div>
			    	<div class="col-md-12">
			    	</div>
			    	<div class="col-md-12">
			    		<h4>Agenda</h4>
		    			<grid-agenda></grid-agenda>
			    	</div>
		    	</div>
		    	<div role="tabpanel" class="tab-pane" ng-controller="gridAbastecimentoController" ng-class="{'active': tabAtiva == 'abastecimento'}" ng-if="tabAtiva == 'abastecimento'">
		    		<div class="col-md-1">
		    			<a class="btn btn-default " ng-click="novoAbastecimento();" href="#" data-animation="am-flip-x" data-trigger="hover" data-title="Novo Abastecimento" bs-tooltip> 
			  				<i class="fa fa-plus "></i> Novo Abastecimento
			  			</a>
		    		</div>
		    		<div class="col-md-12">
			    	</div>
			    	<div class="col-md-12">
			    		<h4>Abastecimento</h4>
		    			<grid-abastecimento></grid-abastecimento>
			    	</div>
		    	</div>
		    	<div role="tabpanel" class="tab-pane" ng-class="{'active': tabAtiva == 'manutencao'}" ng-if="tabAtiva == 'manutencao'">
		    		<div class="col-md-1">
			    		<a class="btn btn-default " ng-click="novaManutencao();" href="#" data-animation="am-flip-x" data-trigger="hover" data-title="Nova Manutenção" bs-tooltip> 
			  				<i class="fa fa-plus "></i> Nova Manutenção
			  			</a>
		  			</div>
		  			<div class="col-md-12">
			    	</div>
			    	<div class="col-md-12">
			    		<h4>Manutenção</h4>
		    			<grid-manutencao></grid-manutencao>
			    	</div>
		    	</div>
		    	<div role="tabpanel" class="tab-pane" ng-class="{'active': tabAtiva == 'km'}" ng-if="tabAtiva == 'km'">
		    		<div class="col-md-1">
		    			<a class="btn btn-default " ng-click="novoKm();" href="#" data-animation="am-flip-x" data-trigger="hover" data-title="Nova Quilometragem" bs-tooltip> 
		  					<i class="fa fa-plus "></i> Novo Km
		  				</a>
		  			</div>
		  			<div class="col-md-12">
			    	</div>
		    		<div class="col-md-12">
			    		<h4>Quilometragem</h4>
		    			<grid-quilometragem></grid-quilometragem>
			    	</div>
		    	</div>
		    	<div role="tabpanel" class="tab-pane" ng-class="{'active': tabAtiva == 'multa'}" ng-if="tabAtiva == 'multa'">
		    		<div class="col-md-1">
		    			<a class="btn btn-default " ng-click="novoMulta();" href="#" data-animation="am-flip-x" data-trigger="hover" data-title="Nova Multa" bs-tooltip> 
		  					<i class="fa fa-plus "></i> Nova Multa
		  				</a>
		  			</div>
		  			<div class="col-md-12">
			    	</div>
		    		<div class="col-md-12">
			    		<h4>Multas</h4>
		    			<grid-multa></grid-multa>
			    	</div>
		    	</div>
		    </div>
		</div>
	</div>
</div>