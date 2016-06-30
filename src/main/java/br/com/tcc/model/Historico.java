package br.com.tcc.model;

import java.util.Date;

public class Historico {
	
	private int id;
	private int acaoid;
	private String acao;
	private Date data;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAcaoid() {
		return acaoid;
	}
	public void setAcaoid(int acaoid) {
		this.acaoid = acaoid;
	}
	
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

}