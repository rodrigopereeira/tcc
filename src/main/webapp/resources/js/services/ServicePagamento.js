app.factory('ServicePagamento', function ($http, $q) {
	
	var formasPagamento = [];
	
	function getFormasPagamento() {
		return formasPagamento;
	}
	
	function setFormasPagamento(newFormasPagamento) {
		formasPagamento = newFormasPagamento;
	}
	
	function listaFormasPagamento () {
		return $http.get('pagamento/tipos')
			 .then(function(response) {
                 if (typeof response.data === 'object') {
                	 setFormasPagamento(response.data);
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
	
	return {
		listaFormasPagamento: listaFormasPagamento,
		getFormasPagamento: getFormasPagamento,
		setFormasPagamento: setFormasPagamento
	}
	
})