package com.tradesoft.cryptolitics.application;

import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.BybitExchangeMarketApiV5;
import com.tradesoft.cryptolitics.application.port.repository.BybitExchangeMarketRepository;
import com.tradesoft.cryptolitics.application.port.repository.KLineH1Repository;
import com.tradesoft.cryptolitics.domain.ServerTime;
import com.tradesoft.cryptolitics.domain.constants.CoinPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.ta4j.core.BarSeries;
import org.ta4j.core.BaseBarSeriesBuilder;

import java.time.Duration;
import java.time.Instant;

@Component
@Profile("!test")
public class AppTest {

    private final BybitExchangeMarketRepository bybitExchangeMarketRepository;
    private final BybitExchangeMarketApiV5 bybitApi;
    private final KLineH1Repository kLineRepository;

    @Autowired
    public AppTest(
            BybitExchangeMarketRepository bybitExchangeMarketRepository,
            BybitExchangeMarketApiV5 bybitApi,
            KLineH1Repository kLineRepository) {
        this.bybitExchangeMarketRepository = bybitExchangeMarketRepository;
        this.bybitApi = bybitApi;
        this.kLineRepository = kLineRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    private void test() {

        ServerTime serverTime = bybitExchangeMarketRepository.getServerTime();
        System.out.printf("Server time: %s%n", serverTime);
        System.out.println("=========================================================");
/*
        GetKlineRequestParameters kLineParameters = new GetKlineRequestParameters(
                Category.SPOT.name().toLowerCase(),
                CoinPair.BTCUSDT.name(),
                BybitInterval.H1.bybitInterval,
//                LocalDateTime.now().minusHours(24L).toEpochSecond(ZoneOffset.UTC) * 1000L,
                null,
                null,
                10
        );
        KLineGraph kLineGraph = bybitExchangeMarketRepository.getKline(kLineParameters);
  */
        BarSeries barSeries = new BaseBarSeriesBuilder().withName(CoinPair.BTCUSDT.name()).build();
        Instant endTime = Instant.now();
        barSeries.addBar(barSeries.barBuilder()
                .timePeriod(Duration.ofDays(1))
                .endTime(endTime)
                .openPrice(105.42)
                .highPrice(112.99)
                .lowPrice(104.01)
                .closePrice(111.42)
                .volume(1337)
                .build());

        barSeries.getBarData().forEach(System.out::println);
//        kLineGraph.kLines().forEach(System.out::println);
//        List<KLine> kLines = kLineGraph.kLines();
//        kLineRepository.saveAll(kLineGraph.coinPair(), kLines);
    }
}
