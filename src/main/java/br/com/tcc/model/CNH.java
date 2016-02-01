package br.com.tcc.model;

import java.util.Date;

public class CNH {
	
	private int codigoCnh;
	private int numero;
	private Date validade;
	private String categoria;
	
	public int getCodigoCnh() {
		return codigoCnh;
	}
	public void setCodigoCnh(int codigoCnh) {
		this.codigoCnh = codigoCnh;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
