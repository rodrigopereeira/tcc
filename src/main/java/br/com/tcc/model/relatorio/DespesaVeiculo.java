package br.com.tcc.model.relatorio;

import java.util.List;

import br.com.tcc.model.Despesa;

public class DespesaVeiculo{

	public DespesaVeiculo(String veiculo, List<Despesa> despesas, double despesaTotalFrota) {
		this.veiculo = veiculo;
		this.despesas = despesas;
		this.despesaTotalFrota = despesaTotalFrota;
	}
	
	private String veiculo;
	private List<Despesa> despesas;
	private double despesaTotalFrota;
	
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public List<Despesa> getDespesas() {
		return despesas;
	}
	public void setDespesas(List<Despesa> despesas) {
		this.despesas = despesas;
	}
	public double getDespesaTotalFrota() {
		return despesaTotalFrota;
	}
	public void setDespesaTotalFrota(double despesaTotalFrota) {
		this.despesaTotalFrota = despesaTotalFrota;
	}
}