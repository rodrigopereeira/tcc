app.directive("gridAbastecimento", function() {
    return {
        template: '<div ui-grid="gridAbastecimento" ui-grid-selection class="grid"></div>',
        replace: false,
        controller: 'gridAbastecimentoController',
        transclude: true,
        restrict: "E"
    };
});

app.controller("gridAbastecimentoController", function($scope, $modal, $http, ServiceVeiculo, ServiceMotorista, ServiceFornecedor) {

    $scope.gridAbastecimento = {
    	enableFiltering: true,
        rowHeight: '23',
        enableHorizontalScrollbar: 1,
        enableRowSelection: true,
        enableRowHeaderSelection: false,
        multiSelect: false,
        modifierKeysToMultiSelect: false,
        noUnselect: true,
        enableSorting: true,
        rowTemplate: "<div ng-dblclick=\"grid.appScope.visualizaAbastecimentoModal(row)\"  ng-repeat=\"(colRenderIndex, col) in colContainer.renderedColumns track by col.colDef.name\" class=\"ui-grid-cell\" ng-class=\"{ 'ui-grid-row-header-cell': col.isRowHeader }\" ui-grid-cell></div>",
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
            field: 'motorista.nome',
            displayName: 'Motorista',
            width: '150'
        }, {
            field: 'tipoCombustivel',
            displayName: 'Tipo do Combustível',
            width: '135'
        }, {
            field: 'pagamento.valor',
            cellFilter: 'currency',
            displayName: 'Valor',
            width: '100'
        }, {
            field: 'valorLitro',
            cellFilter: 'currency',
            displayName: 'Valor do litro',
            width: '100'
        }, {
            field: 'km',
            displayName: 'KM',
            width: '100'
        }, {
            field: 'kmPercorrido',
            displayName: 'KM percorrido',
            width: '100'
        }, {
            field: 'fornecedor.nomeFantasia',
            displayName: 'Fornecedor',
            width: '150'
        }, ],
        onRegisterApi: function(gridApi) {
            $scope.gridApi = gridApi;
        }
    };

    $scope.gridAbastecimento.onRegisterApi = function(gridApi) {
        //set gridApi on scope
        $scope.gridApi = gridApi;
        gridApi.selection.on.rowSelectionChanged($scope, function(row) {
            console.log('row selected ' + row.isSelected);
        });
    };

    $scope.novoAbastecimento = function() {

        $scope.abastecimento = {};
        $scope.date = new Date();

        var abastecimentoModal = $modal({
            controllerAs: 'gridAbastecimentoController',
            templateUrl: 'resources/js/modal/novoAbastecimento.jsp',
            title: 'Novo Abastecimento',
            backdrop: false,
            show: false,
            scope: $scope
        });
        abastecimentoModal.$promise.then(function() {
            abastecimentoModal.show();
        });
    }

    $scope.visualizaAbastecimentoModal = function(row) {

        $scope.abastecimentoA = {};

        $http.get('abastecimento/' + row.entity.id).success(function(data) {
            $scope.abastecimentoA = data;
        })

        var modalAbastecimento = $modal({
            controllerAs: 'gridAbastecimentoController',
            templateUrl: 'resources/js/modal/visualizaAbastecimento.jsp',
            title: 'Visualizar Abastecimento',
            backdrop: false,
            show: false,
            scope: $scope
        });

        $http.get('abastecimento/' + row.entity.id).success(function(data) {
            $scope.abastecimentoA = data;

            modalAbastecimento.$promise.then(function() {
                modalAbastecimento.show();
            });

        });

    }

    reset();

    function reset() {
        $http.get('abastecimento').success(function(data) {
            $scope.gridAbastecimento.data = data;
        });
        $scope.resetaCombox();
    }

    $scope.defineVeiculoabastecimento = function(veiculoid) {
        var veiculo = ServiceVeiculo.procuraVeiculo(veiculoid);
        $scope.abastecimento.kmAnterior = veiculo.km;
    }

    $scope.defineMotoristaabastecimento = function(motoristaid) {
        $scope.abastecimento.motorista = ServiceMotorista.procuraMotorista(motoristaid);
    }

    $scope.defineFornecedorabastecimento = function(fornecedorid) {
        $scope.abastecimento.fornecedor = ServiceFornecedor.procuraFornecedor(fornecedorid);
    }

    $scope.calculaLitro = function(valorTotal, valorLitro) {
        if (valorLitro > 0) {
            ($scope.abastecimento != null ? $scope.abastecimento.litros = (valorTotal / valorLitro).toFixed(4) : console.log("Calculo Invalido"));
            ($scope.abastecimentoA != null ? $scope.abastecimentoA.litros = (valorTotal / valorLitro).toFixed(4) : console.log("Calculo Invalido"));
        }
    }

    $scope.calculaKmPercorrido = function(kmAnterior, kmAtual) {
        ($scope.abastecimento != null ? $scope.abastecimento.kmPercorrido = kmAtual - kmAnterior : console.log("Calculo Invalido"));
        ($scope.abastecimentoA != null ? $scope.abastecimentoA.kmPercorrido = kmAtual - kmAnterior : console.log("Calculo Invalido"));
    }

    $scope.cadastrarAbastecimento = function(abastecimento) {
        $http.post('abastecimento', abastecimento).success(function() {
            reset();
            delete $scope.abastecimento;
        });
    }

    $scope.salvarAbastecimento = function(abastecimento) {
        $http.put('abastecimento', abastecimento).success(function() {
            reset();
            delete $scope.abastecimentoA;
        });
    }

    $scope.excluirAbastecimento = function(abastecimento) {
        $http.delete('abastecimento/' + abastecimento.id + '/' + abastecimento.pagamento.id).success(function() {
            reset();
            delete $scope.abastecimentoA;
        });
    };
});