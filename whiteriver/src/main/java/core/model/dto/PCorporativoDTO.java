package core.model.dto;

import java.util.Date;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PCorporativoDTO {

    @NotNull
    @Size(min = 5, max = 14)
    @Column(name = "codigo_barra")
    private String codigoBarra;
    @NotNull
    @Size(min = 11, max = 14)
    private String rucCliente;
    private Integer codClasificacionN1;
    private Integer codClasificacionN2;
    private Integer codClasificacionN3;
    @Size(max = 50)
    private String codigoArticuloProveedor;
    private Integer codigoBalanza;
    private Short codigoIva;
    private Integer codigoProductoCliente;
    private Short departamentoVentaCodigo;
    @Size(max = 50)
    private String departamentoVentaDescripcion;
    @Size(max = 50)
    private String descripcionClasificacionN1;
    @Size(max = 50)
    private String descripcionClasificacionN2;
    @Size(max = 50)
    private String descripcionClasificacionN3;
    @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss")
    private Date fechaActualizacion;
    @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss")
    private Date fechaRegistro;
    @NotNull
 
    private String imagen;
    @NotNull
    private String imagen1;
    private String imagen2;
    private String imagen3;
    @Size(max = 50)
    private String marca;
    @Size(max = 50)
    @NotNull
    private String nombreProducto;
    @Size(max = 50)
    private String nombreProveedor;
    @Size(max = 50)
    private String rsocialProveedor;
    @Size(min = 1, max = 15)
    private String rucProveedor;
    @Size(max = 255)
    private String sugerencia;
    private Integer webMaClasificacionN1Codigo;
    @Size(max = 50)
    private String webMaClasificacionN1Descripcion;
    private Integer webMaClasificacionN2Codigo;
    @Size(max = 50)
    private String webMaClasificacionN2Descripcion;
    @NotNull
    private String imageBase64;

    public PCorporativoDTO() {
    }

    
    
    public String getCodigoBarra() {
        return codigoBarra;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getRucCliente() {
        return rucCliente;
    }

    public void setRucCliente(String rucCliente) {
        this.rucCliente = rucCliente;
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

    public Short getCodigoIva() {
        return codigoIva;
    }

    public void setCodigoIva(Short codigoIva) {
        this.codigoIva = codigoIva;
    }

    public Integer getCodigoProductoCliente() {
        return codigoProductoCliente;
    }

    public void setCodigoProductoCliente(Integer codigoProductoCliente) {
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
