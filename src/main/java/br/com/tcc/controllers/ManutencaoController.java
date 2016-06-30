package br.com.tcc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.dao.FornecedorDAO;
import br.com.tcc.dao.ManutencaoDAO;
import br.com.tcc.dao.PagamentoDAO;
import br.com.tcc.dao.VeiculoDAO;
import br.com.tcc.model.Manutencao;
import br.com.tcc.model.Pagamento;

@RestController
@RequestMapping("manutencao")
public class ManutencaoController {
	
	PagamentoDAO daoPagamento = new PagamentoDAO();
	ManutencaoDAO daoManutencao = new ManutencaoDAO();
	FornecedorDAO daoFornecedor = new FornecedorDAO();
	VeiculoDAO daoVeiculo = new VeiculoDAO();
	
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastra (@RequestBody Manutencao manutencao) {
		Pagamento pagamento = daoPagamento.cadastra(manutencao.getPagamento());
		manutencao.setPagamento(pagamento);
		
		daoManutencao.cadastra(manutencao);
		daoVeiculo.cadastraAcao(manutencao.getVeiculo(), 4);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public @ResponseBody Manutencao visualiza (@PathVariable int id) {
		Manutencao manutencao = daoManutencao.visualiza(id);
		manutencao.setFornecedor(daoFornecedor.visualiza(manutencao.getFornecedor().getId()));
		manutencao.setVeiculo(daoVeiculo.visualiza(manutencao.getVeiculo().getId()));
		manutencao.setPagamento(daoPagamento.visualiza(manutencao.getPagamento().getId()));
		return manutencao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Manutencao> manutencoes () {
		return daoManutencao.listaManutencoes();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void altera (@RequestBody Manutencao manutencao) {
		daoPagamento.altera(manutencao.getPagamento());
		daoManutencao.altera(manutencao);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void remove (@PathVariable int id) {
		daoManutencao.deleta(id);
	}

}
