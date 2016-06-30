<div class="panel panel-default" style="margin-top:5px;">
				<div class="panel-heading">Cadastro de Usuário</div>
			  	<div class="panel-body">
			    	<form class="form-horizontal">
				    	<fieldset>
				    		<ul class="nav nav-tabs" role="tablist">
							    <li role="presentation" class="active"><a href="#dadosUsuario"  role="tab" data-toggle="tab">Dados</a></li>
							    <li role="presentation"><a href="#contatoUsuario"  role="tab" data-toggle="tab">Contato</a></li>
							</ul>
							
							  <!-- Tab panes -->
							  <div class="tab-content">
							  	<div role="tabpanel" class="tab-pane active " id="dadosUsuario">
							  		<div class="form-group">
							  			<div class="col-md-4">
				                			<label class=" control-label" for="os">Nome</label>  
				                    		<input ng-model="usuario.nome" type="text"class="form-control input-sm" >
					                	</div>
					                	<div class="col-md-5">
					                		<label class=" control-label" for="os">Sobrenome</label>  
					                    	<input ng-model="usuario.sobrenome" type="text"class="form-control input-sm" >
					                	</div>
					                	<div class="col-md-3">
						                	<label class=" control-label" for="os">Sexo</label>  
						                    <select class="form-control input-sm" ng-model="usuario.sexo">
						                    	<option value="M">Masc</option>
						                    	<option value="F">Fem</option>
						                    </select>
						                </div>
						                <div class="col-md-4">
					                		<label class=" control-label" for="os">Data de Nascimento</label>  
					                    	<input ng-model="usuario.dataNascimento" type="text" class="form-control input-sm" data-date-format="dd/MM/yyyy" data-autoclose="1"  bs-datepicker>
					                	</div>
					                	<div class="col-md-4">
					                		<label class=" control-label" for="os">RG</label>  
					                    	<input ng-model="usuario.rg" type="text"class="form-control input-sm" >
					                	</div>
					                	<div class="col-md-4">
					                		<label class=" control-label" for="os">CPF</label>  
					                    	<input ng-model="usuario.cpf" type="text"class="form-control input-sm" >
					                	</div>
					                	
					                	<div class="col-md-7">
					                		<label class=" control-label" for="os">Email</label>  
					                    	<input ng-model="usuario.email" type="text"class="form-control input-sm" >
					                	</div>
					                	<div class="col-md-5">
						                	<label class=" control-label" for="os">Estado Civil</label>  
						                    <select class="form-control input-sm" ng-model="usuario.estadoCivil">
						                    	<option value="solteiro">Solteiro(a)</option>
						                    	<option value="casado">Casado(a)</option>
						                    	<option value="divorciado">Divorciado(a)</option>
						                    	<option value="viuvo">Víuvo(a)</option>
						                    </select>
						                </div>
						                
						                <div class="col-md-5">
						                	<label class=" control-label" for="os">Setor</label>  
						                    <select class="form-control input-sm" ng-model="usuario.setor">
						                    	
						                    </select>
						                </div>
						                <div class="col-md-5">
						                	<!-- Tipo de usuário, pode ser motorista, funcionario etc.. -->
						                	<label class=" control-label" for="os">Tipo</label>  
						                    <select class="form-control input-sm" 
						                    	ng-model="usuario.tipoid" 
						                    	ng-options="tipo.id as tipo.descricao for tipo in tipoUsuario">
						                    </select>
						                </div>
						                <!-- Motorista -->
						                <div ng-if="usuario.tipoid == '2'">
							                <div class="col-md-12">
							                	<hr/>
							                </div>
							                <div class="col-md-5">
						                		<label class=" control-label" for="os">Nº CNH</label>  
						                    	<input  type="text"class="form-control input-sm" ng-model="usuario.cnh.numero">
						                	</div>
						                	<div class="col-md-4">
						                		<label class=" control-label" for="os">Validade</label>  
						                    	<input  type="text"class="form-control input-sm" ng-model="usuario.cnh.validade" data-date-format="dd/MM/yyyy" bs-datepicker>
						                	</div>
						                	<div class="col-md-3">
							                	<label class=" control-label" for="os">Categoria</label>  
							                    <select class="form-control input-sm" ng-model="usuario.cnh.categoria">
							                    	<option value="A">A</option>
						                    		<option value="B">B</option>
						                    		<option value="AB">AB</option>
							                    </select>
							                </div>
						                </div>
						                <!-- Usuário ou Administrador -->
						                <div ng-if="usuario.tipoid == '1' || usuario.tipoid == '3'">
							                <div class="col-md-12">
							                	<hr/>
							                </div>
							                <div class="col-md-5">
						                		<label class=" control-label" for="os">Usuário</label>  
						                    	<input ng-model="usuario.login" type="text"class="form-control input-sm" >
						                	</div>
						                	<div class="col-md-5">
						                		<label class=" control-label" for="os">Senha</label>  
						                    	<input ng-model="usuario.senha" type="password"class="form-control input-sm" >
						                	</div>
					                	</div>
					                </div>
							  	</div>

							  	<div role="tabpanel" class="tab-pane" id="contatoUsuario">
							  		<div class="form-group">
							  			<div class="col-md-9">
						                	<label class=" control-label" for="os">Rua</label>  
						                    <input ng-model="usuario.contato.rua" type="text"class="form-control input-sm" >
						                </div>	
						                <div class="col-md-3">
						                	<label class=" control-label" for="os">Nº</label>  
						                    <input ng-model="usuario.contato.numero" type="text"class="form-control input-sm" >
						                </div>
						                <div class="col-md-3">
						                	<label class=" control-label" for="os">Estado</label>  
						                    <select class="form-control input-sm" 
						                    	ng-model="usuario.contato.estado" 
						                    	ng-options="estado as estado for estado in estados">
						                    </select>
						                </div>
						                <div class="col-md-5">
						                	<label class=" control-label" for="os">Cidade</label>  
						                    <input ng-model="usuario.contato.cidade" type="text"class="form-control input-sm" >
						                </div>
						                <div class="col-md-4">
						                	<label class=" control-label" for="os">Bairro</label>  
						                    <input ng-model="usuario.contato.bairro" type="text"class="form-control input-sm" >
						                </div>
						                <div class="col-md-5">
						                	<label class=" control-label" for="os">CEP</label>  
						                    <input ng-model="usuario.contato.cep" type="text"class="form-control input-sm" >
						                </div>	
						                <div class="col-md-5">
						                	<label class=" control-label" for="os">Telefone</label>  
						                    <input ng-model="usuario.telefone.numero" type="text"class="form-control input-sm" >
						                </div>
						                <div class="col-md-2">
						                	<label class=" control-label" for="os">Ramal</label>  
						                    <input ng-model="usuario.telefone.ramal" type="text"class="form-control input-sm" >
						                </div>
							  			<div class="col-md-12">
						                	<label class=" control-label" for="os">Observações</label>  
						                    <input ng-model="usuario.telefone.observacoes" type="text"class="form-control input-sm" >
						                </div>
						                
							  		</div>
							  	</div>
							  </div>
				        </fieldset>
				        <button class="btn btn-primary" ng-click="cadastrarUsuario(usuario);">Cadastrar</button>
				        <button class="btn btn-default">Cancelar</button>
					</form>	
			 	</div>
			</div>