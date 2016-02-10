package br.com.tcc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.dao.FuncionarioDAO;
import br.com.tcc.model.Funcionario;
import br.com.tcc.model.Usuario;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {
	
	FuncionarioDAO daoFuncionario = new FuncionarioDAO();
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastra (@RequestBody Usuario usuario) {
		
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public void usuario (@PathVariable int id) {
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Funcionario> funcionarios() {
		return daoFuncionario.listaFuncionarios();
		
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void altera (@RequestBody Usuario usuario) {
		
	}
	
	@RequestMapping(value="/{idUsuario}", method = RequestMethod.DELETE)
	public void remove (@PathVariable int idUsuario) {
		
	}

}
