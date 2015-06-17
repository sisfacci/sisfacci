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
@Table(name = "asignatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignatura.findAll", query = "SELECT a FROM Asignatura a"),
    @NamedQuery(name = "Asignatura.findById", query = "SELECT a FROM Asignatura a WHERE a.id = :id"),
    @NamedQuery(name = "Asignatura.findByCodigo", query = "SELECT a FROM Asignatura a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Asignatura.findByCreditos", query = "SELECT a FROM Asignatura a WHERE a.creditos = :creditos"),
    @NamedQuery(name = "Asignatura.findByHoraspresente", query = "SELECT a FROM Asignatura a WHERE a.horaspresente = :horaspresente"),
    @NamedQuery(name = "Asignatura.findByHorasautomas", query = "SELECT a FROM Asignatura a WHERE a.horasautomas = :horasautomas"),
    @NamedQuery(name = "Asignatura.findByHorasteoricas", query = "SELECT a FROM Asignatura a WHERE a.horasteoricas = :horasteoricas"),
    @NamedQuery(name = "Asignatura.findByHoraspracticas", query = "SELECT a FROM Asignatura a WHERE a.horaspracticas = :horaspracticas"),
    @NamedQuery(name = "Asignatura.findByPrerequisito", query = "SELECT a FROM Asignatura a WHERE a.prerequisito = :prerequisito"),
    @NamedQuery(name = "Asignatura.findByCorequisito", query = "SELECT a FROM Asignatura a WHERE a.corequisito = :corequisito")})
public class Asignatura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "creditos")
    private Integer creditos;
    @Column(name = "horaspresente")
    private Integer horaspresente;
    @Column(name = "horasautomas")
    private Integer horasautomas;
    @Column(name = "horasteoricas")
    private Integer horasteoricas;
    @Column(name = "horaspracticas")
    private Integer horaspracticas;
    @Column(name = "prerequisito")
    private String prerequisito;
    @Column(name = "corequisito")
    private String corequisito;
    @JoinColumn(name = "id_nivel", referencedColumnName = "id")
    @ManyToOne
    private Nivel idNivel;
    @OneToMany(mappedBy = "idAsignatura")
    private Collection<Silabo> silaboCollection;

    public Asignatura() {
    }

    public Asignatura(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public Integer getHoraspresente() {
        return horaspresente;
    }

    public void setHoraspresente(Integer horaspresente) {
        this.horaspresente = horaspresente;
    }

    public Integer getHorasautomas() {
        return horasautomas;
    }

    public void setHorasautomas(Integer horasautomas) {
        this.horasautomas = horasautomas;
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

    public String getPrerequisito() {
        return prerequisito;
    }

    public void setPrerequisito(String prerequisito) {
        this.prerequisito = prerequisito;
    }

    public String getCorequisito() {
        return corequisito;
    }

    public void setCorequisito(String corequisito) {
        this.corequisito = corequisito;
    }

    public Nivel getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Nivel idNivel) {
        this.idNivel = idNivel;
    }

    @XmlTransient
    public Collection<Silabo> getSilaboCollection() {
        return silaboCollection;
    }

    public void setSilaboCollection(Collection<Silabo> silaboCollection) {
        this.silaboCollection = silaboCollection;
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
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.facci.entity.Asignatura[ id=" + id + " ]";
    }
    
}
