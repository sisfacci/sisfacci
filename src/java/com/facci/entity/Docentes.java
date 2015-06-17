/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facci.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "docentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docentes.findAll", query = "SELECT d FROM Docentes d"),
    @NamedQuery(name = "Docentes.findById", query = "SELECT d FROM Docentes d WHERE d.id = :id"),
    @NamedQuery(name = "Docentes.findByCorreo1", query = "SELECT d FROM Docentes d WHERE d.correo1 = :correo1"),
    @NamedQuery(name = "Docentes.findByCorreo2", query = "SELECT d FROM Docentes d WHERE d.correo2 = :correo2"),
    @NamedQuery(name = "Docentes.findByMovil", query = "SELECT d FROM Docentes d WHERE d.movil = :movil"),
    @NamedQuery(name = "Docentes.findByEstado", query = "SELECT d FROM Docentes d WHERE d.estado = :estado")})
public class Docentes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "correo1")
    private String correo1;
    @Column(name = "correo2")
    private String correo2;
    @Column(name = "movil")
    private BigInteger movil;
    @Column(name = "estado")
    private Boolean estado;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne
    private Usuario idUsuario;
    @OneToMany(mappedBy = "idDocentes")
    private Collection<SilaboDocentes> silaboDocentesCollection;

    public Docentes() {
    }

    public Docentes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo1() {
        return correo1;
    }

    public void setCorreo1(String correo1) {
        this.correo1 = correo1;
    }

    public String getCorreo2() {
        return correo2;
    }

    public void setCorreo2(String correo2) {
        this.correo2 = correo2;
    }

    public BigInteger getMovil() {
        return movil;
    }

    public void setMovil(BigInteger movil) {
        this.movil = movil;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public Collection<SilaboDocentes> getSilaboDocentesCollection() {
        return silaboDocentesCollection;
    }

    public void setSilaboDocentesCollection(Collection<SilaboDocentes> silaboDocentesCollection) {
        this.silaboDocentesCollection = silaboDocentesCollection;
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
        if (!(object instanceof Docentes)) {
            return false;
        }
        Docentes other = (Docentes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.facci.entity.Docentes[ id=" + id + " ]";
    }
    
}
