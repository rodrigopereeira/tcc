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
                            <div role="tabpanel" class="tab-pane active " id="dadosFornecedor">
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
            <div class="modal-footer">
                <button class="btn btn-primary">Salvar</button>
                <button class="btn btn-danger">Excluir</button>
                <button type="button" class="btn btn-default" ng-click="$hide()">Fechar</button>
            </div>
        </div>
    </div>
</div>