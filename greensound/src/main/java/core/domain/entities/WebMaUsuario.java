/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.domain.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author JOrtiz
 */
@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "ws_ma_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebMaUsuario.findAll", query = "SELECT w FROM WebMaUsuario w")
    , @NamedQuery(name = "WebMaUsuario.findByNombre", query = "SELECT w FROM WebMaUsuario w WHERE w.nombre = :nombre")
    , @NamedQuery(name = "WebMaUsuario.findByPassword", query = "SELECT w FROM WebMaUsuario w WHERE w.password = :password")
    , @NamedQuery(name = "WebMaUsuario.findByCodigo", query = "SELECT w FROM WebMaUsuario w WHERE w.codigo = :codigo")
    , @NamedQuery(name = "WebMaUsuario.findByOperacion", query = "SELECT w FROM WebMaUsuario w WHERE w.operacion = :operacion")})
public class WebMaUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "password")
    private String password;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "operacion")
    private String operacion;

   
}
