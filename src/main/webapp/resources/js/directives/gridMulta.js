app.directive("gridMulta", function() {
    return {
        template: '<div ui-grid="gridMulta" ui-grid-selection class="grid"></div>',
        replate: true,
        controller: 'gridMultaController',
        transclude: true,
        restrict: "E"
    };
});

app.controller("gridMultaController", function($scope, $modal, $http, ServiceVeiculo, ServiceMotorista, ServiceFornecedor) {

    $scope.gridMulta = {
    	enableFiltering: true,
        rowHeight: '23',
        enableHorizontalScrollbar: 1,
        enableRowSelection: true,
        enableRowHeaderSelection: false,
        multiSelect: false,
        modifierKeysToMultiSelect: false,
        noUnselect: true,
        enableSorting: true,
        rowTemplate: "<div ng-dblclick=\"grid.appScope.visualizaMultaModal(row)\"  ng-repeat=\"(colRenderIndex, col) in colContainer.renderedColumns track by col.colDef.name\" class=\"ui-grid-cell\" ng-class=\"{ 'ui-grid-row-header-cell': col.isRowHeader }\" ui-grid-cell></div>",
        columnDefs: [{
            field: 'data',
            cellFilter: 'date:"dd/MM/yyyy"',
            displayName: 'Data',
            width: '100'
        }, {
            field: 'hora',
            cellFilter: 'date:"HH:mm"',
            displayName: 'Hora',
            width: '90'
        },{
            field: 'veiculo.modelo',
            displayName: 'Veículo',
            width: '150'
        }, {
            field: 'motorista.nome',
            displayName: 'Motorista',
            width: '150'
        }, {
            field: 'pagamento.valor',
            cellFilter: 'currency',
            displayName: 'Valor',
            width: '100'
        }, {
            field: 'status',
            displayName: 'Status',
            width: '100'
        }, {
            field: 'dataVencimento',
            cellFilter: 'date:"dd/MM/yyyy"',
            displayName: 'Data de Vencimento',
            width: '125'
        },{
            field: 'descricao',
            displayName: 'Descrição',
            width: '250'
        }, ],
        onRegisterApi: function(gridApi) {
            $scope.gridApi = gridApi;
        }
    };

    $scope.gridMulta.onRegisterApi = function(gridApi) {
        //set gridApi on scope
        $scope.gridApi = gridApi;
        gridApi.selection.on.rowSelectionChanged($scope, function(row) {
            console.log('row selected ' + row.isSelected);
        });
    };

    $scope.novoMulta = function() {

        $scope.multa = {};
        $scope.date = new Date();

        var multaModal = $modal({
            controllerAs: 'gridMultaController',
            templateUrl: 'resources/js/modal/novoMulta.jsp',
            title: 'Nova Multa',
            backdrop: false,
            show: false,
            scope: $scope
        });
        multaModal.$promise.then(function() {
            multaModal.show();
        });
    }
    
    $scope.salvarMulta = function(multa) {
        $http.put('multa', multa).success(function() {
            reset();
            delete $scope.multaA;
        });
    }
    
    $scope.excluirMulta = function(multa) {
        $http.delete('multa/' + multa.id).success(function() {
            reset();
            delete $scope.multaA;
        });
    }

    $scope.visualizaMultaModal = function(row) {

        $scope.multaA = {};

        $http.get('multa/' + row.entity.id).success(function(data) {
            $scope.multaA = data;
        })

        var modalMulta = $modal({
            controllerAs: 'gridMultaController',
            templateUrl: 'resources/js/modal/visualizaMulta.jsp',
            title: 'Visualizar Multa',
            backdrop: false,
            show: false,
            scope: $scope
        });

        $http.get('multa/' + row.entity.id).success(function(data) {
            $scope.multaA = data;

            modalMulta.$promise.then(function() {
                modalMulta.show();
            });
        })

    }

    $scope.cadastrarMulta = function(multa) {
        $http.post('multa', multa).success(function() {
            reset();
            delete $scope.multa;
        });
    }

    reset();

    function reset() {
        $http.get('multa').success(function(data) {
            $scope.gridMulta.data = data;
        });
    }

});