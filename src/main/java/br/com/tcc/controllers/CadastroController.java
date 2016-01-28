package br.com.tcc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CadastroController {
	
	@RequestMapping("/cadastro")
	public String inicio () {
		return "cadastro/cadastro";
	}

}
