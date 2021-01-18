/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author JOrtiz findByRucProveedorAndCodigoArticuloProveedor
 */
@Entity
@Table(name = "p_corporativo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PCorporativo.findAll", query = "SELECT p FROM PCorporativo p"),
    @NamedQuery(name = "PCorporativo.findByCodClasificacionN1", query = "SELECT p FROM PCorporativo p WHERE p.codClasificacionN1 = :codClasificacionN1"),
    @NamedQuery(name = "PCorporativo.findByCodClasificacionN2", query = "SELECT p FROM PCorporativo p WHERE p.codClasificacionN2 = :codClasificacionN2"),
    @NamedQuery(name = "PCorporativo.findByCodClasificacionN3", query = "SELECT p FROM PCorporativo p WHERE p.codClasificacionN3 = :codClasificacionN3"),
    @NamedQuery(name = "PCorporativo.findByCodigoArticuloProveedor", query = "SELECT p FROM PCorporativo p WHERE p.codigoArticuloProveedor = :codigoArticuloProveedor"),
    @NamedQuery(name = "PCorporativo.findByRucProveedorAndCodigoArticuloProveedor", query = "SELECT p FROM PCorporativo p WHERE p.codigoArticuloProveedor = :codigoArticuloProveedor AND p.rucProveedor = :rucProveedor"),  
    @NamedQuery(name = "PCorporativo.findByCodigoBalanza", query = "SELECT p FROM PCorporativo p WHERE p.codigoBalanza = :codigoBalanza"),
    @NamedQuery(name = "PCorporativo.findByCodigoBarra", query = "SELECT p FROM PCorporativo p WHERE p.pCorporativoPK.codigoBarra = :codigoBarra"),
    @NamedQuery(name = "PCorporativo.findByCodigoBarraPrincipal", query = "SELECT p FROM PCorporativo p WHERE p.codigoBarraPrincipal = :codigoBarraPrincipal"),
    @NamedQuery(name = "PCorporativo.findByCodigoIva", query = "SELECT p FROM PCorporativo p WHERE p.codigoIva = :codigoIva"),
    @NamedQuery(name = "PCorporativo.findByCodigoProductoCliente", query = "SELECT p FROM PCorporativo p WHERE p.codigoProductoCliente = :codigoProductoCliente"),
    @NamedQuery(name = "PCorporativo.findByDepartamentoVentaCodigo", query = "SELECT p FROM PCorporativo p WHERE p.departamentoVentaCodigo = :departamentoVentaCodigo"),
    @NamedQuery(name = "PCorporativo.findByDepartamentoVentaDescripcion", query = "SELECT p FROM PCorporativo p WHERE p.departamentoVentaDescripcion = :departamentoVentaDescripcion"),
    @NamedQuery(name = "PCorporativo.findByDescripcionClasificacionN1", query = "SELECT p FROM PCorporativo p WHERE p.descripcionClasificacionN1 = :descripcionClasificacionN1"),
    @NamedQuery(name = "PCorporativo.findByDescripcionClasificacionN2", query = "SELECT p FROM PCorporativo p WHERE p.descripcionClasificacionN2 = :descripcionClasificacionN2"),
    @NamedQuery(name = "PCorporativo.findByDescripcionClasificacionN3", query = "SELECT p FROM PCorporativo p WHERE p.descripcionClasificacionN3 = :descripcionClasificacionN3"),
    @NamedQuery(name = "PCorporativo.findByEsCodigoBarraPrincipal", query = "SELECT p FROM PCorporativo p WHERE p.esCodigoBarraPrincipal = :esCodigoBarraPrincipal"),
    @NamedQuery(name = "PCorporativo.findByEstado", query = "SELECT p FROM PCorporativo p WHERE p.estado = :estado"),
    @NamedQuery(name = "PCorporativo.findByFechaActualizacion", query = "SELECT p FROM PCorporativo p WHERE p.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "PCorporativo.findByFechaRegistro", query = "SELECT p FROM PCorporativo p WHERE p.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "PCorporativo.findByImagen1", query = "SELECT p FROM PCorporativo p WHERE p.imagen1 = :imagen1"),
    @NamedQuery(name = "PCorporativo.findByImagen", query = "SELECT p FROM PCorporativo p WHERE p.imagen = :imagen"),
    @NamedQuery(name = "PCorporativo.findByImagen2", query = "SELECT p FROM PCorporativo p WHERE p.imagen2 = :imagen2"),
    @NamedQuery(name = "PCorporativo.findByImagen3", query = "SELECT p FROM PCorporativo p WHERE p.imagen3 = :imagen3"),
    @NamedQuery(name = "PCorporativo.findByMarca", query = "SELECT p FROM PCorporativo p WHERE p.marca = :marca"),
    @NamedQuery(name = "PCorporativo.findByNombreProducto", query = "SELECT p FROM PCorporativo p WHERE p.nombreProducto = :nombreProducto"),
    @NamedQuery(name = "PCorporativo.findByNombreProveedor", query = "SELECT p FROM PCorporativo p WHERE p.nombreProveedor = :nombreProveedor"),
    @NamedQuery(name = "PCorporativo.findByRsocialProveedor", query = "SELECT p FROM PCorporativo p WHERE p.rsocialProveedor = :rsocialProveedor"),
    @NamedQuery(name = "PCorporativo.findByRucCliente", query = "SELECT p FROM PCorporativo p WHERE p.pCorporativoPK.rucCliente = :rucCliente"),
    @NamedQuery(name = "PCorporativo.findByRucProveedor", query = "SELECT p FROM PCorporativo p WHERE p.rucProveedor = :rucProveedor"),
    @NamedQuery(name = "PCorporativo.findBySugerencia", query = "SELECT p FROM PCorporativo p WHERE p.sugerencia = :sugerencia"),
    @NamedQuery(name = "PCorporativo.findByWebMaClasificacionN1Codigo", query = "SELECT p FROM PCorporativo p WHERE p.webMaClasificacionN1Codigo = :webMaClasificacionN1Codigo"),
    @NamedQuery(name = "PCorporativo.findByWebMaClasificacionN1Descripcion", query = "SELECT p FROM PCorporativo p WHERE p.webMaClasificacionN1Descripcion = :webMaClasificacionN1Descripcion"),
    @NamedQuery(name = "PCorporativo.findByWebMaClasificacionN2Codigo", query = "SELECT p FROM PCorporativo p WHERE p.webMaClasificacionN2Codigo = :webMaClasificacionN2Codigo"),
    @NamedQuery(name = "PCorporativo.findByWebMaClasificacionN2Descripcion", query = "SELECT p FROM PCorporativo p WHERE p.webMaClasificacionN2Descripcion = :webMaClasificacionN2Descripcion"),
    @NamedQuery(name = "PCorporativo.findByIkey", query = "SELECT p FROM PCorporativo p WHERE p.ikey = :ikey")})
