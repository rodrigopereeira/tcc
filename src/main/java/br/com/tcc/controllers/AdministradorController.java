package br.com.tcc.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.dao.AdministradorDAO;
import br.com.tcc.dao.ContatoDAO;
import br.com.tcc.dao.FuncionarioDAO;
import br.com.tcc.dao.TelefoneDAO;
import br.com.tcc.model.Administrador;
import br.com.tcc.model.Contato;
import br.com.tcc.model.Telefone;

@RestController
@RequestMapping("administrador")
public class AdministradorController {

	AdministradorDAO daoAdministrador = new AdministradorDAO();
	TelefoneDAO daoTelefone = new TelefoneDAO();
	ContatoDAO daoContato = new ContatoDAO();
	FuncionarioDAO daoFuncionario = new FuncionarioDAO();
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastra(@RequestBody Administrador administrador) {

		Telefone telefone = daoTelefone.cadastra(administrador.getTelefone());
		Contato contato = daoContato.cadastra(administrador.getContato());

		administrador.setTelefone(telefone);
		administrador.setContato(contato);

		daoAdministrador.cadastra(administrador);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Administrador administrador(@PathVariable int id) {
		Administrador administrador = daoAdministrador.visualiza(id);

		administrador.setTelefone(daoTelefone.visualiza(administrador.getTelefone()));
		administrador.setContato(daoContato.visualiza(administrador.getContato()));

		return administrador;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void usuarios() {

	}

	@RequestMapping(method = RequestMethod.PUT)
	public void altera(@RequestBody Administrador administrador) {
		daoTelefone.altera(administrador.getTelefone());
		daoContato.altera(administrador.getContato());

		daoAdministrador.altera(administrador);
	}

	@RequestMapping(value="/{id}/{telefoneid}/{contatoid}", method = RequestMethod.DELETE)
	public void remove (@PathVariable int id, @PathVariable int telefoneid, @PathVariable int contatoid) {
		daoFuncionario.deleta(id);
		daoTelefone.deleta(telefoneid);
		daoContato.deleta(contatoid);
	}

}
