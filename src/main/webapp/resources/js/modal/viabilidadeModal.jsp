<div class="modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header" ng-show="title">
                <button type="button" class="close" aria-label="Close" ng-click="$hide()"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" ng-bind="title"></h4>
            </div>
            <div class="modal-body row" >
                <div class="col-md-12">
                	<div class="col-md-4">
                		<label class=" control-label" >Nº de Veículos:</label>  
                    	<input ng-model="viabilidade.numVeiculos" ng-init="viabilidade.numVeiculos = 1" class="form-control input-sm" >
                	</div>
                	<div class="col-md-8" style="height:100%; width:100%;">
                	</div>
                	<div class="col-md-6">
                		<label class=" control-label" >Quilometragem Diária:</label>  
                    	<input type="text" ng-model="viabilidade.kmDiaria" class="form-control input-sm" >
                	</div>
                	<div class="col-md-6">
                		<label class=" control-label" >Preço do Combustível:</label>  
                    	<input type="text" ng-model="viabilidade.precoCombustivel" class="form-control input-sm" >
                	</div>
                	<div class="col-md-6">
                		<label class=" control-label" >Consumo Médio atual:</label>  
                    	<input type="text" ng-model="viabilidade.consumoMedioatual" class="form-control input-sm" >
                	</div>
                	<div class="col-md-6">
                		<label class=" control-label" >Consumo Médio do Veículo Novo:</label>  
                    	<input type="text" ng-model="viabilidade.consumoMedionovo" class="form-control input-sm" >
                	</div>
                	<div class="col-md-12">
                		<hr>
               	 	</div>
               	 	<div class="col-md-12">
               	 		<div class="alert alert-success" role="alert" ng-if="viabilidade.economia > 0">
               	 			<h4>Economia!</h4>
		                	<strong>Em 1 mês você terá a economia de:</strong> <span>{{viabilidade.economia | currency}}</span> <br>
		                	<strong>Em 1 ano você terá a economia de:</strong> <span>{{viabilidade.economia*12 | currency}}</span> <br>
               	 		</div>
               	 		<div class="alert alert-danger" role="alert" ng-if="viabilidade.economia < 0">
               	 			<h4>Despesas!</h4>
		                	<strong>Em 1 mês você gastará a mais:</strong> <span>{{(viabilidade.economia) | absoluteValue | currency}}</span> <br>
		                	<strong>Em 1 ano você gastará a mais:</strong> <span>{{(viabilidade.economia*12) | absoluteValue | currency}}</span> <br>
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