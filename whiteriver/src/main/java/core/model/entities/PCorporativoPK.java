/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author JOrtiz
 */
@Embeddable
public class PCorporativoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "codigo_barra")
    private String codigoBarra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ruc_cliente")
    private String rucCliente;

    public PCorporativoPK() {
    }

    public PCorporativoPK(String codigoBarra, String rucCliente) {
        this.codigoBarra = codigoBarra;
        this.rucCliente = rucCliente;
    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoBarra != null ? codigoBarra.hashCode() : 0);
        hash += (rucCliente != null ? rucCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PCorporativoPK)) {
            return false;
        }
        PCorporativoPK other = (PCorporativoPK) object;
        if ((this.codigoBarra == null && other.codigoBarra != null) || (this.codigoBarra != null && !this.codigoBarra.equals(other.codigoBarra))) {
            return false;
        }
        if ((this.rucCliente == null && other.rucCliente != null) || (this.rucCliente != null && !this.rucCliente.equals(other.rucCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "core.domain.PCorporativoPK[ codigoBarra=" + codigoBarra + ", rucCliente=" + rucCliente + " ]";
    }
    
}
