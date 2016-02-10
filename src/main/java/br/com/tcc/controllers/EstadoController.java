package br.com.tcc.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.model.Estados;

@RestController
@RequestMapping("estado")
public class EstadoController {
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Estados[] usuarios () {
		return Estados.values();
	}

}
