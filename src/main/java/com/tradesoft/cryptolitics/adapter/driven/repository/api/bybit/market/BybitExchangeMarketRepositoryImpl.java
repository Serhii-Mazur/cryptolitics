package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market;

import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.mapper.KlineMapper;
import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.mapper.ServerTimeMapper;
import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.response.GetKlineBybitApiResponse;
import com.tradesoft.cryptolitics.application.port.BybitExchangeMarketRepository;
import com.tradesoft.cryptolitics.domain.ServerTime;
import com.tradesoft.cryptolitics.domain.market.Kline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

@Repository
public class BybitExchangeMarketRepositoryImpl implements BybitExchangeMarketRepository {
    private final BybitExchangeMarketApiV5 bybitMarketApi;

    @Autowired
    public BybitExchangeMarketRepositoryImpl(BybitExchangeMarketApiV5 bybitExchangeMarketApiV5) {
        bybitMarketApi = bybitExchangeMarketApiV5;
    }

    @Override
    public ServerTime getServerTime() {

        return ServerTimeMapper.toDomain(bybitMarketApi.getServerTime());
    }

    @Override
    public Kline getKline(GetKlineRequestParameters params) {
        GetKlineBybitApiResponse kline = bybitMarketApi.getKline(
                params.category(),
                params.symbol(),
                params.interval(),
                params.startDateTime(),
                params.endDateTime(),
                params.limit()
        );

        if (kline != null) {
            return KlineMapper.toDomain(kline.result());
        } else {
            throw new NoSuchElementException(); // TODO: Replace with business exception
        }
    }
}
