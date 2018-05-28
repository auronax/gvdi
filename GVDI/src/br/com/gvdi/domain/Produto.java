package br.com.gvdi.domain;

public class Produto {
	private Long id_prod;
	private String desc_prod;
	private String quantidade;
	private String preco_custo;
	private String preco_venda;
	

	public Long getId_prod() {
		return id_prod;
	}
	public void setId_prod(Long id_prod) {
		this.id_prod = id_prod;
	}
	public String getDesc_prod() {
		return desc_prod;
	}
	public void setDesc_prod(String desc_prod) {
		this.desc_prod = desc_prod;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getPreco_custo() {
		return preco_custo;
	}
	public void setPreco_custo(String preco_custo) {
		this.preco_custo = preco_custo;
	}
	public String getPreco_venda() {
		return preco_venda;
	}
	public void setPreco_venda(String preco_venda) {
		this.preco_venda = preco_venda;
	}

}
