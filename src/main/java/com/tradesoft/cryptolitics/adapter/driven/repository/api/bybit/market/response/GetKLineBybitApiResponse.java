package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GetKLineBybitApiResponse(
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
        GetKLineBybitApiResponse.KLine result
) implements BaseBybitApiResponse {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record KLine(
            @NotEmpty
            @JsonProperty("symbol")
            String symbol,   // BTCUSD
            @NotEmpty
            @JsonProperty("category")
            String category, // spot
            @NotNull
            @JsonProperty("list")
            List<List<String>> list
            /*
              > list[0]: startTime	string	Start time of the candle (ms)
              > list[1]: openPrice	string	Open price
              > list[2]: highPrice	string	Highest price
              > list[3]: lowPrice	string	Lowest price
              > list[4]: closePrice	string	Close price. Is the last traded price when the candle is not closed
              > list[5]: volume	    string	Trade volume. Unit of contract: pieces of contract. Unit of spot: quantity of coins
              > list[6]: turnover	string	Turnover. Unit of figure: quantity of quota coin
            */
    ) {
    }
}
