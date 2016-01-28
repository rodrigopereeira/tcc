<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="../templates/menu.jsp" />

<div ng-controller="cadastroController" class="container">

  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#veiculos"  role="tab" data-toggle="tab">Veículos</a></li>
    <li role="presentation"><a href="#usuarios"  role="tab" data-toggle="tab">Usuários</a></li>
    <li role="presentation"><a href="#fornecedores"  role="tab" data-toggle="tab">Fornecedores</a></li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="veiculos">
    	<div class="col-md-8" style="margin-top:5px;">
    		<div id="grid1" ui-grid="gridVeiculos" class="grid"></div>
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
				        <button class="btn btn-primary">Cadastrar</button>
				        <button class="btn btn-default">Cancelar</button>
					</form>	
			 	</div>
			</div>
    	</div>
    </div>
    <div role="tabpanel" class="tab-pane " id="usuarios">
    	<div class="col-md-8" style="margin-top:5px;">
    		<div id="grid1" ui-grid="gridMotoristas" class="grid"></div>
    	</div>
    	
    	<div class="col-md-4" >
    		<div class="panel panel-default" style="margin-top:5px;">
				<div class="panel-heading">Cadastro de Motorista</div>
			  	<div class="panel-body">
			    	<form class="form-horizontal">
				    	<fieldset>
				    		<ul class="nav nav-tabs" role="tablist">
							    <li role="presentation" class="active"><a href="#dadosMotorista"  role="tab" data-toggle="tab">Dados</a></li>
							    <li role="presentation"><a href="#contatoMotorista"  role="tab" data-toggle="tab">Contato</a></li>
							</ul>
							
							  <!-- Tab panes -->
							  <div class="tab-content">
							  	<div role="tabpanel" class="tab-pane active " id="dadosMotorista">
							  		<div class="form-group">
							  			<div class="col-md-4">
				                			<label class=" control-label" for="os">Nome</label>  
				                    		<input id="os" name="os" type="text"class="form-control input-sm" >
					                	</div>
					                	<div class="col-md-5">
					                		<label class=" control-label" for="os">Sobrenome</label>  
					                    	<input id="os" name="os" type="text"class="form-control input-sm" >
					                	</div>
					                	<div class="col-md-3">
						                	<label class=" control-label" for="os">Sexo</label>  
						                    <select class="form-control input-sm">
						                    
						                    </select>
						                </div>
					                	<div class="col-md-4">
					                		<label class=" control-label" for="os">RG</label>  
					                    	<input id="os" name="os" type="text"class="form-control input-sm" >
					                	</div>
					                	<div class="col-md-4">
					                		<label class=" control-label" for="os">CPF</label>  
					                    	<input id="os" name="os" type="text"class="form-control input-sm" >
					                	</div>
					                	<div class="col-md-4">
					                		<label class=" control-label" for="os">Data de Nascimento</label>  
					                    	<input id="os" name="os" type="text"class="form-control input-sm" >
					                	</div>
					                	<div class="col-md-7">
					                		<label class=" control-label" for="os">Email</label>  
					                    	<input id="os" name="os" type="text"class="form-control input-sm" >
					                	</div>
					                	<div class="col-md-5">
						                	<label class=" control-label" for="os">Estado Civil</label>  
						                    <select class="form-control input-sm">
						                    
						                    </select>
						                </div>
						                
						                <div class="col-md-5">
						                	<label class=" control-label" for="os">Setor</label>  
						                    <select class="form-control input-sm">
						                    
						                    </select>
						                </div>
						                <div class="col-md-5">
						                	<!-- Tipo de usuário, pode ser motorista, funcionario etc.. -->
						                	<label class=" control-label" for="os">Tipo</label>  
						                    <select class="form-control input-sm">
						                    
						                    </select>
						                </div>
						                <div class="col-md-12">
						                	<hr/>
						                </div>
						                <div class="col-md-5">
					                		<label class=" control-label" for="os">Nº CNH</label>  
					                    	<input id="os" name="os" type="text"class="form-control input-sm" >
					                	</div>
					                	<div class="col-md-4">
					                		<label class=" control-label" for="os">Validade</label>  
					                    	<input id="os" name="os" type="text"class="form-control input-sm" >
					                	</div>
					                	<div class="col-md-3">
						                	<label class=" control-label" for="os">Categoria</label>  
						                    <select class="form-control input-sm">
						                    
						                    </select>
						                </div>
						                <div class="col-md-12">
						                	<hr/>
						                </div>
						                <div class="col-md-5">
					                		<label class=" control-label" for="os">Usuário</label>  
					                    	<input id="os" name="os" type="text"class="form-control input-sm" >
					                	</div>
					                	<div class="col-md-5">
					                		<label class=" control-label" for="os">Senha</label>  
					                    	<input id="os" name="os" type="password"class="form-control input-sm" >
					                	</div>
					                </div>
							  	</div>

							  	<div role="tabpanel" class="tab-pane" id="contatoMotorista">
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
				        <button class="btn btn-primary">Cadastrar</button>
				        <button class="btn btn-default">Cancelar</button>
					</form>	
			 	</div>
			</div>
    	</div>
    </div>
    	
    <div role="tabpanel" class="tab-pane" id="fornecedores">
    	<div class="col-md-8" style="margin-top:5px;">
    		<div id="grid1" ui-grid="gridMotoristas" class="grid"></div>
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