var app = angular.module('app', ['ngAnimate', 'ui.grid.pagination', 'ngTouch', 'ui.grid', 'ui.grid.pagination', 'ui.grid.autoResize', 'ui.grid.moveColumns', 'ui.grid.selection', 'ui.grid.cellNav',  'ui.grid.edit']);

app.controller('MainCtrl', ['$scope', '$http', 'uiGridConstants', function ($scope, $timeout, $http) {
    
    $scope.visualizaPedido = function(row) {
            var chamado = row.entity;
        }

        $scope.visualizaPedidoModal = function(row) {
            var chamado = row.entity;
            
        }

        var paginationOptions = {
            pageNumber: 1,
            pageSize: 26,
            sort: null,
            columnSort: null
        };
    
    
  $scope.gridOptions1 = {
    enableRowHeaderSelection: false,
            multiSelect: false,
            enableFiltering: true,
            paginationPageSizes: [26, 52, 104],
            paginationPageSize: 26,
            enableHorizontalScrollbar: 1,
            columnDefs: [{
                field: 'productnumber',
                displayName: 'OS',
                width: '100',
                filterHeaderTemplate: '<div class="ui-grid-filter-container ng-scope"> <input ng-enter="grid.appScope.filtraTodosTrabalhos()" type="text" class="ui-grid-filter-input" ng-model="grid.appScope.todosTrabalhos.productnumber"></div>'
            }, {
                field: 'requestid',
                displayName: 'Ped.',
                width: '40',
                filterHeaderTemplate: '<div class="ui-grid-filter-container ng-scope"> <input ng-enter="grid.appScope.filtraTodosTrabalhos()" type="text" class="ui-grid-filter-input" ng-model="grid.appScope.todosTrabalhos.requestid"></div>'
            }, {
                field: 'version',
                displayName: 'Ver.',
                width: '40',
                filterHeaderTemplate: '<div class="ui-grid-filter-container ng-scope"> <input ng-enter="grid.appScope.filtraTodosTrabalhos()" type="text" class="ui-grid-filter-input" ng-model="grid.appScope.todosTrabalhos.version"></div>'
            }, {
                field: 'description',
                displayName: 'Nome do Servi�o',
                width: '250',
                filterHeaderTemplate: '<div class="ui-grid-filter-container ng-scope"> <input ng-enter="grid.appScope.filtraTodosTrabalhos()" type="text" class="ui-grid-filter-input" ng-model="grid.appScope.todosTrabalhos.description"></div>'
            }, {
                field: 'technology',
                displayName: 'Tec.',
                width: '130',
                filterHeaderTemplate: '<div class="ui-grid-filter-container ng-scope"> <select ng-change="grid.appScope.filtraTodosTrabalhos()" class="ui-grid-filter-input" ng-model="grid.appScope.todosTrabalhos.technology"><option value="">Todos</option><option value="Antigo!">Antigo</option><option value="Convencional">Convencional</option><option value="Digital">Digital</option><option value="HD Flexo">HD Flexo</option><option value="LUX">LUX</option><option value="NExT">NExT</option><option value="NX">NX</option><option value="Sem">Sem</option><option value="UV2">UV2</option></select>   </div>'
            }, {
                field: 'thickness',
                displayName: 'Esp.',
                width: '50',
                filterHeaderTemplate: '<div class="ui-grid-filter-container ng-scope"> <input ng-enter="grid.appScope.filtraTodosTrabalhos()" type="text" class="ui-grid-filter-input" ng-model="grid.appScope.todosTrabalhos.thickness"></div>'
            }, {
                field: 'customer',
                displayName: 'Cliente',
                width: '120',
                filterHeaderTemplate: '<div class="ui-grid-filter-container ng-scope"> <input ng-enter="grid.appScope.filtraTodosTrabalhos()" type="text" class="ui-grid-filter-input" ng-model="grid.appScope.todosTrabalhos.customer"></div>'
            }, {
                field: 'productcode',
                displayName: 'C�digo do Produto',
                width: '120',
                filterHeaderTemplate: '<div class="ui-grid-filter-container ng-scope"> <input ng-enter="grid.appScope.filtraTodosTrabalhos()" type="text" class="ui-grid-filter-input" ng-model="grid.appScope.todosTrabalhos.productcode"></div>'
            }, {
                field: 'barcodenumber',
                displayName: 'C�d. de Barras',
                width: '100',
                filterHeaderTemplate: '<div class="ui-grid-filter-container ng-scope"> <input ng-enter="grid.appScope.filtraTodosTrabalhos()" type="text" class="ui-grid-filter-input" ng-model="grid.appScope.todosTrabalhos.barcodenumber"></div>'
            }, {
                field: 'engravinglocation',
                displayName: 'Local de Gravacao',
                width: '120',
                filterHeaderTemplate: '<div class="ui-grid-filter-container ng-scope"> <input ng-enter="grid.appScope.filtraTodosTrabalhos()" type="text" class="ui-grid-filter-input" ng-model="grid.appScope.todosTrabalhos.engravinglocation"></div>'
            }, {
                field: 'prepresslocation',
                displayName: 'Local de Editora��o',
                width: '120',
                filterHeaderTemplate: '<div class="ui-grid-filter-container ng-scope"> <input ng-enter="grid.appScope.filtraTodosTrabalhos()" type="text" class="ui-grid-filter-input" ng-model="grid.appScope.todosTrabalhos.prepresslocation"></div>'
            }, {
                field: 'requeststatus',
                displayName: 'Status',
                width: '100',
                filterHeaderTemplate: '<div class="ui-grid-filter-container ng-scope"> <input ng-enter="grid.appScope.filtraTodosTrabalhos()" type="text" class="ui-grid-filter-input" ng-model="grid.appScope.todosTrabalhos.requeststatus"></div>'
            }, {
                field: 'requesttype',
                displayName: 'Tipo de Pedido',
                width: '100',
                filterHeaderTemplate: '<div class="ui-grid-filter-container ng-scope"> <input ng-enter="grid.appScope.filtraTodosTrabalhos()" type="text" class="ui-grid-filter-input" ng-model="grid.appScope.todosTrabalhos.requesttype"></div>'
            }, {
                field: 'material',
                displayName: 'Material',
                width: '100',
                filterHeaderTemplate: '<div class="ui-grid-filter-container ng-scope"> <input ng-enter="grid.appScope.filtraTodosTrabalhos()" type="text" class="ui-grid-filter-input" ng-model="grid.appScope.todosTrabalhos.material"></div>'
            }, {
                field: 'customerjobref',
                displayName: 'Observa��es Nota',
                width: '150',
                filterHeaderTemplate: '<div class="ui-grid-filter-container ng-scope"> <input ng-enter="grid.appScope.filtraTodosTrabalhos()" type="text" class="ui-grid-filter-input" ng-model="grid.appScope.todosTrabalhos.customerjobref"></div>'
            }, {
                field: 'blockenginvdescription',
                displayName: 'Ordem de Compra',
                width: '100',
                filterHeaderTemplate: '<div class="ui-grid-filter-container ng-scope"> <input ng-enter="grid.appScope.filtraTodosTrabalhos()" type="text" class="ui-grid-filter-input" ng-model="grid.appScope.todosTrabalhos.blockenginvdescription"></div>'
            }, {
                field: 'user',
                displayName: 'Respons�vel',
                width: '120',
                filterHeaderTemplate: '<div class="ui-grid-filter-container ng-scope"> <input ng-enter="grid.appScope.filtraTodosTrabalhos()" type="text" class="ui-grid-filter-input" ng-model="grid.appScope.todosTrabalhos.user"></div>'
            }, {
                field: 'creationdate',
                type: 'date',
                cellFilter: 'date:"dd/MM/yyyy"',
                displayName: 'Cria��o',
                width: '100',
                filterHeaderTemplate: '<div class="ui-grid-filter-container ng-scope"> <input ng-enter="grid.appScope.filtraTodosTrabalhos()" type="text" class="ui-grid-filter-input" ng-model="grid.appScope.todosTrabalhos.creationdate"></div>'
            }, {
                field: 'duedate',
                type: 'date',
                cellFilter: 'date:"dd/MM/yyyy"',
                displayName: 'Despachar',
                width: '100',
                filterHeaderTemplate: '<div class="ui-grid-filter-container ng-scope"> <input ng-enter="grid.appScope.filtraTodosTrabalhos()" type="text" class="ui-grid-filter-input" ng-model="grid.appScope.todosTrabalhos.duedate"></div>'
            }],

            onRegisterApi: function(gridApi) {

                $scope.gridApi = gridApi;

                    $scope.gridApi.core.handleWindowResize();


                gridApi.cellNav.on.navigate($scope, function(newRowCol, oldRowCol) {

                    $scope.gridApi.selection.selectRow(newRowCol.row.entity);
                    $scope.visualizaPedido(newRowCol.row);

                });

                gridApi.pagination.on.paginationChanged($scope, function(newPage, pageSize) {

                    paginationOptions.pageNumber = newPage;
                    paginationOptions.pageSize = pageSize;

                    $scope.filtraTodosTrabalhos();
                });

                gridApi.core.on.sortChanged($scope, function(grid, sortColumns) {

                    if (sortColumns.length == 0) {
                        paginationOptions.sort = null;
                    } else {
                        paginationOptions.columnSort = sortColumns[0].field;
                        paginationOptions.sort = sortColumns[0].sort.direction;
                    }

                    $scope.filtraTodosTrabalhos();
                });
            },
            rowTemplate: "<div ng-dblclick=\"grid.appScope.visualizaPedidoModal(row)\"  ng-repeat=\"(colRenderIndex, col) in colContainer.renderedColumns track by col.colDef.name\" class=\"ui-grid-cell\" ui-grid-cell></div>"
  };
    
    $scope.todosTrabalhos = {
            invoicenumber: "",
            productnumber: "",
            requestid: "",
            version: "",
            description: "",
            technology: "",
            thickness: "",
            customer: "",
            productcode: "",
            barcodenumber: "",
            engravinglocation: "",
            prepresslocation: "",
            requeststatus: "",
            requesttype: "",
            material: "",
            customerjobref: "",
            blockenginvdescription: "",
            user: "",
            creationdate: "",
            duedate: ""
        };

        $scope.filtraTodosTrabalhos = function() {

            $scope.loading = true;

            var pesquisa = {
                paginaAtual: paginationOptions.pageNumber,
                registrosMostrados: paginationOptions.pageSize,
                colunaDirecao: (paginationOptions.sort == null ? "id" : paginationOptions.columnSort),
                direcao: (paginationOptions.sort == null ? "desc" : paginationOptions.sort),

                productnumber: $scope.todosTrabalhos.productnumber,
                requestid: $scope.todosTrabalhos.requestid,
                version: $scope.todosTrabalhos.version,
                description: $scope.todosTrabalhos.description,
                technology: $scope.todosTrabalhos.technology,
                thickness: $scope.todosTrabalhos.thickness,
                customer: $scope.todosTrabalhos.customer,
                productcode: $scope.todosTrabalhos.productcode,
                barcodenumber: $scope.todosTrabalhos.barcodenumber,
                engravinglocation: $scope.todosTrabalhos.engravinglocation,
                prepresslocation: $scope.todosTrabalhos.prepresslocation,
                requeststatus: $scope.todosTrabalhos.requeststatus,
                requesttype: $scope.todosTrabalhos.requesttype,
                material: $scope.todosTrabalhos.material,
                customerjobref: $scope.todosTrabalhos.customerjobref,
                blockenginvdescription: $scope.todosTrabalhos.blockenginvdescription,
                user: $scope.todosTrabalhos.user,
                creationdate: $scope.todosTrabalhos.creationdate,
                duedate: $scope.todosTrabalhos.duedate,
            };

            
           $scope.gridOptions1.data = [
  {
    "productnumber": "marinastephenson@injoy.com",
    "requestid": "marinastephenson@injoy.com",
    "version": "marinastephenson@injoy.com",
    "description": "marinastephenson@injoy.com",
    "technology": "marinastephenson@injoy.com",
    "thickness": "marinastephenson@injoy.com",
    "customer": "marinastephenson@injoy.com",
    "productcode": "marinastephenson@injoy.com",
    "barcodenumber": "marinastephenson@injoy.com",
    "engravinglocation": "marinastephenson@injoy.com",
    "prepresslocation": "marinastephenson@injoy.com",
    "requeststatus": "marinastephenson@injoy.com",
    "requesttype": "marinastephenson@injoy.com",
    "material": "marinastephenson@injoy.com",
    "blockengdescription": "marinastephenson@injoy.com",
    "user": "marinastephenson@injoy.com",
    "creationdate": "marinastephenson@injoy.com",
    "duedate": "marinastephenson@injoy.com"
  },
  {
    "productnumber": "marinastephenson@injoy.com",
    "requestid": "marinastephenson@injoy.com",
    "version": "marinastephenson@injoy.com",
    "description": "marinastephenson@injoy.com",
    "technology": "marinastephenson@injoy.com",
    "thickness": "marinastephenson@injoy.com",
    "customer": "marinastephenson@injoy.com",
    "productcode": "marinastephenson@injoy.com",
    "barcodenumber": "marinastephenson@injoy.com",
    "engravinglocation": "marinastephenson@injoy.com",
    "prepresslocation": "marinastephenson@injoy.com",
    "requeststatus": "marinastephenson@injoy.com",
    "requesttype": "marinastephenson@injoy.com",
    "material": "marinastephenson@injoy.com",
    "blockengdescription": "marinastephenson@injoy.com",
    "user": "marinastephenson@injoy.com",
    "creationdate": "marinastephenson@injoy.com",
    "duedate": "marinastephenson@injoy.com"
  },
  {
    "productnumber": "marinastephenson@injoy.com",
    "requestid": "marinastephenson@injoy.com",
    "version": "marinastephenson@injoy.com",
    "description": "marinastephenson@injoy.com",
    "technology": "marinastephenson@injoy.com",
    "thickness": "marinastephenson@injoy.com",
    "customer": "marinastephenson@injoy.com",
    "productcode": "marinastephenson@injoy.com",
    "barcodenumber": "marinastephenson@injoy.com",
    "engravinglocation": "marinastephenson@injoy.com",
    "prepresslocation": "marinastephenson@injoy.com",
    "requeststatus": "marinastephenson@injoy.com",
    "requesttype": "marinastephenson@injoy.com",
    "material": "marinastephenson@injoy.com",
    "blockengdescription": "marinastephenson@injoy.com",
    "user": "marinastephenson@injoy.com",
    "creationdate": "marinastephenson@injoy.com",
    "duedate": "marinastephenson@injoy.com"
  },
  {
    "productnumber": "marinastephenson@injoy.com",
    "requestid": "marinastephenson@injoy.com",
    "version": "marinastephenson@injoy.com",
    "description": "marinastephenson@injoy.com",
    "technology": "marinastephenson@injoy.com",
    "thickness": "marinastephenson@injoy.com",
    "customer": "marinastephenson@injoy.com",
    "productcode": "marinastephenson@injoy.com",
    "barcodenumber": "marinastephenson@injoy.com",
    "engravinglocation": "marinastephenson@injoy.com",
    "prepresslocation": "marinastephenson@injoy.com",
    "requeststatus": "marinastephenson@injoy.com",
    "requesttype": "marinastephenson@injoy.com",
    "material": "marinastephenson@injoy.com",
    "blockengdescription": "marinastephenson@injoy.com",
    "user": "marinastephenson@injoy.com",
    "creationdate": "marinastephenson@injoy.com",
    "duedate": "marinastephenson@injoy.com"
  },
  {
    "productnumber": "marinastephenson@injoy.com",
    "requestid": "marinastephenson@injoy.com",
    "version": "marinastephenson@injoy.com",
    "description": "marinastephenson@injoy.com",
    "technology": "marinastephenson@injoy.com",
    "thickness": "marinastephenson@injoy.com",
    "customer": "marinastephenson@injoy.com",
    "productcode": "marinastephenson@injoy.com",
    "barcodenumber": "marinastephenson@injoy.com",
    "engravinglocation": "marinastephenson@injoy.com",
    "prepresslocation": "marinastephenson@injoy.com",
    "requeststatus": "marinastephenson@injoy.com",
    "requesttype": "marinastephenson@injoy.com",
    "material": "marinastephenson@injoy.com",
    "blockengdescription": "marinastephenson@injoy.com",
    "user": "marinastephenson@injoy.com",
    "creationdate": "marinastephenson@injoy.com",
    "duedate": "marinastephenson@injoy.com"
  },
  {
    "productnumber": "marinastephenson@injoy.com",
    "requestid": "marinastephenson@injoy.com",
    "version": "marinastephenson@injoy.com",
    "description": "marinastephenson@injoy.com",
    "technology": "marinastephenson@injoy.com",
    "thickness": "marinastephenson@injoy.com",
    "customer": "marinastephenson@injoy.com",
    "productcode": "marinastephenson@injoy.com",
    "barcodenumber": "marinastephenson@injoy.com",
    "engravinglocation": "marinastephenson@injoy.com",
    "prepresslocation": "marinastephenson@injoy.com",
    "requeststatus": "marinastephenson@injoy.com",
    "requesttype": "marinastephenson@injoy.com",
    "material": "marinastephenson@injoy.com",
    "blockengdescription": "marinastephenson@injoy.com",
    "user": "marinastephenson@injoy.com",
    "creationdate": "marinastephenson@injoy.com",
    "duedate": "marinastephenson@injoy.com"
  },
  {
    "productnumber": "marinastephenson@injoy.com",
    "requestid": "marinastephenson@injoy.com",
    "version": "marinastephenson@injoy.com",
    "description": "marinastephenson@injoy.com",
    "technology": "marinastephenson@injoy.com",
    "thickness": "marinastephenson@injoy.com",
    "customer": "marinastephenson@injoy.com",
    "productcode": "marinastephenson@injoy.com",
    "barcodenumber": "marinastephenson@injoy.com",
    "engravinglocation": "marinastephenson@injoy.com",
    "prepresslocation": "marinastephenson@injoy.com",
    "requeststatus": "marinastephenson@injoy.com",
    "requesttype": "marinastephenson@injoy.com",
    "material": "marinastephenson@injoy.com",
    "blockengdescription": "marinastephenson@injoy.com",
    "user": "marinastephenson@injoy.com",
    "creationdate": "marinastephenson@injoy.com",
    "duedate": "marinastephenson@injoy.com"
  },
  {
    "productnumber": "marinastephenson@injoy.com",
    "requestid": "marinastephenson@injoy.com",
    "version": "marinastephenson@injoy.com",
    "description": "marinastephenson@injoy.com",
    "technology": "marinastephenson@injoy.com",
    "thickness": "marinastephenson@injoy.com",
    "customer": "marinastephenson@injoy.com",
    "productcode": "marinastephenson@injoy.com",
    "barcodenumber": "marinastephenson@injoy.com",
    "engravinglocation": "marinastephenson@injoy.com",
    "prepresslocation": "marinastephenson@injoy.com",
    "requeststatus": "marinastephenson@injoy.com",
    "requesttype": "marinastephenson@injoy.com",
    "material": "marinastephenson@injoy.com",
    "blockengdescription": "marinastephenson@injoy.com",
    "user": "marinastephenson@injoy.com",
    "creationdate": "marinastephenson@injoy.com",
    "duedate": "marinastephenson@injoy.com"
  },
  {
    "productnumber": "marinastephenson@injoy.com",
    "requestid": "marinastephenson@injoy.com",
    "version": "marinastephenson@injoy.com",
    "description": "marinastephenson@injoy.com",
    "technology": "marinastephenson@injoy.com",
    "thickness": "marinastephenson@injoy.com",
    "customer": "marinastephenson@injoy.com",
    "productcode": "marinastephenson@injoy.com",
    "barcodenumber": "marinastephenson@injoy.com",
    "engravinglocation": "marinastephenson@injoy.com",
    "prepresslocation": "marinastephenson@injoy.com",
    "requeststatus": "marinastephenson@injoy.com",
    "requesttype": "marinastephenson@injoy.com",
    "material": "marinastephenson@injoy.com",
    "blockengdescription": "marinastephenson@injoy.com",
    "user": "marinastephenson@injoy.com",
    "creationdate": "marinastephenson@injoy.com",
    "duedate": "marinastephenson@injoy.com"
  },
  {
    "productnumber": "marinastephenson@injoy.com",
    "requestid": "marinastephenson@injoy.com",
    "version": "marinastephenson@injoy.com",
    "description": "marinastephenson@injoy.com",
    "technology": "marinastephenson@injoy.com",
    "thickness": "marinastephenson@injoy.com",
    "customer": "marinastephenson@injoy.com",
    "productcode": "marinastephenson@injoy.com",
    "barcodenumber": "marinastephenson@injoy.com",
    "engravinglocation": "marinastephenson@injoy.com",
    "prepresslocation": "marinastephenson@injoy.com",
    "requeststatus": "marinastephenson@injoy.com",
    "requesttype": "marinastephenson@injoy.com",
    "material": "marinastephenson@injoy.com",
    "blockengdescription": "marinastephenson@injoy.com",
    "user": "marinastephenson@injoy.com",
    "creationdate": "marinastephenson@injoy.com",
    "duedate": "marinastephenson@injoy.com"
  },
  {
    "productnumber": "marinastephenson@injoy.com",
    "requestid": "marinastephenson@injoy.com",
    "version": "marinastephenson@injoy.com",
    "description": "marinastephenson@injoy.com",
    "technology": "marinastephenson@injoy.com",
    "thickness": "marinastephenson@injoy.com",
    "customer": "marinastephenson@injoy.com",
    "productcode": "marinastephenson@injoy.com",
    "barcodenumber": "marinastephenson@injoy.com",
    "engravinglocation": "marinastephenson@injoy.com",
    "prepresslocation": "marinastephenson@injoy.com",
    "requeststatus": "marinastephenson@injoy.com",
    "requesttype": "marinastephenson@injoy.com",
    "material": "marinastephenson@injoy.com",
    "blockengdescription": "marinastephenson@injoy.com",
    "user": "marinastephenson@injoy.com",
    "creationdate": "marinastephenson@injoy.com",
    "duedate": "marinastephenson@injoy.com"
  },
  {
    "productnumber": "marinastephenson@injoy.com",
    "requestid": "marinastephenson@injoy.com",
    "version": "marinastephenson@injoy.com",
    "description": "marinastephenson@injoy.com",
    "technology": "marinastephenson@injoy.com",
    "thickness": "marinastephenson@injoy.com",
    "customer": "marinastephenson@injoy.com",
    "productcode": "marinastephenson@injoy.com",
    "barcodenumber": "marinastephenson@injoy.com",
    "engravinglocation": "marinastephenson@injoy.com",
    "prepresslocation": "marinastephenson@injoy.com",
    "requeststatus": "marinastephenson@injoy.com",
    "requesttype": "marinastephenson@injoy.com",
    "material": "marinastephenson@injoy.com",
    "blockengdescription": "marinastephenson@injoy.com",
    "user": "marinastephenson@injoy.com",
    "creationdate": "marinastephenson@injoy.com",
    "duedate": "marinastephenson@injoy.com"
  },
  {
    "productnumber": "marinastephenson@injoy.com",
    "requestid": "marinastephenson@injoy.com",
    "version": "marinastephenson@injoy.com",
    "description": "marinastephenson@injoy.com",
    "technology": "marinastephenson@injoy.com",
    "thickness": "marinastephenson@injoy.com",
    "customer": "marinastephenson@injoy.com",
    "productcode": "marinastephenson@injoy.com",
    "barcodenumber": "marinastephenson@injoy.com",
    "engravinglocation": "marinastephenson@injoy.com",
    "prepresslocation": "marinastephenson@injoy.com",
    "requeststatus": "marinastephenson@injoy.com",
    "requesttype": "marinastephenson@injoy.com",
    "material": "marinastephenson@injoy.com",
    "blockengdescription": "marinastephenson@injoy.com",
    "user": "marinastephenson@injoy.com",
    "creationdate": "marinastephenson@injoy.com",
    "duedate": "marinastephenson@injoy.com"
  },
  {
    "productnumber": "marinastephenson@injoy.com",
    "requestid": "marinastephenson@injoy.com",
    "version": "marinastephenson@injoy.com",
    "description": "marinastephenson@injoy.com",
    "technology": "marinastephenson@injoy.com",
    "thickness": "marinastephenson@injoy.com",
    "customer": "marinastephenson@injoy.com",
    "productcode": "marinastephenson@injoy.com",
    "barcodenumber": "marinastephenson@injoy.com",
    "engravinglocation": "marinastephenson@injoy.com",
    "prepresslocation": "marinastephenson@injoy.com",
    "requeststatus": "marinastephenson@injoy.com",
    "requesttype": "marinastephenson@injoy.com",
    "material": "marinastephenson@injoy.com",
    "blockengdescription": "marinastephenson@injoy.com",
    "user": "marinastephenson@injoy.com",
    "creationdate": "marinastephenson@injoy.com",
    "duedate": "marinastephenson@injoy.com"
  },
  {
    "productnumber": "marinastephenson@injoy.com",
    "requestid": "marinastephenson@injoy.com",
    "version": "marinastephenson@injoy.com",
    "description": "marinastephenson@injoy.com",
    "technology": "marinastephenson@injoy.com",
    "thickness": "marinastephenson@injoy.com",
    "customer": "marinastephenson@injoy.com",
    "productcode": "marinastephenson@injoy.com",
    "barcodenumber": "marinastephenson@injoy.com",
    "engravinglocation": "marinastephenson@injoy.com",
    "prepresslocation": "marinastephenson@injoy.com",
    "requeststatus": "marinastephenson@injoy.com",
    "requesttype": "marinastephenson@injoy.com",
    "material": "marinastephenson@injoy.com",
    "blockengdescription": "marinastephenson@injoy.com",
    "user": "marinastephenson@injoy.com",
    "creationdate": "marinastephenson@injoy.com",
    "duedate": "marinastephenson@injoy.com"
  },
  {
    "productnumber": "marinastephenson@injoy.com",
    "requestid": "marinastephenson@injoy.com",
    "version": "marinastephenson@injoy.com",
    "description": "marinastephenson@injoy.com",
    "technology": "marinastephenson@injoy.com",
    "thickness": "marinastephenson@injoy.com",
    "customer": "marinastephenson@injoy.com",
    "productcode": "marinastephenson@injoy.com",
    "barcodenumber": "marinastephenson@injoy.com",
    "engravinglocation": "marinastephenson@injoy.com",
    "prepresslocation": "marinastephenson@injoy.com",
    "requeststatus": "marinastephenson@injoy.com",
    "requesttype": "marinastephenson@injoy.com",
    "material": "marinastephenson@injoy.com",
    "blockengdescription": "marinastephenson@injoy.com",
    "user": "marinastephenson@injoy.com",
    "creationdate": "marinastephenson@injoy.com",
    "duedate": "marinastephenson@injoy.com"
  },
  {
    "productnumber": "marinastephenson@injoy.com",
    "requestid": "marinastephenson@injoy.com",
    "version": "marinastephenson@injoy.com",
    "description": "marinastephenson@injoy.com",
    "technology": "marinastephenson@injoy.com",
    "thickness": "marinastephenson@injoy.com",
    "customer": "marinastephenson@injoy.com",
    "productcode": "marinastephenson@injoy.com",
    "barcodenumber": "marinastephenson@injoy.com",
    "engravinglocation": "marinastephenson@injoy.com",
    "prepresslocation": "marinastephenson@injoy.com",
    "requeststatus": "marinastephenson@injoy.com",
    "requesttype": "marinastephenson@injoy.com",
    "material": "marinastephenson@injoy.com",
    "blockengdescription": "marinastephenson@injoy.com",
    "user": "marinastephenson@injoy.com",
    "creationdate": "marinastephenson@injoy.com",
    "duedate": "marinastephenson@injoy.com"
  },
  {
    "productnumber": "marinastephenson@injoy.com",
    "requestid": "marinastephenson@injoy.com",
    "version": "marinastephenson@injoy.com",
    "description": "marinastephenson@injoy.com",
    "technology": "marinastephenson@injoy.com",
    "thickness": "marinastephenson@injoy.com",
    "customer": "marinastephenson@injoy.com",
    "productcode": "marinastephenson@injoy.com",
    "barcodenumber": "marinastephenson@injoy.com",
    "engravinglocation": "marinastephenson@injoy.com",
    "prepresslocation": "marinastephenson@injoy.com",
    "requeststatus": "marinastephenson@injoy.com",
    "requesttype": "marinastephenson@injoy.com",
    "material": "marinastephenson@injoy.com",
    "blockengdescription": "marinastephenson@injoy.com",
    "user": "marinastephenson@injoy.com",
    "creationdate": "marinastephenson@injoy.com",
    "duedate": "marinastephenson@injoy.com"
  },
  {
    "productnumber": "marinastephenson@injoy.com",
    "requestid": "marinastephenson@injoy.com",
    "version": "marinastephenson@injoy.com",
    "description": "marinastephenson@injoy.com",
    "technology": "marinastephenson@injoy.com",
    "thickness": "marinastephenson@injoy.com",
    "customer": "marinastephenson@injoy.com",
    "productcode": "marinastephenson@injoy.com",
    "barcodenumber": "marinastephenson@injoy.com",
    "engravinglocation": "marinastephenson@injoy.com",
    "prepresslocation": "marinastephenson@injoy.com",
    "requeststatus": "marinastephenson@injoy.com",
    "requesttype": "marinastephenson@injoy.com",
    "material": "marinastephenson@injoy.com",
    "blockengdescription": "marinastephenson@injoy.com",
    "user": "marinastephenson@injoy.com",
    "creationdate": "marinastephenson@injoy.com",
    "duedate": "marinastephenson@injoy.com"
  },
  {
    "productnumber": "marinastephenson@injoy.com",
    "requestid": "marinastephenson@injoy.com",
    "version": "marinastephenson@injoy.com",
    "description": "marinastephenson@injoy.com",
    "technology": "marinastephenson@injoy.com",
    "thickness": "marinastephenson@injoy.com",
    "customer": "marinastephenson@injoy.com",
    "productcode": "marinastephenson@injoy.com",
    "barcodenumber": "marinastephenson@injoy.com",
    "engravinglocation": "marinastephenson@injoy.com",
    "prepresslocation": "marinastephenson@injoy.com",
    "requeststatus": "marinastephenson@injoy.com",
    "requesttype": "marinastephenson@injoy.com",
    "material": "marinastephenson@injoy.com",
    "blockengdescription": "marinastephenson@injoy.com",
    "user": "marinastephenson@injoy.com",
    "creationdate": "marinastephenson@injoy.com",
    "duedate": "marinastephenson@injoy.com"
  },
  {
    "productnumber": "marinastephenson@injoy.com",
    "requestid": "marinastephenson@injoy.com",
    "version": "marinastephenson@injoy.com",
    "description": "marinastephenson@injoy.com",
    "technology": "marinastephenson@injoy.com",
    "thickness": "marinastephenson@injoy.com",
    "customer": "marinastephenson@injoy.com",
    "productcode": "marinastephenson@injoy.com",
    "barcodenumber": "marinastephenson@injoy.com",
    "engravinglocation": "marinastephenson@injoy.com",
    "prepresslocation": "marinastephenson@injoy.com",
    "requeststatus": "marinastephenson@injoy.com",
    "requesttype": "marinastephenson@injoy.com",
    "material": "marinastephenson@injoy.com",
    "blockengdescription": "marinastephenson@injoy.com",
    "user": "marinastephenson@injoy.com",
    "creationdate": "marinastephenson@injoy.com",
    "duedate": "marinastephenson@injoy.com"
  },
  {
    "productnumber": "marinastephenson@injoy.com",
    "requestid": "marinastephenson@injoy.com",
    "version": "marinastephenson@injoy.com",
    "description": "marinastephenson@injoy.com",
    "technology": "marinastephenson@injoy.com",
    "thickness": "marinastephenson@injoy.com",
    "customer": "marinastephenson@injoy.com",
    "productcode": "marinastephenson@injoy.com",
    "barcodenumber": "marinastephenson@injoy.com",
    "engravinglocation": "marinastephenson@injoy.com",
    "prepresslocation": "marinastephenson@injoy.com",
    "requeststatus": "marinastephenson@injoy.com",
    "requesttype": "marinastephenson@injoy.com",
    "material": "marinastephenson@injoy.com",
    "blockengdescription": "marinastephenson@injoy.com",
    "user": "marinastephenson@injoy.com",
    "creationdate": "marinastephenson@injoy.com",
    "duedate": "marinastephenson@injoy.com"
  },
  {
    "productnumber": "marinastephenson@injoy.com",
    "requestid": "marinastephenson@injoy.com",
    "version": "marinastephenson@injoy.com",
    "description": "marinastephenson@injoy.com",
    "technology": "marinastephenson@injoy.com",
    "thickness": "marinastephenson@injoy.com",
    "customer": "marinastephenson@injoy.com",
    "productcode": "marinastephenson@injoy.com",
    "barcodenumber": "marinastephenson@injoy.com",
    "engravinglocation": "marinastephenson@injoy.com",
    "prepresslocation": "marinastephenson@injoy.com",
    "requeststatus": "marinastephenson@injoy.com",
    "requesttype": "marinastephenson@injoy.com",
    "material": "marinastephenson@injoy.com",
    "blockengdescription": "marinastephenson@injoy.com",
    "user": "marinastephenson@injoy.com",
    "creationdate": "marinastephenson@injoy.com",
    "duedate": "marinastephenson@injoy.com"
  }
];
  
            
           
            
        }

        reset();

        function reset() {
            $scope.loading = true;
            $scope.filtraTodosTrabalhos();
        }

    

   
 
}]);
