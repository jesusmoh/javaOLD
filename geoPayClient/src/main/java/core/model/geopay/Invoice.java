
package core.model.geopay;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "date",
    "number",
    "totalAmount",
    "serial",
    "finalConsumer",
    "dueDate",
    "description",
    "currency",
    "address"
})
@Generated("jsonschema2pojo")
public class Invoice {

    @JsonProperty("date")
    private String date;
    @JsonProperty("number")
    private String number;
    @JsonProperty("totalAmount")
    private Long totalAmount;
    @JsonProperty("serial")
    private String serial;
    @JsonProperty("finalConsumer")
    private Boolean finalConsumer;
    @JsonProperty("dueDate")
    private String dueDate;
    @JsonProperty("description")
    private String description;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("address")
    private Address address;

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("number")
    public String getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(String number) {
        this.number = number;
    }

    @JsonProperty("totalAmount")
    public Long getTotalAmount() {
        return totalAmount;
    }

    @JsonProperty("totalAmount")
    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    @JsonProperty("serial")
    public String getSerial() {
        return serial;
    }

    @JsonProperty("serial")
    public void setSerial(String serial) {
        this.serial = serial;
    }

    @JsonProperty("finalConsumer")
    public Boolean getFinalConsumer() {
        return finalConsumer;
    }

    @JsonProperty("finalConsumer")
    public void setFinalConsumer(Boolean finalConsumer) {
        this.finalConsumer = finalConsumer;
    }

    @JsonProperty("dueDate")
    public String getDueDate() {
        return dueDate;
    }

    @JsonProperty("dueDate")
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

}
