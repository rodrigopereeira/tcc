package br.com.tcc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.dao.MultaDAO;
import br.com.tcc.dao.FornecedorDAO;
import br.com.tcc.dao.MotoristaDAO;
import br.com.tcc.dao.PagamentoDAO;
import br.com.tcc.dao.VeiculoDAO;
import br.com.tcc.model.Manutencao;
import br.com.tcc.model.Multa;
import br.com.tcc.model.Pagamento;

@RestController
@RequestMapping("multa")
public class MultaController {
	
	PagamentoDAO daoPagamento = new PagamentoDAO();
	MultaDAO daoMulta = new MultaDAO();
	VeiculoDAO daoVeiculo = new VeiculoDAO();
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastra (@RequestBody Multa multa) {
		
		Pagamento pagamento = daoPagamento.cadastra(multa.getPagamento());
		multa.setPagamento(pagamento);
		
		daoMulta.cadastra(multa);
		daoVeiculo.cadastraAcao(multa.getVeiculo(), 5);
	}
	
	@RequestMapping( method = RequestMethod.GET)
	public @ResponseBody List<Multa> listaMultas () {
		return daoMulta.listaMultas();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public @ResponseBody Multa visualiza (@PathVariable int id) {
		
		Multa multa = daoMulta.visualiza(id);
		multa.setPagamento(daoPagamento.visualiza(multa.getPagamento().getId()));
		return multa;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void altera (@RequestBody Multa multa) {
		
		daoPagamento.altera(multa.getPagamento());
		daoMulta.altera(multa);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void deleta (@PathVariable int id) {
		daoMulta.deleta(id);
	}
	
}
