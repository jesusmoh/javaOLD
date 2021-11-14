
package core.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Presentacione {

    private String codigo;
    private String nombre;
    private String sku;
    private Integer stock;
    private PrecioLista precioLista;
    private PrecioVenta precioVenta;
    private List<PreciosAlternativo> preciosAlternativos = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public PrecioLista getPrecioLista() {
        return precioLista;
    }

    public void setPrecioLista(PrecioLista precioLista) {
        this.precioLista = precioLista;
    }

    public PrecioVenta getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(PrecioVenta precioVenta) {
        this.precioVenta = precioVenta;
    }

    public List<PreciosAlternativo> getPreciosAlternativos() {
        return preciosAlternativos;
    }

    public void setPreciosAlternativos(List<PreciosAlternativo> preciosAlternativos) {
        this.preciosAlternativos = preciosAlternativos;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
