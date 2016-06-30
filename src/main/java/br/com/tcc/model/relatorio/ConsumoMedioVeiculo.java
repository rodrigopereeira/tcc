package br.com.tcc.model.relatorio;

public class ConsumoMedioVeiculo{

	public ConsumoMedioVeiculo(String veiculo, double distanciaPercorrida, 
			double combustivelUtilizado, double consumoMedio) {
		this.veiculo = veiculo;
		this.distanciaPercorrida = distanciaPercorrida;
		this.combustivelUtilizado = combustivelUtilizado;
		this.consumoMedio = consumoMedio;
	}
	
	private String veiculo;
	private double distanciaPercorrida;
	private double combustivelUtilizado;
	private double consumoMedio;
	
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public double getDistanciaPercorrida() {
		return distanciaPercorrida;
	}
	public void setDistanciaPercorrida(double distanciaPercorrida) {
		this.distanciaPercorrida = distanciaPercorrida;
	}
	public double getCombustivelUtilizado() {
		return combustivelUtilizado;
	}
	public void setCombustivelUtilizado(double combustivelUtilizado) {
		this.combustivelUtilizado = combustivelUtilizado;
	}
	public double getConsumoMedio() {
		return consumoMedio;
	}
	public void setConsumoMedio(double consumoMedio) {
		this.consumoMedio = consumoMedio;
	}
	
}
