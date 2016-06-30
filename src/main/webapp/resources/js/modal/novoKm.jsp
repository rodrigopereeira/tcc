<div class="modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header" ng-show="title">
                <button type="button" class="close" aria-label="Close" ng-click="$hide()"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" ng-bind="title"></h4>
            </div>
            <div class="modal-body" >
                <form class="form-horizontal">
                    <fieldset>
   						<div class="form-group">
   							<div class="col-md-4">
                            	<label class=" control-label" >Veículo</label>  
                                <select class="form-control input-sm" 
                                	ng-model="km.veiculo"
                                	ng-options="veiculo as veiculo.modelo for veiculo in veiculos">
                                	<option value="">Selecione um veículo</option>
								</select>
                            </div>
   						
                        	<div class="col-md-4">
                            	<label class="control-label">Data e hora de saída</label><br>
                                <input ng-model="km.dataSaida" style="width: 55%; float:left;" ng-init="km.dataSaida = date" type="text"class="form-control input-sm" data-date-format="dd/MM/yyyy" data-autoclose="1" bs-datepicker>
                            	<input ng-model="km.horaSaida" style="width: 43%; float:right;" type="text" size="8" class="form-control input-sm"  data-time-format="HH:mm" data-autoclose="1" bs-timepicker>
                            </div>
                            <div class="col-md-4">
                            	<label class="control-label">Data e hora de Chegada</label><br>
                                <input ng-model="km.dataChegada" style="width: 55%; float:left;" ng-init="km.dataChegada = date" type="text"class="form-control input-sm" data-date-format="dd/MM/yyyy" data-autoclose="1" bs-datepicker>
                            	<input ng-model="km.horaChegada" style="width: 43%; float:right;" type="text" size="8" class="form-control input-sm"  data-time-format="HH:mm" data-autoclose="1" bs-timepicker>
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Motorista</label>  
                                <select class="form-control input-sm" 
                                	ng-model="km.motorista"
                                	ng-options="motorista as motorista.nome for motorista in motoristas">
                                	<option value="">Selecione um motorista</option>
								</select>
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >KM Anterior</label>  
                                <input ng-model="km.veiculo.km" readonly type="text"class="form-control input-sm">
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >KM Atual</label>  
                                <input ng-model="km.kmAtual" type="text"class="form-control input-sm">
                            </div>
                            <div class="col-md-12">
                            	<label class=" control-label" >Destino</label>  
                            	<textarea ng-model="km.destino" rows="2"class="form-control input-sm"></textarea>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" ng-click="cadastrarKm(km); $hide()">Salvar</button>
                <button type="button" class="btn btn-default" ng-click="$hide()">Fechar</button>
            </div>
        </div>
    </div>
</div>