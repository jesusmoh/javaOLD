
package uy.com.sisnet.fenicioClient.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Variante {

    private String codigo;
    private String nombre;
    private Integer orden;
    private Atributos atributos;
    private List<Presentacione> presentaciones = null;
   

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

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public List<Presentacione> getPresentaciones() {
        return presentaciones;
    }

    public void setPresentaciones(List<Presentacione> presentaciones) {
        this.presentaciones = presentaciones;
    }

}
