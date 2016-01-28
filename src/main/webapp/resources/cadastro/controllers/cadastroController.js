var app = angular.module("tcc", ['ui.grid']);

app.controller("cadastroController", function ($scope) {
	
	$scope.gridVeiculos = {
		    enableSorting: true,
		    columnDefs: [
		      { field: 'placa', displayName: 'Placa' },
		      { field: 'descricao', displayName: 'Descrição' },
		      { field: 'ano', displayName: 'Ano' },
		      { field: 'kmAtual', displayName: 'Km Atual' },
		      { field: 'combustivel', displayName: 'Combustível' },
		      { field: 'marca', displayName: 'Marca' },
		      { field: 'cor', displayName: 'Cor' }
		    ],
		    onRegisterApi: function( gridApi ) {
		      $scope.gridApi = gridApi;
		    }
		  };
	
	$scope.gridMotoristas = {
		    enableSorting: true,
		    columnDefs: [
		      { field: 'placa', displayName: 'Nome' },
		      { field: 'descricao', displayName: 'Email' },
		      { field: 'ano', displayName: 'Sexo' },
		      { field: 'kmAtual', displayName: 'Tipo' }
		    ],
		    onRegisterApi: function( gridApi ) {
		      $scope.gridApi = gridApi;
		    }
		  };
	
	
	
});