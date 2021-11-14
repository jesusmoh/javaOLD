
package core.dto;

import core.model.Data;
import core.model.Response;


public class ProductsDTO extends Response{

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
