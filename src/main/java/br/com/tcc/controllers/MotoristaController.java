package br.com.tcc.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.model.Motorista;
import br.com.tcc.model.Usuario;

@RestController
@RequestMapping("motorista")
public class MotoristaController {
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastra (@RequestBody Motorista motorista) {
		
	}
	
	@RequestMapping(value="/{idUsuario}", method = RequestMethod.GET)
	public void usuario (@PathVariable int idUsuario) {
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void usuarios () {
		
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void altera (@RequestBody Motorista motorista) {
		
	}
	
	@RequestMapping(value="/{idUsuario}", method = RequestMethod.DELETE)
	public void remove (@PathVariable int idUsuario) {
		
	}

}
