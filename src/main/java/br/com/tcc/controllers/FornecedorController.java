package br.com.tcc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.dao.ContatoDAO;
import br.com.tcc.dao.FornecedorDAO;
import br.com.tcc.dao.TelefoneDAO;
import br.com.tcc.model.Contato;
import br.com.tcc.model.Fornecedor;
import br.com.tcc.model.Telefone;

@RestController
@RequestMapping("fornecedor")
public class FornecedorController {
	
	FornecedorDAO daoFornecedor = new FornecedorDAO();
	TelefoneDAO daoTelefone = new TelefoneDAO();
	ContatoDAO daoContato = new ContatoDAO();
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastra (@RequestBody Fornecedor fornecedor) {
		
		Telefone telefone = daoTelefone.cadastra(fornecedor.getTelefone());
		Contato contato = daoContato.cadastra(fornecedor.getContato());
		
		fornecedor.setTelefone(telefone);
		fornecedor.setContato(contato);
		
		daoFornecedor.cadastra(fornecedor);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public @ResponseBody Fornecedor visualiza (@PathVariable int id) {
		Fornecedor fornecedor = daoFornecedor.visualiza(id);
		
		fornecedor.setTelefone(daoTelefone.visualiza(fornecedor.getTelefone()));
		fornecedor.setContato(daoContato.visualiza(fornecedor.getContato()));
		
		return fornecedor;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Fornecedor> fornecedores () {
		return daoFornecedor.listaFornecedores();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void altera (@RequestBody Fornecedor fornecedor) {
		daoTelefone.altera(fornecedor.getTelefone());
		daoContato.altera(fornecedor.getContato());
		
		daoFornecedor.altera(fornecedor);
	}
	
	@RequestMapping(value="/{id}/{telefoneid}/{contatoid}", method = RequestMethod.DELETE)
	public void remove (@PathVariable int id, @PathVariable int telefoneid, @PathVariable int contatoid) {
		daoFornecedor.deleta(id);
		daoTelefone.deleta(telefoneid);
		daoContato.deleta(contatoid);
	}

}
