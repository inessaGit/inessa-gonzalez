package objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    @JsonProperty("externalContractId")
    private String externalContractId;
    @JsonProperty("productName")
    private String productName;
    @JsonProperty("fulfillment")
    private boolean fulfillment;
    @JsonProperty("macAddress")
    private String macAddress;
    @JsonProperty("deliverAddress")
    private Address deliverAddress;

    public String getExternalContractId() {
        return externalContractId;
    }

    public void setExternalContractId(String externalContractId) {
        this.externalContractId = externalContractId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public boolean isFulfillment() {
        return fulfillment;
    }

    public void setFulfillment(boolean fulfillment) {
        this.fulfillment = fulfillment;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Address getDeliverAddress() {
        return deliverAddress;
    }

    public void setDeliverAddress(Address deliverAddress) {
        this.deliverAddress = deliverAddress;
    }
}
