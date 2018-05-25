package br.com.gvdi.DAO;

import java.sql.*;
import java.util.ArrayList;

import br.com.gvdi.conexao.ConexaoBd;
import br.com.gvdi.domain.Pessoa;

public class PessoaDAO {
	public void salvar(Pessoa p) throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("INSERT INTO pessoa ");
		sql.append("(nome,email,senha) ");
		sql.append("VALUES (?,?,?) ");

		Connection conexao = ConexaoBd.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, p.getNome());
		comando.setString(2, p.getEmail());
		comando.setString(3, p.getSenha());
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
		sql.append("SET nome = ? ");
		sql.append("WHERE id_pessoa = ? ");

		Connection conexao = ConexaoBd.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, p.getNome());
		comando.setLong(2, p.getId_pessoa());
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
	
	public static void main(String[] args) {
		/*
		  Pessoa p1 = new Pessoa(); 
		  p1.setNome("Elison");
		  p1.setEmail("elison.br@gmail.com"); 
		  p1.setSenha("naotemsenha"); 
		  PessoaDAO pdao = new PessoaDAO();
		 
		 try { pdao.salvar(p1); System.out.println("Salvo!"); } catch
		 (SQLException e) { System.out.println("Erro"); e.printStackTrace(); }
		 */

		/*
		  Pessoa p1 = new Pessoa(); 
		  	p1.setId_pessoa(4);
		  
		  PessoaDAO pdao = new PessoaDAO();
		  
		  try { pdao.excluir(p1); 
		  	System.out.println("Apagado!");
		  
		  } catch (SQLException e) { 
			System.out.println("Erro");
			e.printStackTrace(); }
		 
*/
		/*
		 Pessoa p1 = new Pessoa(); 
		 p1.setId_pessoa(1); 
		 p1.setNome("Elison Martins de Souza");
		  
		  PessoaDAO pdao = new PessoaDAO();
		  
		  try { pdao.editar(p1); 
		  System.out.println("Alterado!");
		  
		  } catch (SQLException e) { 
			  System.out.println("Erro");
		  e.printStackTrace(); }
		 */
		/*
		Pessoa p1 = new Pessoa();
		p1.setId_pessoa(1);

		Pessoa p2 = new Pessoa();
		p2.setId_pessoa(3);

		PessoaDAO pdao = new PessoaDAO();

		try {
			Pessoa p3 = pdao.buscaPorId(p1);
			Pessoa p4 = pdao.buscaPorId(p2);

			System.out.println("Resultado1: " + p3);
			System.out.println("Resultado2: " + p4);
		} catch (SQLException e) {
			System.out.println("Erro");
			e.printStackTrace();
		}
		*/
		
		/*PessoaDAO pdao = new PessoaDAO();

		try {
			ArrayList<Pessoa> lista = pdao.listar();
			
			for(Pessoa p : lista){
			System.out.println("resultado "+p);
			}
		} catch (SQLException e) {
			System.out.println("Erro");
			e.printStackTrace();
		}*/
		
		/*
		Pessoa p1 = new Pessoa();
		p1.setNome("Eli");
		
		PessoaDAO pdao = new PessoaDAO();
		
		try {
			ArrayList<Pessoa> lista = pdao.buscarPorNome(p1);
			
			for(Pessoa p : lista){
			System.out.println("resultado "+p);
			}
		} catch (SQLException e) {
			System.out.println("Erro");
			e.printStackTrace();
		}*/
	}
	
}
