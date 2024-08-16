package com.example.coin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RateData {
    private String id;
    private String symbol;
    private String currencySymbol;
    private String type;
    private double rateUsd;
    @Id
    private Long timestamp;

    public RateData(String id, String symbol, String currencySymbol, String type, double rateUsd, Long timestamp) {
        this.id = id;
        this.symbol = symbol;
        this.currencySymbol = currencySymbol;
        this.type = type;
        this.rateUsd = rateUsd;
        this.timestamp = timestamp;
    }

    public RateData(){

    }

    @Override
    public String toString() {
        return "RateData [id=" + id + ", symbol=" + symbol + ", currencySymbol=" + currencySymbol + ", type=" + type
                + ", rateUsd=" + rateUsd + ", timestamp=" + timestamp + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRateUsd() {
        return rateUsd;
    }

    public void setRateUsd(double rateUsd) {
        this.rateUsd = rateUsd;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}