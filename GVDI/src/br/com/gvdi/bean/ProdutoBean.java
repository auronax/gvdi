package br.com.gvdi.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gvdi.DAO.ProdutoDAO;
import br.com.gvdi.domain.Produto;
import br.com.gvdi.util.JSFUtil;
/*
@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {
	private Produto produto;
	private ArrayList<Produto> itens;
	private ArrayList<Produto> itensFiltrados;
	
	private ArrayList<Produto>comboProduto;
	
	public ArrayList<Produto> getComboProduto() {
		return comboProduto;
	}
	
	public void setComboProduto(ArrayList<Produto> comboProduto) {
		this.comboProduto = comboProduto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ArrayList<Produto> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Produto> itens) {
		this.itens = itens;
	}

	public ArrayList<Produto> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Produto> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			ProdutoDAO pdao = new ProdutoDAO();
			itens = pdao.listar();

		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void prepararNovo(){
		produto = new Produto();		
	}
	
	

}*/