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
@Table(name = "silabo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Silabo.findAll", query = "SELECT s FROM Silabo s"),
    @NamedQuery(name = "Silabo.findById", query = "SELECT s FROM Silabo s WHERE s.id = :id"),
    @NamedQuery(name = "Silabo.findByPeriodo", query = "SELECT s FROM Silabo s WHERE s.periodo = :periodo"),
    @NamedQuery(name = "Silabo.findByUnicurricular", query = "SELECT s FROM Silabo s WHERE s.unicurricular = :unicurricular"),
    @NamedQuery(name = "Silabo.findByModalidad", query = "SELECT s FROM Silabo s WHERE s.modalidad = :modalidad"),
    @NamedQuery(name = "Silabo.findByDescripcion", query = "SELECT s FROM Silabo s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "Silabo.findByObespecifico", query = "SELECT s FROM Silabo s WHERE s.obespecifico = :obespecifico"),
    @NamedQuery(name = "Silabo.findByResulaprendizaje", query = "SELECT s FROM Silabo s WHERE s.resulaprendizaje = :resulaprendizaje"),
    @NamedQuery(name = "Silabo.findByCompespecificas", query = "SELECT s FROM Silabo s WHERE s.compespecificas = :compespecificas")})
public class Silabo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "periodo")
    private String periodo;
    @Column(name = "unicurricular")
    private String unicurricular;
    @Column(name = "modalidad")
    private String modalidad;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "obespecifico")
    private String obespecifico;
    @Column(name = "resulaprendizaje")
    private String resulaprendizaje;
    @Column(name = "compespecificas")
    private String compespecificas;
    @OneToMany(mappedBy = "idSilabo")
    private Collection<SilaboCompetencias> silaboCompetenciasCollection;
    @OneToMany(mappedBy = "idSilabo")
    private Collection<SilaboDocentes> silaboDocentesCollection;
    @OneToMany(mappedBy = "idSilabo")
    private Collection<AsignaturaAprendizaje> asignaturaAprendizajeCollection;
    @OneToMany(mappedBy = "idSilabo")
    private Collection<Unidad> unidadCollection;
    @JoinColumn(name = "id_facultad", referencedColumnName = "id")
    @ManyToOne
    private Facultad idFacultad;
    @JoinColumn(name = "id_asignatura", referencedColumnName = "id")
    @ManyToOne
    private Asignatura idAsignatura;
    @OneToMany(mappedBy = "idSilabo")
    private Collection<Contenidos> contenidosCollection;
    @OneToMany(mappedBy = "idSilabo")
    private Collection<FormaEvaluacion> formaEvaluacionCollection;

    public Silabo() {
    }

    public Silabo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getUnicurricular() {
        return unicurricular;
    }

    public void setUnicurricular(String unicurricular) {
        this.unicurricular = unicurricular;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObespecifico() {
        return obespecifico;
    }

    public void setObespecifico(String obespecifico) {
        this.obespecifico = obespecifico;
    }

    public String getResulaprendizaje() {
        return resulaprendizaje;
    }

    public void setResulaprendizaje(String resulaprendizaje) {
        this.resulaprendizaje = resulaprendizaje;
    }

    public String getCompespecificas() {
        return compespecificas;
    }

    public void setCompespecificas(String compespecificas) {
        this.compespecificas = compespecificas;
    }

    @XmlTransient
    public Collection<SilaboCompetencias> getSilaboCompetenciasCollection() {
        return silaboCompetenciasCollection;
    }

    public void setSilaboCompetenciasCollection(Collection<SilaboCompetencias> silaboCompetenciasCollection) {
        this.silaboCompetenciasCollection = silaboCompetenciasCollection;
    }

    @XmlTransient
    public Collection<SilaboDocentes> getSilaboDocentesCollection() {
        return silaboDocentesCollection;
    }

    public void setSilaboDocentesCollection(Collection<SilaboDocentes> silaboDocentesCollection) {
        this.silaboDocentesCollection = silaboDocentesCollection;
    }

    @XmlTransient
    public Collection<AsignaturaAprendizaje> getAsignaturaAprendizajeCollection() {
        return asignaturaAprendizajeCollection;
    }

    public void setAsignaturaAprendizajeCollection(Collection<AsignaturaAprendizaje> asignaturaAprendizajeCollection) {
        this.asignaturaAprendizajeCollection = asignaturaAprendizajeCollection;
    }

    @XmlTransient
    public Collection<Unidad> getUnidadCollection() {
        return unidadCollection;
    }

    public void setUnidadCollection(Collection<Unidad> unidadCollection) {
        this.unidadCollection = unidadCollection;
    }

    public Facultad getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Facultad idFacultad) {
        this.idFacultad = idFacultad;
    }

    public Asignatura getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Asignatura idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    @XmlTransient
    public Collection<Contenidos> getContenidosCollection() {
        return contenidosCollection;
    }

    public void setContenidosCollection(Collection<Contenidos> contenidosCollection) {
        this.contenidosCollection = contenidosCollection;
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
        if (!(object instanceof Silabo)) {
            return false;
        }
        Silabo other = (Silabo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.facci.entity.Silabo[ id=" + id + " ]";
    }
    
}
