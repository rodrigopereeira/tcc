app.directive("gridManutencao", function() {
    return {
        template: '<div ui-grid="gridManutencao" ui-grid-selection class="grid"></div>',
        replate: true,
        controller: 'gridManutencaoController',
        transclude: true,
        restrict: "E"
    };
});

app.controller("gridManutencaoController", function($scope, $modal, $http) {

	 $scope.salvarManutencao = function(manutencao) {
        $http.put('manutencao', manutencao).success(function() {
            reset();
            delete $scope.manutencaoA;
        });
    }

    $scope.excluirManutencao = function(row) {
        $http.delete('manutencao/' + row.id).success(function() {
            reset();
            delete $scope.manutencaoA;
        });
    }
    
	$scope.visualizaManutencaoModal = function(row) {
		
		var modalManutencao = $modal({
		    controllerAs: 'gridManutencaiController',
		    templateUrl: 'resources/js/modal/visualizaManutencao.jsp',
		    title: 'Visualizar Manutenção',
		    backdrop: false,
		    show: false,
		    scope: $scope
		});
		
		$http.get('manutencao/' + row.entity.id).success(function(data) {
		    $scope.manutencaoA = data;
		
		    modalManutencao.$promise.then(function() {
		        modalManutencao.show();
		    });
		})
	
	}

    
    $scope.gridManutencao = {
    	enableFiltering: true,
        rowHeight: '23',
        enableHorizontalScrollbar: 1,
        enableRowSelection: true,
        enableRowHeaderSelection: false,
        multiSelect: false,
        modifierKeysToMultiSelect: false,
        noUnselect: true,
        enableSorting: true,
        rowTemplate: "<div ng-dblclick=\"grid.appScope.visualizaManutencaoModal(row)\"  ng-repeat=\"(colRenderIndex, col) in colContainer.renderedColumns track by col.colDef.name\" class=\"ui-grid-cell\" ng-class=\"{ 'ui-grid-row-header-cell': col.isRowHeader }\" ui-grid-cell></div>",
        columnDefs: [{
            field: 'data',
            cellFilter: 'date:"dd/MM/yyyy"',
            displayName: 'Data',
            width: '90'
        }, {
            field: 'veiculo.modelo',
            displayName: 'Veículo',
            width: '150'
        }, {
            field: 'pagamento.valor',
            cellFilter: 'currency',
            displayName: 'Valor',
            width: '100'
        }, {
            field: 'tipoManutencao',
            displayName: 'Tipo',
            width: '150'
        }, {
            field: 'status',
            displayName: 'Status',
            width: '150'
        }, {
            field: 'fornecedor.nomeFantasia',
            displayName: 'Fornecedor',
            width: '150'
        }, {
            field: 'problema',
            displayName: 'Comentários'
        }],
        onRegisterApi: function(gridApi) {
            $scope.gridApi = gridApi;
        }
    };


    $scope.gridManutencao.onRegisterApi = function(gridApi) {
        //set gridApi on scope
        $scope.gridApi = gridApi;
        gridApi.selection.on.rowSelectionChanged($scope, function(row) {
            console.log('row selected ' + row.isSelected);
        });
    };

    

    $scope.$on('novaManutencao', function(event, args) {
        reset();
    });

    reset();

    function reset() {
        $http.get('manutencao').success(function(data) {
            $scope.gridManutencao.data = data;
        });
    }
});