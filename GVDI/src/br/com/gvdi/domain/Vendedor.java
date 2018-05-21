package br.com.gvdi.domain;

public class Vendedor {
	private Long id_vendedor;
	private Pessoa pessoa;

	public Long getId_vendedor() {
		return id_vendedor;
	}

	public void setId_vendedor(Long id_vendedor) {
		this.id_vendedor = id_vendedor;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
