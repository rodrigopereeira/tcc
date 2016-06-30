var app = angular.module("tcc", ['ui.grid', 'ui.grid.selection', 'mgcrea.ngStrap']);




app.controller("frotaController", function ($scope, $modal, $http, $rootScope, ServiceVeiculo, ServiceFornecedor, ServiceMotorista, ServicePagamento) {
	
	$scope.tabAtiva = "agenda";
	
	$scope.alteraTab = function (tab) {
		$scope.tabAtiva = tab;
	}
	
	$scope.tipoAgenda = [{id: 1, descricao:"Manutenção"},{id: 2, descricao:"Abastecimento"},{id: 3, descricao:"Viagem"}];
	$scope.tipoCombustivel = [{id: 1, descricao:"Gasolina"},{id: 2, descricao:"Etanol"},{id: 3, descricao:"Diesel"}];
	$scope.tipoManutencao = [{id: 1, descricao:"Preventiva"},{id: 2, descricao:"Corretiva"}];

	$scope.novoAgendamento = function () {
		
		$scope.agenda = {};
		
		var agendamentoModal = $modal({
			controllerAs: 'frotaController',
			templateUrl: 'resources/js/modal/novoAgendamento.jsp', 
	        title: 'Novo Agendamento',
	        backdrop: false,
	        show: false,
			scope: $scope
		});
		agendamentoModal.$promise.then(function() {
			agendamentoModal.show();
        });
	}
	
	$scope.novaManutencao = function () {
		
		$scope.manutencao = {};
		$scope.date = new Date();
		
		var manutencaoModal = $modal({
			controllerAs: 'frotaController',
			templateUrl: 'resources/js/modal/novaManutencao.jsp', 
	        title: 'Nova Manutenção',
	        backdrop: false,
	        show: false,
			scope: $scope
		});
		manutencaoModal.$promise.then(function() {
			manutencaoModal.show();
        });
	}
	
	$scope.novoKm = function () {
		
		$scope.km = {};
		$scope.date = new Date();
		
		var kmModal = $modal({
			controllerAs: 'frotaController',
			templateUrl: 'resources/js/modal/novoKm.jsp', 
	        title: 'Nova Quilometragem',
	        backdrop: false,
	        show: false,
			scope: $scope
		});
		kmModal.$promise.then(function() {
			kmModal.show();
        });
	}
	
	
	
	
	$scope.abastecimentoModal = function () {
		
		var abastecimentoModal = $modal({
			controllerAs: 'frotaController',
			templateUrl: 'resources/js/modal/abastecimento.jsp', 
	        title: 'Abastecimento',
	        backdrop: false,
	        show: false,
			scope: $scope
		});
		
		abastecimentoModal.$promise.then(function() {
			abastecimentoModal.show();
        });
	}
	
	function listaVeiculos () {
		var promiseVeiculos = ServiceVeiculo.listaVeiculos();
		promiseVeiculos.then(function (data) {
			$scope.veiculos = ServiceVeiculo.getVeiculos();
		})
	}
	function listaFornecedores() {
		var promiseFornecedores = ServiceFornecedor.listaFornecedores();
		promiseFornecedores.then(function (data) {
			$scope.fornecedores = ServiceFornecedor.getFornecedores();
		})
	}
	function listaMotoristas () {
		var promiseMotoristas = ServiceMotorista.listaMotoristas();
		promiseMotoristas.then(function (data) {
			$scope.motoristas = ServiceMotorista.getMotoristas();
		})
	}
	function listaFormasPagamento() {
		var promisePagamento = ServicePagamento.listaFormasPagamento();
		promisePagamento.then(function (data) {
			$scope.tiposPagamento = ServicePagamento.getFormasPagamento();
		})
	}
	
	$scope.resetaCombox = function () {
		listaVeiculos();
		listaFornecedores();
		listaMotoristas();
		listaFormasPagamento();
	}
	
	$scope.resetaCombox();
	
	
	$scope.cadastrarAgenda = function (agenda) {
		$http.post('agenda', agenda).success(function () {
			$rootScope.$broadcast('novaAgenda');
			delete $scope.agenda;
		});
	}
	
	$scope.cadastrarManutencao = function (manutencao) {
		$http.post('manutencao', manutencao).success(function () {
			$rootScope.$broadcast('novaManutencao');
			delete $scope.manutencao;
		});
	}
	
	$scope.cadastrarKm = function (km) {
		$http.post('km', km).success(function () {
			$rootScope.$broadcast('novoKM');
			delete $scope.km;
		});
	}
	
		
	
	
	
	

});