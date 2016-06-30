package br.com.tcc.controllers.relatorio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.dao.DespesasDAO;
import br.com.tcc.dao.VeiculoDAO;
import br.com.tcc.model.Despesa;
import br.com.tcc.model.Km;
import br.com.tcc.model.Veiculo;
import br.com.tcc.model.relatorio.Cabecalho;
import br.com.tcc.model.relatorio.ConsumoMedio;
import br.com.tcc.model.relatorio.ConsumoMedioVeiculo;
import br.com.tcc.model.relatorio.DespesaRelatorio;
import br.com.tcc.model.relatorio.DespesaVeiculo;
import br.com.tcc.model.relatorio.DistanciaPercorrida;
import br.com.tcc.model.relatorio.DistanciaPercorridaVeiculo;
import br.com.tcc.model.relatorio.ImpactoFinanceiro;

@RestController
@RequestMapping("relatorio")
public class RelatorioController {
	
	VeiculoDAO daoVeiculo = new VeiculoDAO();
	double totalKm = 0;
	double totalDespesa = 0;
	
	@RequestMapping(value="consumoMedio/{veiculoid}/{dataInicial}/{dataFinal}", method = RequestMethod.GET)
	public void consumoMedio (@PathVariable int veiculoid, @PathVariable long dataInicial, 
			@PathVariable long dataFinal, HttpServletRequest request, HttpServletResponse response) {
		
		Cabecalho cabecalho = new Cabecalho("Consumo Médio", new Date(dataInicial), new Date(dataFinal));
		List<ConsumoMedioVeiculo> veiculos = new ArrayList<ConsumoMedioVeiculo>();
    	
    	if (veiculoid == 0) {
    		List<Veiculo> listaVeiculos = daoVeiculo.listaVeiculos();
    		for (Veiculo veiculo : listaVeiculos) {
    			String modelo = veiculo.getModelo();
    			double totalPercorrido = daoVeiculo.kmPercorrido(veiculo.getId(), new Date(dataInicial), new Date(dataFinal));
    			double combustivelUtilizado = daoVeiculo.combustivelUtilizado(veiculo.getId(), new Date(dataInicial), new Date(dataFinal));
    			double consumoMedioVeiculo = totalPercorrido/combustivelUtilizado;
    			
    			ConsumoMedioVeiculo i = new ConsumoMedioVeiculo(modelo, totalPercorrido, combustivelUtilizado, consumoMedioVeiculo);
    			veiculos.add(i);
    		}
    	} else {
    		Veiculo veiculo = daoVeiculo.visualiza(veiculoid);
    		String modelo = veiculo.getModelo();
			double totalPercorrido = daoVeiculo.kmPercorrido(veiculo.getId(), new Date(dataInicial), new Date(dataFinal));
			double combustivelUtilizado = daoVeiculo.combustivelUtilizado(veiculo.getId(), new Date(dataInicial), new Date(dataFinal));
			double consumoMedioVeiculo = totalPercorrido/combustivelUtilizado;
			
			ConsumoMedioVeiculo i = new ConsumoMedioVeiculo(modelo, totalPercorrido, combustivelUtilizado, consumoMedioVeiculo);
			veiculos.add(i);
    	}
    	
		
    	ConsumoMedio consumoMedio = new ConsumoMedio();
    	consumoMedio.setCabecalho(cabecalho);
    	consumoMedio.setVeiculos(veiculos);
    	
		try {

			String nome = request.getServletContext().getRealPath(CaminhosRelatorio.retornaCaminho("consumoMedio"));
        	
            Map<String, Object> parametros = new HashMap<String, Object>();

            GeradorRelatorio gerador = new GeradorRelatorio(nome, parametros, consumoMedio);
             
			gerador.geraPDFParaOutputStream(response.getOutputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="distanciaPercorrida/{veiculoid}/{dataInicial}/{dataFinal}", method = RequestMethod.GET)
	public void distanciaPercorrida (@PathVariable int veiculoid, @PathVariable long dataInicial, 
			@PathVariable long dataFinal, HttpServletRequest request, HttpServletResponse response) {
		
		totalKm = 0;
		Cabecalho cabecalho = new Cabecalho("Distância Percorrida", new Date(dataInicial), new Date(dataFinal));
		List<DistanciaPercorridaVeiculo> veiculos = new ArrayList<DistanciaPercorridaVeiculo>();
    	
    	if (veiculoid == 0) {
    		List<Veiculo> listaVeiculos = daoVeiculo.listaVeiculos();
    		for (Veiculo veiculo : listaVeiculos) {
    			String modelo = veiculo.getModelo();
    			List<Km> listaKms = daoVeiculo.listaKms(veiculo.getId(), new Date(dataInicial), new Date(dataFinal));
    			double somaTotalKm = somaTotalKm(listaKms);
    			
    			DistanciaPercorridaVeiculo i = new DistanciaPercorridaVeiculo(modelo, listaKms, somaTotalKm);
    			veiculos.add(i);
    		}
    	} else {
    	}
    	
		
    	DistanciaPercorrida distanciaPercorrida = new DistanciaPercorrida();
    	distanciaPercorrida.setCabecalho(cabecalho);
    	distanciaPercorrida.setVeiculos(veiculos);
    	
		try {

			String nome = request.getServletContext().getRealPath(CaminhosRelatorio.retornaCaminho("distanciaPercorrida"));
        	
            Map<String, Object> parametros = new HashMap<String, Object>();

            GeradorRelatorio gerador = new GeradorRelatorio(nome, parametros, distanciaPercorrida);
             
			gerador.geraPDFParaOutputStream(response.getOutputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="despesas/{veiculoid}/{dataInicial}/{dataFinal}", method = RequestMethod.GET)
	public void despesas (@PathVariable int veiculoid, @PathVariable long dataInicial, 
			@PathVariable long dataFinal, HttpServletRequest request, HttpServletResponse response) {
		
		totalKm = 0;
		Cabecalho cabecalho = new Cabecalho("Despesas", new Date(dataInicial), new Date(dataFinal));
		List<DespesaVeiculo> veiculos = new ArrayList<DespesaVeiculo>();
    	
    	if (veiculoid == 0) {
    		List<Veiculo> listaVeiculos = daoVeiculo.listaVeiculos();
    		
    		for (Veiculo veiculo : listaVeiculos) {
    			String modelo = veiculo.getModelo();
    			List<Despesa> listaDespesas = daoVeiculo.listaDespesas(veiculo.getId(), new Date(dataInicial), new Date(dataFinal));
    			double somaTotalDespesa = somaTotalDespesa(listaDespesas);
    			
    			DespesaVeiculo i = new DespesaVeiculo(modelo, listaDespesas, somaTotalDespesa);
    			veiculos.add(i);
    		}
    	} else {
    		
    	}
		
    	DespesaRelatorio despesas = new DespesaRelatorio();
    	despesas.setCabecalho(cabecalho);
    	despesas.setVeiculos(veiculos);
    	
		try {

			String nome = request.getServletContext().getRealPath(CaminhosRelatorio.retornaCaminho("despesa"));
        	
            Map<String, Object> parametros = new HashMap<String, Object>();

            GeradorRelatorio gerador = new GeradorRelatorio(nome, parametros, despesas);
             
			gerador.geraPDFParaOutputStream(response.getOutputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="impactoFinanceiro", method = RequestMethod.GET)
	public ImpactoFinanceiro impactoFinanceiro (HttpServletRequest request, HttpServletResponse response) {
		ImpactoFinanceiro impacto = new ImpactoFinanceiro();
		
		DespesasDAO daoDespesa = new DespesasDAO();
		impacto.setTotalAbastecimento(daoDespesa.totalAbastecimento());
		impacto.setTotalManutencao(daoDespesa.totalManutencao());
		impacto.setTotalMulta(daoDespesa.totalMulta());
		
		return impacto;
	}
	
	double somaTotalKm(List<Km> listaKms) {
		for (Km km : listaKms) {
			totalKm = totalKm + km.getKmPercorrida();
		}
		return totalKm;
	}
	
	double somaTotalDespesa(List<Despesa> listaDespesas) {
		for (Despesa despesa : listaDespesas) {
			totalDespesa = totalDespesa + despesa.getValor();
		}
		return totalDespesa;
	}
	
}
