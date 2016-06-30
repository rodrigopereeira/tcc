package br.com.tcc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.dao.ContatoDAO;
import br.com.tcc.dao.FuncionarioDAO;
import br.com.tcc.dao.TelefoneDAO;
import br.com.tcc.dao.UsuarioDAO;
import br.com.tcc.model.Contato;
import br.com.tcc.model.Telefone;
import br.com.tcc.model.Usuario;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
	
	UsuarioDAO daoUsuario = new UsuarioDAO();
	TelefoneDAO daoTelefone = new TelefoneDAO();
	ContatoDAO daoContato = new ContatoDAO();
	FuncionarioDAO daoFuncionario = new FuncionarioDAO();
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastra (@RequestBody Usuario usuario) {
		
		Telefone telefone = daoTelefone.cadastra(usuario.getTelefone());
		Contato contato = daoContato.cadastra(usuario.getContato());
		
		usuario.setTelefone(telefone);
		usuario.setContato(contato);
		
		daoUsuario.cadastra(usuario);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Usuario usuario (@PathVariable int id) {
		Usuario usuario = daoUsuario.visualiza(id);

		usuario.setTelefone(daoTelefone.visualiza(usuario.getTelefone()));
		usuario.setContato(daoContato.visualiza(usuario.getContato()));

		return usuario;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Usuario> usuarios() {
		return null;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void altera (@RequestBody Usuario usuario) {
		daoTelefone.altera(usuario.getTelefone());
		daoContato.altera(usuario.getContato());
		
		daoUsuario.altera(usuario);
	}
	
	@RequestMapping(value="/{id}/{telefoneid}/{contatoid}", method = RequestMethod.DELETE)
	public void remove (@PathVariable int id, @PathVariable int telefoneid, @PathVariable int contatoid) {
		daoFuncionario.deleta(id);
		daoTelefone.deleta(telefoneid);
		daoContato.deleta(contatoid);
	}

}
