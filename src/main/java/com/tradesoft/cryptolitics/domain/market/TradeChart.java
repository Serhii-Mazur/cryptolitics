package com.tradesoft.cryptolitics.domain.market;

import com.tradesoft.cryptolitics.domain.constants.Category;
import com.tradesoft.cryptolitics.domain.constants.Coin;
import com.tradesoft.cryptolitics.domain.constants.Interval;

import java.util.List;
import java.util.Map;

public record TradeChart(
        Category category,
        Map<Coin, Coin> coinPair,
        Interval interval,
        List<CandleStick> candleSticks
) {
}
