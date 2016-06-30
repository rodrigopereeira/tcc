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
						    <li role="presentation" class="active"><a href="#dadosVeiculoModal"  role="tab" data-toggle="tab">Dados</a></li>
						    <li role="presentation"><a href="#historicoVeiculoModal" ng-click="historicoVeiculo = true" role="tab" data-toggle="tab">Histórico</a></li>
						    <li role="presentation"><a href="#agendaVeiculoModal"  ng-click="agendaVeiculo = true" role="tab" data-toggle="tab">Agenda</a></li>
						</ul>
						<!-- Tab panes -->
						<div class="tab-content">
						  	<div role="tabpanel" class="tab-pane active " id="dadosVeiculoModal">
						  		<div class="form-group">
					            	<div class="col-md-3">
					                	<label class=" control-label" for="os">Placa</label>  
					                    <input ng-model="veiculoA.placa" type="text"class="form-control input-sm" >
					                </div>
					                <div class="col-md-9">
					                	<label class=" control-label" for="os">Descrição</label>  
					                    <input ng-model="veiculoA.modelo" type="text"class="form-control input-sm" >
					                </div>
					                <div class="col-md-6">
					                	<label class=" control-label" for="os">Chassi</label>  
					                    <input ng-model="veiculoA.chassi" type="text"class="form-control input-sm" >
					                </div>
					                <div class="col-md-6">
					                	<label class=" control-label" for="os">Renavam</label>  
					                    <input ng-model="veiculoA.renavam" type="text"class="form-control input-sm" >
					                </div>
					                <div class="col-md-3">
					                	<label class=" control-label" for="os">Ano</label>  
					                    <input ng-model="veiculoA.ano" type="number"class="form-control input-sm" >
					                </div>
					                <div class="col-md-4">
					                	<label class=" control-label" for="os">Km Atual</label>  
					                    <input ng-model="veiculoA.km" type="number"class="form-control input-sm" >
					                </div>
					                <div class="col-md-5">
					                	<label class=" control-label" for="os">Combustível</label>  
					                	<select class="form-control input-sm" ng-model="veiculoA.combustivel">
					                		<option>Alcool</option>
					                		<option>Gasolina</option>
					                	</select>
					                </div>
					                <div class="col-md-5">
					                	<label class=" control-label" for="os">Marca</label>  
					                    <input ng-model="veiculoA.marca" type="text"class="form-control input-sm" >
					                </div>
					                <div class="col-md-4">
					                	<label class=" control-label" for="os">Cor</label>  
					                    <input ng-model="veiculoA.cor" type="text"class="form-control input-sm" >
					                </div>
					                
					                
					                <div class="col-md-3">
					                	<label class=" control-label" for="os">Valor Pago</label>  
					                    <input ng-model="veiculoA.valor" type="number"class="form-control input-sm" >
					                </div>
					                <div class="col-md-4">
					                	<label class=" control-label" for="os">Últ. Troca de Pneu</label>  
					                    <input ng-model="veiculoA.ultimaTrocaPneu" type="text"class="form-control input-sm" data-date-format="dd/MM/yyyy" data-autoclose="1" bs-datepicker>
					                </div>
					                <div class="col-md-4">
					                	<label class=" control-label" for="os">Mês Pgto IPVA</label>  
					                    <input ng-model="veiculoA.mesIpva" type="text"class="form-control input-sm" >
					                </div>
					            </div>
						  	</div>
						  	<div role="tabpanel" class="tab-pane" id="historicoVeiculoModal" ng-if="historicoVeiculo">
						  		<label class=" control-label" for="os">Últimos 15 registros</label>  
						  		<div ui-grid="gridHistoricoVeiculo"  class="grid" style="height:200px;"></div>
						  	</div>
						  	<div role="tabpanel" class="tab-pane" id="agendaVeiculoModal" ng-if="agendaVeiculo">
						  		<label class=" control-label" for="os">Últimos 15 registros</label>  
						  		<div ui-grid="gridAgendaVeiculo"  class="grid" style="height:200px;"></div>
						  	</div>
						</div>
                    </fieldset>
                </form>
            </div>
            <div class="modal-footer">
            	<button class="btn btn-primary" ng-click="salvarVeiculo(veiculoA);$hide()">Salvar</button>
            	<button class="btn btn-danger" ng-click="excluirVeiculo(veiculoA);$hide()">Excluir</button>
                <button type="button" class="btn btn-default" ng-click="$hide()">Fechar</button>
            </div>
        </div>
    </div>
</div>
