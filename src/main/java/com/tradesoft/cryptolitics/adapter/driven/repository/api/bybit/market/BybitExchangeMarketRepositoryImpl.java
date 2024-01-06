package com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market;

import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.mapper.KlineGraphMapper;
import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.mapper.ServerTimeMapper;
import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.response.GetKLineBybitApiResponse;
import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.response.GetServerTimeBybitApiResponse;
import com.tradesoft.cryptolitics.application.port.repository.BybitExchangeMarketRepository;
import com.tradesoft.cryptolitics.domain.ServerTime;
import com.tradesoft.cryptolitics.domain.constants.CoinPair;
import com.tradesoft.cryptolitics.domain.market.KLineGraph;
import com.tradesoft.cryptolitics.exception.BybitApiException;
import feign.FeignException.FeignClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BybitExchangeMarketRepositoryImpl implements BybitExchangeMarketRepository {
    private final BybitExchangeMarketApiV5 bybitMarketApi;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public BybitExchangeMarketRepositoryImpl(BybitExchangeMarketApiV5 bybitExchangeMarketApiV5) {
        bybitMarketApi = bybitExchangeMarketApiV5;
    }

    @Override
    public ServerTime getServerTime() {
        GetServerTimeBybitApiResponse bybitServerTimeResponse = null;
        try {
            bybitServerTimeResponse = bybitMarketApi.getServerTime();
            bybitServerTimeResponse.validate();
        } catch (FeignClientException ex) {
            logger.error("Feign Client Exception! ", ex);
        } catch (BybitApiException ex) {
            logger.error("Bybit API Error: ", ex);
        }
        if (bybitServerTimeResponse == null) {
            return null;
        } else {
            return ServerTimeMapper.toDomain(bybitServerTimeResponse);
        }
    }

    @Override
    public KLineGraph getKline(GetKlineRequestParameters params) {
        try {
            GetKLineBybitApiResponse kLineResponse = bybitMarketApi.getKline(
                    params.category(),
                    params.symbol(),
                    params.interval(),
                    params.startDateTime(),
                    params.endDateTime(),
                    params.limit()
            );
            kLineResponse.validate();

            return KlineGraphMapper.toDomain(kLineResponse.result());
        } catch (FeignClientException ex) {
            logger.error("Feign Client Exception! ", ex);
        } catch (BybitApiException ex) {
            logger.error("Bybit API Error: ", ex);
        }

        return KLineGraph.empty(CoinPair.valueOf(params.symbol()));
    }
}
