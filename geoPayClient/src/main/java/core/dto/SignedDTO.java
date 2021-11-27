
package core.dto;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "stateSigned",
    "digitalSign",
    "detail"
})
@Generated("jsonschema2pojo")
public class SignedDTO {

    @JsonProperty("stateSigned")
    private String stateSigned;
    @JsonProperty("digitalSign")
    private String digitalSign;
    @JsonProperty("detail")
    private String detail;

    @JsonProperty("stateSigned")
    public String getSignedState() {
        return stateSigned;
    }

    @JsonProperty("stateSigned")
    public void setSignedState(String state) {
        this.stateSigned = state;
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
