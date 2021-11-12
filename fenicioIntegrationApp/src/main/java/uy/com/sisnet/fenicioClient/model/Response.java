/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.sisnet.fenicioClient.model;

import javax.json.bind.annotation.JsonbProperty;

/**
 *
 * @author jesus
 */
public class Response {

    private String status;
    private String mensaje;
    @JsonbProperty("_idSolicitud")
    private String idSolicitud;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @JsonbProperty("_idSolicitud")
    public String getIdSolicitud() {
        return idSolicitud;
    }
    @JsonbProperty("_idSolicitud")
    public void setIdSolicitud(String idSolicitud) {
        this.idSolicitud = idSolicitud;
    }
    
    
}
