package com.tradesoft.cryptolitics.application.port.repository;

import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.GetKlineRequestParameters;
import com.tradesoft.cryptolitics.domain.ServerTime;
import com.tradesoft.cryptolitics.domain.market.KLineGraph;

public interface BybitExchangeMarketRepository {
    ServerTime getServerTime();

    KLineGraph getKline(GetKlineRequestParameters params);
}
