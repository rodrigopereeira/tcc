var app = angular.module("tcc", ['ui.grid', 'ui.grid.selection', 'mgcrea.ngStrap']);

app.controller("cadastroController", function ($scope, $modal, $http, $rootScope, ServiceModal) {
	
	$scope.tabAtiva = "veiculos";
	
	$scope.alteraTab = function (tab) {
		$scope.tabAtiva = tab;
	}
	
	$scope.tipoUsuario = [
	    {id: 1, descricao: 'Administrador'},
	    {id: 2, descricao: 'Motorista'},
	    {id: 3, descricao: 'Usuário'}
	];
	
	$scope.tipoFornecedor = [
		{id: 1, descricao: 'Posto de Combustível'},
	    {id: 2, descricao: 'Mecânica/Elétrica'}
	];
	
	$scope.cadastrarUsuario = function(usuario) {
		if (usuario.tipoid == 1) {
			$http.post('administrador', usuario).success(function () {
				$rootScope.$broadcast('novoUsuario');
				delete $scope.usuario;
			});
		} else if (usuario.tipoid == 2) {
			$http.post('motorista', usuario).success(function () {
				$rootScope.$broadcast('novoUsuario');
				delete $scope.usuario;
			});
		} else if (usuario.tipoid == 3) {
			$http.post('usuario', usuario).success(function () {
				$rootScope.$broadcast('novoUsuario');
				delete $scope.usuario;
			});
		}
	}
	
	$scope.salvarFuncionario = function(usuario) {
		if (usuario.tipoid == 1) {
			$http.put('administrador', usuario).success(function () {
				$rootScope.$broadcast('novoUsuario');
				delete $scope.usuario;
			});
		} else if (usuario.tipoid == 2) {
			$http.put('motorista', usuario).success(function () {
				$rootScope.$broadcast('novoUsuario');
				delete $scope.usuario;
			});
		} else if (usuario.tipoid == 3) {
			$http.put('usuario', usuario).success(function () {
				$rootScope.$broadcast('novoUsuario');
				delete $scope.usuario;
			});
		}
	}
	
	$scope.excluirFuncionario = function (funcionario) {
		if (funcionario.tipoid == 1) {
			$http.delete('administrador/' + funcionario.id + '/' + funcionario.telefone.id + '/' + funcionario.contato.id).success(function () {
				$rootScope.$broadcast('novoUsuario');
				ServiceModal.fecharModalFuncionario();
				delete $scope.funcionario;
			});
		} else if (funcionario.tipoid == 2) {
			$http.delete('motorista/' + funcionario.id + '/' + funcionario.telefone.id + '/' + funcionario.contato.id+ '/' + funcionario.cnh.id).success(function () {
				$rootScope.$broadcast('novoUsuario');
				ServiceModal.fecharModalFuncionario();
				delete $scope.funcionario;
			});
		} else if (funcionario.tipoid == 3) {
			$http.delete('usuario/' + funcionario.id + '/' + funcionario.telefone.id + '/' + funcionario.contato.id).success(function () {
				$rootScope.$broadcast('novoUsuario');
				ServiceModal.fecharModalFuncionario();
				delete $scope.funcionario;
			});
		}
	}
	
	
	$scope.cadastrarVeiculo = function (veiculo) {
		$http.post('veiculo', veiculo).success(function () {
			$rootScope.$broadcast('novoVeiculo');
			delete $scope.veiculo;
		});
	}
	
	$scope.salvarVeiculo = function (veiculo) {
		$http.put('veiculo', veiculo).success(function () {
			$rootScope.$broadcast('novoVeiculo');
			delete $scope.veiculo;
		});
	}
	
	$scope.excluirVeiculo = function (veiculo) {
		$http.delete('veiculo/' + veiculo.id).success(function () {
			$rootScope.$broadcast('novoVeiculo');
			ServiceModal.fecharModalVeiculo();
			delete $scope.veiculo;
		});
	}

	$scope.cadastrarFornecedor = function (fornecedor) {
		$http.post('fornecedor', fornecedor).success(function () {
			$rootScope.$broadcast('novoFornecedor');
			delete $scope.fornecedor;
		});
	}
	
	$scope.salvarFornecedor = function (fornecedor) {
		$http.put('fornecedor', fornecedor).success(function () {
			$rootScope.$broadcast('novoFornecedor');
			delete $scope.fornecedor;
		});
	}
	
	$scope.excluirFornecedor = function (fornecedor) {
		$http.delete('fornecedor/' + fornecedor.id + '/' + fornecedor.telefone.id + '/' + fornecedor.contato.id).success(function () {
			$rootScope.$broadcast('novoFornecedor');
			ServiceModal.fecharModalFornecedor();
			delete $scope.funcionario;
		});
	}
	
	$http.get('estado').success(function (data) {
		$scope.estados = data;
	});
	
});

app.factory("ServiceModal", function () {
	
	var modalFuncionario = {};
	var modalFornecedor = {};
	var modalVeiculo = {};
	
	function setModalFuncionario (modal) {
		modalFuncionario = modal;
	}
	
	function fecharModalFuncionario() {
		modalFuncionario.hide();
	}
	
	function setModalFornecedor (modal) {
		modalFornecedor = modal;
	}
	
	function fecharModalFornecedor() {
		modalFornecedor.hide();
	}
	
	function setModalVeiculo (modal) {
		modalVeiculo = modal;
	}
	
	function fecharModalVeiculo() {
		modalVeiculo.hide();
	}
	
	return {
		setModalFuncionario:setModalFuncionario, 
		fecharModalFuncionario:fecharModalFuncionario,
		setModalFornecedor:setModalFornecedor, 
		fecharModalFornecedor:fecharModalFornecedor,
		setModalVeiculo:setModalVeiculo, 
		fecharModalVeiculo:fecharModalVeiculo
	}
});
