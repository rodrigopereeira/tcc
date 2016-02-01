app.directive("gridVeiculos", function() {
    return {
    	template: '<div ui-grid="gridVeiculos" ui-grid-selection class="grid"></div>',
        replate: true,
        controller: 'gridVeiculosController',
        transclude: true,
        restrict: "E"
    };
});

app.controller("gridVeiculosController", function($scope, $modal) {

	$scope.gridVeiculos = {
			enableRowSelection: true, 
			enableRowHeaderSelection: false,
			multiSelect: false,
			modifierKeysToMultiSelect: false,
			noUnselect: true,
		    enableSorting: true,
            rowTemplate: "<div ng-dblclick=\"grid.appScope.visualizaVeiculoModal(row)\"  ng-repeat=\"(colRenderIndex, col) in colContainer.renderedColumns track by col.colDef.name\" class=\"ui-grid-cell\" ng-class=\"{ 'ui-grid-row-header-cell': col.isRowHeader }\" ui-grid-cell></div>",
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
	
	$scope.gridVeiculos.onRegisterApi = function(gridApi){
	      //set gridApi on scope
	      $scope.gridApi = gridApi;
	      gridApi.selection.on.rowSelectionChanged($scope,function(row){
	        console.log('row selected ' + row.isSelected);
	      });
	    };
	    
	$scope.visualizaVeiculoModal = function (row) {
		var modalVeiculo = $modal({
			controllerAs: 'cadastroController',
			templateUrl: 'resources/cadastro/modal/veiculo.jsp', 
	        title: 'Visualizar Veículo',
	        backdrop: false,
	        show: false,
	        
			scope: $scope
		});
		
		modalVeiculo.$promise.then(function() {
			modalVeiculo.show();
        });
	}
    
	$scope.gridVeiculos.data = [{}, {}];
});