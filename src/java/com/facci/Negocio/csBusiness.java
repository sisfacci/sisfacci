/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facci.Negocio;

import com.facci.entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author HPENVY
 */
public class csBusiness {
    EntityManagerFactory emf;
    EntityManager em;

    public csBusiness() {
        emf = Persistence.createEntityManagerFactory("SISFACCI2PU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    public boolean loginControl(String alias, String clave){
        try {
            List<Usuario> listUser = em.createNamedQuery("Usuario.findByAlias", Usuario.class).setParameter("alias", alias).getResultList();
            
            if (listUser != null){
                for (Usuario listUser1 : listUser) {
                    if (listUser1.getClave().equals(clave))
                    {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }
}
