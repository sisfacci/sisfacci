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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC 18
 */
@Entity
@Table(name = "asignatura_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignaturaAprendizaje.findAll", query = "SELECT a FROM AsignaturaAprendizaje a"),
    @NamedQuery(name = "AsignaturaAprendizaje.findById", query = "SELECT a FROM AsignaturaAprendizaje a WHERE a.id = :id"),
    @NamedQuery(name = "AsignaturaAprendizaje.findByContribucion", query = "SELECT a FROM AsignaturaAprendizaje a WHERE a.contribucion = :contribucion"),
    @NamedQuery(name = "AsignaturaAprendizaje.findByEvidenciaaprendizaje", query = "SELECT a FROM AsignaturaAprendizaje a WHERE a.evidenciaaprendizaje = :evidenciaaprendizaje")})
public class AsignaturaAprendizaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "contribucion")
    private String contribucion;
    @Column(name = "evidenciaaprendizaje")
    private String evidenciaaprendizaje;
    @JoinColumn(name = "id_unidad", referencedColumnName = "id")
    @ManyToOne
    private Unidad idUnidad;
    @JoinColumn(name = "id_silabo", referencedColumnName = "id")
    @ManyToOne
    private Silabo idSilabo;

    public AsignaturaAprendizaje() {
    }

    public AsignaturaAprendizaje(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContribucion() {
        return contribucion;
    }

    public void setContribucion(String contribucion) {
        this.contribucion = contribucion;
    }

    public String getEvidenciaaprendizaje() {
        return evidenciaaprendizaje;
    }

    public void setEvidenciaaprendizaje(String evidenciaaprendizaje) {
        this.evidenciaaprendizaje = evidenciaaprendizaje;
    }

    public Unidad getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Unidad idUnidad) {
        this.idUnidad = idUnidad;
    }

    public Silabo getIdSilabo() {
        return idSilabo;
    }

    public void setIdSilabo(Silabo idSilabo) {
        this.idSilabo = idSilabo;
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
        if (!(object instanceof AsignaturaAprendizaje)) {
            return false;
        }
        AsignaturaAprendizaje other = (AsignaturaAprendizaje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.facci.entity.AsignaturaAprendizaje[ id=" + id + " ]";
    }
    
}
