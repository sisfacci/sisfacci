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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC 18
 */
@Entity
@Table(name = "bibliografia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bibliografia.findAll", query = "SELECT b FROM Bibliografia b"),
    @NamedQuery(name = "Bibliografia.findById", query = "SELECT b FROM Bibliografia b WHERE b.id = :id"),
    @NamedQuery(name = "Bibliografia.findByDescripcion", query = "SELECT b FROM Bibliografia b WHERE b.descripcion = :descripcion"),
    @NamedQuery(name = "Bibliografia.findByIdTipo", query = "SELECT b FROM Bibliografia b WHERE b.idTipo = :idTipo"),
    @NamedQuery(name = "Bibliografia.findByIdSilabo", query = "SELECT b FROM Bibliografia b WHERE b.idSilabo = :idSilabo"),
    @NamedQuery(name = "Bibliografia.findByCodlibro", query = "SELECT b FROM Bibliografia b WHERE b.codlibro = :codlibro"),
    @NamedQuery(name = "Bibliografia.findByLink", query = "SELECT b FROM Bibliografia b WHERE b.link = :link")})
public class Bibliografia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "id_tipo")
    private Integer idTipo;
    @Column(name = "id_silabo")
    private Integer idSilabo;
    @Column(name = "codlibro")
    private String codlibro;
    @Column(name = "link")
    private String link;

    public Bibliografia() {
    }

    public Bibliografia(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public Integer getIdSilabo() {
        return idSilabo;
    }

    public void setIdSilabo(Integer idSilabo) {
        this.idSilabo = idSilabo;
    }

    public String getCodlibro() {
        return codlibro;
    }

    public void setCodlibro(String codlibro) {
        this.codlibro = codlibro;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
        if (!(object instanceof Bibliografia)) {
            return false;
        }
        Bibliografia other = (Bibliografia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.facci.entity.Bibliografia[ id=" + id + " ]";
    }
    
}
