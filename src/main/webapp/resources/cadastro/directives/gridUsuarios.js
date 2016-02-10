app.directive("gridUsuarios", function() {
    return {
    	template: '<div ui-grid="gridUsuarios" ui-grid-selection class="grid"></div>',
        replate: true,
        controller: 'gridUsuariosController',
        transclude: true,
        restrict: "E"
    };
});

app.controller("gridUsuariosController", function($scope, $modal, $http) {

	$scope.gridUsuarios = {
			rowHeight: '22',
			enableRowSelection: true, 
			enableRowHeaderSelection: false,
			multiSelect: false,
			modifierKeysToMultiSelect: false,
			noUnselect: true,
		    enableSorting: true,
            rowTemplate: "<div ng-dblclick=\"grid.appScope.visualizaUsuarioModal(row)\"  ng-repeat=\"(colRenderIndex, col) in colContainer.renderedColumns track by col.colDef.name\" class=\"ui-grid-cell\" ng-class=\"{ 'ui-grid-row-header-cell': col.isRowHeader }\" ui-grid-cell></div>",
		    columnDefs: [
		      { field: 'nome', displayName: 'Nome' },
		      { field: 'email', displayName: 'Email' },
		      { field: 'sexo', displayName: 'Sexo' },
		      { field: 'tipoUsuario', displayName: 'Tipo' }
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
		
		if (row.entity.tipoid == 1) {
			$http.get('administrador/' + row.entity.id).success(function (data) {
				$scope.usuario = data;
			})
		} else if (row.entity.tipoid == 2) {
			$http.get('motorista/' + row.entity.id).success(function (data) {
				$scope.usuario = data;
			})
		} else if (row.entity.tipoid == 3) {
			$http.get('usuario/' + row.entity.id).success(function (data) {
				$scope.usuario = data;
			})
		}
		
		//motorista
		if (row.entity.tipoid == 2) {
			modalUsuario = $modal({
				controllerAs: 'cadastroController',
				templateUrl: 'resources/cadastro/modal/motorista.jsp', 
		        title: 'Visualizar Motorista',
		        backdrop: false,
		        show: false,
		        
				scope: $scope
			});
		} else if (row.entity.tipoid == 1 || row.entity.tipoid == 3) {
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
    
	$http.get('funcionario').success(function (data) {
		$scope.gridUsuarios.data = data;
	});	
	
    
});