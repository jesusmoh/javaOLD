/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redcloud.model.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author JOrtiz
 */
@Entity
@Table(name = "web_ma_ciudades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebMaCiudades.findAll", query = "SELECT w FROM WebMaCiudades w")
    , @NamedQuery(name = "WebMaCiudades.findByCodigo", query = "SELECT w FROM WebMaCiudades w WHERE w.codigo = :codigo")
    , @NamedQuery(name = "WebMaCiudades.findByDescripcion", query = "SELECT w FROM WebMaCiudades w WHERE w.descripcion = :descripcion")
    , @NamedQuery(name = "WebMaCiudades.findByActualizado", query = "SELECT w FROM WebMaCiudades w WHERE w.actualizado = :actualizado")
    , @NamedQuery(name = "WebMaCiudades.findByFecReg", query = "SELECT w FROM WebMaCiudades w WHERE w.fecReg = :fecReg")
    , @NamedQuery(name = "WebMaCiudades.findByUsuario", query = "SELECT w FROM WebMaCiudades w WHERE w.usuario = :usuario")})
public class WebMaCiudades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 1)
    @Column(name = "actualizado")
    private String actualizado;
    @Column(name = "fec_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecReg;
    @Size(max = 20)
    @Column(name = "usuario")
    private String usuario;

    public WebMaCiudades() {
    }

    public WebMaCiudades(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getActualizado() {
        return actualizado;
    }

    public void setActualizado(String actualizado) {
        this.actualizado = actualizado;
    }

    public Date getFecReg() {
        return fecReg;
    }

    public void setFecReg(Date fecReg) {
        this.fecReg = fecReg;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
        if (!(object instanceof WebMaCiudades)) {
            return false;
        }
        WebMaCiudades other = (WebMaCiudades) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "api.entities.WebMaCiudades[ codigo=" + codigo + " ]";
    }
    
}
