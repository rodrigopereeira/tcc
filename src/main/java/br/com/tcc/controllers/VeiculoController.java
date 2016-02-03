package br.com.tcc.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.model.Veiculo;

@RestController	
@RequestMapping("veiculo")
public class VeiculoController {
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastra (@RequestBody Veiculo veiculo) {
		//teste
	}
	
	@RequestMapping(value="/{idVeiculo}", method = RequestMethod.GET)
	public void usuario (@PathVariable int idVeiculo) {
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void usuarios () {
		
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void altera (@RequestBody Veiculo veiculo) {
		
	}
	
	@RequestMapping(value="/{idVeiculo}", method = RequestMethod.DELETE)
	public void remove (@PathVariable int idVeiculo) {
		
	}

}
