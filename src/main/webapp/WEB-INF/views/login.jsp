<html>
<head>
	<title>Gestão de Frotas - Login</title>
	<link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="resources/css/custom.css">
</head>
<body class="fundo">
	<div class="container-fluid ">
		<div class="row">
	        <div class="col-md-3 col-md-offset-7">
	            <div class="panel panel-default" style="margin-top:65%">
	                <div class="panel-heading"> <strong class="">Entrar no Sistema</strong>
	                </div>
	                <div class="panel-body">
	                    <form class="form-horizontal" name='loginForm' action="j_spring_security_check" method='POST'>
	                        <div class="form-group">
	                            <label  class="col-sm-3 control-label">Usuário</label>
	                            <div class="col-sm-9">
	                                <input required type="text" class="form-control" name="j_username" placeholder="Insira seu usuário" aria-describedby="basic-addon1">
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label  class="col-sm-3 control-label">Senha</label>
	                            <div class="col-sm-9">
	                                <input required type="password" class="form-control" name="j_password" placeholder="Insira sua senha" aria-describedby="basic-addon1">
	                            </div>
	                        </div>
	                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	                        <div class="form-group last">
	                            <div class="col-sm-offset-3 col-sm-9">
	                                <button type="submit" class="btn btn-success ">Entrar</button>
	                                <button type="reset" class="btn btn-default ">Limpar</button>
	                            </div>
	                        </div>
	                    </form>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
</body>
</html>