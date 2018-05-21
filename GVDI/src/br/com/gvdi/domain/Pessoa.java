package br.com.gvdi.domain;

public class Pessoa {
	private Long id_pessoa;
	private String nome;
	private String email;
	private String senha;

	public Long getId_pessoa() {
		return id_pessoa;
	}

	public void setId_pessoa(long id_pessoa) {
		this.id_pessoa = id_pessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		String saida = id_pessoa + " - " + nome;
		return saida;
	}
}