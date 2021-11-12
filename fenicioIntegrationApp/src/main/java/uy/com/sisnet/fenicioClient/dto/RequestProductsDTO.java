package uy.com.sisnet.fenicioClient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestProductsDTO {

    @JsonProperty("_idSolicitud")
    private String idSolicitud;

    private Integer desde;

    private Integer total;

    @JsonProperty("_idSolicitud")
    public String getIdSolicitud() {
        return idSolicitud;
    }

    @JsonProperty("_idSolicitud")
    public void setIdSolicitud(String idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Integer getDesde() {
        return desde;
    }

    public void setDesde(Integer desde) {
        this.desde = desde;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
