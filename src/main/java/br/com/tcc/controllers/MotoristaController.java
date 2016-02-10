package br.com.tcc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.dao.CnhDAO;
import br.com.tcc.dao.ContatoDAO;
import br.com.tcc.dao.MotoristaDAO;
import br.com.tcc.dao.TelefoneDAO;
import br.com.tcc.model.CNH;
import br.com.tcc.model.Contato;
import br.com.tcc.model.Motorista;
import br.com.tcc.model.Telefone;

@RestController
@RequestMapping("motorista")
public class MotoristaController {
	
	MotoristaDAO daoMotorista = new MotoristaDAO();
	CnhDAO daoCnh = new CnhDAO();
	TelefoneDAO daoTelefone = new TelefoneDAO();
	ContatoDAO daoContato = new ContatoDAO();
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastra (@RequestBody Motorista motorista) {
		
		Telefone telefone = daoTelefone.cadastra(motorista.getTelefone());
		Contato contato = daoContato.cadastra(motorista.getContato());
		CNH cnh = daoCnh.cadastra(motorista.getCnh());
		
		motorista.setTelefone(telefone);
		motorista.setContato(contato);
		motorista.setCnh(cnh);
		
		daoMotorista.cadastra(motorista);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public @ResponseBody Motorista visualiza (@PathVariable int id) {
		Motorista motorista = daoMotorista.visualiza(id);
		
		motorista.setTelefone(daoTelefone.visualiza(motorista.getTelefone()));
		motorista.setContato(daoContato.visualiza(motorista.getContato()));
		motorista.setCnh(daoCnh.visualiza(motorista.getCnh()));
		
		return motorista;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Motorista> motoristas () {
		return daoMotorista.listaMotoristas();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void altera (@RequestBody Motorista motorista) {
		
	}
	
	@RequestMapping(value="/{idUsuario}", method = RequestMethod.DELETE)
	public void remove (@PathVariable int idUsuario) {
		
	}

}
