
package core.model.geopay;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "dateTime", "netId", "netDescription", "auditNumber", "version", "digitalSign" })
@Generated("jsonschema2pojo")
public class RequestHeader {

    @JsonProperty("dateTime")
    private String dateTime;
    @JsonProperty("netDescription")
    private String netDescription;
    @JsonProperty("netId")
    private String netId;
    @JsonProperty("auditNumber")
    private String auditNumber;
    @JsonProperty("version")
    private String version;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String digitalSign;

    @JsonProperty("dateTime")
    public String getDateTime() {
        return dateTime;
    }

    @JsonProperty("dateTime")
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @JsonProperty("netDescription")
    public String getNetDescription() {
        return netDescription;
    }

    @JsonProperty("netDescription")
    public void setNetDescription(String netDescription) {
        this.netDescription = netDescription;
    }

    @JsonProperty("netId")
    public String getNetId() {
        return netId;
    }

    @JsonProperty("netId")
    public void setNetId(String netId) {
        this.netId = netId;
    }

    @JsonProperty("auditNumber")
    public String getAuditNumber() {
        return auditNumber;
    }

    @JsonProperty("auditNumber")
    public void setAuditNumber(String auditNumber) {
        this.auditNumber = auditNumber;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }
    
    @JsonProperty("digitalSign")
    public String getDigitalSign() {
        return digitalSign;
    }

    @JsonProperty("digitalSign")
    public void setDigitalSign(String digitalSign) {
        this.digitalSign = digitalSign;
    }

}
