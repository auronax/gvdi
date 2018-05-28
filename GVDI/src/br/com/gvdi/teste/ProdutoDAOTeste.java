package br.com.gvdi.teste;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;
import br.com.gvdi.DAO.ProdutoDAO;
//import br.com.gvdi.domain.Pessoa;
import br.com.gvdi.domain.Produto;


public class ProdutoDAOTeste {

	@Test
	@Ignore
	public void salvar() throws SQLException{
	  Produto p1 = new Produto(); 
	  p1.setDesc_prod("Perfume Vraie 100ml");
	  p1.setQuantidade("20"); 
	  p1.setPreco_custo("49.99");
	  p1.setPreco_venda("99.90");
	  
	  //foreign key para fornecedor ou pedido
	 /* Pessoa c = new Pessoa();
	  c.setId_pessoa(90);
	  p1.setPessoa(c);
	  */
	  
	  ProdutoDAO pdao = new ProdutoDAO();
	  pdao.salvar(p1);
	}
	
	@Test
	@Ignore
	public void listar() throws SQLException{
		ProdutoDAO pdao = new ProdutoDAO();
		ArrayList<Produto> lista = pdao.listar();
		
		for(Produto p : lista){
			System.out.println("Código: " + p.getId_prod());
			System.out.println("Descrição: " + p.getDesc_prod());
			System.out.println("Quantidade: " + p.getQuantidade());
			System.out.println("Preço de venda: R$" + p.getPreco_venda());
			System.out.println(" ");
			
		}
		
		
	}
	
	@Test
	@Ignore
	public void excluir() throws SQLException{
		Produto p = new Produto();
		p.setId_prod(1L);
		
		ProdutoDAO pdao = new ProdutoDAO();
		pdao.excluir(p);
	
	}
	
	@Test
	//@Ignore
	public void alterar() throws SQLException{
		Produto p = new Produto();
		p.setId_prod(3L);
		p.setDesc_prod("Creme hidratante Adlux 100ml");
		p.setQuantidade("10");
		p.setPreco_custo("24.99");
		p.setPreco_venda("49.90");
		
		ProdutoDAO pdao = new ProdutoDAO();
		pdao.alterar(p);
		
	}
	
}
