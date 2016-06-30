package br.com.tcc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.dao.VeiculoDAO;
import br.com.tcc.model.Veiculo;

@RestController	
@RequestMapping("veiculo")
public class VeiculoController {
	
	VeiculoDAO daoVeiculo = new VeiculoDAO();
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json")
	public void cadastra (@RequestBody Veiculo veiculo) {
		daoVeiculo.cadastra(veiculo);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Veiculo getVeiculo (@PathVariable int id) {
		return daoVeiculo.visualiza(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Veiculo> veiculos() {
		return daoVeiculo.listaVeiculos();
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes="application/json")
	public void altera (@RequestBody Veiculo veiculo) {
		daoVeiculo.altera(veiculo);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void remove (@PathVariable int id) {
		daoVeiculo.deleta(id);
	}

}
