/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facci.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HPENVY
 */
@Entity
@Table(name = "perfilrecurso")
@XmlRootElement
@NamedQueries({
    //@NamedQuery(name = "Perfilrecurso.findByIdPerfil", query = "SELECT p FROM Perfilrecurso p WHERE p.idperfil=:idperfil and p.activo =:activo"),
    @NamedQuery(name = "Perfilrecurso.findAll", query = "SELECT p FROM Perfilrecurso p"),
    @NamedQuery(name = "Perfilrecurso.findById", query = "SELECT p FROM Perfilrecurso p WHERE p.id = :id"),
    @NamedQuery(name = "Perfilrecurso.findByActivo", query = "SELECT p FROM Perfilrecurso p WHERE p.activo = :activo")})
public class Perfilrecurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "activo")
    private Boolean activo;
    @JoinColumn(name = "idperfil", referencedColumnName = "id")
    @ManyToOne
    private Perfil idperfil;
    @JoinColumn(name = "idrecurso", referencedColumnName = "id")
    @ManyToOne
    private Recurso idrecurso;
    @JoinColumn(name = "idrol", referencedColumnName = "id")
    @ManyToOne
    private Rol idrol;

    public Perfilrecurso() {
    }

    public Perfilrecurso(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Perfil getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Perfil idperfil) {
        this.idperfil = idperfil;
    }

    public Recurso getIdrecurso() {
        return idrecurso;
    }

    public void setIdrecurso(Recurso idrecurso) {
        this.idrecurso = idrecurso;
    }

    public Rol getIdrol() {
        return idrol;
    }

    public void setIdrol(Rol idrol) {
        this.idrol = idrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfilrecurso)) {
            return false;
        }
        Perfilrecurso other = (Perfilrecurso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.facci.entity.Perfilrecurso[ id=" + id + " ]";
    }
    
}
