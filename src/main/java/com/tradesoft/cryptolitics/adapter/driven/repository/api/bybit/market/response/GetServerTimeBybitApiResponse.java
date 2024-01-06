package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GetServerTimeBybitApiResponse(
        @NotEmpty
        @JsonProperty("retCode")
        int retCode,
        @NotEmpty
        @JsonProperty("retMsg")
        String retMsg,
        @JsonProperty("time")
        long time,
        @NotNull
        @JsonProperty("result")
        ServerTime result
) implements BaseBybitApiResponse {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record ServerTime(
            @NotEmpty
            @JsonProperty("timeSecond")
            String timeSecond,
            @NotEmpty
            @JsonProperty("timeNano")
            String timeNano
    ) {
    }
}
