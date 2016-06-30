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
				    		<ul class="nav nav-tabs" role="tablist">
								<li role="presentation" class="active"><a href="#dadosFornecedor"  role="tab" data-toggle="tab">Dados</a></li>
							    <li role="presentation"><a href="#contatoFornecedor"  role="tab" data-toggle="tab">Contato</a></li>
							</ul>
							<!-- Tab panes -->
							<div class="tab-content">
							  	
								<div role="tabpanel" class="tab-pane active" id="dadosFornecedor">
									<div class="form-group">
								  		<div class="col-md-12">
							              	<label class=" control-label" for="os">Razão Social</label>  
							                <input ng-model="fornecedorA.razaoSocial" type="text"class="form-control input-sm" >
							            </div>
							            <div class="col-md-7">
							              	<label class=" control-label" for="os">Nome Fantasia</label>  
							                <input ng-model="fornecedorA.nomeFantasia" type="text"class="form-control input-sm" >
							            </div>
							            <div class="col-md-5">
							              	<label class=" control-label" for="os">CNPJ</label>  
							                <input ng-model="fornecedorA.cnpj" type="text"class="form-control input-sm" >
							            </div>
							            <div class="col-md-5">
							              	<label class=" control-label" for="os">Inscrição Estadual</label>  
							                <input ng-model="fornecedorA.inscricaoEstadual" type="text"class="form-control input-sm" >
							            </div>
										<div class="col-md-7">
							              	<label class=" control-label" for="os">Email</label>  
							                <input ng-model="fornecedorA.email" type="text"class="form-control input-sm" >
							            </div>
							            <div class="col-md-5">
							                <label class=" control-label" >Tipo do Fornecedor</label>  
						                    <select class="form-control input-sm" 
						                    	ng-model="fornecedorA.tipoid" 
						                    	ng-options="tipo.id as tipo.descricao for tipo in tipoFornecedor">
						                    </select>
							            </div>
							        </div>
							        
								</div>
								<div role="tabpanel" class="tab-pane" id="contatoFornecedor">
							  		<div class="form-group">
							  			<div class="col-md-9">
						                	<label class=" control-label" for="os">Rua</label>  
						                    <input ng-model="fornecedorA.contato.rua" type="text"class="form-control input-sm" >
						                </div>	
						                <div class="col-md-3">
						                	<label class=" control-label" for="os">Nº</label>  
						                    <input ng-model="fornecedorA.contato.numero" type="text"class="form-control input-sm" >
						                </div>
						                <div class="col-md-3">
						                	<label class=" control-label" for="os">Estado</label>  
						                    <select class="form-control input-sm" 
						                    	ng-model="fornecedorA.contato.estado" 
						                    	ng-options="estado as estado for estado in estados">
						                    </select>
						                </div>
						                <div class="col-md-5">
						                	<label class=" control-label" for="os">Cidade</label>  
						                    <input ng-model="fornecedorA.contato.cidade" type="text"class="form-control input-sm" >
						                </div>
						                <div class="col-md-4">
						                	<label class=" control-label" for="os">Bairro</label>  
						                    <input ng-model="fornecedorA.contato.bairro" type="text"class="form-control input-sm" >
						                </div>
						                <div class="col-md-5">
						                	<label class=" control-label" for="os">CEP</label>  
						                    <input ng-model="fornecedorA.contato.cep" type="text"class="form-control input-sm" >
						                </div>	
						                <div class="col-md-5">
						                	<label class=" control-label" for="os">Telefone</label>  
						                    <input ng-model="fornecedorA.telefone.numero" type="text"class="form-control input-sm" >
						                </div>
						                <div class="col-md-2">
						                	<label class=" control-label" for="os">Ramal</label>  
						                    <input ng-model="fornecedorA.telefone.ramal" type="text"class="form-control input-sm" >
						                </div>
							  			<div class="col-md-12">
						                	<label class=" control-label" for="os">Observações</label>  
						                    <input ng-model="fornecedorA.telefone.observacoes" type="text"class="form-control input-sm" >
						                </div>
							  		</div>
							  	</div>
							</div>	
						</fieldset>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" ng-click="salvarFornecedor(fornecedorA);$hide()">Salvar</button>
                <button class="btn btn-danger" ng-click="excluirFornecedor(fornecedorA);$hide()">Excluir</button>
                <button type="button" class="btn btn-default" ng-click="$hide()">Fechar</button>
            </div>
        </div>
    </div>
</div>