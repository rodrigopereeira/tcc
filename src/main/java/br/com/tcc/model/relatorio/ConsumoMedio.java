package br.com.tcc.model.relatorio;

import java.util.List;

public class ConsumoMedio {
	
	private Cabecalho cabecalho;
	private List<ConsumoMedioVeiculo> veiculos;
	
	public Cabecalho getCabecalho() {
		return cabecalho;
	}
	public void setCabecalho(Cabecalho cabecalho) {
		this.cabecalho = cabecalho;
	}
	public List<ConsumoMedioVeiculo> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(List<ConsumoMedioVeiculo> veiculos) {
		this.veiculos = veiculos;
	}

}
