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
                            <li role="presentation" class="active"><a href="#dadosUsuarioModal"  role="tab" data-toggle="tab">Dados</a></li>
                            <li role="presentation"><a href="#contatoUsuarioModal"  role="tab" data-toggle="tab">Contato</a></li>
                        </ul>
                        <!-- Tab panes -->
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane active " id="dadosUsuarioModal">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class=" control-label" for="os">Nome</label>  
                                        <input ng-model="usuarioA.nome"  type="text"class="form-control input-sm" >
                                    </div>
                                    <div class="col-md-5">
                                        <label class=" control-label" for="os">Sobrenome</label>  
                                        <input ng-model="usuarioA.sobrenome"  type="text"class="form-control input-sm" >
                                    </div>
                                    <div class="col-md-3">
                                        <label class=" control-label" for="os">Sexo</label>  
                                        <select class="form-control input-sm" ng-model="usuarioA.sexo">
                                        	<option value="M">Masc</option>
						                	<option value="F">Fem</option>
                                        </select>
                                    </div>
                                    <div class="col-md-4">
                                        <label class=" control-label" for="os">RG</label>  
                                        <input ng-model="usuarioA.rg" type="text"class="form-control input-sm" >
                                    </div>
                                    <div class="col-md-4">
                                        <label class=" control-label" for="os">CPF</label>  
                                        <input ng-model="usuarioA.cpf" type="text"class="form-control input-sm" >
                                    </div>
                                    <div class="col-md-4">
                                        <label class=" control-label" for="os">Data de Nascimento</label>  
                                        <input ng-model="usuarioA.dataNascimento" type="text"class="form-control input-sm" data-date-format="dd/MM/yyyy" bs-datepicker>
                                    </div>
                                    <div class="col-md-7">
                                        <label class=" control-label" for="os">Email</label>  
                                        <input ng-model="usuarioA.email" type="text"class="form-control input-sm" >
                                    </div>
                                    <div class="col-md-5">
                                        <label class=" control-label" for="os">Estado Civil</label>  
                                        <select class="form-control input-sm" ng-model="usuarioA.estadoCivil">
						                    <option value="solteiro">Solteiro(a)</option>
						                    <option value="casado">Casado(a)</option>
						                    <option value="divorciado">Divorciado(a)</option>
						                    <option value="viuvo">Víuvo(a)</option>
						            	</select>
                                    </div>
                                    <div class="col-md-12">
                                        <hr/>
                                    </div>
                                    <div class="col-md-5">
					                	<label class=" control-label" for="os">Usuário</label>  
					                   	<input ng-model="usuarioA.login" type="text"class="form-control input-sm" >
					                </div>
					               	<div class="col-md-5">
					               		<label class=" control-label" for="os">Senha</label>  
					                   	<input ng-model="usuarioA.senha" type="password"class="form-control input-sm" >
					               	</div>
                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane" id="contatoUsuarioModal">
                                <div class="form-group">
                                    <div class="col-md-9">
                                        <label class=" control-label" for="os">Rua</label>  
                                        <input ng-model="usuarioA.contato.rua" type="text"class="form-control input-sm" >
                                    </div>
                                    <div class="col-md-3">
                                        <label class=" control-label" for="os">Nº</label>  
                                        <input ng-model="usuarioA.contato.numero" type="text"class="form-control input-sm" >
                                    </div>
                                    <div class="col-md-3">
                                        <label class=" control-label" for="os">Estado</label>  
                                        <select class="form-control input-sm" 
						                	ng-model="usuarioA.contato.estado" 
						                	ng-options="estado as estado for estado in estados">
						            	</select>
                                    </div>
                                    <div class="col-md-5">
                                        <label class=" control-label" for="os">Cidade</label>  
                                        <input ng-model="usuarioA.contato.cidade" type="text"class="form-control input-sm" >
                                    </div>
                                    <div class="col-md-4">
						                	<label class=" control-label" for="os">Bairro</label>  
						                    <input ng-model="usuarioA.contato.bairro" type="text"class="form-control input-sm" >
						                </div>
						                <div class="col-md-5">
						                	<label class=" control-label" for="os">CEP</label>  
						                    <input ng-model="usuarioA.contato.cep" type="text"class="form-control input-sm" >
						                </div>	
						                <div class="col-md-5">
						                	<label class=" control-label" for="os">Telefone</label>  
						                    <input ng-model="usuarioA.telefone.numero" type="text"class="form-control input-sm" >
						                </div>
						                <div class="col-md-2">
						                	<label class=" control-label" for="os">Ramal</label>  
						                    <input ng-model="usuarioA.telefone.ramal" type="text"class="form-control input-sm" >
						                </div>
							  			<div class="col-md-12">
						                	<label class=" control-label" for="os">Observações</label>  
						                    <input ng-model="usuarioA.telefone.observacoes" type="text"class="form-control input-sm" >
						                </div>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" ng-click="salvarFuncionario(usuarioA);$hide()">Salvar</button>
                <button class="btn btn-danger" ng-click="excluirFuncionario(usuarioA);$hide()">Excluir</button>
                <button type="button" class="btn btn-default" ng-click="$hide()">Fechar</button>
            </div>
        </div>
    </div>
</div>