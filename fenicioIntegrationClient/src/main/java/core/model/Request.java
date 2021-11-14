package core.model;

import javax.json.bind.annotation.JsonbProperty;

public class Request {

    @JsonbProperty("_idSolicitud")
    private String _idSolicitud;

    @JsonbProperty("_idSolicitud")
    public String getIdSolicitud() {
        return _idSolicitud;
    }
    
    @JsonbProperty("_idSolicitud")
    public void setIdSolicitud(String idSolicitud) {
        this._idSolicitud = idSolicitud;
    }
}
