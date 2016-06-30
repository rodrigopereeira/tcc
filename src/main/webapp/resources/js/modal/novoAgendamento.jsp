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
                            	<label class=" control-label" >Data</label>  
                                <input ng-model="agenda.data" type="text"class="form-control input-sm" data-date-format="dd/MM/yyyy" data-autoclose="1" bs-datepicker>
                            </div>
                            <div class="col-md-3">
                            	<label class=" control-label" >Hora</label>  
                                <input ng-model="agenda.hora"  type="text" class="form-control input-sm" size="8" name="time" bs-timepicker>
                            </div>
                            <div class="col-md-5">
                            	<label class=" control-label" >Veículo</label>  
                                <select class="form-control input-sm" 
                                	ng-model="agenda.veiculo.id"
                                	ng-options="veiculo.id as veiculo.modelo for veiculo in veiculos">
                                	<option value="">Selecione um veículo</option>
								</select>
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Tipo</label>  
                                <select ng-model="agenda.tipoid" 
                                	class="form-control input-sm">
                                	<option value="1">Manutenção</option>	
                                	<option value="2">Abastecimento</option>	
                                	<option value="3">Viagem</option>	
								</select>
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Local</label>  
                                <input ng-model="agenda.local" type="text"class="form-control input-sm" >
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Fornecedor</label>  
                                <select class="form-control input-sm"
                                	ng-model="agenda.fornecedor.id"
                                	ng-options="fornecedor.id as fornecedor.nomeFantasia for fornecedor in fornecedores">
                                	<option value="">Selecione um fornecedor</option>
								</select>
                            </div>
                            <div class="col-md-12">
                            	<label class=" control-label" >Descrição</label>  
                                <textarea ng-model="agenda.descricao" class="form-control" rows="4"></textarea>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" ng-click="cadastrarAgenda(agenda); $hide()">Salvar</button>
                <button type="button" class="btn btn-default" ng-click="$hide()">Fechar</button>
            </div>
        </div>
    </div>
</div>