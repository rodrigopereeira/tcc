package br.com.tcc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.dao.KmDAO;
import br.com.tcc.dao.MotoristaDAO;
import br.com.tcc.dao.VeiculoDAO;
import br.com.tcc.model.Km;

@RestController
@RequestMapping("km")
public class KmController {
	
	KmDAO daoKm = new KmDAO();
	VeiculoDAO daoVeiculo = new VeiculoDAO();
	MotoristaDAO daoMotorista = new MotoristaDAO();
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastra (@RequestBody Km km) {
		daoKm.cadastra(km);
		
		daoVeiculo.atualizaKm(km.getVeiculo().getId(), km.getKmAtual());
		daoVeiculo.cadastraAcao(km.getVeiculo(), 3);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public @ResponseBody Km visualiza (@PathVariable int id) {
		Km km = daoKm.visualiza(id);
		
		//km.setVeiculo(daoVeiculo.visualiza(km.getVeiculo().getId()));
		//km.setMotorista(daoMotorista.visualiza(km.getMotorista().getId()));
		
		return km;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Km> manutencoes () {
		return daoKm.listaKms();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void altera (@RequestBody Km km) {
		daoKm.altera(km);
		
		if (daoVeiculo.chegaKmMaior(km.getVeiculo().getId(), km.getKmAtual())) {
			daoVeiculo.atualizaKm(km.getVeiculo().getId(), km.getKmAtual());
		}
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void remove (@PathVariable int id) {
		daoKm.deleta(id);
	}

}
