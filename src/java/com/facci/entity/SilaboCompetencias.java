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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "silabo_competencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SilaboCompetencias.findAll", query = "SELECT s FROM SilaboCompetencias s"),
    @NamedQuery(name = "SilaboCompetencias.findById", query = "SELECT s FROM SilaboCompetencias s WHERE s.id = :id")})
public class SilaboCompetencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_silabo", referencedColumnName = "id")
    @ManyToOne
    private Silabo idSilabo;
    @JoinColumn(name = "id_competencias", referencedColumnName = "id")
    @ManyToOne
    private Competencias idCompetencias;

    public SilaboCompetencias() {
    }

    public SilaboCompetencias(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Silabo getIdSilabo() {
        return idSilabo;
    }

    public void setIdSilabo(Silabo idSilabo) {
        this.idSilabo = idSilabo;
    }

    public Competencias getIdCompetencias() {
        return idCompetencias;
    }

    public void setIdCompetencias(Competencias idCompetencias) {
        this.idCompetencias = idCompetencias;
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
        if (!(object instanceof SilaboCompetencias)) {
            return false;
        }
        SilaboCompetencias other = (SilaboCompetencias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.facci.entity.SilaboCompetencias[ id=" + id + " ]";
    }
    
}
