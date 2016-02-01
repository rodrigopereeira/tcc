app.directive("gridFornecedores", function() {
    return {
    	template: '<div ui-grid="gridFornecedores" ui-grid-selection class="grid"></div>',
        replate: true,
        controller: 'gridFornecedoresController',
        transclude: true,
        restrict: "E"
    };
});

app.controller("gridFornecedoresController", function($scope, $modal) {

	$scope.gridFornecedores = {
			enableRowSelection: true, 
			enableRowHeaderSelection: false,
			multiSelect: false,
			modifierKeysToMultiSelect: false,
			noUnselect: true,
		    enableSorting: true,
            rowTemplate: "<div ng-dblclick=\"grid.appScope.visualizaFornecedorModal(row)\"  ng-repeat=\"(colRenderIndex, col) in colContainer.renderedColumns track by col.colDef.name\" class=\"ui-grid-cell\" ng-class=\"{ 'ui-grid-row-header-cell': col.isRowHeader }\" ui-grid-cell></div>",
		    columnDefs: [
		      { field: 'placa', displayName: 'Razão Social' },
		      { field: 'descricao', displayName: 'Nome Fantasia' },
		      { field: 'ano', displayName: 'CNPJ' },
		      { field: 'kmAtual', displayName: 'IE' },
		      { field: 'kmAtual', displayName: 'Email' },
		      { field: 'kmAtual', displayName: 'Tipo' }
		    ],
		    onRegisterApi: function( gridApi ) {
		      $scope.gridApi = gridApi;
		    }
		  };
	
	$scope.gridFornecedores.onRegisterApi = function(gridApi){
	      //set gridApi on scope
	      $scope.gridApi = gridApi;
	      gridApi.selection.on.rowSelectionChanged($scope,function(row){
	        console.log('row selected ' + row.isSelected);
	      });
	    };
	
	$scope.visualizaFornecedorModal = function (row) {
		var modalFornecedor = $modal({
			controllerAs: 'cadastroController',
			templateUrl: 'resources/cadastro/modal/fornecedor.jsp', 
	        title: 'Visualizar Fornecedor',
	        backdrop: false,
	        show: false,
	        
			scope: $scope
		});
		
		modalFornecedor.$promise.then(function() {
			modalFornecedor.show();
        });
	}
    
	$scope.gridFornecedores.data = [{}, {}];
    
});