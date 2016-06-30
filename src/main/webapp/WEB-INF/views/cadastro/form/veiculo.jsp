<div class="panel panel-default" style="margin-top:5px;">
    <div class="panel-heading">Cadastro de Veículo</div>
    <div class="panel-body">
        <form class="form-horizontal">
            <fieldset>
                <div class="form-group">
                    <div class="col-md-3">
                        <label class=" control-label" for="os">Placa</label>  
                        <input ng-model="veiculo.placa" type="text"class="form-control input-sm" >
                    </div>
                    <div class="col-md-9">
                        <label class=" control-label" for="os">Descrição</label>  
                        <input ng-model="veiculo.modelo" type="text"class="form-control input-sm" >
                    </div>
                    <div class="col-md-6">
                        <label class=" control-label" for="os">Chassi</label>  
                        <input ng-model="veiculo.chassi" type="text"class="form-control input-sm" >
                    </div>
                    <div class="col-md-6">
                        <label class=" control-label" for="os">Renavam</label>  
                        <input ng-model="veiculo.renavam" type="text"class="form-control input-sm" >
                    </div>
                    <div class="col-md-3">
                        <label class=" control-label" for="os">Ano</label>  
                        <input ng-model="veiculo.ano" type="number"class="form-control input-sm" >
                    </div>
                    <div class="col-md-4">
                        <label class=" control-label" for="os">Km Atual</label>  
                        <input ng-model="veiculo.km" type="number"class="form-control input-sm" >
                    </div>
                    <div class="col-md-5">
                        <label class=" control-label" for="os">Combustível</label>  
                        <select class="form-control input-sm" ng-model="veiculo.combustivel">
                            <option>Alcool</option>
                            <option>Gasolina</option>
                        </select>
                    </div>
                    <div class="col-md-5">
                        <label class=" control-label" for="os">Marca</label>  
                        <input ng-model="veiculo.marca" type="text"class="form-control input-sm" >
                    </div>
                    <div class="col-md-4">
                        <label class=" control-label" for="os">Cor</label>  
                        <input ng-model="veiculo.cor" type="text"class="form-control input-sm" >
                    </div>
                    <div class="col-md-3">
                        <label class=" control-label" for="os">Valor Pago</label>  
                        <input ng-model="veiculo.valor" type="number"class="form-control input-sm" >
                    </div>
                    <div class="col-md-4">
                        <label class=" control-label" for="os">Últ. Troca de Pneu</label>  
                        <input ng-model="veiculo.ultimaTrocaPneu" type="text"class="form-control input-sm" data-date-format="dd/MM/yyyy" data-autoclose="1" bs-datepicker>
                    </div>
                    <div class="col-md-4">
                        <label class=" control-label" for="os">Mês Pgto IPVA</label>  
                        <input ng-model="veiculo.mesIpva" type="text"class="form-control input-sm" >
                    </div>
                </div>
            </fieldset>
            <button class="btn btn-primary" ng-click="cadastrarVeiculo(veiculo)">Cadastrar</button>
            <button class="btn btn-default">Cancelar</button>
        </form>
    </div>
</div>