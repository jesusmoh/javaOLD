/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.sisnet.fenicioClient.model.entities.bo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author jesus
 */
@Entity
@Table(name = "web_ma_productos")
@XmlRootElement
public class WebMaProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_prod")
    private Integer codProd;
    @Size(max = 100)
    @Column(name = "nom_prod")
    private String nomProd;
    @Size(max = 250)
    @Column(name = "descripcion_detallada")
    private String descripcionDetallada;
    @Size(max = 10)
    @Column(name = "marca")
    private String marca;
    @Size(max = 1)
    @Column(name = "disponibilidad")
    private String disponibilidad;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "codigo_n2")
    private Integer codigoN2;
    @Column(name = "cod_iva")
    private Integer codIva;
    @Column(name = "packing")
    private Integer packing;
    @Column(name = "grupo_descuento_cliente")
    private Integer grupoDescuentoCliente;
    @Size(max = 1)
    @Column(name = "actualizado")
    private String actualizado;
    @Column(name = "fec_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecReg;
    @Size(max = 20)
    @Column(name = "usuario")
    private String usuario;
    @Size(max = 1)
    @Column(name = "activo")
    private String activo;
    @Size(max = 50)
    @Column(name = "talle")
    private String talle;
    @Size(max = 50)
    @Column(name = "color")
    private String color;
    @Column(name = "mailing")
    private Integer mailing;
    @Size(max = 1)
    @Column(name = "proximos_arribos")
    private String proximosArribos;
    @Column(name = "prioridad")
    private Integer prioridad;
    @Size(max = 20)
    @Column(name = "cod_doc_sistema_anterior")
    private String codDocSistemaAnterior;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "sugerencia")
    private String sugerencia;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;

    public WebMaProductos() {
    }

    public WebMaProductos(Integer codProd) {
        this.codProd = codProd;
    }

    public Integer getCodProd() {
        return codProd;
    }

    public void setCodProd(Integer codProd) {
        this.codProd = codProd;
    }

    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public String getDescripcionDetallada() {
        return descripcionDetallada;
    }

    public void setDescripcionDetallada(String descripcionDetallada) {
        this.descripcionDetallada = descripcionDetallada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getCodigoN2() {
        return codigoN2;
    }

    public void setCodigoN2(Integer codigoN2) {
        this.codigoN2 = codigoN2;
    }

    public Integer getCodIva() {
        return codIva;
    }

    public void setCodIva(Integer codIva) {
        this.codIva = codIva;
    }

    public Integer getPacking() {
        return packing;
    }

    public void setPacking(Integer packing) {
        this.packing = packing;
    }

    public Integer getGrupoDescuentoCliente() {
        return grupoDescuentoCliente;
    }

    public void setGrupoDescuentoCliente(Integer grupoDescuentoCliente) {
        this.grupoDescuentoCliente = grupoDescuentoCliente;
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

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getMailing() {
        return mailing;
    }

    public void setMailing(Integer mailing) {
        this.mailing = mailing;
    }

    public String getProximosArribos() {
        return proximosArribos;
    }

    public void setProximosArribos(String proximosArribos) {
        this.proximosArribos = proximosArribos;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public String getCodDocSistemaAnterior() {
        return codDocSistemaAnterior;
    }

    public void setCodDocSistemaAnterior(String codDocSistemaAnterior) {
        this.codDocSistemaAnterior = codDocSistemaAnterior;
    }

    public String getSugerencia() {
        return sugerencia;
    }

    public void setSugerencia(String sugerencia) {
        this.sugerencia = sugerencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProd != null ? codProd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebMaProductos)) {
            return false;
        }
        WebMaProductos other = (WebMaProductos) object;
        if ((this.codProd == null && other.codProd != null) || (this.codProd != null && !this.codProd.equals(other.codProd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.com.sisnet.fenicioClient.model.entities.WebMaProductos[ codProd=" + codProd + " ]";
    }
    
}
