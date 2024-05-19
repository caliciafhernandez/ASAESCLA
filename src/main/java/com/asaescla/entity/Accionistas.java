/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asaescla.entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alicia Fernández
 */
@Entity
@Table(name = "accionistas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accionistas.findAll", query = "SELECT a FROM Accionistas a"),
    @NamedQuery(name = "Accionistas.findByIdaccionistas", query = "SELECT a FROM Accionistas a WHERE a.idaccionistas = :idaccionistas"),
    @NamedQuery(name = "Accionistas.findByNombreacc", query = "SELECT a FROM Accionistas a WHERE a.nombreacc = :nombreacc"),
    @NamedQuery(name = "Accionistas.findByApellidoacc", query = "SELECT a FROM Accionistas a WHERE a.apellidoacc = :apellidoacc"),
    @NamedQuery(name = "Accionistas.findByGenero", query = "SELECT a FROM Accionistas a WHERE a.genero = :genero"),
    @NamedQuery(name = "Accionistas.findByFechanac", query = "SELECT a FROM Accionistas a WHERE a.fechanac = :fechanac"),
    @NamedQuery(name = "Accionistas.findByDireccionacc", query = "SELECT a FROM Accionistas a WHERE a.direccionacc = :direccionacc"),
    @NamedQuery(name = "Accionistas.findByFecharegistro", query = "SELECT a FROM Accionistas a WHERE a.fecharegistro = :fecharegistro"),
    @NamedQuery(name = "Accionistas.findByDuiacc", query = "SELECT a FROM Accionistas a WHERE a.duiacc = :duiacc")})
public class Accionistas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaccionistas")
    private Integer idaccionistas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombreacc")
    private String nombreacc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellidoacc")
    private String apellidoacc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechanac")
    @Temporal(TemporalType.DATE)
    private Date fechanac;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccionacc")
    private String direccionacc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecharegistro")
    @Temporal(TemporalType.DATE)
    private Date fecharegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "duiacc")
    private String duiacc;

    public Accionistas() {
    }

    public Accionistas(Integer idaccionistas) {
        this.idaccionistas = idaccionistas;
    }

    public Accionistas(Integer idaccionistas, String nombreacc, String apellidoacc, String genero, Date fechanac, String direccionacc, Date fecharegistro, String duiacc) {
        this.idaccionistas = idaccionistas;
        this.nombreacc = nombreacc;
        this.apellidoacc = apellidoacc;
        this.genero = genero;
        this.fechanac = fechanac;
        this.direccionacc = direccionacc;
        this.fecharegistro = fecharegistro;
        this.duiacc = duiacc;
    }

    public Integer getIdaccionistas() {
        return idaccionistas;
    }

    public void setIdaccionistas(Integer idaccionistas) {
        this.idaccionistas = idaccionistas;
    }

    public String getNombreacc() {
        return nombreacc;
    }

    public void setNombreacc(String nombreacc) {
        this.nombreacc = nombreacc;
    }

    public String getApellidoacc() {
        return apellidoacc;
    }

    public void setApellidoacc(String apellidoacc) {
        this.apellidoacc = apellidoacc;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public String getDireccionacc() {
        return direccionacc;
    }

    public void setDireccionacc(String direccionacc) {
        this.direccionacc = direccionacc;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getDuiacc() {
        return duiacc;
    }

    public void setDuiacc(String duiacc) {
        this.duiacc = duiacc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaccionistas != null ? idaccionistas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accionistas)) {
            return false;
        }
        Accionistas other = (Accionistas) object;
        if ((this.idaccionistas == null && other.idaccionistas != null) || (this.idaccionistas != null && !this.idaccionistas.equals(other.idaccionistas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asaescla.entity.Accionistas[ idaccionistas=" + idaccionistas + " ]";
    }
    
}
