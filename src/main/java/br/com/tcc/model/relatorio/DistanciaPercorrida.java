package br.com.tcc.model.relatorio;

import java.util.List;

public class DistanciaPercorrida {
	
	private Cabecalho cabecalho;
	private List<DistanciaPercorridaVeiculo> veiculos;
	
	public Cabecalho getCabecalho() {
		return cabecalho;
	}
	public void setCabecalho(Cabecalho cabecalho) {
		this.cabecalho = cabecalho;
	}
	public List<DistanciaPercorridaVeiculo> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(List<DistanciaPercorridaVeiculo> veiculos) {
		this.veiculos = veiculos;
	}
}