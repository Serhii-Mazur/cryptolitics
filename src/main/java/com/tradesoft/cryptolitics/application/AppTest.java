package com.tradesoft.cryptolitics.application;

import com.tradesoft.cryptolitics.adapter.driven.repository.db.bybit.BybitMarketRepository;
import com.tradesoft.cryptolitics.domain.ServerTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AppTest {

    private final BybitMarketRepository bybitMarketRepository;

    @Autowired
    public AppTest(BybitMarketRepository bybitMarketRepository) {
        this.bybitMarketRepository = bybitMarketRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    private void test() {
        ServerTime serverTime = bybitMarketRepository.getServerTime();
        System.out.printf("Server time: %s%n", serverTime);
    }
}
