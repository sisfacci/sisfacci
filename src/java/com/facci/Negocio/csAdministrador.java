/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facci.Negocio;

import com.facci.csUtilitarios.csUtilitarios;
import com.facci.entity.Grupo;
import com.facci.entity.Perfil;
import com.facci.entity.Perfilrecurso;
import com.facci.entity.Perfilusuario;
import com.facci.entity.Recurso;
import com.facci.entity.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author PC 18
 */
public class csAdministrador {
    protected final csBusiness bo = new csBusiness();
    public String nombreUsuario = "";
    public String friendlyName = "";
    public int idFacultad = 0;
    public boolean estaValidado = false;
    private Object glo_usuario = new Usuario();
    private List<Recurso> glo_listaRecursos;
    private List<Perfilrecurso> glo_listaPerfilRecursos;
    private List<Perfil> glo_listaPerfil;
    private List<Grupo> glo_listaGrupo;
    //private csConfiguracionEmpresa configuracionEmpresa = new csConfiguracionEmpresa();
    EntityManagerFactory emf;
    EntityManager em;
    
//////    private void throwException(String value) throws Exception
//////    {
//////        throw new Exception (value);
//////    }
//////    
    public csAdministrador() { }
    
    public csAdministrador(String par_nUssuario)
    {
        emf = Persistence.createEntityManagerFactory("SISFACCI2PU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        
        try {
            if (par_nUssuario == null) throw new RuntimeException("El nombre de usuario no esta definido correctamente");
            if (par_nUssuario.trim().equals("")) throw new RuntimeException("El nombre de usuario debe tener mas de 1 caracter");

            Object tmp_usuario = em.createNamedQuery("Usuario.findByAlias", Usuario.class).setParameter("alias", par_nUssuario).getSingleResult();
            if (tmp_usuario == null) throw new RuntimeException("El nombre de usuario no esta definido como un usuario del Aplicativo");
            else {
                if (tmp_usuario instanceof Usuario)
                {
                    this.glo_usuario = ((Usuario)tmp_usuario);
                    this.idFacultad = ((Usuario)tmp_usuario).getIdfacultad().getId();
                    this.nombreUsuario = par_nUssuario;
                    this.friendlyName = ((Usuario)tmp_usuario).getNombres();
                } 
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public csAdministrador(Usuario par_xObjUssuario)
    {
        if (par_xObjUssuario == null) throw new RuntimeException("El Objeto usuario no esta definido correctamente");

        Object tmp_usuario = em.createNamedQuery("Usuario.findByAlias", Usuario.class).setParameter("alias", this.nombreUsuario).getFirstResult();
        //var tmp_usuario = glo_fk.Usuario.Where(p => p.alias.Trim() == this.nombreUsuario).FirstOrDefault();
        
        if (tmp_usuario == null) throw new RuntimeException("El nombre de usuario {0} no esta definido como un usuario del Aplicativo");

        this.glo_usuario = (Usuario) tmp_usuario;
        this.nombreUsuario = par_xObjUssuario.getAlias();
        this.friendlyName = ((Usuario) glo_usuario).getNombres();
    }
    
    public void validarContrasena(String password) throws Exception
    {
        try
        {
            if (((Usuario) glo_usuario).getClave() == null) throw new RuntimeException("El usuario no tinene contraseña establecida");
            if (((Usuario) glo_usuario).getClave().trim().equals("")) throw new RuntimeException("El usuario no tinene contrase;a establecida");

            if (!csUtilitarios.verifyMd5Hash(password, ((Usuario) glo_usuario).getClave())) throw new RuntimeException("No puede iniciar sesion. La Contraseña no es válida.");

            this.obtenerPermisos();
            estaValidado = true;
        }
        catch (Exception ex)
        {
//            csUtilitarios.notificarError("Inicio de Sesion", ex.Message + "\n\r" + ex.StackTrace, "Inicio de sesión ", false, true, true);
            estaValidado = false;
            throw ex;
        }
    }
    
    private void obtenerPermisos()
    {
        try
        {
            //this.cnofiguracionEmpresa = new csConfiguracionEmpresa(this.rucEmpresa);
            //this.configuracoin = this.cnofiguracionEmpresa.obtenerInfoEmpresa();
            glo_listaPerfil = new ArrayList<Perfil>();
            glo_listaPerfilRecursos = new ArrayList<Perfilrecurso>();
            glo_listaRecursos = new ArrayList<Recurso>();
            glo_listaGrupo = new ArrayList<Grupo>();
            
            if (((Usuario) glo_usuario).getIdrol().getId() == null) throw new RuntimeException("El usuario no tiene asignado un Rol Principal.");
            if (((Usuario) glo_usuario).getPerfilusuarioCollection().size() == 0) throw new RuntimeException("El usuario no tiene asignado un Perfil. Por favor, solicitar al Administrador del Sitio agregar uno o mas perfiles.");

            for (Perfilusuario item : ((Usuario) glo_usuario).getPerfilusuarioCollection()) 
            {
                if (item.getActivo())
                {
                    // Corregir x si acaso
                    if (!glo_listaPerfil.contains(item.getIdperfil())) glo_listaPerfil.add(item.getIdperfil());
                }
            }
            
            //obtener los permisos del usuario. 
            for (Perfil itemPerfil : glo_listaPerfil) 
            {
                if (itemPerfil.getActivo())
                {
                    //glo_listaPerfilRecursos.AddRange(glo_fk.PerfilRecurso.Where(p => p.idPerfil == item.id && p.estado == 1));
                    // Corregir x si acaso
                    List<Perfilrecurso> tmp_pr = em.createNamedQuery("Perfilrecurso.findAll", Perfilrecurso.class).getResultList();
                    for (Perfilrecurso tmp_perfilRecurso : tmp_pr) 
                    {
                        if(tmp_perfilRecurso.getIdperfil().getId() == itemPerfil.getId() && tmp_perfilRecurso.getActivo() == true)
                        {
                            glo_listaPerfilRecursos.add(tmp_perfilRecurso);
                        }
                    }                    
                }
            }

            glo_listaRecursos.clear();
            for (Perfilrecurso item : glo_listaPerfilRecursos) 
            {
                if (item.getActivo())
                {
                    boolean existeRecurso = glo_listaRecursos
                                            .stream()
                                            .filter(x -> x.getId() == item.getIdrecurso().getId()).count() > 0;
                    boolean existeGrupo = glo_listaGrupo
                                            .stream()
                                            .filter(y -> y.getId() == item.getIdrecurso().getIdgrupo().getId()).count() > 0;
                           
//                    boolean existeRecurso = (em.createNamedQuery("Recurso.findById", Recurso.class)
//                                        .setParameter("id", item.getIdrecurso().getId()).getResultList().size() > 0);
//                    boolean existeGrupo = (em.createNamedQuery("Grupo.findById", Grupo.class)
//                                        .setParameter("id", item.getIdrecurso().getIdgrupo().getId()).getResultList().size() > 0);
//                    
                    if ((boolean) item.getIdrecurso().getActivo() && !existeRecurso)
                        glo_listaRecursos.add(item.getIdrecurso());
                    if (!glo_listaGrupo.contains(item.getIdrecurso().getIdgrupo()) && item.getIdrecurso().getIdgrupo() != null && !existeGrupo)
                        glo_listaGrupo.add(item.getIdrecurso().getIdgrupo());
                }
            }
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }    
    
    public List<Recurso> obtenerListaRecursos()
    {
        return glo_listaRecursos;
    }

    public List<Perfilrecurso> obtenerListaPerfilRecurso()
    {
        return glo_listaPerfilRecursos;
    }

    public List<Perfil> obtenerListaPerfil()
    {
        return glo_listaPerfil;
    }

    public Usuario obtenerUsuario()
    {
        return ((Usuario) glo_usuario);
    }

    public int obtenerIdUsuario()
    {
        return ((Usuario) glo_usuario).getId();
    }

    public String obtenerAlias()
    {
        return ((Usuario) glo_usuario).getAlias();
    }

    public List<Menu> obtenerMenu()
    {
        List<Menu> menu = new ArrayList<Menu>();
        for (Grupo  item : this.glo_listaGrupo) 
        {
            Menu tmp_menu = new Menu();
            tmp_menu.Cabecera = item.getNombre();
            tmp_menu.Enlaces = new ArrayList<ItemMenu>();
            
            for (Recurso tmp_recurso : glo_listaRecursos) 
            {
                if (tmp_recurso.getIdgrupo().getId() == item.getId())
                {
                    ItemMenu tmp_itemMenu = new ItemMenu();
                    tmp_itemMenu.setEnlace(tmp_recurso.getUrl());
                    tmp_itemMenu.setIcono("");
                    tmp_itemMenu.setNombre(tmp_recurso.getNombre());
                    tmp_menu.Enlaces.add(tmp_itemMenu);
                }
            }
            if (glo_listaRecursos.stream().filter(p -> p.getIdgrupo().getId() == item.getId()).count() > 0)
                {
                    menu.add(tmp_menu);
                }
                      
        }        
        return menu;
    }

    public boolean tienePermisoPorRuta(String par_ruta)
    {
        for (Recurso item : glo_listaRecursos) 
        {
            if (item.getUrl().toLowerCase().equals(par_ruta.toLowerCase()) )
            {
                return true;
            }
        }
        return false;
    }
     
}