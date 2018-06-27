package br.com.gvdi.bean;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.gvdi.conexao.ConexaoBd;

@ManagedBean(name = "MBLogin")
@RequestScoped
public class LoginBean {
    private String username;
	private String password;
	
	public String getUsername() {
	return username;
	}
	 
	public void setUsername(String username) {
	this.username = username;
	}
	 
	public String getPassword() {
	return password;
	}
	 
	public void setPassword(String password) {
	this.password = password;
	}

	
	public void login() throws SQLException {
		Connection conexao = ConexaoBd.conectar();
		String sql = "SELECT login, senha FROM usuario WHERE login = ? AND senha = ? ";
				
		PreparedStatement conectar = conexao.prepareStatement(sql);
		
		conectar.setString(1, username);
		conectar.setString(2, password);
		
		ResultSet rs = conectar.executeQuery();
		FacesContext context = FacesContext.getCurrentInstance();
	
		if(rs.next()){
	             context.getExternalContext().getSessionMap().put("user", username);
	             try {
	 context.getExternalContext().redirect("inicial.xhtml");
	 } catch (IOException e) {
	 e.printStackTrace();
	 }
	         }
	         else  {
	                    //Send an error message on Login Failure 
	             context.addMessage(null, new FacesMessage("Dados incorretos. Verifique seu usuário e senha."));
	 
	         } 
	     }
	 
	     public void logout() {
	     	FacesContext context = FacesContext.getCurrentInstance();
	     	context.getExternalContext().invalidateSession();
	         try {
	 context.getExternalContext().redirect("Login.xhtml");
	 } catch (IOException e) {
	 e.printStackTrace();
	 }
	     }
 
}
