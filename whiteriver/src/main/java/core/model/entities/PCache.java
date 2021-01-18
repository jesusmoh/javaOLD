/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JOrtiz
 */
@Entity
@Table(name = "p_cache")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PCache.findAll", query = "SELECT c FROM PCache c"),
    @NamedQuery(name = "PCache.findByValue", query = "SELECT c FROM PCache c WHERE c.value = :value"),
    @NamedQuery(name = "PCache.findByDescripcion", query = "SELECT c FROM PCache c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "PCache.findByVariable", query = "SELECT c FROM PCache c WHERE c.variable = :variable")})
public class PCache implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "value")
    private String value;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "variable")
    private String variable;
    
    @Size(min = 1, max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    

    public PCache() {
    }

    public PCache(String variable) {
        this.variable = variable;
    }

    
    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getVariable() {
        return variable;
    }

    public PCache(String variable,String value) {
        this.value = value;
        this.variable = variable;
    }

    public PCache( String variable,String value, String descripcion) {
        this.value = value;
        this.variable = variable;
        this.descripcion = descripcion;
    }

    
    
    public void setVariable(String variable) {
        this.variable = variable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (variable != null ? variable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PCache)) {
            return false;
        }
        PCache other = (PCache) object;
        if ((this.variable == null && other.variable != null) || (this.variable != null && !this.variable.equals(other.variable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sisnet.integracionthemis.entities.Cache[ variable=" + variable + " ]";
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
