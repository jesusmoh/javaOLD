
package core.dto.geopay.request;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import core.model.geopay.AuthorizerAdditionalDatum;
import core.model.geopay.Client;
import core.model.geopay.Config;
import core.model.geopay.EcommerceAdditionalDatum;
import core.model.geopay.Invoice;
import core.model.geopay.RequestHeader;
import core.model.geopay.ShippingAddress;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "requestHeader",
    "merchantId",
    "preAuthorization",
    "currency",
    "amount",
    "tipAmount",
    "taxedAmount",
    "taxAmount",
    "installments",
    "indi",
    "reference",
    "invoice",
    "client",
    "shippingAddress",
    "config",
    "ecommerceAdditionalData",
    "authorizerAdditionalData"
})
@Generated("jsonschema2pojo")
public class RequestPaymentDTO {

    @JsonProperty("requestHeader")
    private RequestHeader requestHeader;
    @JsonProperty("merchantId")
    private String merchantId;
    @JsonProperty("preAuthorization")
    private Long preAuthorization;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("amount")
    private Long amount;
    @JsonProperty("tipAmount")
    private Long tipAmount;
    @JsonProperty("taxedAmount")
    private Long taxedAmount;
    @JsonProperty("taxAmount")
    private Long taxAmount;
    @JsonProperty("installments")
    private String installments;
    @JsonProperty("indi")
    private Long indi;
    @JsonProperty("reference")
    private String reference;
    @JsonProperty("invoice")
    private Invoice invoice;
    @JsonProperty("client")
    private Client client;
    @JsonProperty("shippingAddress")
    private ShippingAddress shippingAddress;
    @JsonProperty("config")
    private Config config;
    @JsonProperty("ecommerceAdditionalData")
    private List<EcommerceAdditionalDatum> ecommerceAdditionalData = null;
    @JsonProperty("authorizerAdditionalData")
    private List<AuthorizerAdditionalDatum> authorizerAdditionalData = null;

    @JsonProperty("requestHeader")
    public RequestHeader getRequestHeader() {
        return requestHeader;
    }

    @JsonProperty("requestHeader")
    public void setRequestHeader(RequestHeader requestHeader) {
        this.requestHeader = requestHeader;
    }

    @JsonProperty("merchantId")
    public String getMerchantId() {
        return merchantId;
    }

    @JsonProperty("merchantId")
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @JsonProperty("preAuthorization")
    public Long getPreAuthorization() {
        return preAuthorization;
    }

    @JsonProperty("preAuthorization")
    public void setPreAuthorization(Long preAuthorization) {
        this.preAuthorization = preAuthorization;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("amount")
    public Long getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @JsonProperty("tipAmount")
    public Long getTipAmount() {
        return tipAmount;
    }

    @JsonProperty("tipAmount")
    public void setTipAmount(Long tipAmount) {
        this.tipAmount = tipAmount;
    }

    @JsonProperty("taxedAmount")
    public Long getTaxedAmount() {
        return taxedAmount;
    }

    @JsonProperty("taxedAmount")
    public void setTaxedAmount(Long taxedAmount) {
        this.taxedAmount = taxedAmount;
    }

    @JsonProperty("taxAmount")
    public Long getTaxAmount() {
        return taxAmount;
    }

    @JsonProperty("taxAmount")
    public void setTaxAmount(Long taxAmount) {
        this.taxAmount = taxAmount;
    }

    @JsonProperty("installments")
    public String getInstallments() {
        return installments;
    }

    @JsonProperty("installments")
    public void setInstallments(String installments) {
        this.installments = installments;
    }

    @JsonProperty("indi")
    public Long getIndi() {
        return indi;
    }

    @JsonProperty("indi")
    public void setIndi(Long indi) {
        this.indi = indi;
    }

    @JsonProperty("reference")
    public String getReference() {
        return reference;
    }

    @JsonProperty("reference")
    public void setReference(String reference) {
        this.reference = reference;
    }

    @JsonProperty("invoice")
    public Invoice getInvoice() {
        return invoice;
    }

    @JsonProperty("invoice")
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @JsonProperty("client")
    public Client getClient() {
        return client;
    }

    @JsonProperty("client")
    public void setClient(Client client) {
        this.client = client;
    }

    @JsonProperty("shippingAddress")
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    @JsonProperty("shippingAddress")
    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @JsonProperty("config")
    public Config getConfig() {
        return config;
    }

    @JsonProperty("config")
    public void setConfig(Config config) {
        this.config = config;
    }

    @JsonProperty("ecommerceAdditionalData")
    public List<EcommerceAdditionalDatum> getEcommerceAdditionalData() {
        return ecommerceAdditionalData;
    }

    @JsonProperty("ecommerceAdditionalData")
    public void setEcommerceAdditionalData(List<EcommerceAdditionalDatum> ecommerceAdditionalData) {
        this.ecommerceAdditionalData = ecommerceAdditionalData;
    }

    @JsonProperty("authorizerAdditionalData")
    public List<AuthorizerAdditionalDatum> getAuthorizerAdditionalData() {
        return authorizerAdditionalData;
    }

    @JsonProperty("authorizerAdditionalData")
    public void setAuthorizerAdditionalData(List<AuthorizerAdditionalDatum> authorizerAdditionalData) {
        this.authorizerAdditionalData = authorizerAdditionalData;
    }

}
