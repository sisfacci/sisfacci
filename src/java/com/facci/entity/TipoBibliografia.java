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
@Table(name = "tipo_bibliografia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoBibliografia.findAll", query = "SELECT t FROM TipoBibliografia t"),
    @NamedQuery(name = "TipoBibliografia.findById", query = "SELECT t FROM TipoBibliografia t WHERE t.id = :id"),
    @NamedQuery(name = "TipoBibliografia.findByDescripcion", query = "SELECT t FROM TipoBibliografia t WHERE t.descripcion = :descripcion")})
public class TipoBibliografia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descripcion")
    private String descripcion;

    public TipoBibliografia() {
    }

    public TipoBibliografia(Integer id) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoBibliografia)) {
            return false;
        }
        TipoBibliografia other = (TipoBibliografia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.facci.entity.TipoBibliografia[ id=" + id + " ]";
    }
    
}
