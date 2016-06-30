app.factory('ServiceFornecedor', function ($http, $q) {
	
	var fornecedores = [];
	
	function getFornecedores() {
		return fornecedores;
	}
	
	function setFornecedores(newFornecedores) {
		fornecedores = newFornecedores;
	}
	
	function listaFornecedores () {
		return $http.get('fornecedor')
			 .then(function(response) {
                 if (typeof response.data === 'object') {
                	 setFornecedores(response.data);
                     return response.data;
                 } else {
                     // invalid response
                     return $q.reject(response.data);
                 }

             }, function(response) {
                 // something went wrong
                 return $q.reject(response.data);
             });
	}
	
	function procuraFornecedor(fornecedorid) {
		for (var i=0;i<fornecedores.length;i++) {
			if (fornecedores[i].id == fornecedorid) {
				return fornecedores[i];
			}
		}
	}
	
	return {
		listaFornecedores: listaFornecedores,
		getFornecedores: getFornecedores,
		setFornecedores: setFornecedores,
		procuraFornecedor: procuraFornecedor
	}
	
})