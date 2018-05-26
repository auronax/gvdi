package br.com.gvdi.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gvdi.DAO.PessoaDAO;
import br.com.gvdi.domain.Pessoa;
import br.com.gvdi.util.JSFUtil;

@ManagedBean(name = "MBPessoa")
@ViewScoped
public class PessoaBean {
	
	private Pessoa pessoa;
	private ArrayList<Pessoa>pessoas;
	private ArrayList<Pessoa>pessoasFiltradas;
	
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}
	
	public void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	public ArrayList<Pessoa> getPessoasFiltradas() {
		return pessoasFiltradas;
	}
	
	public void setPessoasFiltradas(ArrayList<Pessoa> pessoasFiltradas) {
		this.pessoasFiltradas = pessoasFiltradas;
	}

	@PostConstruct
	public void prepararPesquisa(){
				
		try {
			PessoaDAO pdao = new PessoaDAO();
			pessoas = pdao.listar();
			
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
		
	}
	
	public void prepararNovo(){
		pessoa = new Pessoa();
	}
	
	public void novo(){
		
		try {
			PessoaDAO pdao = new PessoaDAO();
			pdao.salvar(pessoa);
			
			pessoas = pdao.listar();
						
			JSFUtil.adicionarMensagemSucesso("Dados salvos");
			
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	

	
	public void excluir(){
		try {
			PessoaDAO pdao = new PessoaDAO();
			pdao.excluir(pessoa);
			
			pessoas = pdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Excluido");
			
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}


	
	public void alterar(){
		try {
			PessoaDAO pdao = new PessoaDAO();
			pdao.alterar(pessoa);
			
			pessoas = pdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Alterado");
			
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
}