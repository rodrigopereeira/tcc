package br.com.tcc.model.relatorio;

import java.util.List;

public class DespesaRelatorio {
	
	private Cabecalho cabecalho;
	private List<DespesaVeiculo> veiculos;
	
	public Cabecalho getCabecalho() {
		return cabecalho;
	}
	public void setCabecalho(Cabecalho cabecalho) {
		this.cabecalho = cabecalho;
	}
	public List<DespesaVeiculo> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(List<DespesaVeiculo> veiculos) {
		this.veiculos = veiculos;
	}
}