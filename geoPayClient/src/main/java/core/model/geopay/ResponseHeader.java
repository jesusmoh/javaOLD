
package core.model.geopay;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "responseDescription",
    "digitalSign",
    "responseCode",
    "rrn"
})
@Generated("jsonschema2pojo")
public class ResponseHeader {

    @JsonProperty("responseDescription")
    private String responseDescription;
    @JsonProperty("digitalSign")
    private String digitalSign;
    @JsonProperty("responseCode")
    private String responseCode;
    @JsonProperty("rrn")
    private String rrn;
   

    @JsonProperty("responseDescription")
    public String getResponseDescription() {
        return responseDescription;
    }

    @JsonProperty("responseDescription")
    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    @JsonProperty("digitalSign")
    public String getDigitalSign() {
        return digitalSign;
    }

    @JsonProperty("digitalSign")
    public void setDigitalSign(String digitalSign) {
        this.digitalSign = digitalSign;
    }

    @JsonProperty("responseCode")
    public String getResponseCode() {
        return responseCode;
    }

    @JsonProperty("responseCode")
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    @JsonProperty("rrn")
    public String getRrn() {
        return rrn;
    }

    @JsonProperty("rrn")
    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

}
