package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GetServerTimeBybitApiResponse(
        @JsonProperty("retCode")
        int retCode,
        @JsonProperty("retMsg")
        String retMsg,
        @JsonProperty("time")
        long time,
        @JsonProperty("result")
        ServerTime result
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record ServerTime(
            @JsonProperty("timeSecond")
            String timeSecond,
            @JsonProperty("timeNano")
            String timeNano
    ) {
    }
}
