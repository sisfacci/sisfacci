/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facci.controller;

import com.facci.Negocio.csAdministrador;
import com.facci.Negocio.csBusiness;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author HPENVY
 */

@javax.faces.bean.ManagedBean(name = "login")
@SessionScoped
public class LoginController implements Serializable{
    private final csBusiness bo = new csBusiness();    
    
    private String username;
    private String password;
    private String mensaje;
    private Boolean status;
            
    public String loginControl(){
        try 
        {
            String tmp_nombreUsuario = this.username;
            String tmp_Contrasena = this.password;

            csAdministrador loc_administradorSesion = new csAdministrador(tmp_nombreUsuario);
            loc_administradorSesion.validarContrasena(tmp_Contrasena);
            //HttpSession session = null;
            //session = request.getSession(true);      
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            
            session.setAttribute("idUsuario", loc_administradorSesion.obtenerIdUsuario());        
            session.setAttribute("aliasUsuario", loc_administradorSesion.obtenerAlias());
            session.setAttribute("usuarioObjX",loc_administradorSesion.obtenerUsuario());
            session.setAttribute("menu", loc_administradorSesion.obtenerMenu());
            session.setAttribute("AdministradorSesion", loc_administradorSesion);
            return "/home.xhtml?faces-redirect=true";
        } 
        catch (Exception ex) 
        {
            RequestContext.getCurrentInstance().update("notify");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario/Password incorrectos...!!!" ));
            return "";
        }
        
//        if (bo.loginControl(username, password))
//        {
//            return "/home.xhtml?faces-redirect=true";
//        }
        
    }
    
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the status
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    
}
