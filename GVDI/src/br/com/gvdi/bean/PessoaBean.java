package br.com.gvdi.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.gvdi.DAO.PessoaDAO;
import br.com.gvdi.domain.Pessoa;
import br.com.gvdi.util.JSFUtil;

@ManagedBean(name = "MBPessoa")
@ViewScoped
public class PessoaBean {
	private Pessoa pessoa;
			
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	
	
	private ListDataModel<Pessoa> pessoas;
	
	public ListDataModel<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(ListDataModel<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	@PostConstruct
	public void prepararPesquisa(){
		
		
		try {
			PessoaDAO pdao = new PessoaDAO();
			ArrayList<Pessoa>lista = pdao.listar();
			pessoas = new ListDataModel<Pessoa>(lista);
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
			
			ArrayList<Pessoa>lista = pdao.listar();
			pessoas = new ListDataModel<Pessoa>(lista);
			
			JSFUtil.adicionarMensagemSucesso("Dados salvos");
			
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void prepararExcluir(){
		pessoa = pessoas.getRowData();
	}
	
	public void excluir(){
		try {
			PessoaDAO pdao = new PessoaDAO();
			pdao.excluir(pessoa);
			
			ArrayList<Pessoa>lista = pdao.listar();
			pessoas = new ListDataModel<Pessoa>(lista);
			
			JSFUtil.adicionarMensagemSucesso("Excluido");
			
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}

	public void prepararAlterar(){
		pessoa = pessoas.getRowData();
	}	
	
	public void alterar(){
		try {
			PessoaDAO pdao = new PessoaDAO();
			pdao.alterar(pessoa);
			
			ArrayList<Pessoa>lista = pdao.listar();
			pessoas = new ListDataModel<Pessoa>(lista);
			
			JSFUtil.adicionarMensagemSucesso("Alterado");
			
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
}