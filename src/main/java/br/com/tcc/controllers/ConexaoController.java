package br.com.tcc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.tcc.dao.Conexao;

@Controller
public class ConexaoController {
	
	@RequestMapping("iniciaConexao")
	public @ResponseBody String inicia() {
		@SuppressWarnings("unused")
		Conexao conexao = new Conexao();
		
		return "Iniciou a conexão";
	}
	

}
