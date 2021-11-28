package core.dto.geopay.request;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import core.model.geopay.RequestHeader;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"requestHeader"
})
@Generated("jsonschema2pojo")
public class EchoRequestDTO {

@JsonProperty("requestHeader")
private RequestHeader requestHeader;

@JsonProperty("requestHeader")
public RequestHeader getRequestHeader() {
return requestHeader;
}

@JsonProperty("requestHeader")
public void setRequestHeader(RequestHeader requestHeader) {
this.requestHeader = requestHeader;
}

}