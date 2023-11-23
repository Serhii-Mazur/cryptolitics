package com.tradesoft.cryptolitics.application;

import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.BybitInterval;
import com.tradesoft.cryptolitics.adapter.driven.repository.api.bybit.market.GetKlineRequestParameters;
import com.tradesoft.cryptolitics.application.port.BybitExchangeMarketRepository;
import com.tradesoft.cryptolitics.domain.ServerTime;
import com.tradesoft.cryptolitics.domain.constants.Category;
import com.tradesoft.cryptolitics.domain.constants.CoinPair;
import com.tradesoft.cryptolitics.domain.market.Kline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class AppTest {

    private final BybitExchangeMarketRepository bybitExchangeMarketRepository;

    @Autowired
    public AppTest(BybitExchangeMarketRepository bybitExchangeMarketRepository) {
        this.bybitExchangeMarketRepository = bybitExchangeMarketRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    private void test() {
        ServerTime serverTime = bybitExchangeMarketRepository.getServerTime();
        System.out.printf("Server time: %s%n", serverTime);

        Kline kLine = bybitExchangeMarketRepository.getKline(
                new GetKlineRequestParameters(
                        Category.SPOT.name().toLowerCase(),
                        CoinPair.USDTTON.name(),
                        BybitInterval.H1.bybitInterval,
                        LocalDateTime.now().minusHours(24L).toEpochSecond(ZoneOffset.UTC),
                        null,
                        null
                )
        );

//        System.out.println(kLine.coinPair().name() + kLine.category().name());
//        kLine.candleSticks().forEach(System.out::println);
    }
}
