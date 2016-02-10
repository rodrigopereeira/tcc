package br.com.tcc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tcc.dao.Conexao;

@Controller
public class ConexaoController {
	
	@RequestMapping("iniciaConexao")
	public void inicia() {
		Conexao conexao = new Conexao();
	}
	

}
