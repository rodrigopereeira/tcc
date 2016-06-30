package br.com.tcc.model.relatorio;

import java.util.Date;

public class Cabecalho {
	
	public Cabecalho(String titulo, Date dataInicial, Date dataFinal) {
		this.titulo = titulo;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}
	
	private String titulo;
	private Date dataInicial;
	private Date dataFinal;

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
