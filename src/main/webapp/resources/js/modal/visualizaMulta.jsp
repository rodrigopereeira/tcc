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
                                <input ng-model="multaA.data" type="text"class="form-control input-sm" data-date-format="dd/MM/yyyy" data-autoclose="1" bs-datepicker>
                            </div>
                            <div class="col-md-3">
                            	<label class=" control-label" >Hora</label>  
                                <input ng-model="multaA.hora"  type="text" class="form-control input-sm" size="8" name="time" bs-timepicker>
                            </div>
                            <div class="col-md-5">
                            	<label class=" control-label" >Veículo</label>  
                                <select class="form-control input-sm" 
                                	ng-model="multaA.veiculo.id"
                                	ng-options="veiculo.id as veiculo.modelo for veiculo in veiculos">
                                	<option value="">Selecione um veículo</option>
								</select>
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Data de Vencimento</label>  
                                <input ng-model="multaA.dataVencimento" type="text"class="form-control input-sm" data-date-format="dd/MM/yyyy" data-autoclose="1" bs-datepicker>
                            </div>
                            <div class="col-md-2">
                            	<label class=" control-label" >Pontuação</label>  
                                <input ng-model="multaA.pontuacao" type="number" class="form-control input-sm" >
                            </div>
                            <div class="col-md-2">
                            	<label class=" control-label" >Valor</label>  
                                <input ng-model="multaA.pagamento.valor" type="number"class="form-control input-sm" >
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Motorista</label>  
                                <select class="form-control input-sm" 
                                	ng-model="multaA.motorista.id"
                                	ng-options="motorista.id as motorista.nome for motorista in motoristas">
                                	<option value="">Selecione um motorista</option>
								</select>
                            </div>
                            <div class="col-md-12">
                            	<label class=" control-label" >Descrição</label>  
                                <textarea ng-model="multaA.descricao" class="form-control" rows="4"></textarea>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" ng-click="salvarMulta(multaA);$hide()">Salvar</button>
                <button class="btn btn-danger" ng-click="excluirMulta(multaA); $hide()">Excluir</button>
                <button type="button" class="btn btn-default" ng-click="$hide()">Fechar</button>
            </div>
        </div>
    </div>
</div>