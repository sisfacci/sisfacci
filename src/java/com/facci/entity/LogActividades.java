/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facci.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HPENVY
 */
@Entity
@Table(name = "log_actividades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogActividades.findAll", query = "SELECT l FROM LogActividades l"),
    @NamedQuery(name = "LogActividades.findById", query = "SELECT l FROM LogActividades l WHERE l.id = :id"),
    @NamedQuery(name = "LogActividades.findByMetodo", query = "SELECT l FROM LogActividades l WHERE l.metodo = :metodo"),
    @NamedQuery(name = "LogActividades.findByAccion", query = "SELECT l FROM LogActividades l WHERE l.accion = :accion"),
    @NamedQuery(name = "LogActividades.findByFecha", query = "SELECT l FROM LogActividades l WHERE l.fecha = :fecha"),
    @NamedQuery(name = "LogActividades.findByVisible", query = "SELECT l FROM LogActividades l WHERE l.visible = :visible")})
public class LogActividades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "metodo")
    private String metodo;
    @Column(name = "accion")
    private String accion;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "visible")
    private Boolean visible;

    public LogActividades() {
    }

    public LogActividades(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
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
        if (!(object instanceof LogActividades)) {
            return false;
        }
        LogActividades other = (LogActividades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.facci.entity.LogActividades[ id=" + id + " ]";
    }
    
}
