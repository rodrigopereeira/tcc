package br.com.tcc.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.model.FormasPagamento;

@RestController
@RequestMapping("pagamento")
public class PagamentoController {
	
	@RequestMapping(value="/tipos", method = RequestMethod.GET)
	public @ResponseBody FormasPagamento[] formasPagamento () {
		return FormasPagamento.values();
	}

}
