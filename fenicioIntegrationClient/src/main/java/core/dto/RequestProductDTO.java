package core.dto;

import core.model.Request;

public class RequestProductDTO extends Request{

    private Integer desde;
    private Integer total;

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
