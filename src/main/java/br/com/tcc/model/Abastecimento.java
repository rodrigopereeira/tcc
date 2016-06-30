package br.com.tcc.model;

import java.util.Date;

public class Abastecimento {
	
	private int id;
	private Usuario usuario;
	private Motorista motorista;
	private Veiculo veiculo;
	private double km;
	private double kmAnterior;
	private double kmPercorrido;
	private Fornecedor fornecedor;
	private Date data;
	private Pagamento pagamento;
	private int tipoid;
	private double valorLitro;
	private double litros;
	private String tipoCombustivel;
	private String observacoes;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public double getKm() {
		return km;
	}
	public void setKm(double km) {
		this.km = km;
	}
	public double getKmAnterior() {
		return kmAnterior;
	}
	public void setKmAnterior(double kmAnterior) {
		this.kmAnterior = kmAnterior;
	}
	public double getKmPercorrido() {
		return kmPercorrido;
	}
	public void setKmPercorrido(double kmPercorrido) {
		this.kmPercorrido = kmPercorrido;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	public int getTipoid() {
		return tipoid;
	}
	public void setTipoid(int tipoid) {
		this.tipoid = tipoid;
	}
	public double getValorLitro() {
		return valorLitro;
	}
	public void setValorLitro(double valorLitro) {
		this.valorLitro = valorLitro;
	}
	public double getLitros() {
		return litros;
	}
	public void setLitros(double litros) {
		this.litros = litros;
	}
	public String getTipoCombustivel() {
		return tipoCombustivel;
	}
	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
}
