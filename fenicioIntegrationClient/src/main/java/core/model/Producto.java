
package core.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Producto {

    private String codigo;
    private String nombre;
    private String fechaCreacion;
    private Integer prioridad;
    private String guiaTalles;
    private String monedaPredeterminada;
    private Double impuesto;
    private Atributos atributos;
    private List<Variante> variantes = null;
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

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public Object getGuiaTalles() {
        return guiaTalles;
    }

    public void setGuiaTalles(String guiaTalles) {
        this.guiaTalles = guiaTalles;
    }

    public String getMonedaPredeterminada() {
        return monedaPredeterminada;
    }

    public void setMonedaPredeterminada(String monedaPredeterminada) {
        this.monedaPredeterminada = monedaPredeterminada;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    public Atributos getAtributos() {
        return atributos;
    }

    public void setAtributos(Atributos atributos) {
        this.atributos = atributos;
    }

    public List<Variante> getVariantes() {
        return variantes;
    }

    public void setVariantes(List<Variante> variantes) {
        this.variantes = variantes;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", fechaCreacion=" + fechaCreacion + ", prioridad=" + prioridad + ", guiaTalles=" + guiaTalles + ", monedaPredeterminada=" + monedaPredeterminada + ", impuesto=" + impuesto + ", atributos=" + atributos + ", variantes=" + variantes + ", additionalProperties=" + additionalProperties + '}';
    }

}
