<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="../templates/menu.jsp" />

<script src="resources/js/controllers/relatorioController.js"></script>

<script src="resources/js/services/ServiceVeiculo.js"></script>

<link rel="stylesheet" type="text/css" href="resources/css/custom.css">

<link rel="stylesheet" type="text/css" href="resources/angularstrap/angular-strap.css">
<link rel="stylesheet" type="text/css" href="resources/font-awesome/css/font-awesome.min.css">

<script src="resources/angularchart/chart.js"></script>
<script src="resources/angularchart/angular-chart.js"></script>
<link rel="stylesheet" type="text/css" href="resources/angularchart/angular-chart.css">


<div ng-controller="relatorioController" class="container">
	
	<div class="col-md-12">
		<div class="col-md-2">
			<label class=" control-label" for="os">Defina um veículo</label>  
			<select class="form-control input-sm" 
            	ng-model="relatorio.veiculo.id"
                ng-options="veiculo.id as veiculo.modelo for veiculo in veiculos"
                ng-init="relatorio.veiculo.id = 0">
			</select>
			
			<hr>
			<button class="btn btn-default btn-block" ng-click="consumoMedio(relatorio);">Consumo Médio</button>
			<button class="btn btn-default btn-block" ng-click="distanciaPercorrida(relatorio);">Distancia Percorrida</button>
			<button class="btn btn-default btn-block" ng-click="calculaViabilidade();">Viabilidade</button>
			<button class="btn btn-default btn-block" ng-click="despesas(relatorio);">Despesas</button>
			<button class="btn btn-default btn-block" ng-click="impactoFinanceiro(relatorio);">Impacto Financeiro</button>
		</div>
		<div class="col-md-2">
			<label class=" control-label" for="os">Data Inicial</label>  
			<input ng-model="relatorio.dataInicial" type="text"class="form-control input-sm" data-date-format="dd/MM/yyyy" data-autoclose="1" bs-datepicker>
		</div>
		<div class="col-md-2">
			<label class=" control-label" for="os">Data Final</label>  
			<input ng-model="relatorio.dataFinal"  type="text"class="form-control input-sm" data-date-format="dd/MM/yyyy" data-autoclose="1" bs-datepicker>
		</div>
		<div class="col-md-2">
			
		</div>
		
		
	</div>
</div>