package br.com.gvdi.DAO;

import java.sql.*;
import java.util.ArrayList;

import br.com.gvdi.conexao.ConexaoBd;
import br.com.gvdi.domain.Pessoa;
import br.com.gvdi.domain.Produto;

public class ProdutoDAO {
	public void salvar(Produto p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO produto ");
		sql.append("(desc_prod, quantidade, preco_custo, preco_venda) ");
		sql.append("VALUES (?,?,?,?) ");

		Connection conexao = ConexaoBd.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, p.getDesc_prod());
		comando.setString(2, p.getQuantidade());
		comando.setString(3, p.getPreco_custo());
		comando.setString(4, p.getPreco_venda());
		comando.execute();
	}
		
	public void excluir(Produto p) throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("DELETE FROM produto ");
		sql.append("WHERE id_prod = ? ");

		Connection conexao = ConexaoBd.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setLong(1, p.getId_prod());
		comando.execute();
	}
	
	public void alterar(Produto p) throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE produto ");
		sql.append("SET desc_prod = ? ,quantidade = ? ,preco_custo = ? ,preco_venda = ? ");
		sql.append("WHERE id_prod = ?");

		Connection conexao = ConexaoBd.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, p.getDesc_prod());
		comando.setString(2, p.getQuantidade());
		comando.setString(3, p.getPreco_custo());
		comando.setString(4, p.getPreco_venda());
		comando.setLong(5, p.getId_prod());
		comando.execute();
	}
	//fiz a parte
	public Produto buscaPorId(Produto p) throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT id_prod,desc_prod,quantidade, preco_custo,preco_venda ");
		sql.append("FROM produto ");
		sql.append("WHERE id_prod = ? ");

		Connection conexao = ConexaoBd.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setLong(1, p.getId_prod());

		ResultSet resultado = comando.executeQuery();
		Produto retorno = null;

		if (resultado.next()) {
			retorno = new Produto();
			retorno.setId_prod(resultado.getLong("id_prod"));
			retorno.setDesc_prod(resultado.getString("desc_prod"));
			retorno.setQuantidade(resultado.getString("quantidade"));
			retorno.setPreco_custo(resultado.getString("preco_custo"));
			retorno.setPreco_venda(resultado.getString("preco_venda"));
		}

		return retorno;
	}
	
	public ArrayList<Produto> buscarPorNome(Produto p) throws SQLException{
		
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT id_prod,desc_prod,quantidade,preco_custo,preco_venda ");
		sql.append("FROM produto ");
		sql.append("WHERE desc_prod LIKE ? ");
		sql.append("ORDER BY id_prod ASC ");

		Connection conexao = ConexaoBd.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, "%" + p.getDesc_prod() + "%");

		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Produto> lista = new ArrayList<Produto>();
		
		while(resultado.next()){
			Produto produto = new Produto();
			produto.setId_prod(resultado.getLong("id_prod"));
			produto.setDesc_prod(resultado.getString("desc_prod"));
			
			lista.add(produto);
		}
		return lista;
	}
	
	public ArrayList<Produto> listar() throws SQLException{

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT id_prod,desc_prod,preco_venda ");
		sql.append("FROM produto ");
		sql.append("ORDER BY id_prod ASC");

		Connection conexao = ConexaoBd.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Produto> lista = new ArrayList<Produto>();
		
		while(resultado.next()){
			Produto p = new Produto();
			p.setId_prod(resultado.getLong("id_prod"));
			p.setDesc_prod(resultado.getString("desc_prod"));
			p.setPreco_venda(resultado.getString("preco_venda"));
			
			lista.add(p);
		}
		return lista;
	}
}