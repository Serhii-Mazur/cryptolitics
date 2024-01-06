package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market;

import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.response.GetKLineBybitApiResponse;
import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.response.GetServerTimeBybitApiResponse;
import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.response.GetTickersBybitApiResponse;
import com.tradesoft.cryptolitics.config.BybitExchangeMarketFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "Bybit-Exchange-Market-API-V5",
        url = "${resource.bybit.api.url}",
        configuration = BybitExchangeMarketFeignConfig.class
)
public interface BybitExchangeMarketApiV5 {
    String MARKET_PATH = "/v5/market";
    String DEFAULT_CATEGORY = "spot";
    String DEFAULT_SYMBOL = "BTCUSDT";
    String DEFAULT_INTERVAL = "D";

    @GetMapping(MARKET_PATH + "/time")
    GetServerTimeBybitApiResponse getServerTime();

    @GetMapping(MARKET_PATH + "/kline")
    GetKLineBybitApiResponse getKline(
            @RequestParam(name = "category", defaultValue = DEFAULT_CATEGORY, required = true)
            String category,
            @RequestParam(name = "symbol", defaultValue = DEFAULT_SYMBOL, required = true)
            String symbol,
            @RequestParam(name = "interval", defaultValue = DEFAULT_INTERVAL, required = true)
            String interval,
            @RequestParam(name = "start", required = false) // In epoch milliseconds.
            Long start,
            @RequestParam(name = "end", required = false) // In epoch milliseconds
            Long end,
            @RequestParam(name = "limit", required = false) // Limit for data size per page. [1, 1000]. Default: 200
            Integer limit
    );

    /*
    This end point implemented only for {spot} category.
    To implement for other categories need to use appropriate "result".
    NOT REQUIRED params {baseCoin, expDate} are NOT included.
    Please, add them while implementing for {option} category.
     */
    @GetMapping(MARKET_PATH + "/tickers")
    GetTickersBybitApiResponse getTickers(
            @RequestParam(name = "category", defaultValue = DEFAULT_CATEGORY, required = true)
            String category, // Product type: {spot,linear,inverse,option}
            @RequestParam(name = "symbol", defaultValue = DEFAULT_SYMBOL, required = false)
            String symbol
    );
}
