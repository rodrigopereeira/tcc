package br.com.tcc.model;

import java.util.Date;

public class Veiculo {

	private int codigoVeiculo;
	private String placa;
	private String modelo;
	private int ano;
	private String chassi;
	private String renavam;
	private String marca;
	private String cor;
	private String combustivel;
	private double kmAtual;
	private double valorPago;
	private Date ultimaTrocaPneu;
	private int mesIpva;
	
	public int getCodigoVeiculo() {
		return codigoVeiculo;
	}
	public void setCodigoVeiculo(int codigoVeiculo) {
		this.codigoVeiculo = codigoVeiculo;
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
	public double getKmAtual() {
		return kmAtual;
	}
	public void setKmAtual(double kmAtual) {
		this.kmAtual = kmAtual;
	}
	public double getValorPago() {
		return valorPago;
	}
	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
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
}