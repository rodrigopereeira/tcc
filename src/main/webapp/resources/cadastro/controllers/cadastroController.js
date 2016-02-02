var app = angular.module("tcc", ['ui.grid', 'ui.grid.selection', 'mgcrea.ngStrap']);

app.controller("cadastroController", function ($scope, $modal, $http) {
	
	$scope.tabAtiva = "veiculos";
	
	$scope.alteraTab = function (tab) {
		$scope.tabAtiva = tab;
	}
	
	$scope.cadastrarUsuario= function(usuario) {

		if (usuario.tipo == 'administrador') {
			delete usuario.tipo;
			$http.post('administrador', usuario);
		} else if (usuario.tipo == 'motorista') {
			delete usuario.tipo;
			$http.post('motorista', usuario);
		} else if (usuario.tipo == 'usuario') {
			delete usuario.tipo;
			$http.post('usuario', usuario);
		}
		
		
		
		
	}
	
	
});