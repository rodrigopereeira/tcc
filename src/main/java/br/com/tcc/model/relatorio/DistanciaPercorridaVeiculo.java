package br.com.tcc.model.relatorio;

import java.util.List;

import br.com.tcc.model.Km;

public class DistanciaPercorridaVeiculo{

	public DistanciaPercorridaVeiculo(String veiculo, List<Km> kms, double kmTotalFrota) {
		this.veiculo = veiculo;
		this.kms = kms;
		this.kmTotalFrota = kmTotalFrota;
	}
	
	private String veiculo;
	private List<Km> kms;
	private double kmTotalFrota;
	
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public List<Km> getKms() {
		return kms;
	}
	public void setKms(List<Km> kms) {
		this.kms = kms;
	}
	public double getKmTotalFrota() {
		return kmTotalFrota;
	}
	public void setKmTotalFrota(double kmTotalFrota) {
		this.kmTotalFrota = kmTotalFrota;
	}
	
}
