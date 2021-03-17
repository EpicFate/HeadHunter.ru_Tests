package hh_ru.model;


import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "defaultDiscountRate",
        "cost",
        "costWithoutDiscount",
        "grossPrice",
        "currency",
        "useAgreementMoney",
        "items",
        "gift",
        "autoActivationAware",
        "autoActivationAllowed"
})
public class ToTheBasketModel {

    @JsonProperty("defaultDiscountRate")
    private Integer defaultDiscountRate;
    @JsonProperty("cost")
    private Double cost;
    @JsonProperty("costWithoutDiscount")
    private Double costWithoutDiscount;
    @JsonProperty("grossPrice")
    private Double grossPrice;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("useAgreementMoney")
    private Boolean useAgreementMoney;
    @JsonProperty("autoActivationAware")
    private Boolean autoActivationAware;
    @JsonProperty("autoActivationAllowed")
    private Boolean autoActivationAllowed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("defaultDiscountRate")
    public Integer getDefaultDiscountRate() {
        return defaultDiscountRate;
    }

    @JsonProperty("defaultDiscountRate")
    public void setDefaultDiscountRate(Integer defaultDiscountRate) {
        this.defaultDiscountRate = defaultDiscountRate;
    }

    @JsonProperty("cost")
    public Double getCost() {
        return cost;
    }

    @JsonProperty("cost")
    public void setCost(Double cost) {
        this.cost = cost;
    }

    @JsonProperty("costWithoutDiscount")
    public Double getCostWithoutDiscount() {
        return costWithoutDiscount;
    }

    @JsonProperty("costWithoutDiscount")
    public void setCostWithoutDiscount(Double costWithoutDiscount) {
        this.costWithoutDiscount = costWithoutDiscount;
    }

    @JsonProperty("grossPrice")
    public Double getGrossPrice() {
        return grossPrice;
    }

    @JsonProperty("grossPrice")
    public void setGrossPrice(Double grossPrice) {
        this.grossPrice = grossPrice;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("useAgreementMoney")
    public Boolean getUseAgreementMoney() {
        return useAgreementMoney;
    }

    @JsonProperty("useAgreementMoney")
    public void setUseAgreementMoney(Boolean useAgreementMoney) {
        this.useAgreementMoney = useAgreementMoney;
    }

    @JsonProperty("autoActivationAware")
    public Boolean getAutoActivationAware() {
        return autoActivationAware;
    }

    @JsonProperty("autoActivationAware")
    public void setAutoActivationAware(Boolean autoActivationAware) {
        this.autoActivationAware = autoActivationAware;
    }

    @JsonProperty("autoActivationAllowed")
    public Boolean getAutoActivationAllowed() {
        return autoActivationAllowed;
    }

    @JsonProperty("autoActivationAllowed")
    public void setAutoActivationAllowed(Boolean autoActivationAllowed) {
        this.autoActivationAllowed = autoActivationAllowed;
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