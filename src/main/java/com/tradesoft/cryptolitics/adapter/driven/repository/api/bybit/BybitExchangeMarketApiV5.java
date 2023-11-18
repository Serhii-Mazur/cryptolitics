package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit;

import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.response.GetKlineBybitApiResponse;
import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.response.GetServerTimeBybitApiResponse;
import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.response.GetTickersBybitApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "Bybit-Exchange-Market-API-V5",
        url = "${resource.bybit.api.url}"
)
public interface BybitExchangeMarketApiV5 {
    String DEFAULT_CATEGORY = "spot";
    String DEFAULT_SYMBOL = "BTCUSDT";
    String DEFAULT_INTERVAL = "D";

    //    @RequestMapping(method = RequestMethod.GET, value = "/v5/market/time", consumes = "application/json")
    @GetMapping("/v5/market/time")
    GetServerTimeBybitApiResponse getServerTime();

    @GetMapping("/v5/market/kline")
    GetKlineBybitApiResponse getKline(
            @RequestParam(name = "category", defaultValue = DEFAULT_CATEGORY, required = true)
            String category,
            @RequestParam(name = "symbol", defaultValue = DEFAULT_SYMBOL, required = true)
            String symbol,
            @RequestParam(name = "interval", defaultValue = DEFAULT_INTERVAL, required = true)
            String interval,
            @RequestParam(name = "start", required = false) // In epoch milliseconds.
            long start,
            @RequestParam(name = "end", required = false) // In epoch milliseconds
            long end,
            @RequestParam(name = "limit", required = false) // Limit for data size per page. [1, 1000]. Default: 200
            int limit
    );

    @GetMapping("/v5/market/kline")
    GetKlineBybitApiResponse getKline(
            @RequestParam(name = "category", defaultValue = DEFAULT_CATEGORY, required = true)
            String category,
            @RequestParam(name = "symbol", defaultValue = DEFAULT_SYMBOL, required = true)
            String symbol,
            @RequestParam(name = "interval", defaultValue = DEFAULT_INTERVAL, required = true)
            String interval,
            @RequestParam(name = "limit", required = false) // Limit for data size per page. [1, 1000]. Default: 200
            int limit
    );

    /*
    This end point implemented only for {spot} category.
    To implement for other categories need to use appropriate "result".
    NOT REQUIRED params {baseCoin, expDate} are NOT included.
    Please, add them while implementing for {option} category.
     */
    @GetMapping("/v5/market/tickers")
    GetTickersBybitApiResponse getTickers(
            @RequestParam(name = "category", defaultValue = DEFAULT_CATEGORY, required = true)
            String category, // Product type: {spot,linear,inverse,option}
            @RequestParam(name = "symbol", defaultValue = DEFAULT_SYMBOL, required = false)
            String symbol
    );
}
