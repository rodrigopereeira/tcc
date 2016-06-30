app.directive("gridFornecedores", function() {
    return {
        template: '<div ui-grid="gridFornecedores" ui-grid-selection class="grid"></div>',
        replate: true,
        controller: 'gridFornecedoresController',
        transclude: true,
        restrict: "E"
    };
});

app.controller("gridFornecedoresController", function($scope, $modal, $http, ServiceModal) {

    $scope.gridFornecedores = {
        rowHeight: '23',
        enableRowSelection: true,
        enableRowHeaderSelection: false,
        multiSelect: false,
        modifierKeysToMultiSelect: false,
        noUnselect: true,
        enableSorting: true,
        rowTemplate: "<div ng-dblclick=\"grid.appScope.visualizaFornecedorModal(row)\"  ng-repeat=\"(colRenderIndex, col) in colContainer.renderedColumns track by col.colDef.name\" class=\"ui-grid-cell\" ng-class=\"{ 'ui-grid-row-header-cell': col.isRowHeader }\" ui-grid-cell></div>",
        columnDefs: [{
            field: 'razaoSocial',
            displayName: 'Razão Social'
        }, {
            field: 'nomeFantasia',
            displayName: 'Nome Fantasia'
        }, {
            field: 'cnpj',
            displayName: 'CNPJ'
        }, {
            field: 'inscricaoEstadual',
            displayName: 'IE'
        }, {
            field: 'email',
            displayName: 'Email'
        }, {
            field: 'tipoFornecedor',
            displayName: 'Tipo'
        }],
        onRegisterApi: function(gridApi) {
            $scope.gridApi = gridApi;
        }
    };

    $scope.gridFornecedores.onRegisterApi = function(gridApi) {
        //set gridApi on scope
        $scope.gridApi = gridApi;
        gridApi.selection.on.rowSelectionChanged($scope, function(row) {
            console.log('row selected ' + row.isSelected);
        });
    };

    $scope.visualizaFornecedorModal = function(row) {

        $http.get('fornecedor/' + row.entity.id).success(function(data) {
            $scope.fornecedorA = data;
        })

        var modalFornecedor = $modal({
            controllerAs: 'cadastroController',
            templateUrl: 'resources/js/modal/fornecedor.jsp',
            title: 'Visualizar Fornecedor',
            backdrop: false,
            show: false,

            scope: $scope
        });

        ServiceModal.setModalFornecedor(modalFornecedor);


        modalFornecedor.$promise.then(function() {
            modalFornecedor.show();
        });
    }

    $scope.$on('novoFornecedor', function(event, args) {
        reset();
    });

    reset();

    function reset() {
        $http.get('fornecedor').success(function(data) {
            $scope.gridFornecedores.data = data;
        });
    }

});