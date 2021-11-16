
package core.model.geopay;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "showSaveCardOption",
    "propFileName",
    "updateInfoRequired",
    "urlUpdateInfo",
    "cssFileName",
    "callbackUrl",
    "callbackUrlSuffix",
    "hideCards",
    "hideBanks",
    "hidePayNets",
    "useRedirect",
    "paymentTokenEnabledUntil"
})
@Generated("jsonschema2pojo")
public class Config {

    @JsonProperty("showSaveCardOption")
    private Boolean showSaveCardOption;
    @JsonProperty("propFileName")
    private String propFileName;
    @JsonProperty("updateInfoRequired")
    private Boolean updateInfoRequired;
    @JsonProperty("urlUpdateInfo")
    private String urlUpdateInfo;
    @JsonProperty("cssFileName")
    private String cssFileName;
    @JsonProperty("callbackUrl")
    private String callbackUrl;
    @JsonProperty("callbackUrlSuffix")
    private String callbackUrlSuffix;
    @JsonProperty("hideCards")
    private Boolean hideCards;
    @JsonProperty("hideBanks")
    private Boolean hideBanks;
    @JsonProperty("hidePayNets")
    private Boolean hidePayNets;
    @JsonProperty("useRedirect")
    private Boolean useRedirect;
    @JsonProperty("paymentTokenEnabledUntil")
    private String paymentTokenEnabledUntil;

    @JsonProperty("showSaveCardOption")
    public Boolean getShowSaveCardOption() {
        return showSaveCardOption;
    }

    @JsonProperty("showSaveCardOption")
    public void setShowSaveCardOption(Boolean showSaveCardOption) {
        this.showSaveCardOption = showSaveCardOption;
    }

    @JsonProperty("propFileName")
    public String getPropFileName() {
        return propFileName;
    }

    @JsonProperty("propFileName")
    public void setPropFileName(String propFileName) {
        this.propFileName = propFileName;
    }

    @JsonProperty("updateInfoRequired")
    public Boolean getUpdateInfoRequired() {
        return updateInfoRequired;
    }

    @JsonProperty("updateInfoRequired")
    public void setUpdateInfoRequired(Boolean updateInfoRequired) {
        this.updateInfoRequired = updateInfoRequired;
    }

    @JsonProperty("urlUpdateInfo")
    public String getUrlUpdateInfo() {
        return urlUpdateInfo;
    }

    @JsonProperty("urlUpdateInfo")
    public void setUrlUpdateInfo(String urlUpdateInfo) {
        this.urlUpdateInfo = urlUpdateInfo;
    }

    @JsonProperty("cssFileName")
    public String getCssFileName() {
        return cssFileName;
    }

    @JsonProperty("cssFileName")
    public void setCssFileName(String cssFileName) {
        this.cssFileName = cssFileName;
    }

    @JsonProperty("callbackUrl")
    public String getCallbackUrl() {
        return callbackUrl;
    }

    @JsonProperty("callbackUrl")
    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    @JsonProperty("callbackUrlSuffix")
    public String getCallbackUrlSuffix() {
        return callbackUrlSuffix;
    }

    @JsonProperty("callbackUrlSuffix")
    public void setCallbackUrlSuffix(String callbackUrlSuffix) {
        this.callbackUrlSuffix = callbackUrlSuffix;
    }

    @JsonProperty("hideCards")
    public Boolean getHideCards() {
        return hideCards;
    }

    @JsonProperty("hideCards")
    public void setHideCards(Boolean hideCards) {
        this.hideCards = hideCards;
    }

    @JsonProperty("hideBanks")
    public Boolean getHideBanks() {
        return hideBanks;
    }

    @JsonProperty("hideBanks")
    public void setHideBanks(Boolean hideBanks) {
        this.hideBanks = hideBanks;
    }

    @JsonProperty("hidePayNets")
    public Boolean getHidePayNets() {
        return hidePayNets;
    }

    @JsonProperty("hidePayNets")
    public void setHidePayNets(Boolean hidePayNets) {
        this.hidePayNets = hidePayNets;
    }

    @JsonProperty("useRedirect")
    public Boolean getUseRedirect() {
        return useRedirect;
    }

    @JsonProperty("useRedirect")
    public void setUseRedirect(Boolean useRedirect) {
        this.useRedirect = useRedirect;
    }

    @JsonProperty("paymentTokenEnabledUntil")
    public String getPaymentTokenEnabledUntil() {
        return paymentTokenEnabledUntil;
    }

    @JsonProperty("paymentTokenEnabledUntil")
    public void setPaymentTokenEnabledUntil(String paymentTokenEnabledUntil) {
        this.paymentTokenEnabledUntil = paymentTokenEnabledUntil;
    }

}
