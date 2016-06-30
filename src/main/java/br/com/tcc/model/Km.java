package br.com.tcc.model;

import java.util.Date;

public class Km {
	
	private int id;
	private Veiculo veiculo;
	private Usuario usuario;
	private Motorista motorista;
	private double kmAtual;
	private Date dataSaida;
	private Date dataChegada;
	private Date horaSaida;
	private Date horaChegada;
	private String destino;
	private double kmPercorrida;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	public double getKmAtual() {
		return kmAtual;
	}
	public void setKmAtual(double kmAtual) {
		this.kmAtual = kmAtual;
	}
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	public Date getDataChegada() {
		return dataChegada;
	}
	public void setDataChegada(Date dataChegada) {
		this.dataChegada = dataChegada;
	}
	public Date getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(Date horaSaida) {
		this.horaSaida = horaSaida;
	}
	public Date getHoraChegada() {
		return horaChegada;
	}
	public void setHoraChegada(Date horaChegada) {
		this.horaChegada = horaChegada;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public double getKmPercorrida() {
		return kmPercorrida;
	}
	public void setKmPercorrida(double kmPercorrida) {
		this.kmPercorrida = kmPercorrida;
	}

}
