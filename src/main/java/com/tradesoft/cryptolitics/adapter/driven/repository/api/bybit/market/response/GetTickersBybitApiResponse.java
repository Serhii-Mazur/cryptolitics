package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GetTickersBybitApiResponse(
        @JsonProperty("retCode")
        int retCode,
        @JsonProperty("retMsg")
        String retMsg,
        @JsonProperty("result")
        Result result,
        @JsonProperty("time")
        long time
) {
    public record Result(
            @JsonProperty("category")
            String category, // spot
            @JsonProperty("list")
            List<Ticker> list
    ) {
    }

    public record Ticker(
            @JsonProperty("symbol")
            String symbol,         //	Symbol name
            @JsonProperty("bid1Price")
            String bid1Price,      //	Best bid price
            @JsonProperty("bid1Size")
            String bid1Size,       //	Best bid size
            @JsonProperty("ask1Price")
            String ask1Price,      //	Best ask price
            @JsonProperty("ask1Size")
            String ask1Size,       //	Best ask size
            @JsonProperty("lastPrice")
            String lastPrice,      //	Last price
            @JsonProperty("prevPrice24h")
            String prevPrice24h,   //	Market price 24 hours ago
            @JsonProperty("price24hPcnt")
            String price24hPcnt,   //	Percentage change of market price relative to 24h
            @JsonProperty("highPrice24h")
            String highPrice24h,   //	The highest price in the last 24 hours
            @JsonProperty("lowPrice24h")
            String lowPrice24h,    //	The lowest price in the last 24 hours
            @JsonProperty("turnover24h")
            String turnover24h,    //	Turnover for 24h
            @JsonProperty("volume24h")
            String volume24h,      //	Volume for 24h
            @JsonProperty("usdIndexPrice")
            String usdIndexPrice    /*	USD index price
                                    - used to calculate USD value of the assets in Unified account
                                    - non-collateral margin coin returns "" */
    ) {

    }
}
