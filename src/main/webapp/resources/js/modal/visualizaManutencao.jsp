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
                                <input ng-model="manutencaoA.data" type="text"class="form-control input-sm" data-date-format="dd/MM/yyyy" data-autoclose="1" bs-datepicker>
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Veículo</label>  
                                <select class="form-control input-sm" 
                                	ng-model="manutencaoA.veiculo.id"
                                	ng-options="veiculo.id as veiculo.modelo for veiculo in veiculos">
                                	<option value="">Selecione um veículo</option>
								</select>
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Fornecedor</label>  
                                <select class="form-control input-sm"
                                	ng-model="manutencaoA.fornecedor.id"
                                	ng-options="fornecedor.id as fornecedor.nomeFantasia for fornecedor in fornecedores">
                                	<option value="">Selecione um fornecedor</option>
								</select>
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Tipo</label>  
                                <select ng-model="manutencaoA.tipoid" 
                                	class="form-control input-sm"
                                	ng-options="tipo.id as tipo.descricao for tipo in tipoManutencao">
                                	<option value="">Selecione um tipo</option>	
								</select>
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Valor</label>  
                                <input ng-model="manutencaoA.pagamento.valor" class="form-control input-sm"/>
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Forma de Pagamento</label>  
                                <select class="form-control input-sm"
                                	ng-model="manutencaoA.pagamento.tipo"
                                	ng-options="tipo as tipo for tipo in tiposPagamento">
                                	<option value="">Selecione um fornecedor</option>
								</select>
                            </div>
                            <div class="col-md-9">
                            	<label class=" control-label" >Problema</label>  
                            	<textarea ng-model="manutencaoA.problema" rows="1"class="form-control input-sm"></textarea>
                            </div>
                            <div class="col-md-3">
                            	<label class=" control-label" >Status</label> 
                                <select class="form-control input-sm"
                                	ng-model="manutencaoA.status">
                                	<option value="Andamento">Andamento</option>
                                	<option value="Finalizado">Finalizado</option>
								</select>
                            </div>
                            <div class="col-md-12">
                            	<label class=" control-label" >Solução</label>  
                            	<textarea ng-model="manutencaoA.parecerFinal" rows="2"class="form-control input-sm"></textarea>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" ng-click="salvarManutencao(manutencaoA); $hide()">Salvar</button>
                <button class="btn btn-danger" ng-click="excluirManutencao(manutencaoA); $hide()">Excluir</button>
                <button type="button" class="btn btn-default" ng-click="$hide()">Fechar</button>
            </div>
        </div>
    </div>
</div>