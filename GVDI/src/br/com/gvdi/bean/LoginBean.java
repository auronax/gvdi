package br.com.gvdi.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "MBLogin")
public class LoginBean {
    
    private String email;
    private String senha;
 
    public String getEmail() {
		return email;
	}
    public void setEmail(String email) {
		this.email = email;
	}
    public String getSenha() {
		return senha;
	}
    public void setSenha(String senha) {
		this.senha = senha;
	}
    
    public void save() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Welcome " + email + " " + senha));
    }
}
