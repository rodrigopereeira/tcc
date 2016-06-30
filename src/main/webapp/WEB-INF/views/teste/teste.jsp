<!doctype html>
<html ng-app="app">
  <head>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular-touch.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular-animate.js"></script>
    <script src="http://ui-grid.info/docs/grunt-scripts/csv.js"></script>
    <script src="http://ui-grid.info/docs/grunt-scripts/pdfmake.js"></script>
    <script src="http://ui-grid.info/docs/grunt-scripts/vfs_fonts.js"></script>
    <script src="http://ui-grid.info/release/ui-grid.js"></script>
    <link rel="stylesheet" href="http://ui-grid.info/release/ui-grid.css" type="text/css">
    <link rel="stylesheet" href="resources/teste/main.css" type="text/css">
  </head>
  <body>

<div ng-controller="MainCtrl">
  <input type="teste" ng-model="teste" ng-model-options="{ debounce: 1000 }"/>
<pre>{{teste}}</pre>
    
         <div id="grid1" ui-grid="gridOptions1" ui-grid-pagination ui-grid-resize-columns ui-grid-move-columns ui-grid-selection ui-grid-cellNav class="grid"></div>

    
  </div>
  <script src="resources/teste/app.js"></script>
  </body>
</html>
