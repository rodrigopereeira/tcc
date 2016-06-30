package br.com.tcc.model;

public class Motorista extends Funcionario {

	private CNH cnh;
	private String login;
	private String senha;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public CNH getCnh() {
		return cnh;
	}

	public void setCnh(CNH cnh) {
		this.cnh = cnh;
	}
	
}
