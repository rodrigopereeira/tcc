package br.com.tcc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.dao.AgendaDAO;
import br.com.tcc.dao.FornecedorDAO;
import br.com.tcc.dao.VeiculoDAO;
import br.com.tcc.model.Agenda;

@RestController
@RequestMapping("agenda")
public class AgendaController {
	
	AgendaDAO daoAgenda = new AgendaDAO();
	FornecedorDAO daoFornecedor = new FornecedorDAO();
	VeiculoDAO daoVeiculo = new VeiculoDAO();
	
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastra (@RequestBody Agenda agenda) {
		daoAgenda.cadastra(agenda);
		
		daoVeiculo.cadastraAcao(agenda.getVeiculo(), 2);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public @ResponseBody Agenda visualiza (@PathVariable int id) {
		Agenda agenda = daoAgenda.visualiza(id);
		agenda.setFornecedor(daoFornecedor.visualiza(agenda.getFornecedor().getId()));
		agenda.setVeiculo(daoVeiculo.visualiza(agenda.getVeiculo().getId()));
		return agenda;
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void deleta (@PathVariable int id) {
		daoAgenda.deleta(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Agenda> agendas () {
		return daoAgenda.listaAgenda();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void altera (@RequestBody Agenda agenda) {
		daoAgenda.altera(agenda);
	}
	
}
