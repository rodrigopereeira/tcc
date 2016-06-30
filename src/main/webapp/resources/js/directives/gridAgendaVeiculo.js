app.directive("gridAgendaVeiculo", function() {
    return {
        template: '<div ui-grid="gridAgendaVeiculo" ui-grid-selection class="grid" style="height:200px;"></div>',
        replate: true,
        controller: 'gridAgendaVeiculoController',
        transclude: true,
        restrict: "E"
    };
});

app.controller("gridAgendaVeiculoController", function($scope, $modal, $http) {

    

    $scope.gridAgendaVeiculo.onRegisterApi = function(gridApi) {
        //set gridApi on scope
        $scope.gridApi = gridApi;
        gridApi.selection.on.rowSelectionChanged($scope, function(row) {
            console.log('row selected ' + row.isSelected);
        });
    };



    reset();

    function reset() {
        $http.get('veiculo/historico').success(function(data) {
            $scope.gridAgendaVeiculo.data = data;
        });
    }

});