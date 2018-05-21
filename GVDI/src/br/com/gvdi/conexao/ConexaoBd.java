package br.com.gvdi.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBd {
	private static final String USUARIO = "root";
	private static final String SENHA = "123456";
	private static final String URL = "jdbc:mysql://localhost:3306/gvdi";
	
	public static Connection conectar() throws SQLException {
		
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}
	
	public static void main(String[] args) {
		try{
		Connection conexao =  ConexaoBd.conectar();
		System.out.println("Conectado com sucesso!!");
		}
		
		catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("Conexão Falhou!!");
		}
		
		}
	
}
