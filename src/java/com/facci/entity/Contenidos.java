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
@Table(name = "contenidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contenidos.findAll", query = "SELECT c FROM Contenidos c"),
    @NamedQuery(name = "Contenidos.findById", query = "SELECT c FROM Contenidos c WHERE c.id = :id"),
    @NamedQuery(name = "Contenidos.findByDescripcion", query = "SELECT c FROM Contenidos c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Contenidos.findByHorasteoricas", query = "SELECT c FROM Contenidos c WHERE c.horasteoricas = :horasteoricas"),
    @NamedQuery(name = "Contenidos.findByHoraspracticas", query = "SELECT c FROM Contenidos c WHERE c.horaspracticas = :horaspracticas"),
    @NamedQuery(name = "Contenidos.findByHorastutorias", query = "SELECT c FROM Contenidos c WHERE c.horastutorias = :horastutorias"),
    @NamedQuery(name = "Contenidos.findByHorasautonomas", query = "SELECT c FROM Contenidos c WHERE c.horasautonomas = :horasautonomas"),
    @NamedQuery(name = "Contenidos.findByActividadautonoma", query = "SELECT c FROM Contenidos c WHERE c.actividadautonoma = :actividadautonoma"),
    @NamedQuery(name = "Contenidos.findByMecanismoevaluacion", query = "SELECT c FROM Contenidos c WHERE c.mecanismoevaluacion = :mecanismoevaluacion"),
    @NamedQuery(name = "Contenidos.findByActividadclase", query = "SELECT c FROM Contenidos c WHERE c.actividadclase = :actividadclase"),
    @NamedQuery(name = "Contenidos.findByOrden", query = "SELECT c FROM Contenidos c WHERE c.orden = :orden")})
public class Contenidos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "horasteoricas")
    private Integer horasteoricas;
    @Column(name = "horaspracticas")
    private Integer horaspracticas;
    @Column(name = "horastutorias")
    private Integer horastutorias;
    @Column(name = "horasautonomas")
    private Integer horasautonomas;
    @Column(name = "actividadautonoma")
    private String actividadautonoma;
    @Column(name = "mecanismoevaluacion")
    private String mecanismoevaluacion;
    @Column(name = "actividadclase")
    private String actividadclase;
    @Column(name = "orden")
    private Integer orden;
    @JoinColumn(name = "id_unidad", referencedColumnName = "id")
    @ManyToOne
    private Unidad idUnidad;
    @JoinColumn(name = "id_silabo", referencedColumnName = "id")
    @ManyToOne
    private Silabo idSilabo;

    public Contenidos() {
    }

    public Contenidos(Integer id) {
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

    public Integer getHorasteoricas() {
        return horasteoricas;
    }

    public void setHorasteoricas(Integer horasteoricas) {
        this.horasteoricas = horasteoricas;
    }

    public Integer getHoraspracticas() {
        return horaspracticas;
    }

    public void setHoraspracticas(Integer horaspracticas) {
        this.horaspracticas = horaspracticas;
    }

    public Integer getHorastutorias() {
        return horastutorias;
    }

    public void setHorastutorias(Integer horastutorias) {
        this.horastutorias = horastutorias;
    }

    public Integer getHorasautonomas() {
        return horasautonomas;
    }

    public void setHorasautonomas(Integer horasautonomas) {
        this.horasautonomas = horasautonomas;
    }

    public String getActividadautonoma() {
        return actividadautonoma;
    }

    public void setActividadautonoma(String actividadautonoma) {
        this.actividadautonoma = actividadautonoma;
    }

    public String getMecanismoevaluacion() {
        return mecanismoevaluacion;
    }

    public void setMecanismoevaluacion(String mecanismoevaluacion) {
        this.mecanismoevaluacion = mecanismoevaluacion;
    }

    public String getActividadclase() {
        return actividadclase;
    }

    public void setActividadclase(String actividadclase) {
        this.actividadclase = actividadclase;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
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
        if (!(object instanceof Contenidos)) {
            return false;
        }
        Contenidos other = (Contenidos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.facci.entity.Contenidos[ id=" + id + " ]";
    }
    
}
