package br.com.gvdi.DAO;

import java.sql.*;
import br.com.gvdi.conexao.ConexaoBd;
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
	
}