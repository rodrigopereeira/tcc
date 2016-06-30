package br.com.tcc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tcc.dao.Conexao;


@Controller
public class HomeController {
	
	public HomeController() {
		new Conexao();
	}

	@RequestMapping("/")
	public String inicio () {
		return "inicio";
	}
	@RequestMapping("/login")
	public String login () {
		return "login";
	}
	@RequestMapping("/loginError")
	public String loginerror(ModelMap model) {
		return "login";
	}
	@RequestMapping("/cadastro")
	public String cadastro () {
		return "cadastro/cadastro";
	}
	@RequestMapping("/frota")
	public String frota () {
		return "frota/frota";
	}
	@RequestMapping("/relatorio")
	public String relatorio () {
		return "relatorio/relatorio";
	}
	@RequestMapping("/teste")
	public String teste () {
		return "teste/teste";
	}
}
