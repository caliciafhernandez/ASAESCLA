/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asaescla.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alicia Fernández
 */
@Entity
@Table(name = "prueba")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prueba.findAll", query = "SELECT p FROM Prueba p"),
    @NamedQuery(name = "Prueba.findById", query = "SELECT p FROM Prueba p WHERE p.id = :id"),
    @NamedQuery(name = "Prueba.findByNombre", query = "SELECT p FROM Prueba p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Prueba.findByApellido", query = "SELECT p FROM Prueba p WHERE p.apellido = :apellido")})
public class Prueba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 500)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 500)
    @Column(name = "apellido")
    private String apellido;

    public Prueba() {
    }

    public Prueba(Integer id) {
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
        if (!(object instanceof Prueba)) {
            return false;
        }
        Prueba other = (Prueba) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asaescla.entity.Prueba[ id=" + id + " ]";
    }
    
}
