/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JOrtiz
 */
@Entity
@Table(name = "ws_stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WsStock.findAll", query = "SELECT w FROM WsStock w"),
    @NamedQuery(name = "WsStock.findById", query = "SELECT w FROM WsStock w WHERE w.id = :id"),
    @NamedQuery(name = "WsStock.findByCodEmp", query = "SELECT w FROM WsStock w WHERE w.codEmp = :codEmp"),
    @NamedQuery(name = "WsStock.findByCodProd", query = "SELECT w FROM WsStock w WHERE w.codProd = :codProd"),
    @NamedQuery(name = "WsStock.findByDeposito", query = "SELECT w FROM WsStock w WHERE w.deposito = :deposito"),
    @NamedQuery(name = "WsStock.findByMovil", query = "SELECT w FROM WsStock w WHERE w.movil = :movil"),
    @NamedQuery(name = "WsStock.findBySaldo", query = "SELECT w FROM WsStock w WHERE w.saldo = :saldo"),
    @NamedQuery(name = "WsStock.findByTomadoPorMovil", query = "SELECT w FROM WsStock w WHERE w.tomadoPorMovil = :tomadoPorMovil")})
public class WsStock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "cod_emp")
    private Integer codEmp;
    @Column(name = "cod_prod")
    private Integer codProd;
    @Size(max = 255)
    @Column(name = "deposito")
    private String deposito;
    @Column(name = "movil")
    private Integer movil;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo")
    private Double saldo;
    @Column(name = "tomado_por_movil")
    private Boolean tomadoPorMovil;

    public WsStock() {
    }

    public WsStock(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(Integer codEmp) {
        this.codEmp = codEmp;
    }

    public Integer getCodProd() {
        return codProd;
    }

    public void setCodProd(Integer codProd) {
        this.codProd = codProd;
    }

    public String getDeposito() {
        return deposito;
    }

    public void setDeposito(String deposito) {
        this.deposito = deposito;
    }

    public Integer getMovil() {
        return movil;
    }

    public void setMovil(Integer movil) {
        this.movil = movil;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Boolean getTomadoPorMovil() {
        return tomadoPorMovil;
    }

    public void setTomadoPorMovil(Boolean tomadoPorMovil) {
        this.tomadoPorMovil = tomadoPorMovil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WsStock)) {
            return false;
        }
        WsStock other = (WsStock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "core.WsStock[ id=" + id + " ]";
    }
    
}
