package com.tradesoft.cryptolitics.application.port;

import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.GetKlineRequestParameters;
import com.tradesoft.cryptolitics.domain.ServerTime;
import com.tradesoft.cryptolitics.domain.market.Kline;

public interface BybitExchangeMarketRepository {
    ServerTime getServerTime();

    Kline getKline(GetKlineRequestParameters params);
}
