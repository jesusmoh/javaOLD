/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.domain.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jesus
 */
@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "web_ma_ciudades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebMaCiudades.findAll", query = "SELECT w FROM WebMaCiudades w"),
    @NamedQuery(name = "WebMaCiudades.findByCodigo", query = "SELECT w FROM WebMaCiudades w WHERE w.codigo = :codigo"),
    @NamedQuery(name = "WebMaCiudades.findByActualizado", query = "SELECT w FROM WebMaCiudades w WHERE w.actualizado = :actualizado"),
    @NamedQuery(name = "WebMaCiudades.findByDescripcion", query = "SELECT w FROM WebMaCiudades w WHERE w.descripcion = :descripcion"),
    @NamedQuery(name = "WebMaCiudades.findByFecReg", query = "SELECT w FROM WebMaCiudades w WHERE w.fecReg = :fecReg"),
    @NamedQuery(name = "WebMaCiudades.findByUsuario", query = "SELECT w FROM WebMaCiudades w WHERE w.usuario = :usuario")})
public class WebMaCiudades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 255)
    @Column(name = "actualizado")
    private String actualizado;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fec_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecReg;
    @Size(max = 255)
    @Column(name = "usuario")
    private String usuario;

  
}
