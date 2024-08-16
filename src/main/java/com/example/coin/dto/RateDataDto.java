package com.example.coin.dto;

import com.example.coin.entity.RateData;

public class RateDataDto {
    private RateData data;
    private long timestamp;
    
    public RateData getData() {
        return data;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public void setData(RateData data) {
        this.data = data;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }   

    
}
