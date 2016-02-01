<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="../templates/menu.jsp" />

<script src="resources/cadastro/controllers/cadastroController.js"></script>
<script src="resources/cadastro/directives/gridVeiculos.js"></script>
<script src="resources/cadastro/directives/gridUsuarios.js"></script>
<script src="resources/cadastro/directives/gridFornecedores.js"></script>

<div ng-controller="cadastroController" class="container">

  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" ng-class="{'active': tabAtiva == 'veiculos'}"><a ng-click="alteraTab('veiculos')"  role="tab" data-toggle="tab">Veículos</a></li>
    <li role="presentation" ng-class="{'active': tabAtiva == 'usuarios'}"><a ng-click="alteraTab('usuarios');"  role="tab" data-toggle="tab">Usuários</a></li>
    <li role="presentation" ng-class="{'active': tabAtiva == 'fornecedores'}"><a ng-click="alteraTab('fornecedores');"  role="tab" data-toggle="tab">Fornecedores</a></li>
  </ul>
  <!-- Tab panes -->
  <div class="tab-content">
    <div role="tabpanel" class="tab-pane" ng-class="{'active': tabAtiva == 'veiculos'}" id="veiculos" ng-if="tabAtiva == 'veiculos'">
    	<div class="col-md-8" style="margin-top:5px;">
    		<grid-veiculos></grid-veiculos>
    	</div>
    	<div class="col-md-4" >
    		<div class="panel panel-default" style="margin-top:5px;">
				<div class="panel-heading">Cadastro de Veículo</div>
			  	<div class="panel-body">
			    	<form class="form-horizontal">
				    	<fieldset>
				        	<div class="form-group">
				            	<div class="col-md-3">
				                	<label class=" control-label" for="os">Placa</label>  
				                    <input id="os" name="os" type="text"class="form-control input-sm" >
				                </div>
				                <div class="col-md-9">
				                	<label class=" control-label" for="os">Descrição</label>  
				                    <input id="os" name="os" type="text"class="form-control input-sm" >
				                </div>
				                <div class="col-md-6">
				                	<label class=" control-label" for="os">Chassi</label>  
				                    <input id="os" name="os" type="text"class="form-control input-sm" >
				                </div>
				                <div class="col-md-6">
				                	<label class=" control-label" for="os">Renavam</label>  
				                    <input id="os" name="os" type="text"class="form-control input-sm" >
				                </div>
				                <div class="col-md-3">
				                	<label class=" control-label" for="os">Ano</label>  
				                    <input id="os" name="os" type="number"class="form-control input-sm" >
				                </div>
				                <div class="col-md-4">
				                	<label class=" control-label" for="os">Km Atual</label>  
				                    <input id="os" name="os" type="number"class="form-control input-sm" >
				                </div>
				                <div class="col-md-5">
				                	<label class=" control-label" for="os">Combustível</label>  
				                	<select class="form-control input-sm">
				                		<option>Alcool</option>
				                		<option>Gasolina</option>
				                	</select>
				                </div>
				                <div class="col-md-5">
				                	<label class=" control-label" for="os">Marca</label>  
				                    <input id="os" name="os" type="text"class="form-control input-sm" >
				                </div>
				                <div class="col-md-4">
				                	<label class=" control-label" for="os">Cor</label>  
				                    <input id="os" name="os" type="text"class="form-control input-sm" >
				                </div>
				                
				                
				                <div class="col-md-3">
				                	<label class=" control-label" for="os">Valor Pago</label>  
				                    <input id="os" name="os" type="number"class="form-control input-sm" >
				                </div>
				                <div class="col-md-4">
				                	<label class=" control-label" for="os">Últ. Troca de Pneu</label>  
				                    <input id="os" name="os" type="text"class="form-control input-sm" >
				                </div>
				                <div class="col-md-4">
				                	<label class=" control-label" for="os">Mês Pgto IPVA</label>  
				                    <input id="os" name="os" type="text"class="form-control input-sm" >
				                </div>
				            </div>
				        </fieldset>
				        <button class="btn btn-primary" >Cadastrar</button>
				        <button class="btn btn-default">Cancelar</button>
				        
					</form>	
			 	</div>
			</div>
    	</div>
    </div>
    <div role="tabpanel" class="tab-pane" ng-class="{'active': tabAtiva == 'usuarios'}" id="usuarios" ng-if="tabAtiva == 'usuarios'">
    	<div class="col-md-8" style="margin-top:5px;">
    		<grid-usuarios></grid-usuarios>
    	</div>
    	
    	<div class="col-md-4" >
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
					                		<label class=" control-label" for="os">RG</label>  
					                    	<input ng-model="usuario.rg" type="text"class="form-control input-sm" >
					                	</div>
					                	<div class="col-md-4">
					                		<label class=" control-label" for="os">CPF</label>  
					                    	<input ng-model="usuario.cpf" type="text"class="form-control input-sm" >
					                	</div>
					                	<div class="col-md-4">
					                		<label class=" control-label" for="os">Data de Nascimento</label>  
					                    	<input ng-model="usuario.dataNascimento" type="text" bs-datepicker class="form-control input-sm" >
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
						                    <select class="form-control input-sm" ng-model="usuario.tipo">
						                    	<option value="administrador">Administrador</option>
						                    	<option value="motorista">Motorista</option>
						                    	<option value="usuario">Usuário</option>
						                    </select>
						                </div>
						                <!-- Motorista -->
						                <div ng-if="usuario.tipo == 'motorista'">
							                <div class="col-md-12">
							                	<hr/>
							                </div>
							                <div class="col-md-5">
						                		<label class=" control-label" for="os">Nº CNH</label>  
						                    	<input  type="text"class="form-control input-sm" ng-model="usuario.cnh.numero">
						                	</div>
						                	<div class="col-md-4">
						                		<label class=" control-label" for="os">Validade</label>  
						                    	<input  type="text"class="form-control input-sm" ng-model="usuario.cnh.validade">
						                	</div>
						                	<div class="col-md-3">
							                	<label class=" control-label" for="os">Categoria</label>  
							                    <select class="form-control input-sm" ng-model="usuario.cnh.categoria">
							                    
							                    </select>
							                </div>
						                </div>
						                <!-- Usuário ou Administrador -->
						                <div ng-if="usuario.tipo == 'administrador' || usuario.tipo == 'usuario'">
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
						                    <input ng-model="usuario.endereco.rua" type="text"class="form-control input-sm" >
						                </div>	
						                <div class="col-md-3">
						                	<label class=" control-label" for="os">Nº</label>  
						                    <input ng-model="usuario.endereco.numero" type="text"class="form-control input-sm" >
						                </div>
						                <div class="col-md-3">
						                	<label class=" control-label" for="os">Estado</label>  
						                    <select class="form-control input-sm">
						                    	
						                    </select>
						                </div>
						                <div class="col-md-5">
						                	<label class=" control-label" for="os">Cidade</label>  
						                    <input ng-model="usuario.endereco.cidade" type="text"class="form-control input-sm" >
						                </div>
						                <div class="col-md-4">
						                	<label class=" control-label" for="os">Bairro</label>  
						                    <input ng-model="usuario.endereco.bairro" type="text"class="form-control input-sm" >
						                </div>
						                <div class="col-md-5">
						                	<label class=" control-label" for="os">CEP</label>  
						                    <input ng-model="usuario.endereco.cep" type="text"class="form-control input-sm" >
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
				        <button class="btn btn-primary">Cadastrar</button>
				        <button class="btn btn-default">Cancelar</button>
					</form>	
			 	</div>
			</div>
    	</div>
    </div>
    	
    <div role="tabpanel" class="tab-pane" ng-class="{'active': tabAtiva == 'fornecedores'}" id="fornecedores" ng-if="tabAtiva == 'fornecedores'">
    	<div class="col-md-8" style="margin-top:5px;">
    		<grid-fornecedores></grid-fornecedores>
    	</div>
    	
    	<div class="col-md-4" >
    		<div class="panel panel-default" style="margin-top:5px;">
				<div class="panel-heading">Cadastro de Fornecedor</div>
			  	<div class="panel-body">
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
							                <input id="os" name="os" type="text"class="form-control input-sm" >
							            </div>
							            <div class="col-md-7">
							              	<label class=" control-label" for="os">Nome Fantasia</label>  
							                <input id="os" name="os" type="text"class="form-control input-sm" >
							            </div>
							            <div class="col-md-5">
							              	<label class=" control-label" for="os">CNPJ</label>  
							                <input id="os" name="os" type="text"class="form-control input-sm" >
							            </div>
							            <div class="col-md-5">
							              	<label class=" control-label" for="os">Inscrição Estadual</label>  
							                <input id="os" name="os" type="text"class="form-control input-sm" >
							            </div>
										<div class="col-md-7">
							              	<label class=" control-label" for="os">Email</label>  
							                <input id="os" name="os" type="text"class="form-control input-sm" >
							            </div>
							            <div class="col-md-5">
							              	<label class=" control-label" for="os">Tipo do Fornecedor</label>  
							                <select class="form-control input-sm">
							                
							                </select>
							            </div>
							        </div>
							        
								</div>
								<div role="tabpanel" class="tab-pane" id="contatoFornecedor">
							  		<div class="form-group">
							  			<div class="col-md-9">
						                	<label class=" control-label" for="os">Rua</label>  
						                    <input id="os" name="os" type="text"class="form-control input-sm" >
						                </div>	
						                <div class="col-md-3">
						                	<label class=" control-label" for="os">Nº</label>  
						                    <input id="os" name="os" type="text"class="form-control input-sm" >
						                </div>
						                <div class="col-md-3">
						                	<label class=" control-label" for="os">Estado</label>  
						                    <select class="form-control input-sm">
						                    
						                    </select>
						                </div>
						                <div class="col-md-5">
						                	<label class=" control-label" for="os">Cidade</label>  
						                    <input id="os" name="os" type="text"class="form-control input-sm" >
						                </div>
						                <div class="col-md-4">
						                	<label class=" control-label" for="os">Bairro</label>  
						                    <input id="os" name="os" type="text"class="form-control input-sm" >
						                </div>
						                <div class="col-md-5">
						                	<label class=" control-label" for="os">CEP</label>  
						                    <input id="os" name="os" type="text"class="form-control input-sm" >
						                </div>	
						                <div class="col-md-5">
						                	<label class=" control-label" for="os">Telefone</label>  
						                    <input id="os" name="os" type="text"class="form-control input-sm" >
						                </div>
						                <div class="col-md-2">
						                	<label class=" control-label" for="os">Ramal</label>  
						                    <input id="os" name="os" type="text"class="form-control input-sm" >
						                </div>
							  			<div class="col-md-12">
						                	<label class=" control-label" for="os">Observações</label>  
						                    <input id="os" name="os" type="text"class="form-control input-sm" >
						                </div>
						                
							  		</div>
							  	</div>
							</div>	
						</fieldset>
					</form>
			  	</div>
			</div>
		</div>
    </div>
  </div>

</div>