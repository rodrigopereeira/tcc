package br.com.tcc.model;

import java.util.Date;
import java.util.List;

public class Veiculo {

	private int id;
	private String placa;
	private String modelo;
	private int ano;
	private String chassi;
	private String renavam;
	private String marca;
	private String cor;
	private String combustivel;
	private double km;
	private double valor;
	private Date ultimaTrocaPneu;
	private int mesIpva;
	private List<HistoricoVeiculo> historico;
	private List<Agenda> agenda;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getRenavam() {
		return renavam;
	}
	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	public double getKm() {
		return km;
	}
	public void setKm(double km) {
		this.km = km;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Date getUltimaTrocaPneu() {
		return ultimaTrocaPneu;
	}
	public void setUltimaTrocaPneu(Date ultimaTrocaPneu) {
		this.ultimaTrocaPneu = ultimaTrocaPneu;
	}
	public int getMesIpva() {
		return mesIpva;
	}
	public void setMesIpva(int mesIpva) {
		this.mesIpva = mesIpva;
	}
	public List<HistoricoVeiculo> getHistorico() {
		return historico;
	}
	public void setHistorico(List<HistoricoVeiculo> historico) {
		this.historico = historico;
	}
	public List<Agenda> getAgenda() {
		return agenda;
	}
	public void setAgenda(List<Agenda> agenda) {
		this.agenda = agenda;
	}
	
}