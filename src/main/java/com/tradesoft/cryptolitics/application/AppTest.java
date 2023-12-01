package com.tradesoft.cryptolitics.application;

import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.BybitInterval;
import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.BybitExchangeMarketApiV5;
import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.GetKlineRequestParameters;
import com.tradesoft.cryptolitics.application.port.BybitExchangeMarketRepository;
import com.tradesoft.cryptolitics.application.port.KLineRepository;
import com.tradesoft.cryptolitics.domain.ServerTime;
import com.tradesoft.cryptolitics.domain.constants.Category;
import com.tradesoft.cryptolitics.domain.constants.CoinPair;
import com.tradesoft.cryptolitics.domain.market.KLine;
import com.tradesoft.cryptolitics.domain.market.KLineGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("!test")
public class AppTest {

    private final BybitExchangeMarketRepository bybitExchangeMarketRepository;
    private final BybitExchangeMarketApiV5 bybitApi;
    private final KLineRepository klineRepository;

    @Autowired
    public AppTest(
            BybitExchangeMarketRepository bybitExchangeMarketRepository,
            BybitExchangeMarketApiV5 bybitApi,
            KLineRepository kLineRepository) {
        this.bybitExchangeMarketRepository = bybitExchangeMarketRepository;
        this.bybitApi = bybitApi;
        this.klineRepository = kLineRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    private void test() {

        ServerTime serverTime = bybitExchangeMarketRepository.getServerTime();
        System.out.printf("Server time: %s%n", serverTime);

        GetKlineRequestParameters kLineParameters = new GetKlineRequestParameters(
                Category.SPOT.name().toLowerCase(),
                CoinPair.TONUSDT.name(),
                BybitInterval.H1.bybitInterval,
//                LocalDateTime.now().minusHours(24L).toEpochSecond(ZoneOffset.UTC) * 1000L,
                null,
                null,
                1
        );
        KLineGraph kLineGraph = bybitExchangeMarketRepository.getKline(kLineParameters);
//        GetKlineBybitApiResponse kLineResponse = bybitApi.getKline(
//                kLineParameters.category(),
//                kLineParameters.symbol(),
//                kLineParameters.interval(),
////                kLineParameters.startDateTime(),
//                null,
//                null,
//                1
//        );
        System.out.println("=========================================================");

//        System.out.println(kLine.coinPair().name() + kLine.category().name());
        kLineGraph.kLines().forEach(System.out::println);
        List<KLine> kLines = kLineGraph.kLines();
        klineRepository.saveAll(kLineGraph.coinPair(), kLines);
    }
}
