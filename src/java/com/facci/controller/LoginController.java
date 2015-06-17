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
public class LoginController implements Serializable
{
    private int idUsuario;
    private String username;
    private String password;
    private String nombre;
    private String identificacion;
    private String password2;
    private String direccion;
    private String telefono;
    private String email;
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
            info(loc_administradorSesion);
            session.setAttribute("menu", loc_administradorSesion.obtenerMenu());
            session.setAttribute("AdministradorSesion", loc_administradorSesion);
            return "/SiteMaster.jsp?faces-redirect=true";
        } 
        catch (Exception ex) 
        {
            RequestContext.getCurrentInstance().update("notify");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario/Password incorrectos...!!!" ));
            return "";
        }        
    }
    
    private void info(csAdministrador loc_administradorSesion)
    {
        this.idUsuario = loc_administradorSesion.obtenerIdUsuario();
        this.nombre = loc_administradorSesion.obtenerUsuario().getNombres();
        this.identificacion = loc_administradorSesion.obtenerUsuario().getIdentificacion();
        this. direccion = loc_administradorSesion.obtenerUsuario().getDireccion();
        this.telefono = loc_administradorSesion.obtenerUsuario().getTelefono();
        this.email = loc_administradorSesion.obtenerUsuario().getCorreo();
    }
    
    public boolean manageControl()
    {
        try 
        {
            int tmp_idUser = this.idUsuario;
            String tmp_nombreUsuario = this.username;
            String tmp_nombre = this.nombre;
            String tmp_identificacion = this.identificacion;
            String tmp_Contrasena = this.password;
            String tmp_Contrasena2 = this.password2;
            String tmp_direccion = this.direccion;
            String tmp_telefono = this.telefono;
            String tmp_email = this.email;
            
            if (tmp_Contrasena.equals(tmp_Contrasena2))
            {
                return true;
            }
            return false;
        } 
        catch (Exception ex) 
        {            
            RequestContext.getCurrentInstance().update("notify");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario/Password incorrectos...!!!" ));
            return false;
        }        
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

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * @param identificacion the identificacion to set
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * @return the password2
     */
    public String getPassword2() {
        return password2;
    }

    /**
     * @param password2 the password2 to set
     */
    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
