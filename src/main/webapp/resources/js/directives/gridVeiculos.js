app.directive("gridVeiculos", function() {
    return {
        template: '<div ui-grid="gridVeiculos" ui-grid-selection class="grid"></div>',
        controller: 'gridVeiculosController',
        transclude: true,
        restrict: "E"
    };
});

app.controller("gridVeiculosController", function($scope, $modal, $http, ServiceModal) {

	

    $scope.gridVeiculos = {
        rowHeight: '23',
        enableRowSelection: true,
        enableRowHeaderSelection: false,
        multiSelect: false,
        modifierKeysToMultiSelect: false,
        noUnselect: true,
        enableSorting: true,
        rowTemplate: "<div ng-dblclick=\"grid.appScope.visualizaVeiculoModal(row)\"  ng-repeat=\"(colRenderIndex, col) in colContainer.renderedColumns track by col.colDef.name\" class=\"ui-grid-cell\" ng-class=\"{ 'ui-grid-row-header-cell': col.isRowHeader }\" ui-grid-cell></div>",
        columnDefs: [{
            field: 'placa',
            displayName: 'Placa'
        }, {
            field: 'modelo',
            displayName: 'Descrição'
        }, {
            field: 'ano',
            displayName: 'Ano'
        }, {
            field: 'km',
            displayName: 'Km Atual'
        }, {
            field: 'combustivel',
            displayName: 'Combustível'
        }, {
            field: 'marca',
            displayName: 'Marca'
        }, {
            field: 'cor',
            displayName: 'Cor'
        }],
        onRegisterApi: function(gridApi) {
            $scope.gridApi = gridApi;
        }
    };
    
    $scope.gridHistoricoVeiculo = {
            rowHeight: '23',
            enableRowHeaderSelection: false,
            enableSorting: true,
            columnDefs: [{
                field: 'acao',
                displayName: 'Tipo'
            }, {
                field: 'data',
                displayName: 'Data',
                cellFilter: 'date:"dd/MM/yyyy HH:mm"',
            }],
            onRegisterApi: function(gridApi) {
                $scope.gridApi = gridApi;
            }
        };
    
    $scope.gridAgendaVeiculo = {
            rowHeight: '23',
            enableRowSelection: true,
            enableRowHeaderSelection: false,
            multiSelect: false,
            modifierKeysToMultiSelect: false,
            noUnselect: true,
            enableSorting: true,
            columnDefs: [{
                field: 'data',
                cellFilter: 'date:"dd/MM/yyyy"',
                displayName: 'Data',
                width: '85'
            }, {
                field: 'hora',
                cellFilter: 'date:"HH:mm"',
                displayName: 'Hora',
                width: '85'
            }, {
                field: 'tipo',
                displayName: 'Tipo',
                width: '150'
            }, {
                field: 'descricao',
                displayName: 'Comentários'
            }],
            onRegisterApi: function(gridApi) {
                $scope.gridApi = gridApi;
            }
        };

    $scope.gridVeiculos.onRegisterApi = function(gridApi) {
        //set gridApi on scope
        $scope.gridApi = gridApi;
        gridApi.selection.on.rowSelectionChanged($scope, function(row) {
            console.log('row selected ' + row.isSelected);
        });
    };

    $scope.visualizaVeiculoModal = function(row) {

        var modalVeiculo = $modal({
            controllerAs: 'cadastroController',
            templateUrl: 'resources/js/modal/veiculo.jsp',
            title: 'Visualizar Veículo',
            backdrop: false,
            show: false,

            scope: $scope
        });

        ServiceModal.setModalVeiculo(modalVeiculo);
        
        $http.get('veiculo/' + row.entity.id).success(function(data) {
            $scope.veiculoA = data;
            
            modalVeiculo.$promise.then(function() {
            	$scope.gridHistoricoVeiculo.data = $scope.veiculoA.historico;
            	$scope.gridAgendaVeiculo.data = $scope.veiculoA.agenda;
                modalVeiculo.show();
            });
        })
        
    }

    $scope.$on('novoVeiculo', function(event, args) {
        reset();
    });

    reset();

    function reset() {
        $http.get('veiculo').success(function(data) {
            $scope.gridVeiculos.data = data;
        });
    }

});