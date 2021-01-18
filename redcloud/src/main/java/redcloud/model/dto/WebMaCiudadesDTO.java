/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redcloud.model.dto;

import java.util.Date;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 *
 * @author jesus
 */
public class WebMaCiudadesDTO {
    
    private static final long serialVersionUID = 1L;

    @NotNull
    @Positive 
    private Integer codigo;
    @NotNull
    @Size(min = 10, max = 20)
    private String descripcion;
    @NotNull
    private String actualizado;
    @NotNull
    @FutureOrPresent
    private Date fecReg;
    @NotNull
    @Size(min =5, max = 10)
    @Pattern(regexp = "[a-zA-Z0-9]+")
    private String usuario;

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

  
    public WebMaCiudadesDTO() {
    }
    
    
}
