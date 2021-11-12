package uy.com.sisnet.fenicioClient.dto;

import uy.com.sisnet.fenicioClient.model.Data;
import uy.com.sisnet.fenicioClient.model.Response;

public class ProductsDTO extends Response {

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
