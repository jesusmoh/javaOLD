/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dto.geopay.response;

import javax.annotation.Generated;
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
public class ResponseHeaderDTO {

@JsonProperty("responseHeader")
private ResponseHeader responseHeader;
@JsonIgnore

@JsonProperty("responseHeader")
public ResponseHeader getResponseHeader() {
return responseHeader;
}

@JsonProperty("responseHeader")
public void setResponseHeader(ResponseHeader responseHeader) {
this.responseHeader = responseHeader;
}



}
