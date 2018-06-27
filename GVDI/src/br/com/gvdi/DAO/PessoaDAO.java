package br.com.gvdi.DAO;

import java.sql.*;
import java.util.ArrayList;

import br.com.gvdi.conexao.ConexaoBd;
import br.com.gvdi.domain.Pessoa;

public class PessoaDAO {
	public void salvar(Pessoa pessoa) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO pessoa ");
		sql.append("(nome,email,senha) ");
		sql.append("VALUES (?,?,?) ");

		Connection conexao = ConexaoBd.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, pessoa.getNome());
		comando.setString(2, pessoa.getEmail());
		comando.setString(3, pessoa.getSenha());
		comando.execute();
	}

	public void excluir(Pessoa p) throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("DELETE FROM pessoa ");
		sql.append("WHERE id_pessoa = ? ");

		Connection conexao = ConexaoBd.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setLong(1, p.getId_pessoa());
		comando.execute();
	}

	public void alterar(Pessoa p) throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE pessoa ");
		sql.append("SET nome = ? , email = ? ");
		sql.append("WHERE id_pessoa = ? ");

		Connection conexao = ConexaoBd.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, p.getNome());
		comando.setString(2, p.getEmail());
		comando.setLong(3, p.getId_pessoa());
		
		comando.execute();
	}

	public Pessoa buscaPorId(Pessoa p) throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT id_pessoa,nome,email,senha ");
		sql.append("FROM pessoa ");
		sql.append("WHERE id_pessoa = ? ");

		Connection conexao = ConexaoBd.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setLong(1, p.getId_pessoa());

		ResultSet resultado = comando.executeQuery();
		Pessoa retorno = null;

		if (resultado.next()) {
			retorno = new Pessoa();
			retorno.setId_pessoa(resultado.getLong("id_pessoa"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setEmail(resultado.getString("email"));
			retorno.setSenha(resultado.getString("senha"));
		}

		return retorno;
	}

	public ArrayList<Pessoa> buscarPorNome(Pessoa p) throws SQLException{
		
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT id_pessoa,nome,email,senha ");
		sql.append("FROM pessoa ");
		sql.append("WHERE nome LIKE ? ");
		sql.append("ORDER BY nome ASC ");

		Connection conexao = ConexaoBd.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, "%" + p.getNome() + "%");

		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
		
		while(resultado.next()){
			Pessoa pessoa = new Pessoa();
			pessoa.setId_pessoa(resultado.getLong("id_pessoa"));
			pessoa.setNome(resultado.getString("nome"));
			
			lista.add(pessoa);
		}
		return lista;
	}
	
	public ArrayList<Pessoa> listar() throws SQLException{

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT id_pessoa,nome,email,senha ");
		sql.append("FROM pessoa ");
		sql.append("ORDER BY id_pessoa ASC");

		Connection conexao = ConexaoBd.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
		
		while(resultado.next()){
			Pessoa p = new Pessoa();
			p.setId_pessoa(resultado.getLong("id_pessoa"));
			p.setNome(resultado.getString("nome"));
			p.setEmail(resultado.getString("email"));
			p.setSenha(resultado.getString("senha"));
			
			lista.add(p);
		}
		return lista;
	}
}
