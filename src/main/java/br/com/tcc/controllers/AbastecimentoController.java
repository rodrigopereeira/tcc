package br.com.tcc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.dao.AbastecimentoDAO;
import br.com.tcc.dao.FornecedorDAO;
import br.com.tcc.dao.MotoristaDAO;
import br.com.tcc.dao.PagamentoDAO;
import br.com.tcc.dao.VeiculoDAO;
import br.com.tcc.model.Abastecimento;
import br.com.tcc.model.Pagamento;

@RestController
@RequestMapping("abastecimento")
public class AbastecimentoController {
	
	PagamentoDAO daoPagamento = new PagamentoDAO();
	AbastecimentoDAO daoAbastecimento = new AbastecimentoDAO();
	VeiculoDAO daoVeiculo = new VeiculoDAO();
	FornecedorDAO daoFornecedor = new FornecedorDAO();
	MotoristaDAO daoMotorista = new MotoristaDAO();
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastra (@RequestBody Abastecimento abastecimento) {
		Pagamento pagamento = daoPagamento.cadastra(abastecimento.getPagamento());
		abastecimento.setPagamento(pagamento);
		
		daoAbastecimento.cadastra(abastecimento);
		daoVeiculo.atualizaKm(abastecimento.getVeiculo().getId(), abastecimento.getKm());
		daoVeiculo.cadastraAcao(abastecimento.getVeiculo(), 1);
	}
	
	@RequestMapping( method = RequestMethod.GET)
	public @ResponseBody List<Abastecimento> listaAbastecimentos () {
		return daoAbastecimento.listaAbastecimentos();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public @ResponseBody Abastecimento visualiza (@PathVariable int id) {
		Abastecimento abastecimento = daoAbastecimento.visualiza(id);
		abastecimento.setFornecedor(daoFornecedor.visualiza(abastecimento.getFornecedor().getId()));
		abastecimento.setVeiculo(daoVeiculo.visualiza(abastecimento.getVeiculo().getId()));
		abastecimento.setMotorista(daoMotorista.visualiza(abastecimento.getMotorista().getId()));
		abastecimento.setPagamento(daoPagamento.visualiza(abastecimento.getPagamento().getId()));
		
		return abastecimento;
	}
	
	@RequestMapping(value="/{abastecimentoid}/{pagamentoid}", method = RequestMethod.DELETE)
	public void deleta (@PathVariable int abastecimentoid, @PathVariable int pagamentoid) {
		Abastecimento abastecimento = daoAbastecimento.visualiza(abastecimentoid);
		daoVeiculo.atualizaKm(abastecimento.getVeiculo().getId(), abastecimento.getKmAnterior());
		
		daoPagamento.deleta(pagamentoid);
		daoAbastecimento.deleta(abastecimentoid);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void altera (@RequestBody Abastecimento abastecimento) {
		daoPagamento.altera(abastecimento.getPagamento());
		daoAbastecimento.altera(abastecimento);
	}
	
	
}
