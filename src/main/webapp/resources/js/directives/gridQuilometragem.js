app.directive("gridQuilometragem", function() {
    return {
        template: '<div ui-grid="gridQuilometragem" ui-grid-selection class="grid"></div>',
        replate: true,
        controller: 'gridQuilometragemController',
        transclude: true,
        restrict: "E"
    };
});

app.controller("gridQuilometragemController", function($scope, $modal, $http) {

    $scope.gridQuilometragem = {
        enableFiltering: true,
        rowHeight: '23',
        enableHorizontalScrollbar: 1,
        enableRowSelection: true,
        enableRowHeaderSelection: false,
        multiSelect: false,
        modifierKeysToMultiSelect: false,
        noUnselect: true,
        enableSorting: true,
        rowTemplate: "<div ng-dblclick=\"grid.appScope.visualizaKmModal(row)\"  ng-repeat=\"(colRenderIndex, col) in colContainer.renderedColumns track by col.colDef.name\" class=\"ui-grid-cell\" ng-class=\"{ 'ui-grid-row-header-cell': col.isRowHeader }\" ui-grid-cell></div>",
        columnDefs: [{
            field: 'veiculo.modelo',
            displayName: 'Veículo',
            width: '90',
            filterHeaderTemplate: '<div class="ui-grid-filter-container" ng-repeat="colFilter in col.filters"><select ng-model="colFilter.term" ng-init="colFilter.term = grid.appScope.veiculos[0].modelo" ng-options="veiculo.modelo as veiculo.modelo for veiculo in grid.appScope.veiculos"></select></div>',
        }, {
            field: 'motorista.nome',
            displayName: 'Motorista',
            width: '150'
        }, {
            field: 'kmAtual',
            displayName: 'Km de Chegada',
            width: '150'
        }, {
            field: 'veiculo.km',
            displayName: 'Total Percorrido',
            width: '135',
            cellTemplate: '<div class="ui-grid-cell-contents" >{{row.entity.kmAtual - row.entity.veiculo.km}}</div>'
        }, {
            field: 'dataSaida',
            cellFilter: 'date:"dd/MM/yyyy"',
            displayName: 'Data de Saída',
            width: '110'
        }, {
            field: 'dataChegada',
            cellFilter: 'date:"dd/MM/yyyy"',
            displayName: 'Data de Chegada',
            width: '110'
        }, {
            field: 'destino',
            displayName: 'Destino',
            width: '150'
        }],
        onRegisterApi: function(gridApi) {
            $scope.gridApi = gridApi;
        }
    };

    $scope.gridQuilometragem.onRegisterApi = function(gridApi) {
        //set gridApi on scope
        $scope.gridApi = gridApi;
        gridApi.selection.on.rowSelectionChanged($scope, function(row) {
            console.log('row selected ' + row.isSelected);
        });
    };

    $scope.salvarKm = function(manutencao) {
        $http.put('km', manutencao).success(function() {
            reset();
            delete $scope.kmA;
        });
    }

    $scope.excluirKm = function(row) {
        $http.delete('km/' + row.id).success(function() {
            reset();
            delete $scope.kmA;
        });
    }
    
    $scope.visualizaKmModal = function(row) {

        var modalKm = $modal({
            controllerAs: 'gridKmController',
            templateUrl: 'resources/js/modal/visualizaKm.jsp',
            title: 'Visualizar KM',
            backdrop: false,
            show: false,
            scope: $scope
        });

        $http.get('km/' + row.entity.id).success(function(data) {
            $scope.kmA = data;

            modalKm.$promise.then(function() {
                modalKm.show();
            });
        })

    };

    $scope.$on('novoKM', function(event, args) {
        reset();
    });

    reset();

    function reset() {
        $http.get('km').success(function(data) {
            $scope.gridQuilometragem.data = data;
        });
        
        $scope.resetaCombox();
    }
});