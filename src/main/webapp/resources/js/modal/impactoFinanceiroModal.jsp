<div class="modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header" ng-show="title">
                <button type="button" class="close" aria-label="Close" ng-click="$hide()"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" ng-bind="title"></h4>
            </div>
            <div class="modal-body row" >
                <div class="col-md-12">
                	<div class="col-md-5">
                		<label class=" control-label" >Faturamento até a data atual:</label>  
                    	<input ng-model="faturamento" ng-change="calculaImpacto(faturamento);" class="form-control input-sm" >
                	</div>
                	<div class="col-md-5">
                		<label class=" control-label" >Total de despesas:</label>  
                    	<input readonly ng-model="totalDespesa" class="form-control input-sm" >
                	</div>
                	<div class="col-md-8" style="height:100%; width:100%;">
                	</div>
                	<div class="col-md-12">
                		<hr>
               	 	</div>
               	 	<div class="col-md-12">
	               	 	<canvas id="pie" class="chart chart-pie"
							chart-legend="true" chart-data="data" chart-labels="labels">
						</canvas> 
               	 	</div>
               	 	<div class="col-md-12">
	               	 	<div class="alert alert-danger" role="alert"  >
               	 			<h4>Atenção!</h4>
		                	<strong>O custo da sua frota representa </strong> <span>{{impactoFrota}}%</span><strong> do seu faturamento!</strong> <br>
               	 		</div>
               	 	</div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" ng-click="$hide()">Fechar</button>
            </div>
        </div>
    </div>
</div>