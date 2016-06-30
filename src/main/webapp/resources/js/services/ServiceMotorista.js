app.factory('ServiceMotorista', function ($http, $q) {
	
	var motoristas = [];
	
	function getMotoristas() {
		return motoristas;
	}
	
	function setMotoristas(newMotoristas) {
		motoristas = newMotoristas;
	}
	
	function listaMotoristas () {
		return $http.get('motorista')
			 .then(function(response) {
                 if (typeof response.data === 'object') {
                	 setMotoristas(response.data);
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
	
	function procuraMotorista(motoristaid) {
		for (var i=0;i<motoristas.length;i++) {
			if (motoristas[i].id == motoristaid) {
				return motoristas[i];
			}
		}
	}
	
	return {
		listaMotoristas: listaMotoristas,
		getMotoristas: getMotoristas,
		setMotoristas: setMotoristas,
		procuraMotorista: procuraMotorista
	}
	
})