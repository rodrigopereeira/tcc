var app = angular.module("tcc", ['ui.grid', 'ui.grid.selection', 'mgcrea.ngStrap']);

app.controller("cadastroController", function ($scope, $modal, $http) {
	
	$scope.tabAtiva = "veiculos";
	
	$scope.alteraTab = function (tab) {
		$scope.tabAtiva = tab;
	}
	
	$scope.cadastrarUsuario = function(tipoUsuario, usuario) {

		if (tipoUsuario == 'administrador') {
			$http.post('administrador', usuario);
		} else if (tipoUsuario == 'motorista') {
			$http.post('motorista', usuario);
		} else if (tipoUsuario == 'usuario') {
			$http.post('usuario', usuario);
		}
	}
	
	$scope.cadastrarVeiculo = function (veiculo) {
		$http.post('veiculo', veiculo);
	}
	
});