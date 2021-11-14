
package core.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class PrecioVenta {

    private Double uyu;
    private Double usd;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Double getUyu() {
        return uyu;
    }

    public void setUyu(Double uyu) {
        this.uyu = uyu;
    }

    public Double getUsd() {
        return usd;
    }

    public void setUsd(Double usd) {
        this.usd = usd;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
