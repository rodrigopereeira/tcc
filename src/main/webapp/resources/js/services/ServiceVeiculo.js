app.factory('ServiceVeiculo', function ($http, $q) {
	
	var veiculos = [];
	
	function getVeiculos() {
		return veiculos;
	}
	
	function setVeiculos(newVeiculos) {
		veiculos = newVeiculos;
	}
	
	function listaVeiculos () {
		return $http.get('veiculo')
			 .then(function(response) {
                 if (typeof response.data === 'object') {
                	 setVeiculos(response.data);
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
	
	function procuraVeiculo (veiculoid) {
		for (var i=0;i<veiculos.length;i++) {
			if (veiculos[i].id == veiculoid) {
				return veiculos[i];
			}
		}
	}
	return {
		listaVeiculos: listaVeiculos,
		getVeiculos: getVeiculos,
		setVeiculos: setVeiculos,
		procuraVeiculo: procuraVeiculo
	}
	
})