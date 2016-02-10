var app = angular.module("tcc", ['ui.grid', 'ui.grid.selection', 'mgcrea.ngStrap']);

app.controller("cadastroController", function ($scope, $modal, $http) {
	
	$scope.tabAtiva = "veiculos";
	
	$scope.alteraTab = function (tab) {
		$scope.tabAtiva = tab;
	}
	
	$scope.tipoUsuario = [
	    {id: 1, descricao: 'Administrador'},
	    {id: 2, descricao: 'Motorista'},
	    {id: 3, descricao: 'Usuário'}
	];
	
	$scope.cadastrarUsuario = function(usuario) {

		if (usuario.tipoid == 1) {
			$http.post('administrador', usuario).success(function () {
				delete $scope.usuario;
			});
		} else if (usuario.tipoid == 2) {
			$http.post('motorista', usuario).success(function () {
				console.log("Cadastrou");
				delete $scope.usuario;
			});
		} else if (usuario.tipoid == 3) {
			$http.post('usuario', usuario).success(function () {
				delete $scope.usuario;
			});
		}
	}
	
	$scope.cadastrarVeiculo = function (veiculo) {
		$http.post('veiculo', veiculo);
	}
	
	$http.get('estado').success(function (data) {
		$scope.estados = data;
	});
	
});