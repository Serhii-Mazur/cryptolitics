package com.tradesoft.cryptolitics.adapter.driven.repository.db.bybit;

import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.BybitExchangeMarketApiV5;
import com.tradesoft.cryptolitics.adapter.driven.repository.db.bybit.mapper.ServerTimeMapper;
import com.tradesoft.cryptolitics.domain.ServerTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BybitMarketRepositoryImpl implements BybitMarketRepository {
    private final BybitExchangeMarketApiV5 bybitMarketApi;

    @Autowired
    public BybitMarketRepositoryImpl(BybitExchangeMarketApiV5 bybitExchangeMarketApiV5) {
        bybitMarketApi = bybitExchangeMarketApiV5;
    }

    @Override
    public ServerTime getServerTime() {

        return ServerTimeMapper.toDomain(bybitMarketApi.getServerTime());
    }
}
