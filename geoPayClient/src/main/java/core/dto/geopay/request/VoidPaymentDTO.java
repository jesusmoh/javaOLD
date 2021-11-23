
package core.dto.geopay.request;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import core.model.geopay.RequestHeader;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "requestHeader",
    "paymentToken",
    "amount",
    "taxedAmount",
    "taxAmount",
    "invoiceTotalAmount",
    "invoiceNumber",
    "cardCVV"
})
@Generated("jsonschema2pojo")
public class VoidPaymentDTO {

    @JsonProperty("requestHeader")
    private RequestHeader requestHeader;
    @JsonProperty("paymentToken")
    private String paymentToken;
    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("taxedAmount")
    private Integer taxedAmount;
    @JsonProperty("taxAmount")
    private Integer taxAmount;
    @JsonProperty("invoiceTotalAmount")
    private Integer invoiceTotalAmount;
    @JsonProperty("invoiceNumber")
    private String invoiceNumber;
    @JsonProperty("cardCVV")
    private String cardCVV;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("requestHeader")
    public RequestHeader getRequestHeader() {
        return requestHeader;
    }

    @JsonProperty("requestHeader")
    public void setRequestHeader(RequestHeader requestHeader) {
        this.requestHeader = requestHeader;
    }

    @JsonProperty("paymentToken")
    public String getPaymentToken() {
        return paymentToken;
    }

    @JsonProperty("paymentToken")
    public void setPaymentToken(String paymentToken) {
        this.paymentToken = paymentToken;
    }

    @JsonProperty("amount")
    public Integer getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @JsonProperty("taxedAmount")
    public Integer getTaxedAmount() {
        return taxedAmount;
    }

    @JsonProperty("taxedAmount")
    public void setTaxedAmount(Integer taxedAmount) {
        this.taxedAmount = taxedAmount;
    }

    @JsonProperty("taxAmount")
    public Integer getTaxAmount() {
        return taxAmount;
    }

    @JsonProperty("taxAmount")
    public void setTaxAmount(Integer taxAmount) {
        this.taxAmount = taxAmount;
    }

    @JsonProperty("invoiceTotalAmount")
    public Integer getInvoiceTotalAmount() {
        return invoiceTotalAmount;
    }

    @JsonProperty("invoiceTotalAmount")
    public void setInvoiceTotalAmount(Integer invoiceTotalAmount) {
        this.invoiceTotalAmount = invoiceTotalAmount;
    }

    @JsonProperty("invoiceNumber")
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    @JsonProperty("invoiceNumber")
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @JsonProperty("cardCVV")
    public String getCardCVV() {
        return cardCVV;
    }

    @JsonProperty("cardCVV")
    public void setCardCVV(String cardCVV) {
        this.cardCVV = cardCVV;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
