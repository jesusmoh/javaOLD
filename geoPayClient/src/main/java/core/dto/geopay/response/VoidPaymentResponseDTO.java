package core.dto.geopay.response;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import core.model.geopay.ResponseHeader;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"responseHeader"
})
@Generated("jsonschema2pojo")
public class VoidPaymentResponseDTO {

@JsonProperty("responseHeader")
private ResponseHeader responseHeader;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("responseHeader")
public ResponseHeader getResponseHeader() {
return responseHeader;
}

@JsonProperty("responseHeader")
public void setResponseHeader(ResponseHeader responseHeader) {
this.responseHeader = responseHeader;
}



}