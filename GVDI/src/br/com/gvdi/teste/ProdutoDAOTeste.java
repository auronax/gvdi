package br.com.gvdi.teste;

import java.sql.SQLException;

import org.junit.Test;
import br.com.gvdi.DAO.ProdutoDAO;
import br.com.gvdi.domain.Pessoa;
import br.com.gvdi.domain.Produto;


public class ProdutoDAOTeste {

	@Test
	public void salvar() throws SQLException{
	  Produto p1 = new Produto(); 
	  p1.setDesc_prod("Perfume Dynamique 100ml");
	  p1.setQuantidade("15"); 
	  p1.setPreco_custo("49.99");
	  p1.setPreco_venda("99.90");

	 /* Pessoa c = new Pessoa();
	  c.setId_pessoa(90);
	  p1.setPessoa(c);
	  */
	  
	  ProdutoDAO pdao = new ProdutoDAO();
	  pdao.salvar(p1);
	}
}
