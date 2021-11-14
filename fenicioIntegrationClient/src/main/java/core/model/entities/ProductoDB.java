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
 * @author jesus
 */
@Entity
@Table(name = "productos")
@XmlRootElement
public class ProductoDB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "fechacreacion")
    private String fechacreacion;
    @Column(name = "pioridad")
    private Short pioridad;
    @Size(max = 40)
    @Column(name = "guiatalles")
    private String guiatalles;
    @Size(max = 3)
    @Column(name = "monedapredeterminada")
    private String monedapredeterminada;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "impuesto")
    private Float impuesto;

    public ProductoDB() {
    }

    public ProductoDB(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Short getPioridad() {
        return pioridad;
    }

    public void setPioridad(Short pioridad) {
        this.pioridad = pioridad;
    }

    public String getGuiatalles() {
        return guiatalles;
    }

    public void setGuiatalles(String guiatalles) {
        this.guiatalles = guiatalles;
    }

    public String getMonedapredeterminada() {
        return monedapredeterminada;
    }

    public void setMonedapredeterminada(String monedapredeterminada) {
        this.monedapredeterminada = monedapredeterminada;
    }

    public Float getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Float impuesto) {
        this.impuesto = impuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoDB)) {
            return false;
        }
        ProductoDB other = (ProductoDB) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "core.model.entities.Producto[ codigo=" + codigo + " ]";
    }
    
}
