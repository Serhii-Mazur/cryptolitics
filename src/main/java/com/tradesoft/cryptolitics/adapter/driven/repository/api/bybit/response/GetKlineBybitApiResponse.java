package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GetKlineBybitApiResponse(
        @JsonProperty("retCode")
        int retCode,
        @JsonProperty("retMsg")
        String retMsg,
        @JsonProperty("time")
        long time,
        @JsonProperty("result")
        Kline result
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Kline(
            @JsonProperty("symbol")
            String symbol,   // BTCUSD
            @JsonProperty("category")
            String category, // spot
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
