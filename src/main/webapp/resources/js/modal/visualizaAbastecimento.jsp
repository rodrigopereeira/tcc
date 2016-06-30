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
                                <input ng-model="abastecimentoA.data"  type="text"class="form-control input-sm" data-date-format="dd/MM/yyyy" data-autoclose="1" bs-datepicker>
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Veículo</label> 
                            	<input ng-model="abastecimentoA.veiculo.modelo"  type="text"class="form-control input-sm" readonly >
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Motorista</label>  
                                <select class="form-control input-sm" 
                                	ng-model="abastecimentoA.motorista.id"
                                	ng-change="defineMotoristaabastecimento(abastecimentoA.motorista.id);"
                                	ng-options="motorista.id as motorista.nome for motorista in motoristas">
                                	<option value="">Selecione um motorista</option>
								</select>
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Fornecedor</label>  
                                <select class="form-control input-sm"
                                	ng-model="abastecimentoA.fornecedor.id"
                                	ng-change="defineFornecedorabastecimento(abastecimentoA.fornecedor.id);"
                                	ng-options="fornecedor.id as fornecedor.nomeFantasia for fornecedor in fornecedores">
                                	<option value="">Selecione um fornecedor</option>
								</select>
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Tipo</label>  
                                <select ng-model="abastecimentoA.tipoid"
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
                                <input ng-model="abastecimentoA.pagamento.valor" type="text"class="form-control input-sm" >
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Valor do Litro</label>  
                                <input ng-change="calculaLitro(abastecimentoA.pagamento.valor, abastecimentoA.valorLitro);" ng-model="abastecimentoA.valorLitro" type="text"class="form-control input-sm" >
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Litros</label>  
                                <input readonly ng-model="abastecimentoA.litros" type="text"class="form-control input-sm" >
                            </div>
                            
                            <div class="col-md-4">
                            	<label class=" control-label" >Forma de Pagamento</label>  
                                <select class="form-control input-sm"
                                	ng-model="abastecimentoA.pagamento.tipo"
                                	ng-options="tipo as tipo for tipo in tiposPagamento">
                                	<option value="">Selecione um fornecedor</option>
								</select>
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >Data do Pagamento</label>  
                                <input ng-model="abastecimentoA.pagamento.data"  type="text"class="form-control input-sm" data-date-format="dd/MM/yyyy" data-autoclose="1" bs-datepicker>
                            </div>
                            <div class="col-md-12 " >
                            	<hr>
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >KM atual</label>  
                                <input disabled ng-model="abastecimentoA.kmAnterior" type="text"class="form-control input-sm" >
                            </div>
                            <div class="col-md-4">
                            	<label class=" control-label" >KM</label>  
                                <input ng-change="calculaKmPercorrido(abastecimentoA.kmAnterior, abastecimentoA.km)" ng-model="abastecimentoA.km" type="text"class="form-control input-sm" >
                            </div>
                            <div class="col-md-4 ">
                            	<label class=" control-label" >KM Percorrido</label>  
                                <input readonly ng-model="abastecimentoA.kmPercorrido" type="text"class="form-control input-sm" >
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" ng-click="salvarAbastecimento(abastecimentoA); $hide()">Salvar</button>
                <button class="btn btn-danger" ng-click="excluirAbastecimento(abastecimentoA); $hide()">Excluir</button>
                <button type="button" class="btn btn-default" ng-click="$hide()">Fechar</button>
            </div>
        </div>
    </div>
</div>