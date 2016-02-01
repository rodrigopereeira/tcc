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
						    <li role="presentation" class="active"><a href="#dadosVeiculo"  role="tab" data-toggle="tab">Dados</a></li>
						    <li role="presentation"><a href="#historicoVeiculo"  role="tab" data-toggle="tab">Histórico</a></li>
						    <li role="presentation"><a href="#agendaVeiculo"  role="tab" data-toggle="tab">Agenda</a></li>
						</ul>
						<!-- Tab panes -->
						<div class="tab-content">
						  	<div role="tabpanel" class="tab-pane active " id="dadosVeiculo">
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
						  	</div>
						  	<div role="tabpanel" class="tab-pane" id="historicoVeiculo">
						  	
						  	</div>
						  	<div role="tabpanel" class="tab-pane" id="agendaVeiculo">
						  	
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
