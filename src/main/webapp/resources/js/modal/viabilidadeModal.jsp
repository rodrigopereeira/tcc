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
                		<label class=" control-label" >N� de Ve�culos:</label>  
                    	<input ng-model="viabilidade.numVeiculos" ng-init="viabilidade.numVeiculos = 1" class="form-control input-sm" >
                	</div>
                	<div class="col-md-8" style="height:100%; width:100%;">
                	</div>
                	<div class="col-md-6">
                		<label class=" control-label" >Quilometragem Di�ria:</label>  
                    	<input type="text" ng-model="viabilidade.kmDiaria" class="form-control input-sm" >
                	</div>
                	<div class="col-md-6">
                		<label class=" control-label" >Pre�o do Combust�vel:</label>  
                    	<input type="text" ng-model="viabilidade.precoCombustivel" class="form-control input-sm" >
                	</div>
                	<div class="col-md-6">
                		<label class=" control-label" >Consumo M�dio atual:</label>  
                    	<input type="text" ng-model="viabilidade.consumoMedioatual" class="form-control input-sm" >
                	</div>
                	<div class="col-md-6">
                		<label class=" control-label" >Consumo M�dio do Ve�culo Novo:</label>  
                    	<input type="text" ng-model="viabilidade.consumoMedionovo" class="form-control input-sm" >
                	</div>
                	<div class="col-md-12">
                		<hr>
               	 	</div>
               	 	<div class="col-md-12">
               	 		<div class="alert alert-success" role="alert" ng-if="viabilidade.economia > 0">
               	 			<h4>Economia!</h4>
		                	<strong>Em 1 m�s voc� ter� a economia de:</strong> <span>{{viabilidade.economia | currency}}</span> <br>
		                	<strong>Em 1 ano voc� ter� a economia de:</strong> <span>{{viabilidade.economia*12 | currency}}</span> <br>
               	 		</div>
               	 		<div class="alert alert-danger" role="alert" ng-if="viabilidade.economia < 0">
               	 			<h4>Despesas!</h4>
		                	<strong>Em 1 m�s voc� gastar� a mais:</strong> <span>{{(viabilidade.economia) | absoluteValue | currency}}</span> <br>
		                	<strong>Em 1 ano voc� gastar� a mais:</strong> <span>{{(viabilidade.economia*12) | absoluteValue | currency}}</span> <br>
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