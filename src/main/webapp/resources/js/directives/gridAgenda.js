app.directive("gridAgenda", function() {
    return {
        template: '<div ui-grid="gridAgenda" ui-grid-selection class="grid"></div>',
        replate: true,
        controller: 'gridAgendaController',
        transclude: true,
        restrict: "E"
    };
});

app.controller("gridAgendaController", function($scope, $modal, $http) {

    $scope.gridAgenda = {
        rowHeight: '23',
        enableHorizontalScrollbar: 1,
        enableRowSelection: true,
        enableRowHeaderSelection: false,
        multiSelect: false,
        modifierKeysToMultiSelect: false,
        noUnselect: true,
        enableSorting: true,
        rowTemplate: "<div ng-dblclick=\"grid.appScope.visualizaAgendamentoModal(row)\"  ng-repeat=\"(colRenderIndex, col) in colContainer.renderedColumns track by col.colDef.name\" class=\"ui-grid-cell\" ng-class=\"{ 'ui-grid-row-header-cell': col.isRowHeader }\" ui-grid-cell></div>",
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
            field: 'veiculo.modelo',
            displayName: 'Veículo',
            width: '120'
        }, {
            field: 'tipo',
            displayName: 'Tipo',
            width: '120'
        }, {
            field: 'local',
            displayName: 'Local',
            width: '150'
        }, {
            field: 'fornecedor.nomeFantasia',
            displayName: 'Fornecedor',
            width: '150'
        }, {
            field: 'descricao',
            displayName: 'Comentários'
        }],
        onRegisterApi: function(gridApi) {
            $scope.gridApi = gridApi;
        }
    };

    $scope.gridAgenda.onRegisterApi = function(gridApi) {
        //set gridApi on scope
        $scope.gridApi = gridApi;
        gridApi.selection.on.rowSelectionChanged($scope, function(row) {
            console.log('row selected ' + row.isSelected);
        });
    };

    $scope.visualizaAgendamentoModal = function(row) {

        $http.get('agenda/' + row.entity.id).success(function(data) {
            $scope.agendaA = data;
        })

        var modalAgenda = $modal({
            controllerAs: 'gridAgendaController',
            templateUrl: 'resources/js/modal/visualizaAgendamento.jsp',
            title: 'Visualizar Agenda',
            backdrop: false,
            show: false,
            scope: $scope
        });

        modalAgenda.$promise.then(function() {
            modalAgenda.show();
        });

    }

    $scope.salvarAgenda = function(agenda) {
        $http.put('agenda', agenda).success(function() {
            reset();
            delete $scope.agenda;
        });
    }

    $scope.excluirAgenda = function(row) {
        $http.delete('agenda/' + row.id).success(function() {
            reset();
            delete $scope.agenda;
        });
    }


    $scope.$on('novaAgenda', function(event, args) {
        reset();
    });

    reset();

    function reset() {
        $http.get('agenda').success(function(data) {
            $scope.gridAgenda.data = data;
        });
    }

});