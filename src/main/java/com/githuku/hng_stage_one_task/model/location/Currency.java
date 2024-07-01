package com.githuku.hng_stage_one_task.model.location;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Currency {
    @JsonProperty("currency_name")
    private String currencyName;
    @JsonProperty("currency_code")
    private String currencyCode;


    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}




