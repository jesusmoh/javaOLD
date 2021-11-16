
package core.dto;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "state",
    "digitalSign",
    "detail"
})
@Generated("jsonschema2pojo")
public class AppResponseHeaderDTO {

    @JsonProperty("state")
    private String state;
    @JsonProperty("digitalSign")
    private String digitalSign;
    @JsonProperty("detail")
    private String detail;

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("digitalSign")
    public String getDigitalSignt() {
        return digitalSign;
    }

    @JsonProperty("digitalSign")
    public void setDigitalSign(String digitalSign) {
        this.digitalSign = digitalSign;
    }

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

    
}
