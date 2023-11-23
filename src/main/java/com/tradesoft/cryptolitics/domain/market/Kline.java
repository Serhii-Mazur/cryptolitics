package com.tradesoft.cryptolitics.domain.market;

import java.util.List;

public record Kline(
//        Category category,
        String category,
//        CoinPair coinPair,
        String coinPair,
        List<CandleStick> candleSticks
) {
}
