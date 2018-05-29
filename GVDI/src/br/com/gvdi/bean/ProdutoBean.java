package br.com.gvdi.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gvdi.DAO.ProdutoDAO;
import br.com.gvdi.domain.Produto;
import br.com.gvdi.util.JSFUtil;

@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {
	private Produto produto;
	private ArrayList<Produto>produtos;
	private ArrayList<Produto>produtosFiltrados;
	
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	public ArrayList<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}
	public void setProdutosFiltrados(ArrayList<Produto> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa(){
				
		try {
			ProdutoDAO dao = new ProdutoDAO();
			produtos = dao.listar();
			
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
		
	}
	
	public void prepararNovo(){
		produto = new Produto();
	}
	
	public void novo(){
		
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.salvar(produto);
			
			produtos = dao.listar();
						
			JSFUtil.adicionarMensagemSucesso("Dados salvos");
			
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
		
	public void excluir(){
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.excluir(produto);
			
			produtos = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Excluido");
			
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void alterar(){
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.alterar(produto);
			
			produtos = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Alterado");
			
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
}