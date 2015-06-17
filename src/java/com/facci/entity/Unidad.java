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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "unidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidad.findAll", query = "SELECT u FROM Unidad u"),
    @NamedQuery(name = "Unidad.findById", query = "SELECT u FROM Unidad u WHERE u.id = :id"),
    @NamedQuery(name = "Unidad.findByNombre", query = "SELECT u FROM Unidad u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Unidad.findByResulaprendizaje", query = "SELECT u FROM Unidad u WHERE u.resulaprendizaje = :resulaprendizaje"),
    @NamedQuery(name = "Unidad.findByMetodologia", query = "SELECT u FROM Unidad u WHERE u.metodologia = :metodologia"),
    @NamedQuery(name = "Unidad.findByRecurdidactico", query = "SELECT u FROM Unidad u WHERE u.recurdidactico = :recurdidactico")})
public class Unidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "resulaprendizaje")
    private String resulaprendizaje;
    @Column(name = "metodologia")
    private String metodologia;
    @Column(name = "recurdidactico")
    private String recurdidactico;
    @OneToMany(mappedBy = "idUnidad")
    private Collection<AsignaturaAprendizaje> asignaturaAprendizajeCollection;
    @JoinColumn(name = "id_silabo", referencedColumnName = "id")
    @ManyToOne
    private Silabo idSilabo;
    @OneToMany(mappedBy = "idUnidad")
    private Collection<Contenidos> contenidosCollection;

    public Unidad() {
    }

    public Unidad(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResulaprendizaje() {
        return resulaprendizaje;
    }

    public void setResulaprendizaje(String resulaprendizaje) {
        this.resulaprendizaje = resulaprendizaje;
    }

    public String getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    public String getRecurdidactico() {
        return recurdidactico;
    }

    public void setRecurdidactico(String recurdidactico) {
        this.recurdidactico = recurdidactico;
    }

    @XmlTransient
    public Collection<AsignaturaAprendizaje> getAsignaturaAprendizajeCollection() {
        return asignaturaAprendizajeCollection;
    }

    public void setAsignaturaAprendizajeCollection(Collection<AsignaturaAprendizaje> asignaturaAprendizajeCollection) {
        this.asignaturaAprendizajeCollection = asignaturaAprendizajeCollection;
    }

    public Silabo getIdSilabo() {
        return idSilabo;
    }

    public void setIdSilabo(Silabo idSilabo) {
        this.idSilabo = idSilabo;
    }

    @XmlTransient
    public Collection<Contenidos> getContenidosCollection() {
        return contenidosCollection;
    }

    public void setContenidosCollection(Collection<Contenidos> contenidosCollection) {
        this.contenidosCollection = contenidosCollection;
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
        if (!(object instanceof Unidad)) {
            return false;
        }
        Unidad other = (Unidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.facci.entity.Unidad[ id=" + id + " ]";
    }
    
}
