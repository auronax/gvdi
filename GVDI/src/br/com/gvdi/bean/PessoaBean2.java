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
public class PessoaBean2 {
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
			ProdutoDAO pdao = new ProdutoDAO();
			produtos = pdao.listar();
			
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
			ProdutoDAO pdao = new ProdutoDAO();
			pdao.salvar(produto);
			
			produtos = pdao.listar();
						
			JSFUtil.adicionarMensagemSucesso("Dados salvos");
			
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
		
	public void excluir(){
		try {
			ProdutoDAO pdao = new ProdutoDAO();
			pdao.excluir(produto);
			
			produtos = pdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Excluido");
			
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void alterar(){
		try {
			ProdutoDAO pdao = new ProdutoDAO();
			pdao.alterar(produto);
			
			produtos = pdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Alterado");
			
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
}