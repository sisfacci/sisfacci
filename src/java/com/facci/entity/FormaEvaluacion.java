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
@Table(name = "forma_evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormaEvaluacion.findAll", query = "SELECT f FROM FormaEvaluacion f"),
    @NamedQuery(name = "FormaEvaluacion.findById", query = "SELECT f FROM FormaEvaluacion f WHERE f.id = :id"),
    @NamedQuery(name = "FormaEvaluacion.findByParcial", query = "SELECT f FROM FormaEvaluacion f WHERE f.parcial = :parcial"),
    @NamedQuery(name = "FormaEvaluacion.findByPorcentaje", query = "SELECT f FROM FormaEvaluacion f WHERE f.porcentaje = :porcentaje"),
    @NamedQuery(name = "FormaEvaluacion.findByObservacion", query = "SELECT f FROM FormaEvaluacion f WHERE f.observacion = :observacion")})
public class FormaEvaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "parcial")
    private Integer parcial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje")
    private Float porcentaje;
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "id_silabo", referencedColumnName = "id")
    @ManyToOne
    private Silabo idSilabo;
    @JoinColumn(name = "id_instrumento", referencedColumnName = "id")
    @ManyToOne
    private InstrumetoEvaluacion idInstrumento;

    public FormaEvaluacion() {
    }

    public FormaEvaluacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParcial() {
        return parcial;
    }

    public void setParcial(Integer parcial) {
        this.parcial = parcial;
    }

    public Float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Float porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Silabo getIdSilabo() {
        return idSilabo;
    }

    public void setIdSilabo(Silabo idSilabo) {
        this.idSilabo = idSilabo;
    }

    public InstrumetoEvaluacion getIdInstrumento() {
        return idInstrumento;
    }

    public void setIdInstrumento(InstrumetoEvaluacion idInstrumento) {
        this.idInstrumento = idInstrumento;
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
        if (!(object instanceof FormaEvaluacion)) {
            return false;
        }
        FormaEvaluacion other = (FormaEvaluacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.facci.entity.FormaEvaluacion[ id=" + id + " ]";
    }
    
}
