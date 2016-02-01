app.directive("gridUsuarios", function() {
    return {
    	template: '<div ui-grid="gridUsuarios" ui-grid-selection class="grid"></div>',
        replate: true,
        controller: 'gridUsuariosController',
        transclude: true,
        restrict: "E"
    };
});

app.controller("gridUsuariosController", function($scope, $modal) {

	$scope.gridUsuarios = {
			enableRowSelection: true, 
			enableRowHeaderSelection: false,
			multiSelect: false,
			modifierKeysToMultiSelect: false,
			noUnselect: true,
		    enableSorting: true,
            rowTemplate: "<div ng-dblclick=\"grid.appScope.visualizaUsuarioModal(row)\"  ng-repeat=\"(colRenderIndex, col) in colContainer.renderedColumns track by col.colDef.name\" class=\"ui-grid-cell\" ng-class=\"{ 'ui-grid-row-header-cell': col.isRowHeader }\" ui-grid-cell></div>",
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
	
	$scope.gridUsuarios.onRegisterApi = function(gridApi){
	      //set gridApi on scope
	      $scope.gridApi = gridApi;
	      gridApi.selection.on.rowSelectionChanged($scope,function(row){
	        console.log('row selected ' + row.isSelected);
	      });
	    };
	
	$scope.visualizaUsuarioModal = function (row) {
		var modalUsuario = {};
		
		//motorista
		if (row.entity.idTipoUsuario == 3) {
			modalUsuario = $modal({
				controllerAs: 'cadastroController',
				templateUrl: 'resources/cadastro/modal/motorista.jsp', 
		        title: 'Visualizar Motorista',
		        backdrop: false,
		        show: false,
		        
				scope: $scope
			});
		} else if (row.entity.idTipoUsuario == 1 || row.entity.idTipoUsuario == 2) {
			modalUsuario = $modal({
				controllerAs: 'cadastroController',
				templateUrl: 'resources/cadastro/modal/usuario.jsp', 
		        title: 'Visualizar Usuário',
		        backdrop: false,
		        show: false,
		        
				scope: $scope
			});
		}
		
		modalUsuario.$promise.then(function() {
			modalUsuario.show();
        });
	}
    
	$scope.gridUsuarios.data = [{idTipoUsuario: 3}, {idTipoUsuario: 2}, {idTipoUsuario: 1}];
    
});