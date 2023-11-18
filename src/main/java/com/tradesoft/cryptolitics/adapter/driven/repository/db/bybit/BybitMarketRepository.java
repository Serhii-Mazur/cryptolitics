package com.tradesoft.cryptolitics.adapter.driven.repository.db.bybit;

import com.tradesoft.cryptolitics.domain.ServerTime;

public interface BybitMarketRepository {
    ServerTime getServerTime();
}
