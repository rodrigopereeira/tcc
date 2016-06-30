<div class="panel panel-default" style="margin-top:5px;">
				<div class="panel-heading">Cadastro de Fornecedor</div>
			  	<div class="panel-body">
			  		<form class="form-horizontal">
				    	<fieldset>
				    		<ul class="nav nav-tabs" role="tablist">
								<li role="presentation" class="active"><a href="#dadosFornecedorModal"  role="tab" data-toggle="tab">Dados</a></li>
							    <li role="presentation"><a href="#contatoFornecedorModal"  role="tab" data-toggle="tab">Contato</a></li>
							</ul>
							<!-- Tab panes -->
							<div class="tab-content">
							  	
								<div role="tabpanel" class="tab-pane active" id="dadosFornecedorModal">
									<div class="form-group">
								  		<div class="col-md-12">
							              	<label class=" control-label" for="os">Razão Social</label>  
							                <input ng-model="fornecedor.razaoSocial" type="text"class="form-control input-sm" >
							            </div>
							            <div class="col-md-7">
							              	<label class=" control-label" for="os">Nome Fantasia</label>  
							                <input ng-model="fornecedor.nomeFantasia" type="text"class="form-control input-sm" >
							            </div>
							            <div class="col-md-5">
							              	<label class=" control-label" for="os">CNPJ</label>  
							                <input ng-model="fornecedor.cnpj" type="text"class="form-control input-sm" >
							            </div>
							            <div class="col-md-5">
							              	<label class=" control-label" for="os">Inscrição Estadual</label>  
							                <input ng-model="fornecedor.inscricaoEstadual" type="text"class="form-control input-sm" >
							            </div>
										<div class="col-md-7">
							              	<label class=" control-label" for="os">Email</label>  
							                <input ng-model="fornecedor.email" type="text"class="form-control input-sm" >
							            </div>
							            <div class="col-md-5">
							                <label class=" control-label" >Tipo do Fornecedor</label>  
						                    <select class="form-control input-sm" 
						                    	ng-model="fornecedor.tipoid" 
						                    	ng-options="tipo.id as tipo.descricao for tipo in tipoFornecedor">
						                    </select>
							            </div>
							        </div>
							        
								</div>
								<div role="tabpanel" class="tab-pane" id="contatoFornecedorModal">
							  		<div class="form-group">
							  			<div class="col-md-9">
						                	<label class=" control-label" for="os">Rua</label>  
						                    <input ng-model="fornecedor.contato.rua" type="text"class="form-control input-sm" >
						                </div>	
						                <div class="col-md-3">
						                	<label class=" control-label" for="os">Nº</label>  
						                    <input ng-model="fornecedor.contato.numero" type="text"class="form-control input-sm" >
						                </div>
						                <div class="col-md-3">
						                	<label class=" control-label" for="os">Estado</label>  
						                    <select class="form-control input-sm" 
						                    	ng-model="fornecedor.contato.estado" 
						                    	ng-options="estado as estado for estado in estados">
						                    </select>
						                </div>
						                <div class="col-md-5">
						                	<label class=" control-label" for="os">Cidade</label>  
						                    <input ng-model="fornecedor.contato.cidade" type="text"class="form-control input-sm" >
						                </div>
						                <div class="col-md-4">
						                	<label class=" control-label" for="os">Bairro</label>  
						                    <input ng-model="fornecedor.contato.bairro" type="text"class="form-control input-sm" >
						                </div>
						                <div class="col-md-5">
						                	<label class=" control-label" for="os">CEP</label>  
						                    <input ng-model="fornecedor.contato.cep" type="text"class="form-control input-sm" >
						                </div>	
						                <div class="col-md-5">
						                	<label class=" control-label" for="os">Telefone</label>  
						                    <input ng-model="fornecedor.telefone.numero" type="text"class="form-control input-sm" >
						                </div>
						                <div class="col-md-2">
						                	<label class=" control-label" for="os">Ramal</label>  
						                    <input ng-model="fornecedor.telefone.ramal" type="text"class="form-control input-sm" >
						                </div>
							  			<div class="col-md-12">
						                	<label class=" control-label" for="os">Observações</label>  
						                    <input ng-model="fornecedor.telefone.observacoes" type="text"class="form-control input-sm" >
						                </div>
							  		</div>
							  	</div>
							</div>	
						</fieldset>
						<button class="btn btn-primary" ng-click="cadastrarFornecedor(fornecedor);">Cadastrar</button>
				        <button class="btn btn-default">Cancelar</button>
					</form>
			  	</div>
			</div>
