var app = angular.module("tcc", ['ui.grid', 'ui.grid.selection', 'mgcrea.ngStrap', 'chart.js']);

app.controller("relatorioController", function ($scope, $filter, $http, $modal, ServiceVeiculo) {
	
	$scope.viabilidade = {};
	$scope.data = [];

	var relatorio = {};
	
	var promiseVeiculos = ServiceVeiculo.listaVeiculos();
	promiseVeiculos.then(function (data) {
		
		var veiculo = {
			id: 0,
			modelo: "Todos"
		}
		
		$scope.veiculos = ServiceVeiculo.getVeiculos();
		$scope.veiculos.push(veiculo);
		
	})
	
	$scope.consumoMedio = function (relatorio) {
		
		if (typeof relatorio.veiculo === "undefined" ) {
			relatorio.veiculo.id = 0;
		}
		var tabWindowId = window.open('about:blank', '_blank');

        setTimeout(function() { // async
            tabWindowId.location.href = 'relatorio/consumoMedio/'+ relatorio.veiculo.id +'/'+relatorio.dataInicial.getTime()+'/' + relatorio.dataFinal.getTime();
        }, 1001);

        
	}
	
	$scope.distanciaPercorrida = function (relatorio) {
		if (typeof relatorio.veiculo === "undefined" ) {
			relatorio.veiculo.id = 0;
		}
		var tabWindowId = window.open('about:blank', '_blank');

        setTimeout(function() { // async
            tabWindowId.location.href = 'relatorio/distanciaPercorrida/'+ relatorio.veiculo.id +'/'+relatorio.dataInicial.getTime()+'/' + relatorio.dataFinal.getTime();
        }, 1001);
        
	}
	
	$scope.despesas = function (relatorio) {
		if (typeof relatorio.veiculo === "undefined" ) {
			relatorio.veiculo.id = 0;
		}
		var tabWindowId = window.open('about:blank', '_blank');

        setTimeout(function() { // async
            tabWindowId.location.href = 'relatorio/despesas/'+ relatorio.veiculo.id +'/'+relatorio.dataInicial.getTime()+'/' + relatorio.dataFinal.getTime();
        }, 1001);
        
	}
	
	$scope.calculaViabilidade = function () {
		var viabilidadeModal = $modal({
			controllerAs: 'relatorioController',
			templateUrl: 'resources/js/modal/viabilidadeModal.jsp', 
	        title: 'Analise de Viabilidade',
	        backdrop: false,
	        show: false,
			scope: $scope
		});
		viabilidadeModal.$promise.then(function() {
			viabilidadeModal.show();
        });
	}
	
	$scope.calculaImpacto = function (faturamento) {
		$scope.totalDespesa = $scope.data[0] + $scope.data[1] + $scope.data[2];
		var valor = (100/faturamento) * $scope.totalDespesa;
		$scope.impactoFrota = Math.round(valor);
		
	}
	
	$scope.impactoFinanceiro = function (relatorio) {
		
		$scope.labels = ["Total de Abastecimento", "Total de Manutenção", "Total de Multa"];
		
		$http.get('relatorio/impactoFinanceiro').success(function (data) {
			$scope.data[0] = data.totalAbastecimento;
			$scope.data[1] = data.totalManutencao;
			$scope.data[2] = data.totalMulta;
			
			$scope.totalDespesa = $scope.data[0] + $scope.data[1] + $scope.data[2];
			var valor = ((100/$scope.faturamento) * $scope.totalDespesa);
			console.log(valor);
			$scope.impactoFrota = $filter('absoluteValue')(valor);
		});
		var impactoModal = $modal({
			controllerAs: 'relatorioController',
			templateUrl: 'resources/js/modal/impactoFinanceiroModal.jsp', 
	        title: 'Impacto Financeiro',
	        backdrop: false,
	        show: false,
			scope: $scope
		});
		impactoModal.$promise.then(function() {
			impactoModal.show();
        });
	}
	
	$scope.$watchCollection('viabilidade', function (newVal, oldVal) {
		$scope.viabilidade.mediaMensal = $scope.viabilidade.kmDiaria * 22;
		$scope.viabilidade.totalLitroantigo = $scope.viabilidade.mediaMensal/$scope.viabilidade.consumoMedioatual;
		$scope.viabilidade.totalGastoantigo = $scope.viabilidade.totalLitroantigo*$scope.viabilidade.precoCombustivel;
		
		$scope.viabilidade.totalLitronovo = $scope.viabilidade.mediaMensal/$scope.viabilidade.consumoMedionovo;
		$scope.viabilidade.totalGastonovo = $scope.viabilidade.totalLitronovo*$scope.viabilidade.precoCombustivel;
		
		$scope.viabilidade.economia = $scope.viabilidade.totalGastoantigo-$scope.viabilidade.totalGastonovo;
		
		$scope.viabilidade.economia = $scope.viabilidade.numVeiculos * $scope.viabilidade.economia;
	});
	
	
});

app.filter('absoluteValue', function() {
    return function(num) { return Math.abs(num); }
});