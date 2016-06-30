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
                                <input ng-model="abastecimento.data" ng-init="abastecimento.data = date" type="text"class="form-control input-sm" data-date-format="dd/MM/yyyy" data-autoclose="1" bs-datepicker>
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Veículo</label>  
                                <select class="form-control input-sm" 
                                	ng-model="abastecimento.veiculo.id"
                                	ng-change="defineVeiculoabastecimento(abastecimento.veiculo.id);"
                                	ng-options="veiculo.id as veiculo.modelo for veiculo in veiculos">
                                	<option value="">Selecione um veículo</option>
								</select>
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Motorista</label>  
                                <select class="form-control input-sm" 
                                	ng-model="abastecimento.motorista.id"
                                	ng-change="defineMotoristaabastecimento(abastecimento.motorista.id);"
                                	ng-options="motorista.id as motorista.nome for motorista in motoristas">
                                	<option value="">Selecione um motorista</option>
								</select>
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Fornecedor</label>  
                                <select class="form-control input-sm"
                                	ng-model="abastecimento.fornecedor.id"
                                	ng-change="defineFornecedorabastecimento(abastecimento.fornecedor.id);"
                                	ng-options="fornecedor.id as fornecedor.nomeFantasia for fornecedor in fornecedores">
                                	<option value="">Selecione um fornecedor</option>
								</select>
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Tipo</label>  
                                <select ng-model="abastecimento.tipoid"
                                	ng-options="tipo.id as tipo.descricao for tipo in tipoCombustivel" 
                                	class="form-control input-sm">
                                	<option value="">Selecione um tipo</option>	
								</select>
                            </div>
                            <div class="col-md-12 " >
                            	<hr>
                            </div>
                            <div class="col-md-4 ">
                            	<label class=" control-label" >Valor</label>  
                                <input ng-model="abastecimento.pagamento.valor" type="text"class="form-control input-sm" >
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Valor do Litro</label>  
                                <input ng-change="calculaLitro(abastecimento.pagamento.valor, abastecimento.valorLitro);" ng-model="abastecimento.valorLitro" ng-init="abastecimento.valorLitro = 0" type="text"class="form-control input-sm" >
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Litros</label>  
                                <input readonly ng-model="abastecimento.litros" type="text"class="form-control input-sm" >
                            </div>
                            
                            <div class="col-md-4">
                            	<label class=" control-label" >Forma de Pagamento</label>  
                                <select class="form-control input-sm"
                                	ng-model="abastecimento.pagamento.tipo"
                                	ng-options="tipo as tipo for tipo in tiposPagamento">
                                	<option value="">Selecione um fornecedor</option>
								</select>
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Data do Pagamento</label>  
                                <input ng-model="abastecimento.pagamento.data" ng-init="abastecimento.pagamento.data = date" type="text"class="form-control input-sm" data-date-format="dd/MM/yyyy" data-autoclose="1" bs-datepicker>
                            </div>
                            <div class="col-md-12 " >
                            	<hr>
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >KM atual</label>  
                                <input disabled ng-model="abastecimento.kmAnterior" type="text"class="form-control input-sm" >
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >KM</label>  
                                <input ng-change="calculaKmPercorrido(abastecimento.kmAnterior, abastecimento.km)" ng-model="abastecimento.km" type="text"class="form-control input-sm" >
                            </div>
                            <div class="col-md-4 ">
                            	<label class=" control-label" >KM Percorrido</label>  
                                <input readonly ng-model="abastecimento.kmPercorrido" type="text"class="form-control input-sm" >
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" ng-click="cadastrarAbastecimento(abastecimento); $hide()">Salvar</button>
                <button type="button" class="btn btn-default" ng-click="$hide()">Fechar</button>
            </div>
        </div>
    </div>
</div>