package br.com.gvdi.domain;

public class Pedido {
	private Long id_pedido;
	private Double valor_total;
	private Long quant_item;
	private Cliente cliente;
	private Vendedor vendedor;

	public Long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Double getValor_total() {
		return valor_total;
	}

	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}

	public Long getQuant_item() {
		return quant_item;
	}

	public void setQuant_item(Long quant_item) {
		this.quant_item = quant_item;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

}
