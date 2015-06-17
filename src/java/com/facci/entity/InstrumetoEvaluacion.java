/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facci.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC 18
 */
@Entity
@Table(name = "instrumeto_evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstrumetoEvaluacion.findAll", query = "SELECT i FROM InstrumetoEvaluacion i"),
    @NamedQuery(name = "InstrumetoEvaluacion.findById", query = "SELECT i FROM InstrumetoEvaluacion i WHERE i.id = :id"),
    @NamedQuery(name = "InstrumetoEvaluacion.findByDescripcion", query = "SELECT i FROM InstrumetoEvaluacion i WHERE i.descripcion = :descripcion")})
public class InstrumetoEvaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idInstrumento")
    private Collection<FormaEvaluacion> formaEvaluacionCollection;

    public InstrumetoEvaluacion() {
    }

    public InstrumetoEvaluacion(Integer id) {
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

    @XmlTransient
    public Collection<FormaEvaluacion> getFormaEvaluacionCollection() {
        return formaEvaluacionCollection;
    }

    public void setFormaEvaluacionCollection(Collection<FormaEvaluacion> formaEvaluacionCollection) {
        this.formaEvaluacionCollection = formaEvaluacionCollection;
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
        if (!(object instanceof InstrumetoEvaluacion)) {
            return false;
        }
        InstrumetoEvaluacion other = (InstrumetoEvaluacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.facci.entity.InstrumetoEvaluacion[ id=" + id + " ]";
    }
    
}