public class PCorporativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PCorporativoPK pCorporativoPK;
    @Column(name = "cod_clasificacion_n1")
    private Integer codClasificacionN1;
    @Column(name = "cod_clasificacion_n2")
    private Integer codClasificacionN2;
    @Column(name = "cod_clasificacion_n3")
    private Integer codClasificacionN3;
    @Size(max = 255)
    @Column(name = "codigo_articulo_proveedor")
    private String codigoArticuloProveedor;
    @Column(name = "codigo_balanza")
    private Integer codigoBalanza;
    @Size(max = 255)
    @Column(name = "codigo_barra_principal")
    private String codigoBarraPrincipal;
    @Column(name = "codigo_iva")
    private Short codigoIva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_producto_cliente")
    private int codigoProductoCliente;
    @Column(name = "departamento_venta_codigo")
    private Short departamentoVentaCodigo;
    @Size(max = 255)
    @Column(name = "departamento_venta_descripcion")
    private String departamentoVentaDescripcion;
    @Size(max = 255)
    @Column(name = "descripcion_clasificacion_n1")
    private String descripcionClasificacionN1;
    @Size(max = 255)
    @Column(name = "descripcion_clasificacion_n2")
    private String descripcionClasificacionN2;
    @Size(max = 255)
    @Column(name = "descripcion_clasificacion_n3")
    private String descripcionClasificacionN3;
    @Column(name = "es_codigo_barra_principal")
    private Short esCodigoBarraPrincipal;
    @Column(name = "estado")
    private Integer estado;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Size(max = 255)
    @Column(name = "imagen")
    private String imagen;
    @Size(max = 255)
    @Column(name = "imagen1")
    private String imagen1;
    @Size(max = 255)
    @Column(name = "imagen2")
    private String imagen2;
    @Size(max = 255)
    @Column(name = "imagen3")
    private String imagen3;
    @Size(max = 255)
    @Column(name = "marca")
    private String marca;
    @Size(max = 255)
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Size(max = 255)
    @Column(name = "nombre_proveedor")
    private String nombreProveedor;
    @Size(max = 255)
    @Column(name = "rsocial_proveedor")
    private String rsocialProveedor;
    @Size(max = 255)
    @Column(name = "ruc_proveedor")
    private String rucProveedor;
    @Size(max = 2147483647)
    @Column(name = "sugerencia")
    private String sugerencia;
    @Column(name = "web_ma_clasificacion_n1_codigo")
    private Integer webMaClasificacionN1Codigo;
    @Size(max = 255)
    @Column(name = "web_ma_clasificacion_n1_descripcion")
    private String webMaClasificacionN1Descripcion;
    @Column(name = "web_ma_clasificacion_n2_codigo")
    private Integer webMaClasificacionN2Codigo;
    @Size(max = 255)
    @Column(name = "web_ma_clasificacion_n2_descripcion")
    private String webMaClasificacionN2Descripcion;
    @Basic(optional = false)
    @Column(name = "ikey")
    private int ikey;

    public PCorporativo() {
    }

    public PCorporativo(PCorporativoPK pCorporativoPK) {
        this.pCorporativoPK = pCorporativoPK;
    }

    public PCorporativo(PCorporativoPK pCorporativoPK, int codigoProductoCliente, int ikey) {
        this.pCorporativoPK = pCorporativoPK;
        this.codigoProductoCliente = codigoProductoCliente;
        this.ikey = ikey;
    }

    public PCorporativo(String codigoBarra, String rucCliente) {
        this.pCorporativoPK = new PCorporativoPK(codigoBarra, rucCliente);
    }

    public PCorporativoPK getPCorporativoPK() {
        return pCorporativoPK;
    }

    public void setPCorporativoPK(PCorporativoPK pCorporativoPK) {
        this.pCorporativoPK = pCorporativoPK;
    }

    public Integer getCodClasificacionN1() {
        return codClasificacionN1;
    }

    public void setCodClasificacionN1(Integer codClasificacionN1) {
        this.codClasificacionN1 = codClasificacionN1;
    }

    public Integer getCodClasificacionN2() {
        return codClasificacionN2;
    }

    public void setCodClasificacionN2(Integer codClasificacionN2) {
        this.codClasificacionN2 = codClasificacionN2;
    }

    public Integer getCodClasificacionN3() {
        return codClasificacionN3;
    }

    public void setCodClasificacionN3(Integer codClasificacionN3) {
        this.codClasificacionN3 = codClasificacionN3;
    }

    public String getCodigoArticuloProveedor() {
        return codigoArticuloProveedor;
    }

    public void setCodigoArticuloProveedor(String codigoArticuloProveedor) {
        this.codigoArticuloProveedor = codigoArticuloProveedor;
    }

    public Integer getCodigoBalanza() {
        return codigoBalanza;
    }

    public void setCodigoBalanza(Integer codigoBalanza) {
        this.codigoBalanza = codigoBalanza;
    }

    public String getCodigoBarraPrincipal() {
        return codigoBarraPrincipal;
    }

    public void setCodigoBarraPrincipal(String codigoBarraPrincipal) {
        this.codigoBarraPrincipal = codigoBarraPrincipal;
    }

    public Short getCodigoIva() {
        return codigoIva;
    }

    public void setCodigoIva(Short codigoIva) {
        this.codigoIva = codigoIva;
    }

    public int getCodigoProductoCliente() {
        return codigoProductoCliente;
    }

    public void setCodigoProductoCliente(int codigoProductoCliente) {
        this.codigoProductoCliente = codigoProductoCliente;
    }

    public Short getDepartamentoVentaCodigo() {
        return departamentoVentaCodigo;
    }

    public void setDepartamentoVentaCodigo(Short departamentoVentaCodigo) {
        this.departamentoVentaCodigo = departamentoVentaCodigo;
    }

    public String getDepartamentoVentaDescripcion() {
        return departamentoVentaDescripcion;
    }

    public void setDepartamentoVentaDescripcion(String departamentoVentaDescripcion) {
        this.departamentoVentaDescripcion = departamentoVentaDescripcion;
    }

    public String getDescripcionClasificacionN1() {
        return descripcionClasificacionN1;
    }

    public void setDescripcionClasificacionN1(String descripcionClasificacionN1) {
        this.descripcionClasificacionN1 = descripcionClasificacionN1;
    }

    public String getDescripcionClasificacionN2() {
        return descripcionClasificacionN2;
    }

    public void setDescripcionClasificacionN2(String descripcionClasificacionN2) {
        this.descripcionClasificacionN2 = descripcionClasificacionN2;
    }

    public String getDescripcionClasificacionN3() {
        return descripcionClasificacionN3;
    }

    public void setDescripcionClasificacionN3(String descripcionClasificacionN3) {
        this.descripcionClasificacionN3 = descripcionClasificacionN3;
    }

    public Short getEsCodigoBarraPrincipal() {
        return esCodigoBarraPrincipal;
    }

    public void setEsCodigoBarraPrincipal(Short esCodigoBarraPrincipal) {
        this.esCodigoBarraPrincipal = esCodigoBarraPrincipal;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getImagen1() {
        return imagen1;
    }

    public void setImagen1(String imagen1) {
        this.imagen1 = imagen1;
    }

    public String getImagen2() {
        return imagen2;
    }

    public void setImagen2(String imagen2) {
        this.imagen2 = imagen2;
    }

    public String getImagen3() {
        return imagen3;
    }

    public void setImagen3(String imagen3) {
        this.imagen3 = imagen3;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getRsocialProveedor() {
        return rsocialProveedor;
    }

    public void setRsocialProveedor(String rsocialProveedor) {
        this.rsocialProveedor = rsocialProveedor;
    }

    public String getRucProveedor() {
        return rucProveedor;
    }

    public void setRucProveedor(String rucProveedor) {
        this.rucProveedor = rucProveedor;
    }

    public String getSugerencia() {
        return sugerencia;
    }

    public void setSugerencia(String sugerencia) {
        this.sugerencia = sugerencia;
    }

    public Integer getWebMaClasificacionN1Codigo() {
        return webMaClasificacionN1Codigo;
    }

    public void setWebMaClasificacionN1Codigo(Integer webMaClasificacionN1Codigo) {
        this.webMaClasificacionN1Codigo = webMaClasificacionN1Codigo;
    }

    public String getWebMaClasificacionN1Descripcion() {
        return webMaClasificacionN1Descripcion;
    }

    public void setWebMaClasificacionN1Descripcion(String webMaClasificacionN1Descripcion) {
        this.webMaClasificacionN1Descripcion = webMaClasificacionN1Descripcion;
    }

    public Integer getWebMaClasificacionN2Codigo() {
        return webMaClasificacionN2Codigo;
    }

    public void setWebMaClasificacionN2Codigo(Integer webMaClasificacionN2Codigo) {
        this.webMaClasificacionN2Codigo = webMaClasificacionN2Codigo;
    }

    public String getWebMaClasificacionN2Descripcion() {
        return webMaClasificacionN2Descripcion;
    }

    public void setWebMaClasificacionN2Descripcion(String webMaClasificacionN2Descripcion) {
        this.webMaClasificacionN2Descripcion = webMaClasificacionN2Descripcion;
    }

    public int getIkey() {
        return ikey;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    

    public void setIkey(int ikey) {
        this.ikey = ikey;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pCorporativoPK != null ? pCorporativoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PCorporativo)) {
            return false;
        }
        PCorporativo other = (PCorporativo) object;
        if ((this.pCorporativoPK == null && other.pCorporativoPK != null) || (this.pCorporativoPK != null && !this.pCorporativoPK.equals(other.pCorporativoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "core.domain.PCorporativo[ pCorporativoPK=" + pCorporativoPK + " ]";
    }
    
   
}
