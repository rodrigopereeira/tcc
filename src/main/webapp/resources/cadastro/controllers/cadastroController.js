var app = angular.module("tcc", ['ui.grid', 'ui.grid.selection', 'mgcrea.ngStrap']);

app.controller("cadastroController", function ($scope, $modal) {
	
	$scope.tabAtiva = "veiculos";
	
	$scope.alteraTab = function (tab) {
		$scope.tabAtiva = tab;
	}
	
});