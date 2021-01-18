package core.model.dto;


import java.util.Date;
import javax.json.bind.annotation.JsonbDateFormat;


public class PCorporativoDTO {

    private String codigoBarra;
    private String rucCliente;
    private Integer codClasificacionN1;
    private Integer codClasificacionN2;
    private Integer codClasificacionN3;
    private String codigoArticuloProveedor;
    private Integer codigoBalanza;
    private Short codigoIva;
    private int codigoProductoCliente;
    private Short departamentoVentaCodigo;
    private String departamentoVentaDescripcion;
    private String descripcionClasificacionN1;
    private String descripcionClasificacionN2;
    private String descripcionClasificacionN3;
    @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss")
    private Date fechaActualizacion;
    @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss")
    private Date fechaRegistro;
    private String imagen;
    private String imagen1;
    private String imagen2;
    private String imagen3;
    private String marca;
    private String nombreProducto;
    private String nombreProveedor;
    private String rsocialProveedor;
    private String rucProveedor;
    private String sugerencia;
    private Integer webMaClasificacionN1Codigo;
    private String webMaClasificacionN1Descripcion;
    private Integer webMaClasificacionN2Codigo;
    private String webMaClasificacionN2Descripcion;
   
    public String getCodigoBarra() {
        return codigoBarra;
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